package com.spring.booking.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by PC on 09/20/17.
 */
@Entity
@Table(name = "role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "roleEntity")
    private List<UserEntity> userEntityList;

    @Column(name = "Name")
    private String name;

    public RoleEntity() {
    }

    public RoleEntity(List<UserEntity> userEntityList, String name) {
        this.userEntityList = userEntityList;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<UserEntity> getUserEntityList() {
        return userEntityList;
    }

    public void setUserEntityList(List<UserEntity> userEntityList) {
        this.userEntityList = userEntityList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
