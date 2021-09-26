package com.smarthost.roomoccupancymanager.interfaces.restapi;

import com.google.gson.Gson;
import com.smarthost.roomoccupancymanager.application.commandservices.AddWillingnessPayCommandService;
import com.smarthost.roomoccupancymanager.application.dtos.ReservationResult;
import com.smarthost.roomoccupancymanager.application.queryservices.OccupancyQueryService;
import com.smarthost.roomoccupancymanager.domain.models.WillingnessPay;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(RoomOccupancyController.class)
class RoomOccupancyControllerTest {

    private static final String POST_ENDPOINT = "/api/v1/occupancy";

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AddWillingnessPayCommandService commandService;
    @MockBean
    private OccupancyQueryService queryService;

    @Test
    void givenWillingListPay_whenThereIsAList_thenPersistIt() throws Exception {
        Gson gson = new Gson();
        List<Double> willingnessList = List.of(23.0, 45.0, 155.0, 374.0, 22.0, 99.99, 100.0, 101.0, 115.0, 209.0);
        WillingnessPay expectedResult = new WillingnessPay(willingnessList);

        when(commandService.addWillingnessPay(willingnessList)).thenReturn(expectedResult);

        mockMvc.perform(post(POST_ENDPOINT).contentType(APPLICATION_JSON).content(gson.toJson(willingnessList)))
                .andExpect(status().isCreated());
    }

    @Test
    void givenFreeRooms_whenGetRequest_thenReturnPrediction() throws Exception {
        Gson gson = new Gson();
        ReservationResult reservationResultExpected = new ReservationResult(3, 738, 3, 167.99);

        when(queryService.predictReservation(3, 3)).thenReturn(reservationResultExpected);

        mockMvc.perform(get(POST_ENDPOINT+"/predict")
                .param("freePremiumRooms", "3")
                .param("freeEconomyRooms", "3"))
                .andExpect(status().isOk())
                .andExpect(content().json(gson.toJson(reservationResultExpected)));
    }
}