package cn.knife037.bean;

public class NovelBean {
	private int id;
	
	private String name;
	
	private String rectChap;

	private String url;
	
	public NovelBean() {
		
	}
	
	public NovelBean(int id, String name, String rectChap) {
		this.id = id;
		this.name = name;
		this.rectChap = rectChap;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRectChap() {
		return rectChap;
	}

	public void setRectChap(String rectChap) {
		this.rectChap = rectChap;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
