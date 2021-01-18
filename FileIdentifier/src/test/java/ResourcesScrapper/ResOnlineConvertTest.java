package ResourcesScrapper;

import java.net.UnknownHostException;
import org.junit.jupiter.api.Test;
import DatabaseHandler.Files;

class ResOnlineConvertTest {

	@Test
	void fetchResourcesShouldRetrieveExtensions() {
		ResOnlineConvert onlineConvert = new ResOnlineConvert();
		try {
			onlineConvert.fetchReosurces();
		} catch (UnknownHostException ex) {
			System.out.println(ex + "\n\nCheck Your Network Connection.......");
		} catch (Exception ex) {
			System.out.println(ex);
		}

		for (Files e : ResOnlineConvert.detailsOfExtension) {
			System.out.println(e.toString());
		}
	}

}
