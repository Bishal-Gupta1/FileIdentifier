package ResourcesScrapper;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.SocketException;

import org.junit.jupiter.api.Test;

class ResFileInfoTest {

	@Test
	void fetchDescription_ShouldRetrieveDescriptionOfExtension() {
		try {
			new ResFileInfo("o");
			String des = "Object file produced by a C compiler; often created instead of a program file during the development process.";
			assertEquals(des , ResFileInfo.fetchDescription());
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.gc();
		}
	}

	@Test
	void fetchFormat_ShouldRetrieveFormatOfExtension() {
		try {
			new ResFileInfo("pdf");
			assertEquals("Binary", ResFileInfo.fetchFormat());
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.gc();
		}

	}

}
