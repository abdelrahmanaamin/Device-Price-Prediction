package com.example.demo.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Device;
import com.example.repository.DeviceRepository;

@Service
public class ExcelService {

    @Autowired
    private DeviceRepository deviceRepository;

    public void readExcelFileAndSaveToDatabase(String filePath) throws IOException {
        List<Device> devices = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(fis)) {
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next(); // Skip header row

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Device device = new Device();
                
                device.setId((long)row.getCell(0).getNumericCellValue());
                device.setBattery_power((int)row.getCell(1).getNumericCellValue());
                device.setBlue((int)row.getCell(2).getNumericCellValue());
                device.setClock_speed((float)row.getCell(3).getNumericCellValue());
                device.setDual_sim((int)row.getCell(4).getNumericCellValue());
                device.setFc((int)row.getCell(5).getNumericCellValue());
                device.setFour_g((int)row.getCell(6).getNumericCellValue());
                device.setInt_memory((int)row.getCell(7).getNumericCellValue());
                device.setM_dep((int)row.getCell(8).getNumericCellValue());
                device.setMobile_wt((int)row.getCell(9).getNumericCellValue());
                device.setN_cores((int)row.getCell(10).getNumericCellValue());
                device.setPc((int)row.getCell(11).getNumericCellValue());
                device.setPx_height((int)row.getCell(12).getNumericCellValue());
                device.setPx_width((int)row.getCell(13).getNumericCellValue());
                device.setRam((int)row.getCell(14).getNumericCellValue());
                device.setSc_h((int)row.getCell(15).getNumericCellValue());
                device.setSc_w((int)row.getCell(16).getNumericCellValue());
                device.setTalk_time((int)row.getCell(17).getNumericCellValue());
                device.setThree_g((int)row.getCell(18).getNumericCellValue());
                device.setTouch_screen((int)row.getCell(19).getNumericCellValue());
                device.setWifi((int)row.getCell(20).getNumericCellValue());

                devices.add(device);
            }
        }

        deviceRepository.saveAll(devices);
    }
    public void populateDatabase(List<Device> devices) {
        deviceRepository.saveAll(devices);
    }
}