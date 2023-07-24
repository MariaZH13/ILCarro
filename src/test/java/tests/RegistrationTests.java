package tests;

import manager.ProviderData;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void precondition() {

        if (app.getUser().isLogged()) {
            app.getUser().logOut();
        }
    }

    @Test
    public void registrationPositive() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User()
                .withName("Bobbi")
                .withLastName("Brown")
                .withEmail("bobb" + i + "@com.com")
                .withPassword("Qwert123$");


        app.getUser().openRegistrationForm();
        logger.info("openRmegistrationForm invoked");
        app.getUser().fillRegistrationForm(user);
        logger.info("fillRegistrationForm invoked");
        app.getUser().submitLoginYalla();
        logger.info("submitLoginYalla invoked");
        logger.info("registrationPositive starts with credentials: login "
                + user.getEmail() + " & password " + user.getPassword());
 //       app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isLoggedSuccessful());
    }

    @Test
    public void registrationPositiveDTO() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User()
                .withName("Bobbi")
                .withLastName("Brown")
                .withEmail("bobb" + i + "@com.com")
                .withPassword("Qwert123$");


        app.getUser().openRegistrationForm();
        logger.info("openRegistrationForm invoked");
        app.getUser().fillRegistrationForm(user);
        logger.info("fillRegistrationForm invoked");
        app.getUser().submitLoginYalla();
        logger.info("submitLoginYalla invoked");
        logger.info("registrationPositive starts with credentials: login "
                + user.getEmail() + " & password " + user.getPassword());
 //       app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isLoggedSuccessful());
    }

    @Test
    public void registrationNegativeWrongPassWord() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        User user = new User()
                .withName("Bobbi")
                .withLastName("Brown")
                .withEmail("bobb" + i + "@com.com")
                .withPassword("Qwert123");

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitLoginYalla();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isPasswordWrong());

    }
        @Test
        public void registrationNegativePassword () {
            int i = (int) (System.currentTimeMillis() / 1000) % 3600;
            User user = new User()
                    .withName("Dana")
                    .withLastName("Banana")
                    .withEmail("fruit" + i + "@gmail.com")
                    .withPassword("Qwerty123");

            app.getUser().openRegistrationForm();
            app.getUser().fillRegistrationForm(user);
            app.getUser().submitLoginYalla();
            app.getUser().pause(3000);
            Assert.assertTrue(app.getUser().isPasswordWrong());
        }

        @Test
        public void registrationNegativeEmail () {
            int i = (int) (System.currentTimeMillis() / 1000) % 3600;
            User user = new User()
                    .withName("Pit")
                    .withLastName("Potter")
                    .withEmail("potter" + i + ".com")
                    .withPassword("Qwerty1234$");

            app.getUser().openRegistrationForm();
            app.getUser().fillRegistrationForm(user);
            app.getUser().submitLoginYalla();
            app.getUser().pause(3000);
            Assert.assertTrue(app.getUser().isPasswordWrong());
        }

        @AfterMethod
        public void postcondition () {
               app.getUser().closePopUpWindow();

               if(app.getUser().isLogged()){
                   app.getUser().logOut();
               }

        }


    }

