package Utils;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class WebElementUtils {

    //collect link text and titles of the pages they open in a key-value pair for assertions
    public static Map<String, String> getLinkTextAndCorrespondingPageTitlesTheyOpen(List<WebElement> links, WebDriver driver) {
        HashMap<String, String> linkTitleMap = new HashMap<>();
        AtomicInteger index = new AtomicInteger(1);
        links.forEach(link -> {
            WebElement currentElement = getElementByIndex(getElementLocatorAsString(link), index.get(), driver);
            String linkName = currentElement.getText();
            currentElement.click();
            String pageName = trimPageTitleToExcludeDefaultValue(driver.getTitle());
            index.getAndIncrement();
            linkTitleMap.put(linkName, pageName);
        });
        return linkTitleMap;
    }

    public static String getElementLocatorAsString(WebElement element) {
        return element.toString().split("->")[1].replaceFirst("(?s)(.*)]", "$1" + "").split(":")[1].trim();
    }

    public static WebElement getElementByIndex(String xpath, int index, WebDriver driver) {
        return driver.findElement(By.xpath('(' + xpath + ')' + '[' + index + ']'));
    }

    public static String trimPageTitleToExcludeDefaultValue(String linkText) {
        return linkText.replace(" | Demokauppa", "");
    }

    public static void selectButtonInDropdown(WebElement dropdown, String selectButtonName) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(selectButtonName);
    }

    public static List<String> getElementsTextAsList(List<WebElement> webElements) {
        return webElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    @Test
    public void print(){
        System.out.println(System.getProperty("browser").toLowerCase());
    }


}
