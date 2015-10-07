import org.openqa.selenium.Capabilities
import org.openqa.selenium.Dimension
import org.openqa.selenium.firefox.FirefoxBinary
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.phantomjs.PhantomJSDriver

/**
 * Created by blindweasel on 10/6/15.
 */

reportsDir = new File('./build/geb-reports')
driver = {
    def driver = new PhantomJSDriver()
    driver.manage().window().setSize(new Dimension(1024, 768))
    return driver
}
