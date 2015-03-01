package pf.jsf;

import java.io.Serializable;

public class Package implements Serializable {

	private static final long serialVersionUID = 3120741903679253186L;

	private Integer id;
	private String content;
	
	public Package(Integer id, String content) {
		this.id = id;
		this.content = content;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
