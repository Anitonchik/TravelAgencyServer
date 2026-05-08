package com.example.TravelAgencyServer.api.clientPassport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ClientPassportRs {
    private Long id;
    private String series;
    private String numbers;
    private String image;
}
