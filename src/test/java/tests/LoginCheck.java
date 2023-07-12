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

        if (TestBase.app.getUser().isLogged()) {
            TestBase.app.getUser().logOut();
        }
    }


    @Test
    public void loginPositive() {

        TestBase.app.getUser().openLoginForm();
        TestBase.app.getUser().fillLoginForm("marzh@gmail.com", "Qwert123$");
        TestBase.app.getUser().submitLoginYalla();
        TestBase.app.getUser().pause(3000);
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

        TestBase.app.getUser().openLoginForm();
        TestBase.app.getUser().fillLoginForm(user.getEmail(), user.getPassword());
        TestBase.app.getUser().submitLoginYalla();
        TestBase.app.getUser().pause(3000);
        Assert.assertTrue(TestBase.app.getUser().isElementPresent(By.xpath("//h1[.='Logged in']")));

    }

    @Test
    public void loginPositiveUserData() {
        User user = new User().withEmail("marzh@gmail.com")
                .withPassword("Qwert123$");

        TestBase.app.getUser().openLoginForm();
        TestBase.app.getUser().fillLoginForm(user);
        TestBase.app.getUser().submitLoginYalla();
        TestBase.app.getUser().pause(3000);
        Assert.assertTrue(TestBase.app.getUser().isLoggedSuccessful());

    }
    @Test(dataProvider = "userDTO",dataProviderClass = ProviderData.class)
    public void loginPositiveUserDTO(User user) {
//        User user = User.builder()
//                .email("marzh@gmail.com")
//                .password("Qwert123$")
//                .build();

        TestBase.app.getUser().openLoginForm();
        TestBase.app.getUser().fillLoginForm(user);
        TestBase.app.getUser().submitLoginYalla();
        TestBase.app.getUser().pause(3000);
        Assert.assertTrue(TestBase.app.getUser().isLoggedSuccessful());

    }

    @AfterMethod
    public void postcondition() {

        if (TestBase.app.getUser().isLoggedSuccessful()) {
            TestBase.app.getUser().closePopUpWindow();
//            app.getUser().closePopUpWindow();
//            app.getUser().logOut();

        }


    }
}
