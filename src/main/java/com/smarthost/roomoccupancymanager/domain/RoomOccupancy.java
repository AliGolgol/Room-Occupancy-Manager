package com.smarthost.roomoccupancymanager.domain;

import com.smarthost.roomoccupancymanager.application.dtos.ReservationResult;
import lombok.extern.log4j.Log4j2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.partitioningBy;

@Log4j2
public class RoomOccupancy {
    private final List<Double> willingnessPayPerNight;
    private static final double PIVOT = 100;

    public RoomOccupancy(List<Double> willingnessPayPerNight) {
        this.willingnessPayPerNight = willingnessPayPerNight;
    }

    /**
     * Predicting the room usage and total money for each Economy and Premium category
     * <p>Ex:
     *       <p>input: Free Premium rooms: 3
     *       <p>input: Free Economy rooms: 3
     *       <p>output: Usage Premium: 3 (EUR 738)
     *       <p>output: Usage Premium: 3 (EUR 167.99)
     *
     * @param freePremiumRooms is an {@link Integer}
     * @param freeEconomyRooms is an {@link Integer}
     * @return a {@link ReservationResult}
     */
    public ReservationResult predictReservation(int freePremiumRooms, int freeEconomyRooms) {

        Map<Boolean, List<Double>> categorizedRooms = willingnessPayPerNight.stream().collect(partitioningBy(bid -> bid >= PIVOT));
        List<Double> premiumGusts = categorizedRooms.get(true).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Double> economyGuests = categorizedRooms.get(false).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        int premiumUsage = Math.min(freePremiumRooms, premiumGusts.size());
        double premiumRoomsRevenue = premiumGusts.stream().limit(premiumUsage).mapToDouble(Double::doubleValue).sum();
        double premiumRoomsLeft = Math.max(freePremiumRooms - premiumUsage, 0);

        int economyRoomsShortage = Math.max(economyGuests.size() - freeEconomyRooms, 0);
        int upgradedRoomsUsage = (int) Math.min(premiumRoomsLeft, economyRoomsShortage);
        double upgradedRoomsRevenue = economyGuests.stream().limit(upgradedRoomsUsage).mapToDouble(Double::doubleValue).sum();

        int economyRoomsUsage = Math.min(economyGuests.size() - upgradedRoomsUsage, freeEconomyRooms);
        double economyRoomsRevenue = economyGuests.stream().skip(upgradedRoomsUsage).limit(economyRoomsUsage).mapToDouble(Double::doubleValue).sum();

        ReservationResult reservationResult = new ReservationResult(
                premiumUsage + upgradedRoomsUsage,
                premiumRoomsRevenue + upgradedRoomsRevenue,
                economyRoomsUsage,
                economyRoomsRevenue);

        log.info(reservationResult.toString());
        return reservationResult;
    }
}
