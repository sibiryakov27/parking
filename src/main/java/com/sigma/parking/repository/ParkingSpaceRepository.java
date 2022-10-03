package com.sigma.parking.repository;

import com.sigma.parking.data.entity.ParkingSpaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpaceRepository extends JpaRepository<ParkingSpaceEntity, Integer> {
}
