package com.spring.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by PC on 09/20/17.
 */
@Controller
public class AdminController {

    @RequestMapping(value = "/admin")
    public String admin(){return "../admin/admin";}


//    @RequestMapping(value = "/user")
//    public String user(){return "../admin/user";}
//
//    @RequestMapping(value = "/hotel")
//    public String hotel(){return "../admin/hotel";}
}
