package com.example.demo.model.DTO;

import com.example.demo.model.domain.Orders;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class UsersDTO implements Serializable {
    private Long userId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Boolean active;
    private Date birthday;
    private List<Orders> listOrders = new ArrayList<>();

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Orders> getListOrders() {
        return listOrders;
    }

    public void setListOrders(List<Orders> listOrders) {
        this.listOrders = listOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersDTO usersDTO = (UsersDTO) o;
        return Objects.equals(firstName, usersDTO.firstName) &&
                Objects.equals(lastName, usersDTO.lastName) &&
                Objects.equals(username, usersDTO.username) &&
                Objects.equals(password, usersDTO.password) &&
                Objects.equals(active, usersDTO.active) &&
                Objects.equals(birthday, usersDTO.birthday) &&
                Objects.equals(listOrders, usersDTO.listOrders);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName, username, password, active, birthday, listOrders);
    }


}
