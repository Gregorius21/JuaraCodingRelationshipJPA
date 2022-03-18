package com.juaracoding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juaracoding.model.ScreeningModel;

public interface ScreeningRepository extends JpaRepository<ScreeningModel, Long> {

}
