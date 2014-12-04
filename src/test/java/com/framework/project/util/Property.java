package com.framework.project.util;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
import java.util.Properties;

	public class Property{
		public static String read(String key){
			File file = new File("src/test/resources/data/PropertyFile/Config.properties");
			FileInputStream fileinput;
			try {
				fileinput = new FileInputStream(file);
				Properties property = new Properties();
				property.load(fileinput);
			 
			String value = property.getProperty(key);
			return value;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			return key;
			
			
		}
	}
		
