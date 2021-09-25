package com.smarthost.roomoccupancymanager.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WillingnessPay {
    private List<Double> prices;
}
