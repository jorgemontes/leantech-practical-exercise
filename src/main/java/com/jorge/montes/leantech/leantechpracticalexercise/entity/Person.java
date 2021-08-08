package com.jorge.montes.leantech.leantechpracticalexercise.entity;

import javax.persistence.*;
import java.util.UUID;

@Embeddable
public class Person {

    @Column(name = "person_id")
    private String id;

    private String name;

    private String lastName;

    private String address;

    private String cellphone;

    private String cityName;

    public Person() {
    }

    public Person(String id, String name, String lastName, String address, String cellphone, String cityName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.cellphone = cellphone;
        this.cityName = cityName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
