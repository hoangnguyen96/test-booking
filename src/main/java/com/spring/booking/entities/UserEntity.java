package com.spring.booking.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by PC on 09/20/17.
 */
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userId")
    private List<BookingEntity> bookingEntityList;

    @Column(name = "Name")
    private String name;

    @Column(name = "Scmnd")
    private String scmnd;

    @Column(name = "Email")
    private String email;

    @Column(name = "Address")
    private String address;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Password")
    private String password;

    @Column(name = "Sex")
    private String sex;

    @Column(name = "Enable")
    private String enable;

    @ManyToOne
    @JoinColumn(name = "RoleId")
    private RoleEntity roleEntity;

    public UserEntity() {
    }

    public UserEntity(List<BookingEntity> bookingEntityList, String name, String scmnd, String email, String address, String phone, String password, String sex, String enable, RoleEntity roleEntity) {
        this.bookingEntityList = bookingEntityList;
        this.name = name;
        this.scmnd = scmnd;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.password = password;
        this.sex = sex;
        this.enable = enable;
        this.roleEntity = roleEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<BookingEntity> getBookingEntityList() {
        return bookingEntityList;
    }

    public void setBookingEntityList(List<BookingEntity> bookingEntityList) {
        this.bookingEntityList = bookingEntityList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScmnd() {
        return scmnd;
    }

    public void setScmnd(String scmnd) {
        this.scmnd = scmnd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }
}
