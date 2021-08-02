package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	public Properties initProp() {
		prop = new Properties();
		try {
			FileInputStream ipstream = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ipstream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Inside config reader : Prop "+ prop);
		return prop;
	}

}
