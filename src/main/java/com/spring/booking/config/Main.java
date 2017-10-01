package com.spring.booking.config;

import com.spring.booking.entities.RoomEntity;
import com.spring.booking.entities.UserEntity;
import com.spring.booking.more.DateFormat;
import com.spring.booking.repository.RoomRepository;
import com.spring.booking.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by PC on 09/20/17.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        UserRepository userRepository = (UserRepository) context.getBean("userRepository");
//        List<UserEntity> ls = (List<UserEntity>) userRepository.findAll();
//        for (UserEntity u:ls){
//            System.out.println(u.getName());
//        }
//        RoomRepository roomRepository = (RoomRepository) context.getBean("roomRepository");
//       // List<RoomEntity> list = (List<RoomEntity>) roomRepository.findAll();
//        List<RoomEntity> roomEntityList = roomRepository.findByAvailableRoom("2017/09/26","2017/10/20",2);
//        for (RoomEntity r:roomEntityList ){
//            System.out.println(r.getName());
//        }
    }
}
