package com.smarthost.roomoccupancymanager.domain.exceptions;

import lombok.Getter;

public class RoomOccupancyManagerException extends RuntimeException {

    @Getter
    private final ErrorCode errorCode;

    @Getter
    private final Object details;

    public RoomOccupancyManagerException(ErrorCode errorCode, Object details, String message) {
        super(message);
        this.errorCode = errorCode;
        this.details = details;
    }

}

