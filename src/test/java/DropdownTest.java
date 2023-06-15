import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class DropdownTest extends BaseTest{

    @Test
    public void checkDropdown(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        List options = select.getOptions();


        assertEquals(options.size(),3);

        select.selectByIndex(1);
        assertEquals(select.getFirstSelectedOption().getText(),"Option 1");

        select.selectByIndex(2);
        assertEquals(select.getFirstSelectedOption().getText(),"Option 2");
    }

}
