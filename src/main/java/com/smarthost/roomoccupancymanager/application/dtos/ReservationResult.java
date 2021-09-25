package com.smarthost.roomoccupancymanager.application.dtos;

public class ReservationResult {
    private int economyOccupiedRooms;
    private int premiumOccupiedRooms;
    private double economyRoomsRevenue;
    private double premiumRoomsRevenue;

    ReservationResult(final int economyOccupiedRooms,
                      final int premiumOccupiedRooms,
                      final double economyRoomsRevenue,
                      final double premiumRoomsRevenue) {
        this.economyOccupiedRooms = economyOccupiedRooms;
        this.premiumOccupiedRooms = premiumOccupiedRooms;
        this.economyRoomsRevenue = economyRoomsRevenue;
        this.premiumRoomsRevenue = premiumRoomsRevenue;
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
        return "BookingForecastResult{" +
                "economyOccupiedRooms=" + economyOccupiedRooms +
                ", premiumOccupiedRooms=" + premiumOccupiedRooms +
                ", economyRoomsRevenue=" + economyRoomsRevenue +
                ", premiumRoomsRevenue=" + premiumRoomsRevenue +
                '}';
    }
}
