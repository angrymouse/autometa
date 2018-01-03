package autometa.framework.core;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;

public enum Browser {
	CHROME("org.openqa.selenium.chrome.ChromeDriver");
	
	private final String browserDriverName;
	
	private Browser(String browserDriverName) {
		this.browserDriverName = browserDriverName;
	}

	public String getBrowserDriverName() {
		return browserDriverName;
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
