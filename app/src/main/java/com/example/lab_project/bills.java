package com.example.lab_project;

public class bills {

    String room, household, food, Total;

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getHousehold() {
        return household;
    }

    public void setHousehold(String household) {
        this.household = household;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public bills(String room, String household, String food, String total) {
        this.room = room;
        this.household = household;
        this.food = food;
        Total = total;
    }


}
