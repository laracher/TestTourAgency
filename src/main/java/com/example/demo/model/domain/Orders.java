package com.example.demo.model.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ORDERS")
public class Orders {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long orderId;

//    @Column(name = "users_id")
//    private Long usersId;
//
//    @Column(name = "tour_id")
//    private Long tourId;

    @Column(name = "confirmed")
    private Boolean confirmed;

    @Column(name = "time_key")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeKey;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "tour_id")
    private Tours tour;

    public Orders() {}

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public Long getTourId() {
//        return tourId;
//    }
//
//    public void setTourId(Long tourId) {
//        this.tourId = tourId;
//    }

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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Tours getTour() {
        return tour;
    }

    public void setTour(Tours tour) {
        this.tour = tour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return Objects.equals(orderId, orders.orderId) &&
                Objects.equals(confirmed, orders.confirmed) &&
                Objects.equals(timeKey, orders.timeKey) &&
                Objects.equals(user, orders.user) &&
                Objects.equals(tour, orders.tour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, confirmed, timeKey, user, tour);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", confirmed=" + confirmed +
                ", timeKey=" + timeKey +
                ", user=" + user +
                ", tour=" + tour +
                '}';
    }
}
