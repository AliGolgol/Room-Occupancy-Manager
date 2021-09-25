package com.smarthost.roomoccupancymanager.application.queryservices;

import com.smarthost.roomoccupancymanager.application.dtos.ReservationResult;
import com.smarthost.roomoccupancymanager.domain.RoomOccupancy;
import com.smarthost.roomoccupancymanager.domain.WillingnessPayRepository;
import com.smarthost.roomoccupancymanager.domain.exceptions.RoomOccupancyManagerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.smarthost.roomoccupancymanager.domain.exceptions.ErrorCode.INVALID_INPUT;

@Service
public class OccupancyQueryService {

    @Autowired
    WillingnessPayRepository repository;

    public ReservationResult predictReservation(int freePremiumRooms, int freeEconomyRooms){
        validateInput(freePremiumRooms,freeEconomyRooms);
        RoomOccupancy roomOccupancy =new RoomOccupancy(repository.getAll().getPrices());
        ReservationResult reservationResult = roomOccupancy.predictReservation(freePremiumRooms, freeEconomyRooms);
        return reservationResult;
    }

    private void validateInput(int freePremiumRooms, int freeEconomyRooms) {
        if (freePremiumRooms <0 || freeEconomyRooms < 0){
            throw new RoomOccupancyManagerException(INVALID_INPUT,null,"FreePremiumRooms and FreeEconomyRooms must be provided!");
        }
    }
}
