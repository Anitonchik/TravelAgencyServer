package com.example.TravelAgencyServer.api.reservation;

import com.example.TravelAgencyServer.api.client.ClientMapper;
import com.example.TravelAgencyServer.api.hotel.HotelMapper;
import com.example.TravelAgencyServer.api.manager.ManagerMapper;
import com.example.TravelAgencyServer.api.tour.TourMapper;
import com.example.TravelAgencyServer.entity.client.ClientEntity;
import com.example.TravelAgencyServer.entity.flight.FlightEntity;
import com.example.TravelAgencyServer.entity.hotel.HotelEntity;
import com.example.TravelAgencyServer.entity.manager.ManagerEntity;
import com.example.TravelAgencyServer.entity.reservation.ReservationEntity;
import com.example.TravelAgencyServer.entity.reservation.Status;
import com.example.TravelAgencyServer.entity.reservation.VoucherInfoDecrypted;
import com.example.TravelAgencyServer.entity.reservation.VoucherInfoEncrypted;
import com.example.TravelAgencyServer.entity.tour.TourEntity;
import org.mapstruct.*;

import java.util.List;
import java.util.Stack;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
uses = {
        ManagerMapper.class,
        ClientMapper.class,
        TourMapper.class,
        HotelMapper.class
})
public interface ReservationMapper {
    @Mappings ({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "price", target = "price")
    })
    ReservationEntity RqToEntity(ReservationRq dto, Double price, ManagerEntity manager, ClientEntity client,
                                 TourEntity tour, FlightEntity flightFrom, FlightEntity flightTo, HotelEntity hotel);

    @Mappings ({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "tour.price", target = "price")
    })
    ReservationEntity RqToEntity(ReservationRq dto, Status status, ManagerEntity manager, ClientEntity client, TourEntity tour);

    @Mappings ({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "price", target = "price")
    })
    ReservationEntity updateEntity(ReservationRq dto, @MappingTarget ReservationEntity entity, Double price, ManagerEntity manager,
                                   ClientEntity client, TourEntity tour, FlightEntity flightFrom,
                                   FlightEntity flightTo, HotelEntity hotel);

    ReservationRs EntityToRs(ReservationEntity dto);

    List<ReservationRs> ListEntitiesToListRq(List<ReservationEntity> entities);

    @Mappings ({
            @Mapping(source = "passportSeries", target = "clientPassportSeries"),
            @Mapping(source = "passportNumbers", target = "clientPassportNumbers")
    })
    VoucherInfoDecrypted EncryptedToDecrypted(VoucherInfoEncrypted voucherInfo, String passportSeries, String passportNumbers);
}
