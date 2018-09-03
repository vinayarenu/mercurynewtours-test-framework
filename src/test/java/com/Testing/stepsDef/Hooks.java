package com.Testing.stepsDef;

import com.Testing.helpers.BasePage;
import cucumber.api.java.Before;
import org.junit.AfterClass;
import org.junit.BeforeClass;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;

public class Hooks {
    static BasePage basePage = new BasePage();

    @BeforeClass
    public static void setUp() {
        basePage.openBrowser();
    }

    @AfterClass
    public static void tearDown()
    {
        basePage.closeBrowser();
    }
}
