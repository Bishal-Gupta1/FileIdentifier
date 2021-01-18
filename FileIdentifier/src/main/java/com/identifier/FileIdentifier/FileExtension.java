package com.identifier.FileIdentifier;

public class FileExtension {

	private String extension,category,format,application,programParadigm,description,author;
	
	public FileExtension(String extension, String category, String format, String application, String programParadigm,
			String description, String author) {
		this.extension = extension;
		this.category = category;
		this.format = format;
		this.application = application;
		this.programParadigm = programParadigm;
		this.description = description;
		this.author = author;
	}
	
	/**
	 * constructor taking input single string
	 * 
	 * As only Extension is retrieved from websource: webopedia
	 * object of this class with this constructor is initialized to update database with only extension field
	 * and rest attributes as null.
	 * @param extension
	 */
	public FileExtension(String extension) {		
		this.extension = extension;		
		this.application="N/A";
		this.author="N/A";
		this.category="N/A";
		this.format="N/A";
		this.description="N/A";
		this.programParadigm="N/A";
		
	}
	
	/**
	 * constructor taking  input of four strings
	 * 
	 * As Extensions, category, application and author information are only retrieved from websource: Online-Converter
	 * object of this class with this constructor is initialized to update database with these fields only
	 * and rest attributes as null.
	 * @param extension
	 */
	public FileExtension(String extension, String category, String application, String author) {
		
		this.extension = extension;
		this.category = category;
		this.application = application;
		this.author = author;
		this.format="N/A";
		this.description="N/A";
		this.programParadigm="N/A";
		
	}
    
	public String getCategory() {
		return category;
	}
	public String getFormat() {
		return format;
	}
	public String getApplication() {
		return application;
	}
	public String getAuthor() {
		return author;
	}	
	public String getProgramParadigm() {
		return programParadigm;
	}
	public String getDescription() {
		return description;
	}	
	
	@Override
	public String toString() {
		return "FileExtension [extension=" + extension + ", category=" + category + ", format=" + format
				+ ", application=" + application + ", programParadigm=" + programParadigm + ", description="
				+ description + ", author=" + author + "]";
	}
}
