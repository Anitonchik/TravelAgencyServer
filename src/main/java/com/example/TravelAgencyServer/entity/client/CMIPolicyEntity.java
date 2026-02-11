package com.example.TravelAgencyServer.entity.client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CMIPolicyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientEntity client;

    @Column(unique = true, nullable = false)
    private byte[] CMIPolicy;

    @Column(unique = true, nullable = false)
    private byte[] image;

    public CMIPolicyEntity(ClientEntity client, byte[] CMIPolicy, byte[] image) {
        this.client = client;
        this.CMIPolicy = CMIPolicy;
        this.image = image;
    }
}
