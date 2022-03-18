package com.juaracoding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juaracoding.model.SeatModel;

public interface SeatRepository extends JpaRepository<SeatModel, Long> {

}
