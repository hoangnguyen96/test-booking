package com.spring.booking.controller;

import com.spring.booking.entities.RoleEntity;
import com.spring.booking.entities.UserEntity;
import com.spring.booking.more.Encryptor;
import com.spring.booking.more.MailSender;
import com.spring.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam("searchInput") String searchInput, Model model){
        List<UserEntity> list;
        if (searchInput.isEmpty()){
            list = (List<UserEntity>) userRepository.findAll();
        }else{
            list = userRepository.findByNameContaining(searchInput);
        }
        model.addAttribute("listSearch", list);
        return "../admin/user";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable int id){
        userRepository.delete(id);
        return "redirect:/user";
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

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String userRegister(@ModelAttribute UserEntity userEntity, Model model){
        RoleEntity role = new RoleEntity();
        role.setId(2);
        userEntity.setRoleEntity(role);
        userEntity.setPassword(Encryptor.createHash16Char(userEntity.getEmail(),userEntity.getPassword(),100));
        try {
            userRepository.save(userEntity);
            String body="Da vao";
            MailSender.sendEmail(userEntity.getEmail(),"Xac nhan tai khoan",body,true);
            model.addAttribute("msg","Dang ky thanh cong, vui long vao mail de xac nhan.");
            return "success";
        }catch (Exception ex){
            model.addAttribute("msg", "dang ky that bai");
            return "error";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        UserEntity userEntity = (UserEntity) session.getAttribute("user");

        userEntity.getName();
        userEntity.getEmail();
        userEntity.getRoleEntity().getName();
        model.addAttribute("user", new UserEntity());
        model.addAttribute("getSex", getSex());
        return "update";
    }

//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public String userUpdate(@ModelAttribute UserEntity userEntity, HttpServletRequest request, Model model){
//        try {
//            HttpSession session = request.getSession();
//            userRepository.save(userEntity);
//            session.setAttribute("user",userEntity);
//            model.addAttribute("msg","Cap nhat thanh cong");
//            return "success";
//        }catch (Exception ex){
//            model.addAttribute("msg", "Cap nhat khong thanh cong");
//            return "error";
//        }
//    }
    public Map<Integer, String> getSex(){
        Map<Integer,String> hm= new LinkedHashMap<>();
        hm.put(0,"Nam");
        hm.put(1,"Nữ");
        hm.put(2,"Khác");
        return hm;
    }
}
