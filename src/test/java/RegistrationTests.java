import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void precondition(){

        if(app.getUser().isLogged()){
            app.getUser().logOut();
        }
    }

    @Test
    public void registrationPositive(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User()
                .withName("Bobbi")
                .withLastName("Brown")
                .withEmail("bobb" + i +"@com.com")
                .withPassword("Qwert123$");

        app.getUser().openRegistrationForm();
        app.getUser().fillRegistrationForm(user);
        app.getUser().submitLoginYalla();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isLoggedSuccessful());
    }

    @AfterMethod
    public void postcondition(){
        app.getUser().closePopUpWindow();

    }


}
