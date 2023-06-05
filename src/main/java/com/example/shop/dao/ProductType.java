package com.example.shop.dao;

import com.example.shop.dao.entity.HDD;
import com.example.shop.dao.entity.Laptop;
import com.example.shop.dao.entity.Monitor;
import com.example.shop.dao.entity.PC;

public enum ProductType {
    PC(PC.class),
    LAPTOP(Laptop.class),
    MONITOR(Monitor.class),
    HDD(HDD.class);

    private Class classEntity;

    ProductType(Class classEntity) {
        this.classEntity = classEntity;
    }

    public Class getClassEntity() {
        return classEntity;
    }

    public final static String DESKTOP_NAME = "PC";
    public final static String LAPTOP_NAME = "LAPTOP";
    public final static String HDD_NAME = "HDD";
    public final static String MONITOR_NAME = "MONITOR";

}
