package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTest extends TestBase {

    @Test
    public void test1(){

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();

        DashboardPage dash = new DashboardPage();

        dash.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendar = new CalendarEventsPage();

        calendar.waitUntilLoaderScreenDisappear();

        BrowserUtils.waitForClickablility(calendar.createCalendarEvent, 10);

        calendar.createCalendarEvent.click();

        //wait.until(ExpectedConditions(c))

        CreateCalendarEventsPage create = new CreateCalendarEventsPage();

        create.repeat.click();

        Assert.assertTrue(create.days.isSelected());

        Assert.assertFalse(create.weekday.isSelected());
    }

    @Test
    public void test2(){

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();

        DashboardPage dash = new DashboardPage();

        dash.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendar = new CalendarEventsPage();

        calendar.waitUntilLoaderScreenDisappear();

        BrowserUtils.waitForClickablility(calendar.createCalendarEvent, 20);

        calendar.createCalendarEvent.click();

        CreateCalendarEventsPage create = new CreateCalendarEventsPage();

        create.repeat.click();

        Select selection = create.repeatOptionsList();

        List<String> expectedList = Arrays.asList("Daily", "Weekly", "Monthly", "Yearly");

        List<String> actualList = new ArrayList<>();

        List<WebElement> options = selection.getOptions();

        for (WebElement option : options) {
            actualList.add(option.getText());
        }

        //BrowserUtils.getElementsText(options);

        Assert.assertEquals(actualList, expectedList);


    }

}
