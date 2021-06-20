package com.ailtonluiz.parking.domain.repository;

import com.ailtonluiz.parking.domain.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long> {
}
