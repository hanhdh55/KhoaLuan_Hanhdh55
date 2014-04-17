package com.model;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.BSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class ResultGoogle implements DBObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3208186538366700748L;
	private String kind;
	private String title;
	private String htmlTittle;
	private String link;
	private String displayLink;
	private String snippet;
	private String htmlSnippet;
	private String cacheId;
	private String formattedUrl;
	private String htmlFormattedUrl;
	private PageMap pagemap;
	private String sourceCode;
	private Date time;
	
	public String toString(){
		return "title is: " + getTitle() + "\nLink is: " + getLink() + "\nSnippet is: " + getSnippet();
	}
	
	public String getKind() {
		return kind;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}



	public String getHtmlTittle() {
		return htmlTittle;
	}


	public void setHtmlTittle(String htmlTittle) {
		this.htmlTittle = htmlTittle;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public String getDisplayLink() {
		return displayLink;
	}


	public void setDisplayLink(String displayLink) {
		this.displayLink = displayLink;
	}


	public String getSnippet() {
		return snippet;
	}


	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}


	public String getHtmlSnippet() {
		return htmlSnippet;
	}


	public void setHtmlSnippet(String htmlSnippet) {
		this.htmlSnippet = htmlSnippet;
	}


	public String getCacheId() {
		return cacheId;
	}


	public void setCacheId(String cacheId) {
		this.cacheId = cacheId;
	}


	public String getFormattedUrl() {
		return formattedUrl;
	}


	public void setFormattedUrl(String formattedUrl) {
		this.formattedUrl = formattedUrl;
	}


	public String getHtmlFormattedUrl() {
		return htmlFormattedUrl;
	}


	public void setHtmlFormattedUrl(String htmlFormattedUrl) {
		this.htmlFormattedUrl = htmlFormattedUrl;
	}


	public PageMap getPagemap() {
		return pagemap;
	}


	public void setPagemap(PageMap pagemap) {
		this.pagemap = pagemap;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}




	public class PageMap{
		List<CseImage> cse_image;
		List<CseThumbnail> cse_thumbnail;
		public List<CseImage> getCse_image() {
			return cse_image;
		}
		public void setCse_image(List<CseImage> cse_image) {
			this.cse_image = cse_image;
		}
		public List<CseThumbnail> getCse_thumbnail() {
			return cse_thumbnail;
		}
		public void setCse_thumbnail(List<CseThumbnail> cse_thumbnail) {
			this.cse_thumbnail = cse_thumbnail;
		}
		
		
	}
	
	public class CseImage{
		private String src;

		public String getSrc() {
			return src;
		}

		public void setSrc(String src) {
			this.src = src;
		}
		
		
	}
	
	
	public class CseThumbnail{
		private String width;
		private String height;
		private String src;
		public String getWidth() {
			return width;
		}
		public void setWidth(String width) {
			this.width = width;
		}
		public String getHeight() {
			return height;
		}
		public void setHeight(String height) {
			this.height = height;
		}
		public String getSrc() {
			return src;
		}
		public void setSrc(String src) {
			this.src = src;
		}
		
		
	}


	@Override
	public boolean containsField(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Deprecated
	public boolean containsKey(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object get(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object put(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putAll(BSONObject arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void putAll(Map arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object removeField(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map toMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPartialObject() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void markAsPartialObject() {
		// TODO Auto-generated method stub
		
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

}
