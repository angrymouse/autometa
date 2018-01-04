package autometa.framework.core;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;

public enum Browser {
	CHROME("org.openqa.selenium.chrome.ChromeDriver", "/chromedriver.exe");
	
	private final String browserDriverClass;
	
	//Driver name inside resources
	private final String browserDriverPath;
	
	private Browser(String browserDriverClass, String browserDriverPath) {
		this.browserDriverClass = browserDriverClass;
		this.browserDriverPath = browserDriverPath;
	}
	
	public String getBrowserDriverClass() {
		return browserDriverClass;
	}
	
	public String getBrowserDriverPath() {
		return browserDriverPath;
	}
	
	public Capabilities getBrowseCapabilities() {
		switch (this) {
		case CHROME:
			return new ChromeOptions();
			
		default:
			throw new RuntimeException();
		}
	}
}
