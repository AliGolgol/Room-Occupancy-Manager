package com.smarthost.roomoccupancymanager.application.dtos;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationResult that = (ReservationResult) o;
        return premiumOccupiedRooms == that.premiumOccupiedRooms && Double.compare(that.premiumRoomsRevenue, premiumRoomsRevenue) == 0 && economyOccupiedRooms == that.economyOccupiedRooms && Double.compare(that.economyRoomsRevenue, economyRoomsRevenue) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(premiumOccupiedRooms, premiumRoomsRevenue, economyOccupiedRooms, economyRoomsRevenue);
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
