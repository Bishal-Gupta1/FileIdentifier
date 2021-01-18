package DatabaseHandler;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Files")
public class Files {

	@Id
	@Column(name = "EXTENSION")
	private String extension;

	@Column(name = "CATEGORY")
	private String category = "N/A";

	@Column(name = "FORMAT")
	private String format = "N/A";

	@Column(name = "APPLICATION")
	private String application = "N/A";

	@Column(name = "PROGRAM_PARADIGM")
	private String programParadigm = "N/A";

	@Column(name = "DESCRIPTION")
	private String description = "N/A";

	@Column(name = "AUTHOR")
	private String author = "N/A";

	public Files() {

	}

	public Files(String ext) {
		this.extension = ext;
	}

	public Files(String extension, String category, String format, String application, String programParadigm,
			String description, String author) {
		this.extension = extension;
		this.category = category;
		this.format = format;
		this.application = application;
		this.programParadigm = programParadigm;
		this.description = description;
		this.author = author;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getProgramParadigm() {
		return programParadigm;
	}

	public void setProgramParadigm(String programParadigm) {
		this.programParadigm = programParadigm;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "extension=" + extension + "\ncategory=" + category + "\nformat=" + format + "\napplication="
				+ application + "\nprogramParadigm=" + programParadigm + "\ndescription=" + description + "\nauthor="
				+ author;
	}

}