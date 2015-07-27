package cn.edu.cust.util.db;

import java.sql.Connection;
import java.util.HashMap;

public class IDGeneratorFactory {
	
	protected static HashMap<Class<?>, IncrementGenerator> generators = new HashMap<Class<?>, IncrementGenerator>();
	
	public static IncrementGenerator getGenerator(Class<?> clazz, Connection con){
		IncrementGenerator gen = generators.get(clazz);
		if(gen != null){
			return gen;
		}
		synchronized(generators){
			gen = generators.get(clazz);
			if(gen != null){
				return gen;
			}
			try{
				gen = (IncrementGenerator)clazz.newInstance();
				generators.put(clazz, gen);
				return gen;
			}catch(Exception ex){
				return null;
			}
		}
	}

}
