package com.spring.booking.controller;

import com.spring.booking.entities.*;
import com.spring.booking.more.MailSender;
import com.spring.booking.repository.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
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

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    BookingDetailsRepository bookingDetailsRepository;

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

    @RequestMapping(value = "/searchRoom", method = RequestMethod.GET)
    public String searchOrder(@RequestParam("searchInput") String searchInput, Model model){
        List<RoomEntity> listRoom;
        if (searchInput.isEmpty()){
            listRoom = (List<RoomEntity>) roomRepository.findAll();
        }else{
            listRoom = roomRepository.findByNameContaining(searchInput);
        }
        model.addAttribute("roomList", listRoom);
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

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String showOrder(Model model){
        List<BookingDetailsEntity> bookingDetailsList = (List<BookingDetailsEntity>) bookingDetailsRepository.findAll();
        model.addAttribute("bookingList",bookingDetailsList);
        return "/admin/order";
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

    @RequestMapping(value = "/checkin", method = RequestMethod.GET)
    public String checkin(Model model){
        model.addAttribute("bookingDetails", new BookingDetailsEntity());
        setBookingList(model);
        setRoomList(model);
        return "checkin";
    }

    private void setBookingList(Model model) {
        List<BookingEntity> bookingList = (List<BookingEntity>) bookingRepository.findAll();
        if (!bookingList.isEmpty()) {
            Map<Integer, String> bookingMap = new LinkedHashMap<>();
            for(BookingEntity bookingEntity : bookingList) {
                bookingMap.put(bookingEntity.getId(), bookingEntity.getName());
            }
            model.addAttribute("bookingList", bookingMap);
        }
    }

    private void setRoomList(Model model) {
        List<RoomEntity> roomList = (List<RoomEntity>) roomRepository.findAll();
        if (!roomList.isEmpty()) {
            Map<Integer, String> roomMap = new LinkedHashMap<>();
            for(RoomEntity roomEntity : roomList) {
                roomMap.put(roomEntity.getId(), roomEntity.getName());
            }
            model.addAttribute("roomList", roomMap);
        }
    }

    @RequestMapping(value = "/orderCheckIn", method = RequestMethod.POST)
    public String orderCheckIn(@ModelAttribute BookingDetailsEntity bookingDetails, Model model){
        bookingDetailsRepository.save(bookingDetails);
        model.addAttribute("msg","okokok");
        return "success";
//        try {
//            BookingEntity bookingEntity = new BookingEntity();
//            RoomEntity roomEntity = new RoomEntity();
//            bookingEntity.getName();
//
//            bookingDetailsRepository.save(bookingDetails);
//            String body = "<h1>Xin chào <b>" + bookingDetails.getBookingId().getName() + "</b>,</h2>" +
//                    "Chúc mừng bạn đã đặt phòng thành công, bạn vui lòng giữ mã này khi check in tại khách sạn.</h2>";
//            try {
//                MailSender.sendEmail(bookingDetails.getBookingId().getEmail(), "Mã Booking của khách hàng.", body, true);
//            } catch (MessagingException e) {
//                e.printStackTrace();
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//            model.addAttribute("msg", "Chúc mừng bạn đã đặt phòng thành công, bạn vui lòng vào mail để nhận mã check in, trân trọng.");
//            return "success";
//        }catch (Exception ex){
//            model.addAttribute("msg","Đặt phòng không thành công!");
//            return "error";
//        }
    }
//    @RequestMapping(value = "/user")
//    public String user(){return "../admin/user";}
//
//    @RequestMapping(value = "/hotel")
//    public String hotel(){return "../admin/hotel";}
}
