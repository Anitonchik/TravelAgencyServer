package com.example.TravelAgencyServer.entity.reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class VoucherInfoEncrypted {
    private Long reservationId;
    private LocalDateTime reservationDate;

    private String managerLastName;
    private String managerFirstName;

    private String clientFirstName;
    private String clientLastName;
    private String clientSurName;
    private byte[] clientPassportSeries;
    private byte[] clientPassportNumbers;

    private String tourName;
    private String tourDirection;
    private Double tourPrice;
    private LocalDateTime tourDateFrom;
    private LocalDateTime tourDateTo;

    private String flightToAirlineName;
    private String flightToLocationFrom;
    private String flightToLocationTo;
    private LocalDateTime flightToDate;
    private Double flightToPrice;

    private String flightFromAirlineName;
    private String flightFromLocationFrom;
    private String flightFromLocationTo;
    private LocalDateTime flightFromDate;
    private Double flightFromPrice;

    private String hotelName;
    private String hotelLocation;
    private Double hotelPrice;

    private Double finalPrice;
    private String status;
    private String paymentType;
    private String insuranceType;

}
