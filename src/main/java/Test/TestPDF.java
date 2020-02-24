package Test;
import org.testng.annotations.Test;

import PDFVerify.*;
public class TestPDF {
	
	@Test 
	public void test()
	{
		PDFVerification Pdf = new PDFVerification();
		Pdf.VerifyText("sample.pdf", "zzzzz.");
	}

}
