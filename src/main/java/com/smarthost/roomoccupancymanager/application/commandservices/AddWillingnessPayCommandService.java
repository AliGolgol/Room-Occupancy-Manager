package com.smarthost.roomoccupancymanager.application.commandservices;

import com.smarthost.roomoccupancymanager.domain.WillingnessPayRepository;
import com.smarthost.roomoccupancymanager.domain.exceptions.RoomOccupancyManagerException;
import com.smarthost.roomoccupancymanager.domain.models.WillingnessPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.smarthost.roomoccupancymanager.domain.exceptions.ErrorCode.INVALID_INPUT;

@Service
public class AddWillingnessPayCommandService {

    @Autowired
    WillingnessPayRepository repository;

    /**
     * Adding WillingnessPay list to the repository.
     * @param list is a {@link List<Double>}
     * @return a {@link WillingnessPay}
     */
    public WillingnessPay addWillingnessPay(List<Double> list) {
        try {
            return repository.add(list);
        }catch (Exception exception){
            throw new RoomOccupancyManagerException(INVALID_INPUT,list,exception.getMessage());
        }
    }
}
