import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class SortDataTableTest extends BaseTest{

    @Test
    public void checkSortTable(){
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> webElementList = driver.findElements(By.xpath("//table[@id ='table1']/tbody/tr/td[1]"));

        List<String> unsortedLastName = new ArrayList<>();
        unsortedLastName.add(webElementList.get(0).getText());
        unsortedLastName.add(webElementList.get(1).getText());
        unsortedLastName.add(webElementList.get(2).getText());
        unsortedLastName.add(webElementList.get(3).getText());
        Collections.sort(unsortedLastName);

        driver.findElement(By.xpath("//table[@id = 'table1']/head/tr/th[1]/span")).click();

        List<WebElement> webElementListSorted = driver.findElements(By.xpath("//table[@id ='table1']/tbody/tr/td[1]"));
        List<String> sortedLastnames = new ArrayList<>();
        sortedLastnames.add(webElementListSorted.get(0).getText());
        sortedLastnames.add(webElementListSorted.get(1).getText());
        sortedLastnames.add(webElementListSorted.get(2).getText());
        sortedLastnames.add(webElementListSorted.get(3).getText());

        assertEquals(sortedLastnames,unsortedLastName,"Массивы не равны или не отсортированы");


    }
}
