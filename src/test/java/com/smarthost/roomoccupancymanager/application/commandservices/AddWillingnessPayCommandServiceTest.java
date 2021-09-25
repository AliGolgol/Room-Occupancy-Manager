package com.smarthost.roomoccupancymanager.application.commandservices;

import com.smarthost.roomoccupancymanager.domain.WillingnessPayRepository;
import com.smarthost.roomoccupancymanager.domain.exceptions.RoomOccupancyManagerException;
import com.smarthost.roomoccupancymanager.domain.models.WillingnessPay;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.when;

@ExtendWith(value = {SpringExtension.class})
@SpringBootTest
class AddWillingnessPayCommandServiceTest {


    @Autowired
    AddWillingnessPayCommandService addWillingnessPayCommandService;

    @MockBean
    WillingnessPayRepository repository;

    @Test
    void givenWillingListPay_whenThereIsAList_thenPersistIt(){
        List<Double> willingnessList = List.of(23.0, 45.0, 155.0, 374.0, 22.0, 99.99, 100.0, 101.0, 115.0, 209.0);
        WillingnessPay expectedResult = new WillingnessPay(willingnessList);

        when(repository.add(willingnessList)).thenReturn(expectedResult);
        WillingnessPay willingnessPay = addWillingnessPayCommandService.addWillingnessPay(willingnessList);

        assertThat(willingnessPay.getPrices().contains(expectedResult.getPrices()));
    }

    @Test
    void givenInvalidPriceList_whenAddWillingnessPay_thenThrowRoomOccupancyManagerException(){
        when(repository.add(null)).thenThrow(new RuntimeException());
        assertThrows(RoomOccupancyManagerException.class,()->addWillingnessPayCommandService.addWillingnessPay(null));
    }
}