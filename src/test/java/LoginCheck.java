import models.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginCheck extends TestBase{


    @BeforeMethod
    public void precondition(){

    }



    @Test
    public void loginPositive(){

       app.getUser().openLoginForm();
       app.getUser().fillLoginForm("marzh@gmail.com","Qwert123$");
       app.getUser().submitLoginYalla();

    }

    @Test
    public void loginPositiveUser() {
//        User user = new User("marzh@gmail.com","Qwert123$");
        User user = new User()
//        user.setEmail("marzh@gmail.com");
//        user.setPassword("Qwert123$");
                .withEmail("marzh@gmail.com").withPassword("Qwert123$");

        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(user.getEmail(), user.getPassword());
        app.getUser().submitLoginYalla();

    }

        @Test
        public void loginPositiveUserData(){
            User user = new User().withEmail("marzh@gmail.com").withPassword("Qwert123$");

            app.getUser().openLoginForm();
            app.getUser().fillLoginForm(user);
            app.getUser().submitLoginYalla();

        }

        @AfterMethod
    public void postcondition(){

        }
}
