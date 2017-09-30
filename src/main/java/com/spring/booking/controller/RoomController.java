package com.spring.booking.controller;

import com.spring.booking.entities.RoomEntity;
import com.spring.booking.entities.RoomTypeEntity;
import com.spring.booking.entities.UserEntity;
import com.spring.booking.more.FileUploader;
import com.spring.booking.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by PC on 09/28/17.
 */
@Controller
public class RoomController {
    @Autowired
    RoomRepository roomRepository;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadRoom(@ModelAttribute RoomEntity roomEntity, MultipartFile file,
                             HttpServletRequest request, Model model) {
        try {
            String image = "/resources/img/" + FileUploader.uploadFile(file, "D:\\Hoang\\TestBooking\\test-booking\\src\\main\\webapp\\resources\\img");
            roomEntity.setPhoto(image);
            roomRepository.save(roomEntity);
            return "redirect:/room";
        }catch (Exception ex){
            model.addAttribute("msg","Lỗi khi thêm phòng!");
            return "error";
        }

    }
}
