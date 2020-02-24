package PDFVerify;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.testng.annotations.Test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class PDFVerification {
	
	public static void VerifyText( String filePath, String searchWord)
	{
		 try (PDDocument document = PDDocument.load(new File(filePath))) {

	            document.getClass();
                int count = 0 ;
	            if (!document.isEncrypted()) {
				
	                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
	                stripper.setSortByPosition(true);

	                PDFTextStripper tStripper = new PDFTextStripper();

	                String pdfFileInText = null;
					try {
						pdfFileInText = tStripper.getText(document);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                //System.out.println("Text:" + st);

					// split by whitespace
	                String lines[] = pdfFileInText.split("\\r?\\n");
	                for (String line : lines) {
	                	if (line.contains(searchWord))
	                	{
	                		 count ++;
	                	}
	                 
	                }
	                
	                System.out.println("Word "+ searchWord + "Found in " + count +" occurrences in the PDF file ..");

	            }

	        } catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	    }

}
