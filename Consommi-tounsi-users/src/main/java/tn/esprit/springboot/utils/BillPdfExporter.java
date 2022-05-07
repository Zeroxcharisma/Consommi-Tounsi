package tn.esprit.springboot.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import tn.esprit.springboot.entity.Bill;

import java.io.OutputStream;
import java.util.List;
import java.util.Objects;


public class BillPdfExporter {
    private List<Bill> listBills;

    public BillPdfExporter(List<Bill> listBills) {
        this.listBills = listBills;
    }

    private void writeBillTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.BLACK);

        cell.setPhrase(new Phrase("Bill ID", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Montant", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Moyens de paiement", font));
        table.addCell(cell);
    }

    private void writeBillTableData(PdfPTable table) {
        for (Bill bill : listBills) {
            table.addCell(String.valueOf(bill.getIdBill()));
            table.addCell(Double.toString(bill.getMontant()));
            table.addCell(bill.getPaymentType().toString());
        }
    }



    private void writeOrderTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.BLACK);

        cell.setPhrase(new Phrase("Montant", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("N° Produit", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Date", font));
        table.addCell(cell);
    }

    private void writeOrderTableData(PdfPTable table) {
        for (Bill bill : listBills) {
            if (Objects.nonNull(bill.getOrder())) {
                table.addCell(String.valueOf(bill.getOrder().getAmountOrder()));
                table.addCell(Double.toString(bill.getOrder().getProductNumberOrder()));
                table.addCell(bill.getOrder().getDateOrder().toString());
            }
        }
    }

    public void export(OutputStream outputStream) throws DocumentException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, outputStream);

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(BaseColor.BLUE);

        Paragraph billParagraph = new Paragraph("Bill Details", font);
        billParagraph.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(billParagraph);

        // bill table start
        PdfPTable billTable = new PdfPTable(3);
        billTable.setWidthPercentage(100f);
        billTable.setWidths(new float[] {1.5f, 3.5f, 3.5f});
        billTable.setSpacingBefore(10);

        writeBillTableHeader(billTable);
        writeBillTableData(billTable);

        document.add(billTable);
        // bill table end

        // order table start

        Paragraph orderParagraph = new Paragraph("Order Details", font);
        orderParagraph.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(orderParagraph);

        PdfPTable orderTable = new PdfPTable(3);
        orderTable.setWidthPercentage(100f);
        orderTable.setWidths(new float[] {1.5f, 3.5f, 3.5f});
        orderTable.setSpacingBefore(10);

        writeOrderTableHeader(orderTable);
        writeOrderTableData(orderTable);

        document.add(orderTable);


        document.close();
    }
}
