import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class CheckboxesTest extends BaseTest{

    @Test
    public void verifyCheckboxes(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("[type='checkbox']"));

        assertFalse(checkBoxes.get(0).isSelected(), "Чек-бокс включен");

        checkBoxes.get(0).click();

        assertTrue(checkBoxes.get(0).isSelected(),"Чек-бокс выключен");

        assertTrue(checkBoxes.get(1).isSelected(),"Чек-бокс включен");

        checkBoxes.get(1).click();

        assertFalse(checkBoxes.get(1).isSelected(),"Чек-бокс выключен");

    }

}
