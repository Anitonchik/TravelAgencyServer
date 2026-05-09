package com.example.TravelAgencyServer.service.EmailService;

import com.example.TravelAgencyServer.entity.reservation.VoucherEntity;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String fromEmail;

    private void sendMail(ReservationConfirmEmailContext email) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());
        Context context = new Context();
        context.setVariables(email.getContext());
        String emailContent = templateEngine.process(email.getTemplateLocation(), context);

        mimeMessageHelper.setTo(email.getTo());
        mimeMessageHelper.setSubject(email.getSubject());
        mimeMessageHelper.setFrom(fromEmail);
        mimeMessageHelper.setText(emailContent, true);
        if (email.getAttachment() != null) {
            mimeMessageHelper.addAttachment(
                    email.getAttachmentName(),
                    new ByteArrayResource(email.getAttachment())
            );
        }
        emailSender.send(message);
    }

    public void sendVoucherToEmail(VoucherEntity voucher) throws MessagingException {
        Map<String, Object> ctx = new HashMap<>();
        ctx.put("lastName", voucher.getReservation().getClient().getLastName());
        ctx.put("firstName", voucher.getReservation().getClient().getFirstName());
        ctx.put("surName", voucher.getReservation().getClient().getSurName());
        var resCtx = new ReservationConfirmEmailContext(voucher.getReservation().getClient().getEmail(),
                ctx, voucher.getVoucher(), "Ваучер.pdf");
        sendMail(resCtx);
    }
}
