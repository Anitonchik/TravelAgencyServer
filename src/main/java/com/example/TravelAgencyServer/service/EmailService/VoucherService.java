package com.example.TravelAgencyServer.service.EmailService;

import com.example.TravelAgencyServer.entity.reservation.VoucherInfoDecrypted;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Service
public class VoucherService {

    public byte[] generateReservationPdf(
            boolean indicateTransfer,
            boolean indicateInsurance,
            VoucherInfoDecrypted voucherInfo,
            Date dateOfIssueOfTheVoucher
    ) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(baos);
        PdfDocument pdf = new PdfDocument(writer);
        pdf.setDefaultPageSize(PageSize.A4);

        Document document = new Document(pdf);

        PdfFont font = PdfFontFactory.createFont(
                "fonts/Aptos.ttf",
                PdfEncodings.IDENTITY_H,
                PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED
        );

        PdfFont fontBold = PdfFontFactory.createFont(
                "fonts/Aptos-Bold.ttf",
                PdfEncodings.IDENTITY_H,
                PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED
        );

        document.add(
                new Paragraph("Информация о туроператоре")
                        .setFont(fontBold)
                        .setFontSize(20)
                        .setTextAlignment(TextAlignment.CENTER)
        );


        float[] columns = {100, 100, 150, 100, 100};
        Table table = new Table(columns).setWidth(550);

        table.addCell(bold("Ваучер", fontBold));
        table.addCell(bold("Дата выдачи", fontBold));
        LocalDateTime dateVoucher = voucherInfo.getTourDateFrom().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        table.addCell(normal(dateVoucher.format(formatter), font));
        table.addCell(bold("Город", fontBold));
        table.addCell(normal(voucherInfo.getTourDirection(), font));

        table.addCell(bold("Тур", fontBold, 2));
        table.addCell(normal(voucherInfo.getTourName(), font, 3));

        table.addCell(bold("Даты тура", fontBold));
        LocalDateTime fromDate = voucherInfo.getTourDateFrom().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        LocalDateTime toDate = voucherInfo.getTourDateTo().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        table.addCell(normal(fromDate.format(formatter), font));
        table.addCell(normal(toDate.format(formatter), font));
        table.addCell(normal("", font));
        table.addCell(normal("", font));

        table.addCell(bold("Турист", fontBold, 2));
        table.addCell(normal(voucherInfo.getClientLastName() + " " +
                voucherInfo.getClientFirstName() + " " + voucherInfo.getClientSurName(), font, 3));

        table.addCell(bold("Паспорт", fontBold));
        table.addCell(bold("Серия", fontBold));
        table.addCell(normal(voucherInfo.getClientPassportSeries(), font));
        table.addCell(bold("Номер", fontBold));
        table.addCell(normal(voucherInfo.getClientPassportNumbers(), font));

        table.addCell(bold("Отель", fontBold, 2));
        table.addCell(normal(voucherInfo.getHotelName(), font, 3));

        table.addCell(bold("Адрес отеля", fontBold, 2));
        table.addCell(normal(voucherInfo.getHotelLocation(), font, 3));

        table.addCell(bold("Авиабилеты", fontBold, 5));

        table.addCell(bold("Авиакомпания", fontBold));
        table.addCell(normal(voucherInfo.getFlightFromAirlineName(), font));
        table.addCell(bold("Перелет", fontBold));
        table.addCell(normal(voucherInfo.getFlightFromLocationFrom(), font));
        table.addCell(normal(voucherInfo.getFlightFromLocationTo(), font));

        table.addCell(normal("", font));
        table.addCell(bold("Дата", fontBold));
        LocalDateTime dateFlight1 = voucherInfo.getTourDateFrom().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        table.addCell(normal(dateFlight1.format(formatter), font));
        table.addCell(bold("Время", fontBold));
        table.addCell(normal(dateFlight1.format(DateTimeFormatter.ofPattern("HH:mm")), font));


        table.addCell(bold("Авиакомпания", fontBold));
        table.addCell(normal(voucherInfo.getFlightToAirlineName(), font));
        table.addCell(bold("Перелет", fontBold));
        table.addCell(normal(voucherInfo.getFlightToLocationFrom(), font));
        table.addCell(normal(voucherInfo.getFlightToLocationTo(), font));

        table.addCell(normal("", font));
        table.addCell(bold("Дата", fontBold));
        LocalDateTime dateFlight2 = voucherInfo.getTourDateFrom().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        table.addCell(normal(dateFlight2.format(formatter), font));
        table.addCell(bold("Время", fontBold));
        table.addCell(normal(dateFlight2.format(DateTimeFormatter.ofPattern("HH:mm")), font));

        if (indicateTransfer) {
            table.addCell(bold("Трансфер", fontBold));
            table.addCell(normal("+", font));
            table.addCell(normal("", font));
            table.addCell(normal("", font));
            table.addCell(normal("", font));
        }

        if (indicateInsurance) {
            table.addCell(bold("Страховка", fontBold));
            table.addCell(normal("+", font));
            table.addCell(bold("Вид", fontBold));
            table.addCell(normal(voucherInfo.getInsuranceType().getDescription(), font));
            table.addCell(normal("", font));
        }


        table.addCell(normal("Цены, руб.", font));
        table.addCell(normal("", font));
        table.addCell(normal("", font));
        table.addCell(normal("", font));
        table.addCell(normal("", font));

        table.addCell(costNormal("Тур", font));
        table.addCell(costNormal(String.valueOf(voucherInfo.getTourPrice()), font));
        table.addCell(normal("", font));
        table.addCell(normal("", font));
        table.addCell(normal("", font));

        table.addCell(costNormal("Отель", font));
        table.addCell(costNormal(String.valueOf(voucherInfo.getHotelPrice()), font));
        table.addCell(normal("", font));
        table.addCell(normal("", font));
        table.addCell(normal("", font));

        table.addCell(costNormal("Перелет 1", font));
        table.addCell(costNormal(String.valueOf(voucherInfo.getFlightToPrice()), font));
        table.addCell(normal("", font));
        table.addCell(normal("", font));
        table.addCell(normal("", font));

        table.addCell(costNormal("Перелет 2", font));
        table.addCell(costNormal(String.valueOf(voucherInfo.getFlightFromPrice()), font));
        table.addCell(normal("", font));
        table.addCell(normal("", font));
        table.addCell(normal("", font));

        table.addCell(normal("", font));
        table.addCell(normal("", font));
        table.addCell(normal("", font));
        table.addCell(costBold("Итого", fontBold));
        table.addCell(costBold(String.valueOf(voucherInfo.getFinalPrice()), fontBold));


        document.add(table);

        document.close();
        return baos.toByteArray();
    }

    private com.itextpdf.layout.element.Cell bold(String text, PdfFont font) {
        return new com.itextpdf.layout.element.Cell()
                .add(new Paragraph(text).setFont(font).setFontSize(14));
    }

    private com.itextpdf.layout.element.Cell bold(String text, PdfFont font, int colspan) {
        return new com.itextpdf.layout.element.Cell(1, colspan)
                .add(new Paragraph(text).setFont(font).setFontSize(14));
    }

    private com.itextpdf.layout.element.Cell normal(String text, PdfFont font) {
        return new com.itextpdf.layout.element.Cell()
                .add(new Paragraph(text).setFont(font).setFontSize(14));
    }

    private com.itextpdf.layout.element.Cell normal(String text, PdfFont font, int colspan) {
        return new com.itextpdf.layout.element.Cell(1, colspan)
                .add(new Paragraph(text).setFont(font).setFontSize(14));
    }

    private com.itextpdf.layout.element.Cell costNormal(String text, PdfFont font) {
        return new com.itextpdf.layout.element.Cell()
                .add(new Paragraph(text).setFont(font).setFontSize(10));
    }

    private com.itextpdf.layout.element.Cell costBold(String text, PdfFont font) {
        return new com.itextpdf.layout.element.Cell()
                .add(new Paragraph(text).setFont(font).setFontSize(10).setBold());
    }
}
