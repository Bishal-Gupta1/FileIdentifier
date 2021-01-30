package ResourcesScrapper;

import java.io.IOException;
import java.util.Iterator;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ResFileInfo {
	private String url;
	public Document doc;

	public String description;
	public String format;
	public String category;
	public String author;

	public ResFileInfo(String extension)throws HttpStatusException {
		url = "https://fileinfo.com/extension/" + extension;
		try {
			doc = Jsoup.connect(url).get();
			setAll();
		} catch (HttpStatusException e) {
			throw new HttpStatusException("Extension not found",404,url);
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}

	public void setAll() {
		Element Table = doc.select("table.headerInfo").first();
		/*
		 * Making table Iterable... 2nd Column of Table is -> td:nth-of-type(2)
		 */
		Iterator<Element> it = Table.select("td:nth-of-type(2)").iterator();

		this.author = it.next().text();
		if (invalid(this.author))
			this.author = "N/A";

		// this element is skipped as it is popularity of extension, which is not required.
		it.next();

		this.category = it.next().text();
		if (invalid(this.category))
			this.category = "N/A";

		this.format = it.next().text();
		if (invalid(this.format))
			this.format = "N/A";

		this.description = doc.select(" div.infoBox:nth-of-type(2)").text();
		if (invalid(this.description))
			this.description = "N/A";
	}

	public Boolean invalid(String str) {
		if (str == null || str.equals(""))
			return true;
		else
			return false;
	}

	public String getDescription() {
		return this.description;
	}

	public String getFormat() {
		return this.format;
	}

	public String getCategory() {
		return this.category;
	}

	public String getAuthor() {
		return this.author;
	}

}
