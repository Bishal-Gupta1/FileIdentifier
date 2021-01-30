package ResourcesScrapper;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class ResFileInfoTest {

	@Test
	void getDescription_ShouldRetrieveDescriptionOfExtension() {
		try {
			ResFileInfo fileInfo = new ResFileInfo("o");
			String des = "Object file produced by a C compiler; often created instead of a program file during the development process.";
			assertEquals(des, fileInfo.getDescription());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	void getFormat_ShouldRetrieveFormatOfExtension() {
		try {
			ResFileInfo fileInfo = new ResFileInfo("pdf");
			assertEquals("Binary", fileInfo.getFormat());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	void getAuthor_ShouldRetrieveAuthorOfExtension() {
		try {
			ResFileInfo fileInfo = new ResFileInfo("pdf");
			assertEquals("Adobe Systems", fileInfo.getAuthor());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	void getCategory_ShouldRetrieveCategoryOfExtension() {
		try {
			ResFileInfo fileInfo = new ResFileInfo("pdf");
			assertEquals("Page Layout Files", fileInfo.getCategory());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
