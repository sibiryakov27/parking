package com.sigma.parking.data.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "parking_spaces")
public class ParkingSpaceEntity {
    @Id
    @Column(name = "parking_space_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "occupied")
    private Boolean occupied;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "parkingSpace")
    private List<BookingEntity> bookings;
}
