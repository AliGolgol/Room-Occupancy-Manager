package com.smarthost.roomoccupancymanager.infrastructure.repositories;

import com.smarthost.roomoccupancymanager.domain.WillingnessPayRepository;
import com.smarthost.roomoccupancymanager.domain.models.WillingnessPay;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class WillingnessPayRepositoryImpl implements WillingnessPayRepository {
    private final List<Double> priceList;

    public WillingnessPayRepositoryImpl() {
        priceList = new CopyOnWriteArrayList<>();
    }


    @Override
    public synchronized WillingnessPay add(List<Double> prices) {
        priceList.clear();
        priceList.addAll(prices);
        return new WillingnessPay(priceList);
    }

    @Override
    public WillingnessPay getAll() {
        return new WillingnessPay(priceList);
    }
}
