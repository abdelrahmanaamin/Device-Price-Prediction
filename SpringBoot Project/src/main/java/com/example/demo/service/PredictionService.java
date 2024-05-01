package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Device;

import jep.Jep;
import jep.SubInterpreter;

@Service
public class PredictionService {

    //Maximum values for normalization, these were extracted from the training data.
    private int batterPowerMax = 1998;
    private int blueMax = 1;
    private int ClockSpeedMax = 3;
    private int dual_simMax = 1;
    private int fcMax = 19;
    private int four_gMax = 1;
    private int int_memoryMax = 64;
    private int m_depMax = 1;
    private int mobile_wtMax = 200;
    private int n_coresMax = 8;
    private int pcMax = 20;
    private int px_heightMax = 1960;
    private int px_widthMax = 1998;
    private int ramMax = 3998;
    private int sc_hMax = 19;
    private int sc_wMax = 18;
    private int talk_timeMax = 20;
    private int three_gMax = 1;
    private int touch_screenMax = 1;
    private int wifiMax = 1;
    

    @Transactional
    public int predictPrice(Device device) {
        device = preprocessDevice(device);
        try(Jep jep = new SubInterpreter()) {
            // Load model
            jep.eval("import pickle");
            jep.eval("with open('price_prediction_model.pkl', 'rb'): as f: clf = pickle.load(f)");
            jep.set("arg", device);
            jep.eval("prediction = clf.predict(arg)");
            Object result = jep.getValue("result");
            return (int)result;
        }
    }

    public Device preprocessDevice(Device device){
        Device preprocessedDevice = new Device();
        
        preprocessedDevice.setId(device.getId());
        preprocessedDevice.setBattery_power(device.getBattery_power()/batterPowerMax);
        preprocessedDevice.setBlue(device.getBlue()/blueMax);
        preprocessedDevice.setClock_speed(device.getClock_speed()/ClockSpeedMax);
        preprocessedDevice.setDual_sim(device.getDual_sim()/dual_simMax);
        preprocessedDevice.setFc(device.getFc()/fcMax);
        preprocessedDevice.setFour_g(device.getFour_g()/four_gMax);
        preprocessedDevice.setInt_memory(device.getInt_memory()/int_memoryMax);
        preprocessedDevice.setM_dep(device.getM_dep()/m_depMax);
        preprocessedDevice.setMobile_wt(device.getMobile_wt()/mobile_wtMax);
        preprocessedDevice.setN_cores(device.getN_cores()/n_coresMax);
        preprocessedDevice.setPc(device.getPc()/pcMax);
        preprocessedDevice.setPx_height(device.getPx_height()/px_heightMax);
        preprocessedDevice.setPx_width(device.getPx_width()/px_widthMax);
        preprocessedDevice.setRam(device.getRam()/ramMax);
        preprocessedDevice.setSc_h(device.getSc_h()/sc_hMax);
        preprocessedDevice.setSc_w(device.getSc_w()/sc_wMax);
        preprocessedDevice.setTalk_time(device.getTalk_time()/talk_timeMax);
        preprocessedDevice.setThree_g(device.getThree_g()/three_gMax);
        preprocessedDevice.setTouch_screen(device.getTouch_screen()/touch_screenMax);
        preprocessedDevice.setWifi(device.getWifi()/wifiMax);
        return preprocessedDevice;
    }
}