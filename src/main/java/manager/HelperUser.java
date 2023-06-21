package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm(){
        wd.findElement(By.xpath("//a[.=' Log in ']")).click();
    }
    public void fillLoginForm(String email, String password){
        type(By.id("email"),email);
        type(By.id("password"),password);
    }
    // overloading
    public void fillLoginForm(User user){
        type(By.id("email"),user.getEmail());
        type(By.id("password"),user.getPassword());
    }

    // method signature - type + name + parameters types

    public void submitLoginYalla(){
       wd.findElement(By.cssSelector("button[type='submit']")).submit();

    }

    public void logOut(){
        click(By.xpath("//a[.=' Logout ']"));

    }
    public boolean isLogged(){
        return isElementPresent(By.xpath("//a[.=' Logout ']"));
    }

    public void closePopUpWindow(){
        click(By.cssSelector("button[type='button']"));
    }
    public boolean isPopUpWindowPresent(){
        return isElementPresent(By.xpath("//h1[.='Logged in']"));
    }

}
