package com.smarthost.roomoccupancymanager.domain;

import com.smarthost.roomoccupancymanager.application.dtos.ReservationResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoomOccupancyTest {

    RoomOccupancy roomOccupancy;
    private List<Double> willingnessPayPerNight = new ArrayList<>();

    @BeforeEach
    public void setup(){
        willingnessPayPerNight.addAll(List.of(23.0, 45.0, 155.0, 374.0, 22.0, 99.99, 100.0, 101.0, 115.0, 209.0));
        roomOccupancy = new RoomOccupancy(willingnessPayPerNight);
    }

    @Test
    void givenInputRooms_when3FreePremiumRooms3FreeEconomyRooms_thenReturnUsagePremium3Euro738UsageEconomy3Euro16799(){
        double bids[] = {23, 45, 155, 374, 22, 99.99, 100, 101, 115, 209};
        RoomOccupancy roomOccupancy = new RoomOccupancy(willingnessPayPerNight);
        ReservationResult reservationResult = roomOccupancy.predictReservation(3, 3);

        assertEquals(3, reservationResult.getPremiumOccupiedRooms());
        assertEquals(738, reservationResult.getPremiumRoomsRevenue());
        assertEquals(3, reservationResult.getEconomyOccupiedRooms());
        assertEquals(167.99, reservationResult.getEconomyRoomsRevenue());
    }

    @Test
    void givenInputRooms_when7FreePremiumRooms5FreeEconomyRooms_thenReturnUsagePremium6Euro1054UsageEconomy4Euro18999(){
        double bids[] = {23, 45, 155, 374, 22, 99.99, 100, 101, 115, 209};
        RoomOccupancy roomOccupancy = new RoomOccupancy(willingnessPayPerNight);
        ReservationResult reservationResult = roomOccupancy.predictReservation(7, 5);

        assertEquals(6, reservationResult.getPremiumOccupiedRooms());
        assertEquals(1054, reservationResult.getPremiumRoomsRevenue());
        assertEquals(4, reservationResult.getEconomyOccupiedRooms());
        assertEquals(189.99, reservationResult.getEconomyRoomsRevenue());
    }

    @Test
    void givenInputRooms_when2FreePremiumRooms7FreeEconomyRooms_thenReturnUsagePremium2Euro583UsageEconomy4Euro18999(){
        double bids[] = {23, 45, 155, 374, 22, 99.99, 100, 101, 115, 209};
        RoomOccupancy roomOccupancy = new RoomOccupancy(willingnessPayPerNight);
        ReservationResult reservationResult = roomOccupancy.predictReservation(2, 7);

        assertEquals(2, reservationResult.getPremiumOccupiedRooms());
        assertEquals(583, reservationResult.getPremiumRoomsRevenue());
        assertEquals(4, reservationResult.getEconomyOccupiedRooms());
        assertEquals(189.99, reservationResult.getEconomyRoomsRevenue());
    }

    @Test
    void givenInputRooms_when7FreePremiumRooms1FreeEconomyRooms_thenReturnUsagePremium7Euro115399UsageEconomy1Euro45(){
        double bids[] = {23, 45, 155, 374, 22, 99.99, 100, 101, 115, 209};
        RoomOccupancy roomOccupancy = new RoomOccupancy(willingnessPayPerNight);
        ReservationResult reservationResult = roomOccupancy.predictReservation(7, 1);

        assertEquals(7, reservationResult.getPremiumOccupiedRooms());
        assertEquals(1153.99, reservationResult.getPremiumRoomsRevenue());
        assertEquals(1, reservationResult.getEconomyOccupiedRooms());
        assertEquals(45, reservationResult.getEconomyRoomsRevenue());
    }

}