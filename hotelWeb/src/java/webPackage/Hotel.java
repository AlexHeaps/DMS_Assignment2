/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webPackage;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Ryan Hotel (room) bean
 */
public class Hotel implements Serializable {

    private int roomNum;
    private int maxNumPeople;
    private String roomType;
    private boolean vacant;
    private Date occupiedFrom;
    private Date occupiedUntil;

    public Hotel() {

        roomNum = 0;
        maxNumPeople = 0;
        roomType = null;
        vacant = false;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getMaxNumPeople() {
        return maxNumPeople;
    }

    public void setMaxNumPeople(int maxNumPeople) {
        this.maxNumPeople = maxNumPeople;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isVacant() {
        return vacant;
    }

    public void setVacant(boolean vacant) {
        this.vacant = vacant;
    }

    public Date getOccupiedFrom() {
        return occupiedFrom;
    }

    public void setOccupiedFrom(Date occupiedFrom) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("DD-MM-YYYY");
        String occFrom = sdf.format(occupiedFrom);
        this.occupiedFrom = occupiedFrom;
    }

    public Date getOccupiedUntil() {
        return occupiedUntil;
    }

    public void setOccupiedUntil(Date occupiedUntil) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("DD-MM-YYYY");
        String occUntil = sdf.format(occupiedUntil);
        this.occupiedUntil = occupiedUntil;
    }

}
