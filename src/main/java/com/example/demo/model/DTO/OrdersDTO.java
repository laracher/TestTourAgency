package com.example.demo.model.DTO;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class OrdersDTO implements Serializable {
    private Long orderId;
    private Boolean confirmed;
    private Date timeKey;
    private UsersDTO usersDTO;
    private ToursDTO toursDTO;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Date getTimeKey() {
        return timeKey;
    }

    public void setTimeKey(Date timeKey) {
        this.timeKey = timeKey;
    }

    public UsersDTO getUsersDTO() {
        return usersDTO;
    }

    public void setUsersDTO(UsersDTO usersDTO) {
        this.usersDTO = usersDTO;
    }

    public ToursDTO getToursDTO() {
        return toursDTO;
    }

    public void setToursDTO(ToursDTO toursDTO) {
        this.toursDTO = toursDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersDTO ordersDTO = (OrdersDTO) o;
        return Objects.equals(confirmed, ordersDTO.confirmed) &&
                Objects.equals(timeKey, ordersDTO.timeKey) &&
                Objects.equals(usersDTO, ordersDTO.usersDTO) &&
                Objects.equals(toursDTO, ordersDTO.toursDTO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(confirmed, timeKey, usersDTO, toursDTO);
    }

    @Override
    public String toString() {
        return "OrdersDTO{" +
                "orderId=" + orderId +
                ", confirmed=" + confirmed +
                ", timeKey=" + timeKey +
                ", usersDTO=" + usersDTO +
                ", toursDTO=" + toursDTO +
                '}';
    }
}
