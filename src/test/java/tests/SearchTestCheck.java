package tests;

import org.testng.annotations.Test;

public class SearchTestCheck extends TestBase{

    @Test
    public void searchPositiveTest(){
        app.getSearch().fillForm("Haifa", "07/14/2023", "05/18/2024");
    }


}
