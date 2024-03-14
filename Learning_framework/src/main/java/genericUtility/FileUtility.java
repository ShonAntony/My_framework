package genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	//this method is used to get the value from the property file by passing the key
	//@param Key
	public String getValueFromPropertyFile(String key) {
		String value=null;
		try {
			FileInputStream fis = new FileInputStream("");
			Properties pro = new Properties();
			pro.load(fis);
			value = pro.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

}
