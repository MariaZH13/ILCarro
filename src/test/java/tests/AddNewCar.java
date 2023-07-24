package tests;

import models.Car;
import models.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCar extends TestBase {
@BeforeMethod
    public void precondition(){

    if(TestBase.app.getUser().isLogged() == false)
        TestBase.app.getUser().login(
                new User()
                        .withEmail("marzh@gmail.com")
                        .withPassword("Qwert123$"));


}

@Test
    public void addNewCarPositive(){
    int i = (int)(System.currentTimeMillis()/1000)%3600;
    Car car = Car.builder()
            .location("Tel Aviv")
            .make("KIA" + i)
            .model("Sportage" + i)
            .year("2023")
            .fuel("Petrol")
            .seats("5" + i)
            .carClass("B")
            .carRegNumber("100-200-"+ i)
            .price("150" + i)
            .about("")
            .build();
    TestBase.app.getCar().openCarForm();
    TestBase.app.getCar().fillCarForm(car);
    TestBase.app.getUser().submitLoginYalla();
    TestBase.app.getCar().isCarAdd();


}

@AfterMethod
    public void postCondition(){
    TestBase.app.getCar().addOddCar();
    TestBase.app.getUser().logOut();
}
}
