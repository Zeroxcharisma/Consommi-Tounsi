package tn.esprit.springboot.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import tn.esprit.springboot.entity.Bill;

import java.io.OutputStream;
import java.util.List;


public class BillPdfExporter {
    private List<Bill> listBills;

    public BillPdfExporter(List<Bill> listBills) {
        this.listBills = listBills;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);

        cell.setPhrase(new Phrase("Bill ID", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("montant", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        for (Bill bill : listBills) {
            table.addCell(String.valueOf(bill.getIdBill()));
            table.addCell(Double.toString(bill.getMontant()));
        }
    }

    public void export(OutputStream outputStream) throws DocumentException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, outputStream);

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(BaseColor.BLUE);

        Paragraph p = new Paragraph("List of Bills", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();
    }
}
