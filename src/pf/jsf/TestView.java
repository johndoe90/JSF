package pf.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@Scope("view")
public class TestView implements Serializable {

	private static final long serialVersionUID = -3615491628790593027L;

	private Package myPackage;
	
	private List<Package> myPackages;
	
	private MyConverter myConverter;
	
	@PostConstruct
	public void init() {
		System.out.println("in here");
		
		myPackages = new ArrayList<>();
		myPackages.add(new Package(1, "Computer"));
		myPackages.add(new Package(2, "Shovel"));
		myPackages.add(new Package(3, "Headset"));
		myPackages.add(new Package(4, "Printer"));
		
		myConverter = new MyConverter(myPackages);
	}
	
	public void openPackage() {
		System.out.println("Package contains " + myPackage.getContent());
	}
	
	public void removePackage() {
		System.out.println("Remove package " + myPackage.getContent());
		myPackages.remove(myPackage);
	}

	public Package getMyPackage() {
		return myPackage;
	}

	public void setMyPackage(Package myPackage) {
		this.myPackage = myPackage;
	}

	public List<Package> getMyPackages() {
		return myPackages;
	}

	public void setMyPackages(List<Package> myPackages) {
		this.myPackages = myPackages;
	}

	public MyConverter getMyConverter() {
		return myConverter;
	}

	public void setMyConverter(MyConverter myConverter) {
		this.myConverter = myConverter;
	}


}
