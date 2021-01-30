package ResourcesScrapper;

import java.io.IOException;
import java.net.SocketException;
import org.junit.jupiter.api.Test;
import DatabaseHandler.Files;

class ResOnlineConvertTest {

	@Test
	void fetchResourcesShouldRetrieveExtensions() throws SocketException, IOException {
		try {
			new ResOnlineConvert().fetchReosurces();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		for (Files e : ResOnlineConvert.detailsOfExtension) {
			System.out.println(e + "\n");
		}
	}

}