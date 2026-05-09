package com.example.TravelAgencyServer.service;

import com.example.TravelAgencyServer.entity.reservation.ReservationEntity;
import com.example.TravelAgencyServer.entity.reservation.VoucherInfoDecrypted;
import com.itextpdf.io.font.constants.StandardFonts;
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
import java.io.*;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class VoucherService {

    public byte[] generateReservationPdf(
            boolean indicateTransfer,
            boolean indicateInsurance,
            VoucherInfoDecrypted voucherInfo,
            LocalDateTime dateOfIssueOfTheVoucher
    ) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(baos);
        PdfDocument pdf = new PdfDocument(writer);
        pdf.setDefaultPageSize(PageSize.A4);

        Document document = new Document(pdf);

        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        PdfFont fontBold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);

        // ---------- 1. Заголовок ----------
        document.add(
                new Paragraph("Информация о туроператоре")
                        .setFont(fontBold)
                        .setFontSize(20)
                        .setTextAlignment(TextAlignment.CENTER)
        );

        // ---------- 2. Основная таблица ----------
        float[] columns = {100, 100, 150, 100, 100};
        Table table = new Table(columns).setWidth(550);

        table.addCell(bold("Ваучер", fontBold));
        table.addCell(bold("Дата выдачи", fontBold));
        table.addCell(normal(dateOfIssueOfTheVoucher.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), font));
        table.addCell(bold("Город", fontBold));
        table.addCell(normal(voucherInfo.getTourDirection(), font));

        table.addCell(bold("Тур", fontBold, 2));
        table.addCell(normal(voucherInfo.getTourName(), font, 3));

        table.addCell(bold("Даты тура", fontBold));
        table.addCell(normal(voucherInfo.getTourDateFrom().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), font));
        table.addCell(normal(voucherInfo.getTourDateTo().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), font));
        table.addCell(normal("", font));
        table.addCell(normal("", font));

        table.addCell(bold("Турист", fontBold, 2));
        table.addCell(normal(voucherInfo.getClientLastName() + " " +
                voucherInfo.getClientFirstName() + " " + voucherInfo.getClientSurName(), font, 3));

        // ---------- Паспорт ----------
        table.addCell(bold("Паспорт", fontBold));
        table.addCell(bold("Серия", fontBold));
        table.addCell(normal(voucherInfo.getClientPassportSeries(), font));
        table.addCell(bold("Номер", fontBold));
        table.addCell(normal(voucherInfo.getClientPassportNumbers(), font));

        // ---------- Отель ----------
        table.addCell(bold("Отель", fontBold, 2));
        table.addCell(normal(voucherInfo.getHotelName(), font, 3));

        table.addCell(bold("Адрес отеля", fontBold, 2));
        table.addCell(normal(voucherInfo.getHotelLocation(), font, 3));

        // ---------- Авиабилеты ----------
        table.addCell(bold("Авиабилеты", fontBold, 5));

        table.addCell(bold("Авиакомпания", fontBold));
        table.addCell(normal(voucherInfo.getFlightFromAirlineName(), font));
        table.addCell(bold("Перелет", fontBold));
        table.addCell(normal(voucherInfo.getFlightFromLocationFrom(), font));
        table.addCell(normal(voucherInfo.getFlightFromLocationTo(), font));

        table.addCell(normal("", font));
        table.addCell(bold("Дата", fontBold));
        table.addCell(normal(voucherInfo.getFlightFromDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), font));
        table.addCell(bold("Время", fontBold));
        table.addCell(normal(voucherInfo.getFlightFromDate().format(DateTimeFormatter.ofPattern("HH:mm")), font));


        table.addCell(bold("Авиакомпания", fontBold));
        table.addCell(normal(voucherInfo.getFlightToAirlineName(), font));
        table.addCell(bold("Перелет", fontBold));
        table.addCell(normal(voucherInfo.getFlightToLocationFrom(), font));
        table.addCell(normal(voucherInfo.getFlightToLocationTo(), font));

        table.addCell(normal("", font));
        table.addCell(bold("Дата", fontBold));
        table.addCell(normal(voucherInfo.getFlightToDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), font));
        table.addCell(bold("Время", fontBold));
        table.addCell(normal(voucherInfo.getFlightToDate().format(DateTimeFormatter.ofPattern("HH:mm")), font));

        // ---------- Трансфер ----------
        if (indicateTransfer) {
            table.addCell(bold("Трансфер", fontBold));
            table.addCell(normal("+", font));
            table.addCell(normal("", font));
            table.addCell(normal("", font));
            table.addCell(normal("", font));
        }

        // ---------- Страховка ----------
        if (indicateInsurance) {
            table.addCell(bold("Страховка", fontBold));
            table.addCell(normal("+", font));
            table.addCell(bold("Вид", fontBold));
            table.addCell(normal(voucherInfo.getInsuranceType().getDescription(), font));
            table.addCell(normal("", font));
        }

        document.add(table);

        // ---------- 3. Стоимость ----------
        float[] costCols = {150, 100, 150, 100};
        Table costTable = new Table(costCols).setWidth(550);

        costTable.addCell(costNormal("Тур", font));
        costTable.addCell(costNormal(String.valueOf(voucherInfo.getTourPrice()), font));
        costTable.addCell(normal("", font));
        costTable.addCell(normal("", font));

        costTable.addCell(costNormal("Отель", font));
        costTable.addCell(costNormal(String.valueOf(voucherInfo.getHotelPrice()), font));
        costTable.addCell(normal("", font));
        costTable.addCell(normal("", font));

        costTable.addCell(costNormal("Перелет 1", font));
        costTable.addCell(costNormal(String.valueOf(voucherInfo.getFlightToPrice()), font));
        costTable.addCell(normal("", font));
        costTable.addCell(normal("", font));

        costTable.addCell(costNormal("Перелет 2", font));
        costTable.addCell(costNormal(String.valueOf(voucherInfo.getFlightFromPrice()), font));
        costTable.addCell(normal("", font));
        costTable.addCell(normal("", font));

        costTable.addCell(normal("", font));
        costTable.addCell(normal("", font));
        costTable.addCell(costBold("Итого", fontBold));
        costTable.addCell(costBold(String.valueOf(voucherInfo.getFinalPrice()), fontBold));


        document.add(costTable);

        document.close();
        return baos.toByteArray();
    }

    // ---------- Вспомогательные методы ----------
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
