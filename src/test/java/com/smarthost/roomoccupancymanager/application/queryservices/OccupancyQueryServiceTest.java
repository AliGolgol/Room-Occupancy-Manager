package com.smarthost.roomoccupancymanager.application.queryservices;

import com.smarthost.roomoccupancymanager.application.dtos.ReservationResult;
import com.smarthost.roomoccupancymanager.domain.WillingnessPayRepository;
import com.smarthost.roomoccupancymanager.domain.exceptions.RoomOccupancyManagerException;
import com.smarthost.roomoccupancymanager.domain.models.WillingnessPay;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class OccupancyQueryServiceTest {

    @Autowired
    OccupancyQueryService occupancyQueryService;

    @MockBean
    WillingnessPayRepository repository;

    List<Double> willingnessList = new ArrayList<>();
    WillingnessPay willingnessPayExpected;

    @BeforeEach
    void setup() {
        willingnessList.addAll(List.of(23.0, 45.0, 155.0, 374.0, 22.0, 99.99, 100.0, 101.0, 115.0, 209.0));
        willingnessPayExpected = new WillingnessPay(willingnessList);
    }

    @Test
    void givenFreeRooms_whenPredictReservationMethodIsCalled_thenReturnPrediction() {
        when(repository.getAll()).thenReturn(willingnessPayExpected);
        ReservationResult reservationResult = occupancyQueryService.predictReservation(3, 3);
        ReservationResult reservationResultExpected = new ReservationResult(3, 738, 3, 167.99);
        assertEquals(reservationResultExpected, reservationResult);
    }

    @Test
    void givenWrongFreeRooms_whenPredictReservationMehtodIsCalled_thenThrowRoomOccupancyManagerException() {
        when(repository.getAll()).thenReturn(willingnessPayExpected);

        assertThrows(RoomOccupancyManagerException.class, () -> occupancyQueryService.predictReservation(-1, 3));
    }
}