package manager;

import models.Search;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperSearch extends HelperBase{
    public HelperSearch(WebDriver wd) {
        super(wd);
    }

    public void fillSearchForm(Search search){
        typeLocation(search.getCity());
        type(By.id("dates"),search.getDates());

    }

    public void fillSearchFormWithDatePickerThisMonth(Search search){
        typeLocation(search.getCity());
        click(By.id("dates"));
        click(By.xpath("//td[.=' 18 ']"));
        click(By.xpath("//td[.=' 25 ']"));

    }

    public void fillSearchFormWithDatePickerThisYear(Search search){
        typeLocation(search.getCity());
        click(By.id("dates"));
        click(By.xpath("//span[@class='mat-button-wrapper']"));
        click(By.xpath("//div[.=' 2023 ']"));
        click(By.xpath("//div[.=' DEC ']"));
        click(By.xpath("//td[.=' 10 ']"));
        click(By.xpath("//td[.=' 14 ']"));

    }


    public void typeLocation(String address){
        type(By.id("city"),address);
        click(By.cssSelector("div.pac-item"));
    }

    public boolean isCarFound(){
        pause(3000);
        return isElementPresent(By.xpath("//div[@class='car-img-container ng-star-inserted']"));
    }

    public void returnToMainPage(){
        click(By.xpath("//a[@class='logo']"));
    }

}
