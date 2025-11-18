package cz.czechitas.automation;

import org.junit.jupiter.api.Test;

import java.util.Map;


final class UserRegistrationAndLogin extends TestRunner {

    Map<String, String> credentials = Map.of(
            "masterEmail", "ladymaster@gmail.com",
            "masterPassword","Lady123",
            "masterName", "Lady Galadriel",
            "adminEmail", "aragorn@email.com",
            "adminPassword", "Aragorn1",
            "adminName", "Aragorn Dunedain",
            "parentEmail", "john123@email.com",
            "parentPassword", "A1sdfg",
            "parentName", "John Baggins"
    );


    @Test
    void smokePageUrlTest() {
        browser.headerMenu.goToHomePage();
        asserter.generalSection.checkCurrentUrl("https://team8-2022brno.herokuapp.com/");
    }

    //Registration tests
    @Test
    void newUserRegistrationHappyTest() {
        var firstName = browser.generateRandomName(5);
        var lastName = browser.generateRandomName(8);
        var email = lastName + "@hotmail.com";
        var password = "A" + firstName + "123";

        //Each new user is automatically signed in
        fillOutRegistrationForm(firstName, lastName,email, password, password);
        asserter.loginSection.checkUserIsLoggedIn(firstName+" "+lastName);
        browser.loginSection.logout();

        // Each new user is by default in the role parent
        logIn(credentials.get("masterEmail"), credentials.get("masterPassword"));
        browser.internalMenu.goToUsersSection();
        browser.usersSection.search(firstName+" "+lastName);
        browser.waitFor(1);
        asserter.usersSection.checkParentRole();
        browser.loginSection.logout();

        // Each user is available to sign in
        logIn(email, password);
        asserter.loginSection.checkUserIsLoggedIn(firstName+" "+lastName);
        // Each user is allowed to log out
        browser.loginSection.logout();
    }

    @Test
    void newUserRegistrationTest_empty() {
        fillOutRegistrationForm("", "", "", "", "");
        asserter.loginSection.checkUserIsNotLoggedIn();
    }
    @Test
    void newUserRegistrationTest_256() {
        var firstName = browser.generateRandomName(127);
        var lastName = browser.generateRandomName(128);
        var email = lastName + "@hotmail.com";
        var password = "A" + firstName + "123";
        fillOutRegistrationForm(firstName, lastName, email, password, password);
        asserter.loginSection.checkUserIsNotLoggedIn();
    }

    // Logging in tests
    @Test
    void loginAsParentHappy () {
        logIn(credentials.get("parentEmail"), credentials.get("parentPassword"));
        browser.waitFor(1);
        asserter.loginSection.checkUserIsLoggedIn(credentials.get("parentName"));
        asserter.generalSection.checkCurrentUrl("https://team8-2022brno.herokuapp.com/zaci");
        browser.loginSection.logout();
    }
    @Test
    void loginAsAdminHappy () {
        logIn(credentials.get("adminEmail"), credentials.get("adminPassword"));
        browser.waitFor(1);
        asserter.loginSection.checkUserIsLoggedIn(credentials.get("adminName"));
        asserter.generalSection.checkCurrentUrl("https://team8-2022brno.herokuapp.com/");
        browser.loginSection.logout();
    }
    @Test
    void loginAsMasterHappy() {
        logIn(credentials.get("masterEmail"), credentials.get("masterPassword"));
        browser.waitFor(1);
        asserter.loginSection.checkUserIsLoggedIn(credentials.get("masterName"));
        asserter.generalSection.checkCurrentUrl("https://team8-2022brno.herokuapp.com/");
        browser.loginSection.logout();
    }
    @Test
    void loginAsParentWrongPassword () {
        logIn(credentials.get("parentEmail"), credentials.get("parentPassword")+"1");
        browser.waitFor(1);
        asserter.loginSection.checkErrorMessage();
        asserter.loginSection.checkUserIsNotLoggedIn();
    }


// Functions
    void fillOutRegistrationForm(String firstName, String lastName, String email, String password, String confirmPassword) {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.clickRegisterButton();
        browser.registerSection.insertFirstAndLastName(firstName, lastName);
        browser.registerSection.insertEmail(email);
        browser.registerSection.insertPassword(password);
        browser.registerSection.insertPasswordConfirmation(confirmPassword);
        browser.registerSection.clickRegisterButton();
    }
    void logIn(String email, String password) {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail(email);
        browser.loginSection.insertPassword(password);
        browser.loginSection.clickLoginButton();
    }
}
