package com.smarthost.roomoccupancymanager.interfaces.restapi;

import com.smarthost.roomoccupancymanager.application.dtos.ReservationResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/occupancy")
public class RoomOccupancyController {

    @PostMapping
    public ResponseEntity<?> persistPrices(@RequestBody List<Double> priceList){
        return null;
    }

    @GetMapping(value = "/predict")
    public ResponseEntity<ReservationResult> predictReservation(@RequestParam int freePremiumRooms, @RequestParam int freeEconomyRooms){
        return null;
    }
}
