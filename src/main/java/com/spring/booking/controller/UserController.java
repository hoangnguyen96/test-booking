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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("userEntity", new UserEntity());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLogin(@ModelAttribute UserEntity userEntity, Model model,HttpServletRequest request) {
        try {
            UserEntity userEntity1= userRepository.findByEmailAndPassword(userEntity.getEmail(),Encryptor.createHash(userEntity.getEmail(),userEntity.getPassword(),100));
            if(userEntity1 == null) {
                model.addAttribute("msg", "Đăng nhập thất bại!");
                return "error";
            }
            else {
                HttpSession session = request.getSession();
                session.setAttribute("user", userEntity1);
                return "redirect:/home";
            }
        }
        catch (Exception ex){
            model.addAttribute("msg", "Đăng nhập không thành công, vui lòng đăng nhập lại");
            return "error";
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
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String userRegister(@ModelAttribute UserEntity userEntity, Model model, HttpServletRequest request) {
        try {
            RoleEntity role = new RoleEntity();
            role.setId(2);
            userEntity.setRoleEntity(role);
            userEntity.setPassword(Encryptor.createHash(userEntity.getEmail(), userEntity.getPassword(), 100));
            try {
                userRepository.save(userEntity);
//            // takes input from e-mail form
//            String recipient = request.getParameter("email");
//            // creates a simple e-mail object
//            SimpleMailMessage email = new SimpleMailMessage();
//            email.setTo(recipient);
//            email.setSubject("Hotel Emprate");
//            email.setText("Chúc mừng bạn đã đăng ký tài khoản thành công");
//            mailSender.send(email);
                String body = "</h1>Xin chào <b>" + userEntity.getName() +
                        "</b>,</h1><h2>Chúc mừng bạn đã đăng ký tài khoản thành công" +
                        ", bạn vui lòng giữ mã này khi check in tại khách sạn.</h2>"+
                        "<b style='color:blue;'>"+Encryptor.createHash16Char(userEntity.getEmail(), userEntity.getPassword(), 100)+"</b>";
                MailSender.sendEmail(userEntity.getEmail(), "Code checkin.", body, true);
                model.addAttribute("msg", "Đăng ký thành công, vui lòng vào mail để nhận mã check in.");
                return "success";
            } catch (Exception ex) {
                model.addAttribute("msg", "Đăng ký thất bại.");
                return "error";
            }
//            } else {
//                model.addAttribute("msg", "Lỗi hệ thống, vui lòng đăng ký lại!");
//                return "error";

        }catch (Exception ex){
            model.addAttribute("msg", "Lỗi hệ thống, vui lòng đăng ký lại!");
            return "error";
        }
    }

    @RequestMapping(value = "/active", method = RequestMethod.GET)
    public String active(@RequestParam(name = "code")String code, HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        UserEntity userEntity = (UserEntity) session.getAttribute("user");
        if (userEntity!=null) {
            if (!userEntity.getEnable().equalsIgnoreCase("active")) {
                userEntity.setEnable("active");
                userRepository.save(userEntity);
                return "redirect:/home";
            } else {
                model.addAttribute("msg", "Xác nhận tài khoản không thành công, vui lòng vào email để kích hoạt!");
                return "error";
            }
        }else {
            model.addAttribute("msg", "Lỗi xác nhận tài khoản!");
            return "error";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        UserEntity userEntity = (UserEntity) session.getAttribute("user");

        model.addAttribute("userEntity", userEntity);
        model.addAttribute("getSex", getSex());
        return "update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String userUpdate(@ModelAttribute UserEntity userEntity, HttpServletRequest request, Model model){
        try {
            HttpSession session = request.getSession();
            userRepository.save(userEntity);
            session.setAttribute("user",userEntity);
            model.addAttribute("msg","Cập nhật thành công.");
            return "success";
        }catch (Exception ex){
            model.addAttribute("msg", "Cập nhật thất bại, vui lòng cập nhật lại!");
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
