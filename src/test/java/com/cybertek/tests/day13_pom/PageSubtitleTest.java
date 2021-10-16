package com.cybertek.tests.day13_pom;

import com.cybertek.pages.BasePage;
import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.oracle.webservices.internal.api.message.BaseDistributedPropertySet;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    @Test
    public void test1(){

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();

        DashboardPage dashboardPage = new DashboardPage();

        String expectedSubTitle =  "Quick Launchpad";

        String actualSubTitle = dashboardPage.getPageSubTitle();

        Assert.assertEquals(actualSubTitle, expectedSubTitle);

        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendar = new CalendarEventsPage();

        String expectedSubTitle2 = "Calendar Events";

        String actualSubTitle2 = calendar.getPageSubTitle();

        Assert.assertEquals(actualSubTitle2, expectedSubTitle2);





    }

}
