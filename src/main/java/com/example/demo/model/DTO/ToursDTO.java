package com.example.demo.model.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ToursDTO implements Serializable {
    private Long tourId;
    private String name;
    private String description;
    private String location;
    private Date startDate;
    private Date endDate;
    private Integer countLimit;
    private List<OrdersDTO> listOrders = new ArrayList<>();

    public Long getTourId() {
        return tourId;
    }

    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getCountLimit() {
        return countLimit;
    }

    public void setCountLimit(Integer countLimit) {
        this.countLimit = countLimit;
    }

    public List<OrdersDTO> getListOrders() {
        return listOrders;
    }

    public void setListOrders(List<OrdersDTO> listOrders) {
        this.listOrders = listOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToursDTO toursDTO = (ToursDTO) o;
        return Objects.equals(name, toursDTO.name) &&
                Objects.equals(description, toursDTO.description) &&
                Objects.equals(location, toursDTO.location) &&
                Objects.equals(startDate, toursDTO.startDate) &&
                Objects.equals(endDate, toursDTO.endDate) &&
                Objects.equals(countLimit, toursDTO.countLimit) &&
                Objects.equals(listOrders, toursDTO.listOrders);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, description, location, startDate, endDate, countLimit, listOrders);
    }

    @Override
    public String toString() {
        return "ToursDTO{" +
                "tourId=" + tourId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", countLimit=" + countLimit +
                ", listOrders=" + listOrders +
                '}';
    }
}
