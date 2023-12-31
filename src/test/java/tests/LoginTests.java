package tests;

import manager.TestNgListener;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNgListener.class)
public class LoginTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logOut();
        }
    }

    @Test
    public void loginPositive() {
        String email = "marzh@gmail.com", password = "Qwert123$";
        logger.info("User with data " + email + ", " + password + " logged in");
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email, password);
        app.getUser().submitLoginYalla();
        //  Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h1[.='Logged in']")));
        app.getUser().click(By.cssSelector("button[type='button']"));
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[.=' Logout ']")));

    }

    @AfterMethod
    public void postcondition() {

        if (app.getUser().isLoggedSuccessful()) {
            app.getUser().closePopUpWindow();
            app.getUser().logOut();
        }
    }
}