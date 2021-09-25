package com.smarthost.roomoccupancymanager.infrastructure.repositories;

import com.smarthost.roomoccupancymanager.domain.WillingnessPayRepository;
import com.smarthost.roomoccupancymanager.domain.models.WillingnessPay;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WillingnessPayRepositoryImpl implements WillingnessPayRepository {
    @Override
    public WillingnessPay add(List<Double> prices) {
        return null;
    }
}
