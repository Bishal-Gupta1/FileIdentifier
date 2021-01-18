package ResourcesScrapper;

import java.net.UnknownHostException;
import org.junit.jupiter.api.Test;

class ResWebopediaTest {

	@Test
	void fetchResourcesShouldRetrieveExtensions() {
		ResWebopedia webopedia = new ResWebopedia();
		try {
			webopedia.fetchExtensions();
		} catch (UnknownHostException ex) {
			System.out.println(ex + "\n\nCheck Your Network Connection.......");
		} catch (Exception ex) {
			System.out.println(ex);
		}
         int i=0;  
		for (String e : ResWebopedia.extensions) {
			System.out.println(i+"  "+e);
		    ++i;
		}
	}

}
