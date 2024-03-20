package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	// this method is used to get the value from the property file by passing the
	// key
	// @param Key
	public String getValueFromPropertyFile(String key) throws Exception {
		
		
			FileInputStream fis = new FileInputStream(IpathConstants.propertyFilePath);
			Properties pro = new Properties();
			pro.load(fis);
			String value = pro.getProperty(key);
		
		return value;
	}

}
