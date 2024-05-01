package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Device;
import com.example.demo.service.PredictionService;
import com.example.repository.DeviceRepository;

@RestController
@RequestMapping("/api/predict")
public class PredictionController {

    @Autowired
    private PredictionService predictionService;
    @Autowired
    private DeviceRepository deviceRepository;

    @PostMapping("/{deviceId}")
    public ResponseEntity<?> predictPrice(@PathVariable Long deviceId) {
        Device device = deviceRepository.findById((long) deviceId).orElse(null);
        if (device == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Device not found.");
        }
        int priceRange = predictionService.predictPrice(device);
        return ResponseEntity.status(HttpStatus.OK).body("The Price Range for the device with id: "+deviceId+" is: "+priceRange);
    }
}