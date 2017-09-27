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
public class HomeController {

    @RequestMapping(value = "/")
    public String home(){return "index";}

    @RequestMapping(value = "/home")
    public String homeindex(){return "index";}

    @RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
    public String register(){return "forgotpassword";}
//
//    @RequestMapping(value = "/forgotpassword")
//    public String forgotpassword(){return "forgotpassword";}
//
//    @RequestMapping(value = "/checkin")
//    public String checkin(){return "checkin";}
//
//    @RequestMapping(value = "/checkout")
//    public String checkout(){return "checkout";}
//
//    @RequestMapping(value = "/rooms")
//    public String rooms(){return "rooms";}
//
//    @RequestMapping(value = "/roomdetails")
//    public String roomdetails(){return "roomdetails";}
}
