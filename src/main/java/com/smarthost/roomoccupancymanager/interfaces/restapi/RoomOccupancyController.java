package com.smarthost.roomoccupancymanager.interfaces.restapi;

import com.smarthost.roomoccupancymanager.application.commandservices.AddWillingnessPayCommandService;
import com.smarthost.roomoccupancymanager.application.dtos.ReservationResult;
import com.smarthost.roomoccupancymanager.application.queryservices.OccupancyQueryService;
import com.smarthost.roomoccupancymanager.domain.models.WillingnessPay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping("/api/v1/occupancy")
public class RoomOccupancyController {

    @Autowired
    AddWillingnessPayCommandService commandService;
    @Autowired
    OccupancyQueryService queryService;

    @PostMapping
    public ResponseEntity<WillingnessPay> persistPrices(@RequestBody List<Double> priceList){
        WillingnessPay willingnessPay = commandService.addWillingnessPay(priceList);
        return new ResponseEntity<>(willingnessPay, CREATED);
    }

    @GetMapping(value = "/predict")
    public ResponseEntity<ReservationResult> predictReservation(@RequestParam int freePremiumRooms, @RequestParam int freeEconomyRooms){
        ReservationResult reservationResult = queryService.predictReservation(freePremiumRooms, freeEconomyRooms);
        return new ResponseEntity<>(reservationResult, OK);
    }
}
