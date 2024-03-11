package com.phonebook.tests.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void loginPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("maev1978@gl.com")
                .setPassword("dum1234$"));
        app.getUser().clickOnLoginButton();
        //assert Sign Out is present
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeTestWithoutEmail() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setPassword("dum1234$"));
        app.getUser().clickOnLoginButton();
        //assert Sign Out is present
        Assert.assertTrue(app.getUser().isAlertAppears());
    }
}