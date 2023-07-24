package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class SearchTestCheck extends TestBase{

    @Test
    public void searchPositiveTest(){
        app.getSearch().fillForm("Haifa", "07/28/2023", "03/18/2024");
    }

    @AfterClass
    public void postcondition(){
        app.getSearch().returnToMainPage();
    }


}
