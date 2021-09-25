package com.smarthost.roomoccupancymanager.infrastructure.repositories;

import com.smarthost.roomoccupancymanager.domain.models.WillingnessPay;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WillingnessPayRepositoryImplTest {

    WillingnessPayRepositoryImpl repository = new WillingnessPayRepositoryImpl();
    List<Double> willingnessList = new ArrayList<>();
    WillingnessPay willingnessPayExpected;

    @BeforeEach
    void setup() {
        willingnessList.addAll(List.of(23.0, 45.0, 155.0, 374.0, 22.0, 99.99, 100.0, 101.0, 115.0, 209.0));
        willingnessPayExpected = new WillingnessPay(willingnessList);
    }

    @Test
    void givenPriceList_whenAddMethodIsCalled_thenReturnWillingnessPay() {
        WillingnessPay willingnessPay = repository.add(willingnessList);

        assertThat(willingnessPay.getPrices().contains(willingnessPayExpected.getPrices()));
    }

    @Test
    void given_whenGetAllMethodIsCalled_thenReturnWillingnessPrice(){
        repository.add(willingnessList);
        WillingnessPay willingnessPay = repository.getAll();

        assertThat(willingnessPay.getPrices().contains(willingnessPayExpected));
    }

}