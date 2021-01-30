package ResourcesScrapper;

import DatabaseHandler.Files;
import Interfaces.WebScrape;

import java.util.ArrayList;

import java.io.IOException;
import org.jsoup.HttpStatusException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ResWebopedia implements WebScrape {
	final String url = "https://www.webopedia.com/quick_ref/fileextensionsfull.asp";
	public static ArrayList<Files> detailsOfExtension;
	public Document doc;
	public Boolean responseStatus;

	public ResWebopedia() {
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
			for (Element row : doc.select("table.style5 tr")) {
				String ext = row.select("td:nth-of-type(1)").text();
				String format = row.select("td:nth-of-type(2)").text();
				if ( ext == null|| ext.equals(""))
					continue;
				else {
					Files file = new Files(ext.substring(1), format);
					if (!detailsOfExtension.contains(file))
						detailsOfExtension.add(file);
				}
			}
			detailsOfExtension.remove(0);
		} else {
			throw new HttpStatusException("Connection could not be Established", 404, url);
		}

	}

}
