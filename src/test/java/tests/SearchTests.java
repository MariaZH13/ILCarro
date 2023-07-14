package tests;

import models.Search;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchTests extends TestBase{

    @Test
    public void searchCarTestPositive(){
        Search search = new Search()
                .withCity("Tel Aviv")
                .withDates("7/17/2023 - 7/20/2023");

        app.getSearch().fillSearchForm(search);
        logger.info("The city is "+ search.getCity());
        logger.info("The dates are "+ search.getDates());

        app.getUser().submitLoginYalla();
        Assert.assertTrue(app.getSearch().isCarFound());
    }
    @Test
    public void searchCarTest2Positive(){
        Search search = new Search()
                .withCity("Holon");

        app.getSearch().fillSearchFormWithDatePickerThisMonth(search);
        logger.info("The city is "+ search.getCity());
        logger.info("The dates are "+ search.getDates());

        app.getUser().submitLoginYalla();
        Assert.assertTrue(app.getSearch().isCarFound());
    }
    @Test
    public void searchCarTest3Positive() {
        Search search = new Search()
                .withCity("Ashdod");

        app.getSearch().fillSearchFormWithDatePickerThisYear(search);
        logger.info("The city is "+ search.getCity());
        logger.info("The dates are "+ search.getDates());

        app.getUser().submitLoginYalla();
        Assert.assertTrue(app.getSearch().isCarFound());
    }

    @AfterMethod
    public void postcondition(){
        app.getSearch().returnToMainPage();
    }

}
