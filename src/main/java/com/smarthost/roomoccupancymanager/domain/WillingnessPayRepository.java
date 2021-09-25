package com.smarthost.roomoccupancymanager.domain;

import com.smarthost.roomoccupancymanager.domain.models.WillingnessPay;

import java.util.List;

public interface WillingnessPayRepository {
    WillingnessPay add(List<Double> prices);
}
