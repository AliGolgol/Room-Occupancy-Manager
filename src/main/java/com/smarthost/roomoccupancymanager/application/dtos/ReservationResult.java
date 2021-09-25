package com.smarthost.roomoccupancymanager.application.dtos;

public class ReservationResult {
    private int premiumOccupiedRooms;
    private double premiumRoomsRevenue;
    private int economyOccupiedRooms;
    private double economyRoomsRevenue;

    public ReservationResult(int premiumOccupiedRooms, double premiumRoomsRevenue, int economyOccupiedRooms, double economyRoomsRevenue) {
        this.premiumOccupiedRooms = premiumOccupiedRooms;
        this.premiumRoomsRevenue = premiumRoomsRevenue;
        this.economyOccupiedRooms = economyOccupiedRooms;
        this.economyRoomsRevenue = economyRoomsRevenue;
    }

    public int getEconomyOccupiedRooms() {
        return economyOccupiedRooms;
    }

    public int getPremiumOccupiedRooms() {
        return premiumOccupiedRooms;
    }

    public double getEconomyRoomsRevenue() {
        return economyRoomsRevenue;
    }

    public double getPremiumRoomsRevenue() {
        return premiumRoomsRevenue;
    }

    @Override
    public String toString() {
        return "ReservationResult{" +
                "premiumOccupiedRooms=" + premiumOccupiedRooms +
                ", premiumRoomsRevenue=" + premiumRoomsRevenue +
                ", economyOccupiedRooms=" + economyOccupiedRooms +
                ", economyRoomsRevenue=" + economyRoomsRevenue +
                '}';
    }
}
