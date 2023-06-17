package manager;

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

    public void submitLoginYalla(){

        click(By.cssSelector("button[type='submit"));

    }

    public void logOut(){
        click(By.xpath("//a[.=' Logout ']"));

    }
    public boolean isLogged(){
        return isElementPresent(By.xpath("//a[.=' Logout ']"));
    }
}
