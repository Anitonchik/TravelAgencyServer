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

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private ClientEntity client;

    @Column(unique = true, nullable = false)
    private byte[] CMIPolicy;

    @Column(unique = true, nullable = false)
    private byte[] image;

    @Column(nullable = false)
    private boolean isActive;

    public CMIPolicyEntity(ClientEntity client, byte[] CMIPolicy, byte[] image) {
        this.client = client;
        this.CMIPolicy = CMIPolicy;
        this.image = image;
        this.isActive = true;
    }
}
