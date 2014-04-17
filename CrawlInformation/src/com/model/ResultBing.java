package com.model;

import java.util.Date;

public class ResultBing {
	private Metadata __metadata;
	private String ID;
	private String Title;
	private String Description;
	private String DisplayUrl;
	private String Url;
	private String sourceCode;
	private Date time;
	
	public class Metadata{
		private String uri;
		private String type;
		public String getUri() {
			return uri;
		}
		public void setUri(String uri) {
			this.uri = uri;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		
		
	}

	public Metadata get__metadata() {
		return __metadata;
	}

	public void set__metadata(Metadata __metadata) {
		this.__metadata = __metadata;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getDisplayUrl() {
		return DisplayUrl;
	}

	public void setDisplayUrl(String displayUrl) {
		DisplayUrl = displayUrl;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
