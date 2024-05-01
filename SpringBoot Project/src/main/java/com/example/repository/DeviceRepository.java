package com.example.repository;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Device;

@Repository
@EntityScan("com.*")  
public interface DeviceRepository extends JpaRepository<Device, Long> {
}