package com.spring.booking.controller;

import com.spring.booking.entities.RoomEntity;
import com.spring.booking.entities.RoomTypeEntity;
import com.spring.booking.entities.UserEntity;
import com.spring.booking.repository.RoomRepository;
import com.spring.booking.repository.RoomTypeRepository;
import com.spring.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by PC on 09/20/17.
 */
@Controller
public class AdminController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    RoomTypeRepository roomTypeRepository;

    @RequestMapping(value = "/admin")
    public String admin(){return "/admin/admin";}

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload(Model model){
        model.addAttribute("roomEntity", new RoomEntity());
        setRoomTypelist(model);
        return "/admin/upload";
    }

    @RequestMapping(value = "/room",method = RequestMethod.GET)
    public String showRoom(Model model){
        List<RoomEntity> roomList = (List<RoomEntity>) roomRepository.findAll();
        model.addAttribute("roomList",roomList);
        return "/admin/room";
    }

    @RequestMapping(value = "/deleted/{id}", method = RequestMethod.GET)
    public String deleteRoom(@PathVariable int id){
        roomRepository.delete(id);
        return "redirect:/room";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String showUser(Model model){
        List<UserEntity> userList = (List<UserEntity>) userRepository.findAll();
        model.addAttribute("userList",userList);
        return "/admin/user";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam("searchInput") String searchInput, Model model){
        List<UserEntity> list;
        if (searchInput.isEmpty()){
            list = (List<UserEntity>) userRepository.findAll();
        }else{
            list = userRepository.findByNameContainingOrScmndContaining(searchInput,searchInput);
        }
        model.addAttribute("userList", list);
        return "/admin/user";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable int id){
        userRepository.delete(id);
        return "redirect:/user";
    }

    private void setRoomTypelist(Model model) {
        List<RoomTypeEntity> roomTypeList = (List<RoomTypeEntity>) roomTypeRepository.findAll();
        if (!roomTypeList.isEmpty()) {
            Map<Integer, String> cateMap = new LinkedHashMap<>();
            for(RoomTypeEntity roomType : roomTypeList) {
                cateMap.put(roomType.getId(), roomType.getName());
            }
            model.addAttribute("roomType", cateMap);
        }
    }
//    @RequestMapping(value = "/user")
//    public String user(){return "../admin/user";}
//
//    @RequestMapping(value = "/hotel")
//    public String hotel(){return "../admin/hotel";}
}
