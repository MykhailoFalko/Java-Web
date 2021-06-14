package com.example.FinalProject.db.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Slot implements Serializable {

    public Slot() {
    }

    public void setIsDone(int isDone) {
        this.isDone = isDone;
    }

    public int getIsDone() {
        return isDone;
    }

    public Slot(Date date, Time time, int serviceId, int clientId, int workerId,int isDone) {
        this.date = date;
        this.time = time;
        this.serviceId = serviceId;
        this.clientId = clientId;
        this.workerId = workerId;
        this.isDone = isDone;
    }

    private int id;
    private Date date;
    private Time time;
    private int  serviceId;
    private int  clientId;
    private int workerId;
    private int isDone;

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public int getClientId() {
        return clientId;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getServiceId() {
        return serviceId;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    @Override
    public String toString() {
        return "Slot" + " id=" + id + ", date=" + date + ", time=" + time+ ", serviceId=" + serviceId + ", clientId=" + clientId + ", workerId=" + workerId ;
    }
}
