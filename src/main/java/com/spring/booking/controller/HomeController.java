package com.spring.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by PC on 09/20/17.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home(){return "index";}

}
