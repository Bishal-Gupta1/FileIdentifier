package ResourcesScrapper;

import DatabaseHandler.Files;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import Interfaces.WebScrape;

public class ResOnlineConvert implements WebScrape {
	/**
	 * implements WebScrape Interface:
	 * data source : OnlineConvert.com
	 **/
	public static ArrayList<Files> detailsOfExtension;

	public ResOnlineConvert() {
		detailsOfExtension = new ArrayList<>();
	}

	@Override
	public void fetchReosurces() throws IOException, SocketException {
		final String url = "https://www.online-convert.com/file-type";
		final Document doc = Jsoup.connect(url)
				.userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0").get();

		for (org.jsoup.nodes.Element row : doc.select("table.list_file_formats tr")) {
			if (row.select("td:nth-of-type(1)").text().equals(""))
				continue;
			else {
				Files file = new Files();

				file.setExtension(row.select("td:nth-of-type(1)").text());

				file.setCategory(row.select("td:nth-of-type(2)").text());

				file.setApplication(row.select("td:nth-of-type(3)").text());

				file.setAuthor(row.select("td:nth-of-type(4)").text());				
			
			    detailsOfExtension.add(file);
			}			
		}
	}

}
