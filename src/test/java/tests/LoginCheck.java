package tests;

import manager.ProviderData;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginCheck extends TestBase {


    @BeforeMethod
    public void precondition() {

        if (app.getUser().isLogged()) {
            app.getUser().logOut();
        }
    }


    @Test
    public void loginPositive() {

        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("marzh@gmail.com", "Qwert123$");
        app.getUser().submitLoginYalla();
        app.getUser().pause(3000);
        Assert.assertTrue(TestBase.app.getUser().isElementPresent(By.xpath("//h1[.='Logged in']")));

    } @Test
    public void loginPositiveProps() {

        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(app.getEmail(),app.getPassword());
        app.getUser().submitLoginYalla();
        app.getUser().pause(3000);
        Assert.assertTrue(TestBase.app.getUser().isElementPresent(By.xpath("//h1[.='Logged in']")));

    }

    @Test
    public void loginPositiveUser() {
//        User user = new User("marzh@gmail.com","Qwert123$");
        User user = new User()
                .withEmail("marzh@gmail.com")
                .withPassword("Qwert123$");
//        user.setEmail("marzh@gmail.com");
//        user.setPassword("Qwert123$");
        //               .withEmail("marzh@gmail.com").withPassword("Qwert123$");

        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user.getEmail(), user.getPassword());
        app.getUser().submitLoginYalla();
        app.getUser().pause(3000);
        Assert.assertTrue(TestBase.app.getUser().isElementPresent(By.xpath("//h1[.='Logged in']")));

    }

    @Test
    public void loginPositiveUserData() {
        User user = new User().withEmail("marzh@gmail.com")
                .withPassword("Qwert123$");

        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLoginYalla();
        app.getUser().pause(3000);
        Assert.assertTrue(TestBase.app.getUser().isLoggedSuccessful());

    }
    @Test()
    public void loginPositiveUserDTO() {
        User user = new User()
                .withEmail("marzh@gmail.com")
                .withPassword("Qwert123$");

        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user);
        app.getUser().submitLoginYalla();
        app.getUser().pause(3000);
        Assert.assertTrue(TestBase.app.getUser().isLoggedSuccessful());

    }

    @AfterMethod
    public void postcondition() {

        if (app.getUser().isLoggedSuccessful()) {
            app.getUser().closePopUpWindow();
//            app.getUser().closePopUpWindow();
//            app.getUser().logOut();

        }


    }
}
