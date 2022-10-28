package com.cucumber.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties properties;
	private FileInputStream fis;

	public Properties intiProp() {
		try {
			properties = new Properties();
			fis =new FileInputStream(".\\src\\test\\resources\\config.properties");
			properties.load(fis);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return properties;
	}
}
