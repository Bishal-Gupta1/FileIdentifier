package ResourcesScrapper;

import java.io.IOException;
import java.net.SocketException;
import java.util.Iterator;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ResFileInfo {
	public static Document doc;
	public static Boolean responseStatus;

	public ResFileInfo(String extension) throws IOException, SocketException {
		final String url = "https://fileinfo.com/extension/" + extension;
		Response response = Jsoup.connect(url).execute();
		if (response.statusCode() == 200) {
			doc = Jsoup.connect(url).get();
			responseStatus = true;
		} else
			responseStatus = false;
	}

	public static String fetchDescription() {
		String description = "";
		if (responseStatus) {
			description = doc.select(" div.infoBox:nth-of-type(2)").text();
			if (description == null || description.equals("")) {
				description = "N/A";
			}
		}
		return description;
	}

	public static String fetchFormat() {
		String format = "";
		if (responseStatus) {
			Element Table = doc.select("table.headerInfo").first();
			/*
			 * Making table Iterable... 2nd Column of Table is being referred by
			 * td:nth-of-type(2)
			 */
			Iterator<Element> it = Table.select("td:nth-of-type(2)").iterator();
			it.next();
			it.next();
			it.next();
			format = it.next().text();
			if ((format == null) || (format.equals(""))) {
				format = "N/A";
			}
			/*
			 * Another way of Fetching Format
			 * 
			 * int j=1; for (Element row : doc.select("table.headerInfo tr")) { if (j == 4)
			 * format = row.select("td:nth-of-type(2)").text(); ++j; }
			 */
		}
		return format;
	}

}
