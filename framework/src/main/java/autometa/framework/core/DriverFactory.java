package autometa.framework.core;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

	// private static Map<String, Pair<String, Capabilities>> browsers = Stream.of(
	// new Entry(BrowserType.CHROME, new Pair<String,
	// Capabilities>("org.openqa.selenium.chrome.ChromeDriver", new
	// ChromeOptions()))
	// new Entry(BrowserType.FIREFOX, "org.openqa.selenium.firefox.FirefoxDriver"),
	// new Entry(BrowserType.IE, "org.openqa.selenium.ie.InternetExplorerDriver"),
	// new Entry(BrowserType.EDGE, "org.openqa.selenium.edge.EdgeDriver"),
	// new Entry(BrowserType.OPERA_BLINK, "org.openqa.selenium.opera.OperaDriver"),
	// new Entry(BrowserType.OPERA, "com.opera.core.systems.OperaDriver"),
	// new Entry(BrowserType.SAFARI, "org.openqa.selenium.safari.SafariDriver"),
	// new Entry(BrowserType.PHANTOMJS,
	// "org.openqa.selenium.phantomjs.PhantomJSDriver"),
	// new Entry(BrowserType.HTMLUNIT,
	// "org.openqa.selenium.htmlunit.HtmlUnitDriver")
	// ).collect(Collectors.toMap(e -> e.browserName, e -> e.driverCapabilities));

	static {
		System.setProperty("webdriver.chrome.driver", getOsDriver(Browser.CHROME));
		System.setProperty("webdriver.gecko.driver", getOsDriver(Browser.FIREFOX));
	}
	
	private static String getOsDriver(Browser browser) {
		String pathToDriver;
		if(SystemUtils.IS_OS_WINDOWS) {
			pathToDriver = browser.getDriverFolder()+browser.getWindowsDriverName();
		} else if (SystemUtils.IS_OS_LINUX) {
			pathToDriver = browser.getDriverFolder()+browser.getLinuxDriverName();
		} else {
			throw new SystemNoSupported();
		}
		return DriverFactory.class.getResource(pathToDriver).getFile().toString();
	}

	public static WebDriver createDriver(Browser browser) {
		try {
			return callConstructor(browser);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static WebDriver callConstructor(Browser browser)
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<? extends WebDriver> from = Class.forName(browser.getBrowserDriverClass()).asSubclass(WebDriver.class);
		Constructor<? extends WebDriver> constructor = from.getConstructor(Capabilities.class);

		return constructor.newInstance(browser.getBrowseCapabilities());
	}
}
