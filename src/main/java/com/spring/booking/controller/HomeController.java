package com.spring.booking.controller;

import com.spring.booking.entities.BookingDetailsEntity;
import com.spring.booking.entities.RoomEntity;
import com.spring.booking.entities.UserEntity;
import com.spring.booking.more.DateFormat;
import com.spring.booking.repository.RoomRepository;
import com.spring.booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 09/20/17.
 */
@Controller
public class HomeController {

    @Autowired
    RoomRepository roomRepository;

    @RequestMapping(value = "/")
    public String home(){return "index";}

    @RequestMapping(value = "/home")
    public String homeindex(){
        return "index";
    }

    @RequestMapping(value = "/rooms",method = RequestMethod.GET)
    public String rooms(Model model){
        List<RoomEntity> list = (List<RoomEntity>) roomRepository.findAll();
        model.addAttribute("list", list);
        return "rooms";
    }

    @RequestMapping(value = "/searchRoom", method = RequestMethod.POST)
    public String search(@RequestParam(name = "fromDate") String fromDate,
                         @RequestParam(name = "toDate") String toDate,
                         @RequestParam(name = "type") String roomType,
                         HttpServletRequest request, Model model){
        List<RoomEntity> roomEntityList = roomRepository.findByAvailableRoom(Integer.parseInt(roomType));
        List<RoomEntity> lstRoomEmpty = new ArrayList<>();
        if(roomEntityList!=null){
            for(RoomEntity roomEntity:roomEntityList){
                if(roomEntity.getBookingDetailsEntityList().size()>0){
                    boolean isExsit = false;
                    for (BookingDetailsEntity detailsEntity:roomEntity.getBookingDetailsEntityList()){
                        if(DateFormat.parseDateToString(fromDate).equals(detailsEntity.getDateCheckIn())||
                                detailsEntity.getDateCheckOut().equals(DateFormat.parseDateToString(toDate))){
                            isExsit = true;
                        }
                        if(detailsEntity.getDateCheckIn().before(DateFormat.parseDateToString(fromDate))
                                && DateFormat.parseDateToString(fromDate).before(detailsEntity.getDateCheckOut())){
                            isExsit = true;
                        }else if(DateFormat.parseDateToString(toDate).before(detailsEntity.getDateCheckOut())
                                && detailsEntity.getDateCheckIn().before(DateFormat.parseDateToString(toDate))){
                            isExsit = true;
                        }else if(DateFormat.parseDateToString(fromDate).before(detailsEntity.getDateCheckIn()) &&
                                detailsEntity.getDateCheckOut().before(DateFormat.parseDateToString(toDate))){
                            isExsit = true;
                        }
                    }
                    if(!isExsit){
                        lstRoomEmpty.add(roomEntity);
                    }
                } else{
                    lstRoomEmpty.add(roomEntity);
                }
            }
        }
//        model.addAttribute("msg", fromDate);
        model.addAttribute("listSearch", lstRoomEmpty);
        return "roomSearch";
    }

//    @RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
//    public String register(){return "forgotpassword";}
//
//    @RequestMapping(value = "/forgotpassword")
//    public String forgotpassword(){return "forgotpassword";}
//


    @RequestMapping(value = "/checkout")
    public String checkout(){return "checkout";}

    @RequestMapping(value = "/roomdetails")
    public String roomdetails(){return "roomdetails";}
}
