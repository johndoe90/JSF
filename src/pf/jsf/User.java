package pf.jsf;

import java.io.Serializable;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@Scope("view")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSayWelcome() {
		if ( name == null )  {
			return "";
		} else {
			return "Welcome " + name;
		}
	}
}
