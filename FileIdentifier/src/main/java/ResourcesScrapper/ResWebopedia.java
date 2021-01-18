package ResourcesScrapper;

import java.util.ArrayList;
import java.io.IOException;
import java.net.SocketException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ResWebopedia {
	public static ArrayList<String> extensions;

	public ResWebopedia() {
		extensions = new ArrayList<>();
	}

	public void fetchExtensions() throws IOException, SocketException {
		final String url = "https://www.webopedia.com/quick_ref/fileextensionsfull.asp";
		final Document doc = Jsoup.connect(url)
						 	.userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
							.get();

		for (Element row : doc.select("table.style5 tr")) {
			if (row.select("td:nth-of-type(1)").text().equals(""))
				continue;
			else {
				String ext = row.select("td:nth-of-type(1)").text();
				if (extensions.contains(ext))
					continue;
				else
					extensions.add(ext);
			}
		}
		extensions.remove(0);		
	}

}
