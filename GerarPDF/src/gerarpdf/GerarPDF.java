package gerarpdf;

import com.lowagie.text.Document;
import com.itextpdf.text.Font;
import com.lowagie.text.Chapter;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Section;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author ricardo
 */
public class GerarPDF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        /* Document document = new Document();
        
        
        try{
            PdfWriter.getInstance(document, new FileOutputStream("documento.pdf"));
            document.open();
            document.add(new Paragraph("Se deus quiser vai dar certo"));
            document.add(new Header("Header", "Funcionou ?"));
            document.add(new Paragraph(" arroz"));

            
        }catch(DocumentException | FileNotFoundException ex){
            
        }finally{
            document.close();
            
        }
        
        Desktop.getDesktop().open(new File ("documento.pdf"));
        
        
    }*/
        com.lowagie.text.Font blueFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
        com.lowagie.text.Font redFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 255, 0, 0));
        com.lowagie.text.Font yellowFont = FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 255, 0));
        Document document = new Document();
        try {                                                         // Nome do arquivo pode ser algo unico do funcionario + data ;
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("documento.pdf"));
            document.open();
            //document.add(new Paragraph("Styling Example"));

            //Cor e estilo da fonte
            Paragraph paragraphOne = new Paragraph("Pão de batata", redFont);
            document.add(paragraphOne);

            //Cria capitulo e sessao
            Paragraph chapterTitle = new Paragraph("Cápitulo Amarelo", yellowFont);
            Chapter chapter1 = new Chapter(chapterTitle, 1);
            chapter1.setNumberDepth(0);

            Paragraph sectionTitle = new Paragraph("Sessao de titulo vermelho", redFont);
            Section section1 = chapter1.addSection(sectionTitle);

            Paragraph sectionContent = new Paragraph("Sessao de conteudo de texxto", blueFont);
            section1.add(sectionContent);

            document.add(chapter1);

            document.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
