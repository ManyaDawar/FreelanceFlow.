package com.freelanceflow.controller;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceController {

    // Common class for both Worker and Client invoice
    public static class InvoiceData {
        private String id; // workerid OR clientid
        private String projectDescription;
        private float rate;
        private int hours;
        private float amount;

        public InvoiceData(String id, String projectDescription, float rate, int hours, float amount) {
            this.id = id;
            this.projectDescription = projectDescription;
            this.rate = rate;
            this.hours = hours;
            this.amount = amount;
        }

        public String getId() { return id; }
        public String getProjectDescription() { return projectDescription; }
        public float getRate() { return rate; }
        public int getHours() { return hours; }
        public float getAmount() { return amount; }
    }

    public static void main(String[] args) {
        // Example: change to "worker" or "client" depending on dashboard
        generateInvoice("worker");
        generateInvoice("client");
    }

    public static void generateInvoice(String userType) {
        String dest = userType + "_invoice.pdf";

        try {
            // DB connection
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/login_schema", // change
                    "root",  // change
                    "manya@2702" // change
            );

            List<InvoiceData> invoices = new ArrayList<>();
            String userIdForInvoice = null;

            // Query changes based on user type
            String sql;
            if (userType.equalsIgnoreCase("worker")) {
                sql = "SELECT workerid, projectdescription, rate, hours, amount FROM project_log";
            } else {
                sql = "SELECT clientid, projectdescription, rate, hours, amount FROM project_log";
            }

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String id = userType.equals("worker") ? rs.getString("workerid") : rs.getString("clientid");
                if (userIdForInvoice == null) {
                    userIdForInvoice = id; // first row's id
                }
                invoices.add(new InvoiceData(
                        id,
                        rs.getString("projectdescription"),
                        rs.getFloat("rate"),
                        rs.getInt("hours"),
                        rs.getFloat("amount")
                ));
            }
            conn.close();

            // Fonts
            PdfFont boldFont = PdfFontFactory.createFont(com.itextpdf.io.font.constants.StandardFonts.HELVETICA_BOLD);
            PdfFont normalFont = PdfFontFactory.createFont(com.itextpdf.io.font.constants.StandardFonts.HELVETICA);

            // Setup PDF
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf, PageSize.A4);
            document.setMargins(20, 20, 20, 20);

            // ID (top right) → changes text based on type
            if (userIdForInvoice != null) {
                String idText = (userType.equals("worker") ? "Worker ID: " : "Client ID: ") + userIdForInvoice;
                Paragraph idPara = new Paragraph(idText)
                        .setFont(normalFont)
                        .setFontSize(12)
                        .setTextAlignment(TextAlignment.RIGHT);
                document.add(idPara);
            }

            // Title
            Paragraph title = new Paragraph(userType.toUpperCase() + " INVOICE")
                    .setFont(boldFont)
                    .setFontSize(20)
                    .setTextAlignment(TextAlignment.CENTER);
            document.add(title);

            document.add(new Paragraph(" ")); // blank space

            // Table
            float[] columnWidths = {200F, 100F, 100F, 100F};
            Table table = new Table(columnWidths);

            table.addHeaderCell(new Cell().add(new Paragraph("Project Description").setFont(boldFont)));
            table.addHeaderCell(new Cell().add(new Paragraph("Rate").setFont(boldFont)));
            table.addHeaderCell(new Cell().add(new Paragraph("Hours").setFont(boldFont)));
            table.addHeaderCell(new Cell().add(new Paragraph("Amount").setFont(boldFont)));

            // Add rows
            float total = 0;
            for (InvoiceData invoice : invoices) {
                table.addCell(new Cell().add(new Paragraph(invoice.getProjectDescription()).setFont(normalFont)));
                table.addCell(new Cell().add(new Paragraph(String.format("$%.2f", invoice.getRate())).setFont(normalFont)));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(invoice.getHours())).setFont(normalFont)));
                table.addCell(new Cell().add(new Paragraph(String.format("$%.2f", invoice.getAmount())).setFont(normalFont)));
                total += invoice.getAmount();
            }

            document.add(table);

            // Total
            Paragraph totalParagraph = new Paragraph(String.format("TOTAL: $%.2f", total))
                    .setFont(boldFont)
                    .setFontSize(14)
                    .setTextAlignment(TextAlignment.RIGHT);
            document.add(totalParagraph);

            document.close();
            System.out.println(userType + " invoice created: " + dest);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}























// document.add(new Paragraph("Hello Coding error"));