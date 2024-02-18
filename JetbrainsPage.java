import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://www.jetbrains.com/
public class JetbrainsPage {
    @FindBy(css = "html > body > div:nth-of-type(1) > div:nth-of-type(2) > main > div:nth-of-type(1) > section > div > div:nth-of-type(2) > div:nth-of-type(1) > div > div > a")
    public WebElement linkForDevelopers;

    @FindBy(xpath = "//a[@href='/products/#type=ide-vs']")
    public WebElement linkForDevelopers2;

    public JetbrainsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}