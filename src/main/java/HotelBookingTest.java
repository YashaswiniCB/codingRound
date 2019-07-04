import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest {

    WebDriver driver = new ChromeDriver();

    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    @Test
    public void shouldBeAbleToSearchForHotels() {
        setDriverPath();

        driver.get("https://www.cleartrip.com/");
        hotelLink.click();

        localityTextBox.sendKeys("Indiranagar, Bangalore");


//Find the checkin control
driver.findElement(By.xpath("//form[@id='SearchForm']/section[2]/div[1]/dl/dt/label")).click();

//Wait until calendar visible
    wait.until(ExpectedConditions.visibilityOf(driver.findElements(By.className("calendar")).get(0)));


 //Click check-in(5th july) date
    driver.findElements(By.xpath
            ("//div[@id='ui-datepicker-div']/div[1]/table/tbody/tr[1]/td[5]/a")).click();
    //Check-in selection finished//


//Find the check-out control
driver.findElement(By.xpath("//form[@id='SearchForm']/section[2]/div[2]/dl/dt/label")).click();

//Wait until calendar visible
    wait.until(ExpectedConditions.visibilityOf(driver.findElements(By.className("calendar")).get(0)));


 //Click check-out(8th july) date
    driver.findElements(By.xpath
            ("//div[@id='ui-datepicker-div']/div[1]/table/tbody/tr[2]/td[1]/a")).click();
    //Check-out selection finished//



 new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        driver.findElements(By.id
            ("SearchHotelsButton")).click();

        driver.quit();

    }

    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

}
