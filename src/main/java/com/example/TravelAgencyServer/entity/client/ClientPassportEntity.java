package com.example.TravelAgencyServer.entity.client;

import jakarta.persistence.*;

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

    public ClientPassportEntity() {}

    public ClientPassportEntity(Long id, ClientEntity client, String series, String numbers, String image) {
        this.id = id;
        this.client = client;
        this.series = series;
        this.numbers = numbers;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
