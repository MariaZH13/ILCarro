import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{




    @BeforeMethod
    public void precondition(){
        if(app.getUser().isLogged()){
            app.getUser().logOut();
        }
    }

    @Test
    public void loginPositive(){
        String email = "marzh@gmail.com", password = "Qwert123$";
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm(email,password);
        app.getUser().submitLoginYalla();
        app.getUser().pause(3000);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//h1[.='Logged in']")));

    }


}
