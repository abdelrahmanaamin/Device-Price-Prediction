package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Device;
import com.example.demo.service.ExcelService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/excel")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    // @PostMapping("/import")
    // public void importDataFromExcel(@RequestParam("filePath") String filePath) throws IOException {
    //     excelService.readExcelFileAndSaveToDatabase(filePath);
    // }
    @PostMapping("/import")
    public void addDevices(@RequestBody List<Device> devices) {
        excelService.populateDatabase(devices);
    }
}