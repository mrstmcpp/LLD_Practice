package org.mrstm.models;


public class Reservation {
    private Table table;
    private int reservationId;

    public Reservation(Table table , int reservationId){
        this.table = table;
        this.reservationId = reservationId;
    }

}
