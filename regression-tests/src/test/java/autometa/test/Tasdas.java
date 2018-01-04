package autometa.test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import autometa.framework.core.Browser;
import autometa.framework.core.DriverFactory;

public class Tasdas {
	@Test
    public void teste() {
		WebDriver w = DriverFactory.createDriver(Browser.FIREFOX);
    }
}
