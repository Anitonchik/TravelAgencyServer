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

    @Column(unique = true, nullable = false)
    private byte[] series;
    @Column(unique = true, nullable = false)
    private byte[] numbers;
    @Column(unique = true, nullable = false)
    private byte[] image;

    public ClientPassportEntity(ClientEntity client, byte[] series, byte[] numbers, byte[] image) {
        this.client = client;
        this.series = series;
        this.numbers = numbers;
        this.image = image;
    }
}
