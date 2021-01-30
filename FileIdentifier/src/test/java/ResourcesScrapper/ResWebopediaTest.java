package ResourcesScrapper;

import org.junit.jupiter.api.Test;

import DatabaseHandler.Files;

class ResWebopediaTest {

	@Test
	void fetchResourcesShouldRetrieveExtensions() {
		try {
			new ResWebopedia().fetchReosurces();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		for (Files e : ResWebopedia.detailsOfExtension) {
			System.out.println(e.getExtension()+"   "+e.getFormat());
		}

	}

}
