package com.example.TravelAgencyServer.entity.client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ClientPassportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientEntity client;

    private String series;
    private String numbers;
    private String image;

    public ClientPassportEntity(ClientEntity client, String series, String numbers, String image) {
        this.client = client;
        this.series = series;
        this.numbers = numbers;
        this.image = image;
    }
}
