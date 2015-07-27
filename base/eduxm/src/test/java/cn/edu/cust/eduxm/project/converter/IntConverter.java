package cn.edu.cust.eduxm.project.converter;

public class IntConverter implements Converter {

	@Override
	public Object convert(String value) {
		return Integer.parseInt(value);
	}

}
