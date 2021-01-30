
package DatabaseHandler;

import org.junit.jupiter.api.Test;

class ReadDatabaseTest {

	@Test
	void read_WorkingImplementation() {
		try {
			System.out.println(ReadDatabase.Read("pdf"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.gc();
	}

}
