package com.example.demo.entity;

import jakarta.persistence.Entity;

// import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float battery_power;
    private float blue;
    private float clock_speed;
    private float dual_sim;
    private float fc;
    private float four_g;
    private float int_memory;
    private float m_dep;
    private float mobile_wt;
	private float n_cores;
    private float pc;
    private float px_height;
    private float px_width;
    private float ram;
    private float sc_h;
    private float sc_w;
    private float talk_time;
	private float three_g;
    private float touch_screen;
    private float wifi;

    public Device() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getBattery_power() {
        return battery_power;
    }

    public void setBattery_power(float battery_power) {
        this.battery_power = battery_power;
    }

    public float getBlue() {
        return blue;
    }

    public void setBlue(float blue) {
        this.blue = blue;
    }

    public float getClock_speed() {
        return clock_speed;
    }

    public void setClock_speed(float clock_speed) {
        this.clock_speed = clock_speed;
    }

    public float getDual_sim() {
        return dual_sim;
    }

    public void setDual_sim(float dual_sim) {
        this.dual_sim = dual_sim;
    }

    public float getFc() {
        return fc;
    }

    public void setFc(float fc) {
        this.fc = fc;
    }

    public float getFour_g() {
        return four_g;
    }

    public void setFour_g(float four_g) {
        this.four_g = four_g;
    }

    public float getInt_memory() {
        return int_memory;
    }

    public void setInt_memory(float int_memory) {
        this.int_memory = int_memory;
    }

    public float getM_dep() {
        return m_dep;
    }

    public void setM_dep(float m_dep) {
        this.m_dep = m_dep;
    }

    public float getMobile_wt() {
        return mobile_wt;
    }

    public void setMobile_wt(float mobile_wt) {
        this.mobile_wt = mobile_wt;
    }

    public float getN_cores() {
        return n_cores;
    }

    public void setN_cores(float n_cores) {
        this.n_cores = n_cores;
    }

    public float getPc() {
        return pc;
    }

    public void setPc(float pc) {
        this.pc = pc;
    }

    public float getPx_height() {
        return px_height;
    }

    public void setPx_height(float px_height) {
        this.px_height = px_height;
    }

    public float getPx_width() {
        return px_width;
    }

    public void setPx_width(float px_width) {
        this.px_width = px_width;
    }

    public float getRam() {
        return ram;
    }

    public void setRam(float ram) {
        this.ram = ram;
    }

    public float getSc_h() {
        return sc_h;
    }

    public void setSc_h(float sc_h) {
        this.sc_h = sc_h;
    }

    public float getSc_w() {
        return sc_w;
    }

    public void setSc_w(float sc_w) {
        this.sc_w = sc_w;
    }
    
    public float getTalk_time() {
        return talk_time;
    }

    public void setTalk_time(float talk_time) {
        this.talk_time = talk_time;
    }

    public float getThree_g() {
        return three_g;
    }

    public void setThree_g(float three_g) {
        this.three_g = three_g;
    }

    public float getTouch_screen() {
        return touch_screen;
    }

    public void setTouch_screen(float touch_screen) {
        this.touch_screen = touch_screen;
    }

    public float getWifi() {
        return wifi;
    }

    public void setWifi(float wifi) {
        this.wifi = wifi;
    }
}