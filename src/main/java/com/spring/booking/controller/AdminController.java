package com.spring.booking.controller;

import com.spring.booking.entities.UserEntity;
import com.spring.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by PC on 09/20/17.
 */
@Controller
public class AdminController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/admin")
    public String admin(){return "../admin/admin";}

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String showUser(Model model){
        List<UserEntity> userList = (List<UserEntity>) userRepository.findAll();
        model.addAttribute("userList",userList);
        return "../admin/user";
    }
//    @RequestMapping(value = "/user")
//    public String user(){return "../admin/user";}
//
//    @RequestMapping(value = "/hotel")
//    public String hotel(){return "../admin/hotel";}
}
