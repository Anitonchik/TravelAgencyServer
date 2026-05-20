package com.example.TravelAgencyServer.api.reservation;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ReservationsCountRs {
    public Long ALL;
    public Long CONFIRMED;
    public Long EXPECTATION;
    public Long CANCELED;
}
