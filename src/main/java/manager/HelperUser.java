package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm(){
        wd.findElement(By.xpath("//a[.=' Log in ']")).click();
    }
    public void openRegistrationForm(){
        wd.findElement(By.xpath("//a[.=' Sign up ']")).click();
    }

    public void fillLoginForm(String email, String password){
        type(By.id("email"),email);
        type(By.id("password"),password);
//        type(By.id("passwo"),password);
    }
    // overloading
    public void fillLoginForm(User user){
        type(By.id("email"),user.getEmail());
        type(By.id("password"),user.getPassword());
    }

    public void fillRegistrationForm(User user){
        type(By.id("name"),user.getName());
        type(By.id("lastName"),user.getLastName());
        type(By.id("email"),user.getEmail());
        type(By.id("password"),user.getPassword());
        clickCheckbox();
    }

    // method signature - type + name + parameters types


    public void clickCheckbox(){
        System.out.println("Clicked Checkbox");
 //     variant 1
 //       click(By.cssSelector("label[for='terms-of-use']"));
//      variant 2
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click()");
//      variant 3
//        Rectangle rect = wd.findElement(By.cssSelector("div.checkbox-container")).getRect();
//        int x = rect.getX() + 5;
//        int y = rect.getY() + rect.getHeight() / 4;
//        Actions actions = new Actions(wd);
//        actions.moveByOffset(x,y).click().perform();





    }

    public void submitLoginYalla(){
       wd.findElement(By.cssSelector("button[type='submit']")).submit();
//       wd.findElement(By.cssSelector("button[type='submit']")).click();

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
    public boolean isLoggedSuccessful(){
 //       return isElementPresent(By.xpath("//h1[.='Logged in']"));
      return isElementPresent(By.xpath("//h2[contains(text(),'success')]"));
    }
    public void login(User user){
        openLoginForm();
        fillLoginForm(user.getEmail(),user.getPassword());
        submitLoginYalla();
        closePopUpWindow();
    }

    public boolean isRegistrationUnsuccessful(){
       
        return isElementPresent(By.xpath("//div[@class='error']"));
    }

    public boolean isPasswordWrong(){
        return isElementPresent(By.xpath("//div[@class ='ng-star-inserted']"));
    }
    public boolean isEmailWrong(){
        return isElementPresent(By.xpath("//div[@class ='error']"));
    }


}
