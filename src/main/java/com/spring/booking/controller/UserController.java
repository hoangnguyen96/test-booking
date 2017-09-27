package com.spring.booking.controller;

import com.spring.booking.entities.RoleEntity;
import com.spring.booking.entities.UserEntity;
import com.spring.booking.more.Encryptor;
import com.spring.booking.more.MailSender;
import com.spring.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by PC on 09/20/17.
 */
@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String showUser(Model model){
        List<UserEntity> userList = (List<UserEntity>) userRepository.findAll();
        model.addAttribute("userList",userList);
        return "../admin/user";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("userEntity", new UserEntity());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLogin(@ModelAttribute UserEntity userEntity, HttpServletRequest request, Model model){
        UserEntity userEntity1 = userRepository.findByEmailAndPassword(userEntity.getEmail(), Encryptor.createHash16Char(userEntity.getEmail(),userEntity.getPassword(),100));
        if (userEntity1 == null){
            model.addAttribute("msg", "Dang nhap that bai");
            return "error";
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("user", userEntity1);
            return "redirect:/home";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "redirect:/home";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("userEntity", new UserEntity());
        model.addAttribute("action", "registerUser");
        return "register";
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String userRegister(@ModelAttribute UserEntity userEntity, Model model, HttpServletRequest request){
        try {
            RoleEntity role = new RoleEntity();
            role.setId(2);
            userEntity.setRoleEntity(role);
            userEntity.setPassword(Encryptor.createHash16Char(userEntity.getEmail(), userEntity.getPassword(), 100));

            userRepository.save(userEntity);
//            // takes input from e-mail form
//            String recipient = request.getParameter("email");
//            // creates a simple e-mail object
//            SimpleMailMessage email = new SimpleMailMessage();
//            email.setTo(recipient);
//            email.setSubject("Hotel Emprate");
//            email.setText("Đây là TicketCode của bạn để check in phòng.");
//            mailSender.send(email);
            String body="</h1>Xin chào "+userEntity.getName()+
                    ",</h1><h2>Chúc mừng bạn đã đăng ký tài khoản thành công"+
                    ", bạn vui lòng click vào nút bên dưới để kích hoạt tài khoản của bạn."+
                    " Cảm ơn bạn đã sữ dụng dịch vụ của chúng tôi.</h2>";
            MailSender.sendEmail(userEntity.getEmail(), "Xac nhan tai khoan",body,true);
            model.addAttribute("msg", "Dang ky thanh cong, vui long vao mail de xac nhan.");
            return "success";
        }catch (Exception ex){
            model.addAttribute("msg", "Dang ky that bai");
            return "error";
        }
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(Model model, @PathVariable int id){
        model.addAttribute("userEntity", userRepository.findOne(id));
        model.addAttribute("type","update");
        model.addAttribute("type", "update");
        model.addAttribute("action", "/update");

        model.addAttribute("getSex", getSex());
        return "update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String userUpdate(@ModelAttribute UserEntity userEntity, HttpServletRequest request, Model model){
        try {
            HttpSession session = request.getSession();
            userRepository.save(userEntity);
            session.setAttribute("user",userEntity);
            model.addAttribute("msg","Cap nhat thanh cong");
            return "success";
        }catch (Exception ex){
            model.addAttribute("msg", "Cap nhat khong thanh cong");
            return "error";
        }
    }

    public Map<Integer, String> getSex(){
        Map<Integer,String> hm= new LinkedHashMap<>();
        hm.put(0,"Nam");
        hm.put(1,"Nữ");
        hm.put(2,"Khác");
        return hm;
    }

    @RequestMapping(value = "change",method = RequestMethod.GET)
    public String change(){return "changepass";}

    @RequestMapping(value = "change", method = RequestMethod.POST)
    public String doChange(Model model, @RequestParam(name = "pass")String password, HttpServletRequest request){
        HttpSession session = request.getSession();
        UserEntity userEntity = (UserEntity) session.getAttribute("user");
        if (userEntity!= null){
            userEntity.setPassword(Encryptor.createHash(password,userEntity.getEmail(),100));
            userRepository.save(userEntity);
            model.addAttribute("msg", "Đổi mật khẩu thành công");
            return "success";
        }else {
            model.addAttribute("msg","Thay đổi thất bại");
            return "error";
        }
    }
}
