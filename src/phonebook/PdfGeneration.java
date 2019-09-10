
package phonebook;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import javafx.collections.ObservableList;


public class PdfGeneration {
    
    void pdfGeneration(String fileName, ObservableList<Person> data){
        Document document = new Document();
        
        try {
            //kép beszúrása PDF-be
            PdfWriter.getInstance(document, new FileOutputStream(fileName +  ".pdf"));
            document.open();
            Image image1 = Image.getInstance(getClass().getResource("/logo.jpg"));
            image1.scaleToFit(400,186);
            image1.setAbsolutePosition(130f, 650f);
            document.add(image1);
            
            document.add(new Paragraph("\n\n\n\n\n\n\n\n\n\n\n"));
            
            //Táblázat
            float[] columnWidth = {2, 4, 4, 6};
            PdfPTable table = new PdfPTable(columnWidth);
            table.setWidthPercentage(100);
            PdfPCell cell = new PdfPCell( new Phrase("Kontaktlista"));
            cell.setBackgroundColor(GrayColor.GRAYWHITE);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setColspan(4);
            table.addCell(cell);
            
            table.getDefaultCell().setBackgroundColor(new GrayColor(0.75f));
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell("Sorszám");
            table.addCell("Vezetéknév");
            table.addCell("Keresztnév");
            table.addCell("Email");
            table.setHeaderRows(1);
            
            table.getDefaultCell().setBackgroundColor(GrayColor.GRAYWHITE);
            table.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            for(int i=1;i<=data.size();i++){
                Person actualPerson =data.get(i-1);
                
                table.addCell(""+i);
                table.addCell(actualPerson.getLastName());
                table.addCell(actualPerson.getFirstName());
                table.addCell(actualPerson.getEmail());
            }
            
            document.add(table);
            
            
            
            //Aláírás
            Chunk signature = new Chunk("\n\n Generálva a Telefonkönyv alkalmazással.");
            Paragraph base = new Paragraph(signature);
            document.add(base);
            
        } catch (Exception e) {
           System.out.println("Valami baj van a PDF generálásakor!");
        }
        document.close();
        
    }

   
    
}
