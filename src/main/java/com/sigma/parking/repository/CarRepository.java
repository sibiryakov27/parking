package com.sigma.parking.repository;

import com.sigma.parking.data.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Integer> {
    Optional<CarEntity> findByCarNumber(String carNumber);
}
