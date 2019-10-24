package truNarrative;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static truNarrative.POM.*;

public class truNarrative {
    private WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Given("I am on google website")
    public void that_i_am_on_google_website() {
        driver.get("http://www.google.com/");
    }

    @Given("I search for {string}")
    public void i_search_for(String string) {
        WebElement searchBox;
        searchBox = driver.findElement(GOOGLE_SEARCH_BOX);
        searchBox.sendKeys(string);
        searchBox.submit();
    }

    @Given("First result is {string}")
    public void first_result_is(String string) {
        Assert.assertEquals(string, driver.findElement(FIRST_GOOGLE_RESULT).getText());
    }

    @Then("Navigate to Tru Narrative website")
    public void navigate_to_trunarrative_website() {
        driver.findElement(FIRST_GOOGLE_RESULT).click();
    }

    @Then("Check if Easy_Onboarding strap is present")
    public void check_if_Easy_Onboarding_strap_is_present() {
        Assert.assertEquals("Easy Onboarding.  Smooth Transactions.  Insightful Compliance.", driver.findElement(EASY_ONBOARDING_STRAP).getText());
    }

    @Then("Navigate to TruNarrative Team subpage")
    public void navigate_to_TruNarrative_Team_subpage() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(MENU_MORE)).build().perform();
        driver.findElement(MENU_MORE_TRU_NARRATIVE_TEAM).click();
    }

    @Then("Verify if TruNarrative team consists of {int} members")
    public void verify_if_TruNarrative_team_consists_of_members(int membersNumber) {
        Assert.assertEquals(membersNumber, driver.findElements(MEMBER_HOLDER).size());
    }

    @Then("Check roles for the specific team members")
    public void check_roles_for_the_specific_team_members(DataTable members) {
        final String PREFIX = "//*[@id=\"main-content-wrapper\"]/section[2]/div/article/div/div[";
        for (int memberNumber = 1; memberNumber < members.height(); memberNumber++) {
            for (int memberCell = 1; memberCell < driver.findElements(MEMBER_HOLDER).size(); memberCell++) {
                if (driver.findElement(By.xpath(PREFIX + memberCell + "]/div[2]/div/h2")).getText().equals(members.row(memberNumber).get(0))) {
                    Assert.assertEquals(members.row(memberNumber).get(1), driver.findElement(By.xpath(PREFIX + memberCell + "]/div[2]/div/p")).getText());
                }
            }
        }
    }

    @After
    public void after() {
        driver.close();
    }


}
