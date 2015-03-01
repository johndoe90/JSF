package pf.jsf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class MyConverter implements Converter {

	private Method method;
	private final String methodName;
	private final List<? extends Object> dataSource;
	
	public MyConverter(List<? extends Object> dataSource) {
		this(dataSource, "getId");
	}
	
	public MyConverter(List<? extends Object> dataSource, String methodName) {
		this.methodName = methodName;
		this.dataSource = dataSource;
	}
	
	private Method getMethod(Object obj) {
		if ( method == null ) {
			try {
				method = obj.getClass().getDeclaredMethod(methodName, new Class[]{});
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
				throw new RuntimeException(String.format("The class '%s' has no method called '%s'", obj.getClass().getSimpleName(), methodName));
			}
		}
		
		return method;
	}
	
	private String getId(Object obj) {
		String id = null;
		Method method = getMethod(obj);
		
		try {
			id = ((Object) method.invoke(obj, null)).toString();
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException("Something went wrong during invokation");
		}
		
		return id;
	}
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		for ( Object obj : dataSource ) {
			if ( id.equals(getId(obj)) ) {
				return obj;
			}
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		return getId(obj);
	}
}
