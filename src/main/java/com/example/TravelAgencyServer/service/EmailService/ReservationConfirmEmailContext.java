package com.example.TravelAgencyServer.service.EmailService;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ReservationConfirmEmailContext {
    private String to;
    private String subject = "Ваучер бронирования";
   // private String from;
    private String templateLocation = "reservation-confirmation";
    private Map<String, Object> context = new HashMap<>();

    private byte[] attachment;        // содержимое файла
    private String attachmentName;

    public ReservationConfirmEmailContext(String to, Map<String, Object> context, byte[] attachment, String attachmentName) {
        this.to = to;
        this.context = context;
        this.attachment = attachment;
        this.attachmentName = attachmentName;
    }
}
