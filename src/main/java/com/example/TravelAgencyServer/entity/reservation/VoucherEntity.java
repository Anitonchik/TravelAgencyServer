package com.example.TravelAgencyServer.entity.reservation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class VoucherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "reservation_id")
    private ReservationEntity reservation;
    @Column
    private byte[] voucher;

    public VoucherEntity(ReservationEntity reservation, byte[] voucher) {
        this.reservation = reservation;
        this.voucher = voucher;
    }
}
