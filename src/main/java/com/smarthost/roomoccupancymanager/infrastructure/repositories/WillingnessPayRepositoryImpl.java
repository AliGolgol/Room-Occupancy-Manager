package com.smarthost.roomoccupancymanager.infrastructure.repositories;

import com.smarthost.roomoccupancymanager.domain.WillingnessPayRepository;
import com.smarthost.roomoccupancymanager.domain.models.WillingnessPay;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WillingnessPayRepositoryImpl implements WillingnessPayRepository {

    List<Double> priceList = new ArrayList<>();

    @Override
    public WillingnessPay add(List<Double> prices) {
        priceList.clear();
        priceList.addAll(prices);
        WillingnessPay willingnessPay = new WillingnessPay(priceList);
        return willingnessPay;
    }

    @Override
    public WillingnessPay getAll() {
        WillingnessPay willingnessPay = new WillingnessPay(priceList);
        return willingnessPay;
    }
}
