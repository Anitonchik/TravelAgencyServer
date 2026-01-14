package com.example.TravelAgencyServer.entity.client;

import jakarta.persistence.*;

@Entity
public class CMIPolicyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientEntity client;

    private String CMIPolicy;
    private String image;

    public CMIPolicyEntity() {}

    public CMIPolicyEntity(Long id, ClientEntity client, String CMIPolicy, String image) {
        this.id = id;
        this.client = client;
        this.CMIPolicy = CMIPolicy;
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

    public String getCMIPolicy() {
        return CMIPolicy;
    }

    public void setCMIPolicy(String CMIPolicy) {
        this.CMIPolicy = CMIPolicy;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
