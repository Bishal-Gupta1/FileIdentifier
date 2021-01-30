package ResourcesScrapper;

import DatabaseHandler.Files;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import Interfaces.WebScrape;

public class ResOnlineConvert implements WebScrape {
	/**
	 * implements WebScrape Interface: data source : OnlineConvert.com
	 **/
	final String url = "https://www.online-convert.com/file-type";
	public static ArrayList<Files> detailsOfExtension;
	public Document doc;
	public Boolean responseStatus;

	public ResOnlineConvert() throws IOException, SocketException {		
		try {
			doc = Jsoup.connect(url).get();
			responseStatus = true;
		} catch (HttpStatusException e) {
			responseStatus = false;
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	@Override
	public void fetchReosurces() throws HttpStatusException {
		if (responseStatus) {
			detailsOfExtension = new ArrayList<>();
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
		else {
			throw new HttpStatusException("Connection could not be Established", 404, url);
		}
	}


}
