package autometa.framework.core;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public enum Browser {
	CHROME("org.openqa.selenium.chrome.ChromeDriver",
			"/chromedriver-2.34/",
			"chromedriver.win.exe", 
			"chromedriver.linux"),
	
	FIREFOX("org.openqa.selenium.firefox.FirefoxDriver",
			"/geckodriver-0.19.1/",
			"geckodriver.win.exe",
			"geckodriver.linux");
	
	private final String browserDriverClass;
	
	//Driver name inside resources
	private final String driverFolder;
	private final String windowsDriverName;
	private final String linuxDriverName;
	
	private Browser(String browserDriverClass, 
			String driverFolder, 
			String windowsDriverName, 
			String linuxDriverName) {
		this.browserDriverClass = browserDriverClass;
		this.driverFolder = driverFolder;
		this.windowsDriverName = windowsDriverName;
		this.linuxDriverName = linuxDriverName;
	}
	
	public String getBrowserDriverClass() {
		return browserDriverClass;
	}
	
	public String getDriverFolder() {
		return driverFolder;
	}

	public String getWindowsDriverName() {
		return windowsDriverName;
	}
	
	public String getLinuxDriverName() {
		return linuxDriverName;
	}

	public Capabilities getBrowseCapabilities() {
		switch (this) {
		case CHROME:
			return new ChromeOptions();
		case FIREFOX:
			return new FirefoxOptions();
		default:
			throw new RuntimeException("Can't create Browse Capabilities");
		}
	}
}
