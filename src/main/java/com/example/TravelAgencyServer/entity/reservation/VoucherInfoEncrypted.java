package com.example.TravelAgencyServer.entity.reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class VoucherInfoEncrypted {
    private Long reservationId;
    private Date reservationDate;

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
    private Date tourDateFrom;
    private Date tourDateTo;

    private String flightToAirlineName;
    private String flightToLocationFrom;
    private String flightToLocationTo;
    private Date flightToDate;
    private Double flightToPrice;

    private String flightFromAirlineName;
    private String flightFromLocationFrom;
    private String flightFromLocationTo;
    private Date flightFromDate;
    private Double flightFromPrice;

    private String hotelName;
    private String hotelLocation;
    private Double hotelPrice;

    private Double finalPrice;
    private String status;
    private String paymentType;
    private String insuranceType;

}
