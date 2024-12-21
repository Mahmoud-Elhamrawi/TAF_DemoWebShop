package pages;

import Utilities.classesUtility;
import Utilities.logUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class P07_SearchPage {

    private final WebDriver driver;
    private final By searchInp = By.xpath("//input[contains(@class,'search-box-text')]");
    private final By searchBtnSubmit = By.cssSelector("input[type=\"submit\"]");
    public List<WebElement> options;


    public P07_SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public P07_SearchPage enterTextForSearch(String txt) {
        classesUtility.enterText(driver, searchInp, txt);
        return this;
    }

    public P08_ProductDetails clickOnSearchBtnSubmit() {
        classesUtility.clickOnEle(driver, searchBtnSubmit);
        return new P08_ProductDetails(driver);
    }

    public P08_ProductDetails clickOnOption() throws IOException {
        options = driver.findElements(By.xpath("//li[@class=\"ui-menu-item\"]"));//3
        logUtility.info("options " + options);
        for (int i = 1; i <= options.size(); i++) {
            By clickOption = By.xpath("//li[@class=\"ui-menu-item\"][" + i + "]");
            if (classesUtility.getText(driver, clickOption).contains("Health Book"))
                classesUtility.clickOnEle(driver, clickOption);
        }
        return new P08_ProductDetails(driver);
    }


}
