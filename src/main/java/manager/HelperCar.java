package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperCar extends HelperBase{
    public HelperCar(WebDriver wd) {
        super(wd);
    }
    public void openCarForm(){
        click(By.xpath("//a[.=' Let the car work ']"));
    }

    public void fillCarForm(Car car){
        if(isCarFormPresent()==false) return;
        typeLocation(car.getLocation());
        type(By.id("make"),car.getMake());
        type(By.id("model"),car.getModel());
        type(By.id("year"),car.getYear());
        select(By.id("fuel"),car.getFuel());
        type(By.id("seats"),car.getSeats());
        type(By.id("class"),car.getCarClass());
        type(By.id("serialNumber"),car.getCarRegNumber());
//        clickSerialNumber(car.getCarRegNumber());
        type(By.id("price"),car.getPrice());
//        type(By.id("about"),car.getAbout());

    }

    public void typeLocation(String address){
       type(By.id("pickUpPlace"),address);
       click(By.cssSelector("div.pac-item"));
    }
    public void clickSerialNumber(String serialNumber){
       WebElement rect = wd.findElement(By.id("serialNumber"));
//        int x = rect.getX() + rect.getWidth() * 7 / 8;
//        int y = rect.getY() + rect.getHeight() / 2;
//
        Actions actions = new Actions(wd);
 //       actions.moveByOffset(x,y).click().sendKeys(serialNumber).perform();
 //    variant 1
  //     actions.moveToElement(wd.findElement(By.id("serialNumber"))).click().sendKeys(serialNumber).perform();
 //    variant 2
//        actions.moveToElement(wd.findElement(By.id("serialNumber")),-10,-10).click()
//                .sendKeys(serialNumber).perform();
        actions.moveToElement(rect).perform();
        rect.clear();
        rect.sendKeys(serialNumber);

    }


    public void select(By locator,String option){
        new Select(wd.findElement(locator)).selectByValue(option);
    }

    public boolean isCarFormPresent(){
       return new WebDriverWait(wd,10).
               until(ExpectedConditions.
                       textToBePresentInElement(
                               wd.findElement(By.cssSelector("h2")),
               "details"));

    }

    public boolean isCarAdd(){
        return isElementPresent(By.xpath("//h1[.='Car added']"));

    }

    public void addOddCar(){
        click(By.xpath("//button[text()='Add another car']"));
    }
}
