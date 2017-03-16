package pl.sda.pdf;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;
import pl.sda.model.Company;
import pl.sda.service.DataService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;

/**
 * Created by RENT on 2017-03-16.
 */
public class PdfFactory {

    public void createPdf() {
        Properties properties = DataService.loadPropertise();
        String pdfPath = properties.getProperty("pdfPath");

        Document document = new Document(); //File.separator - domyslny separator w sysie
        try {
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath+ File.separator+"file.pdf"));
            document.open();
            document.add(new Paragraph()); //Paragraf od PDF'a
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void pdfFromCompany(Company company) {
        Properties properties = DataService.loadPropertise();
        String pdfPath = properties.getProperty("pdfPath");

        DataService dataService = new DataService();
        List<String> list = dataService.printCompanyInfo(company);
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath+ File.separator+"file.pdf"));
            document.setPageSize(new Rectangle(180, 240));
            document.open();
            for (String e: list) {
                document.add(new Paragraph(e)); //Paragraf od PDF'a
            }
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
