package autometa.framework.core;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private static final int TIMEOUT = 5; //seconds
    private static final int POLLING = 100; //milliseconds

    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);

        /**O AjaxElementLocator é uma implementação de element locator qu
         * aguarda os elementos da tela até o timeout, caso atinja o timeout, dispara uma exceção*/ 
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
        Capabilities chrome = new ChromeOptions();
    }
}