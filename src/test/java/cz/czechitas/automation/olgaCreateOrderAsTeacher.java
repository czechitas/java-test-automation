package cz.czechitas.automation;

import org.junit.jupiter.api.Test;

import java.util.Map;

final class olgaCreateOrderAsTeacher extends TestRunner {

    Map<String, String> credentials = Map.of(
            "masterEmail", "ladymaster@gmail.com",
            "masterPassword","Lady123",
            "masterName", "Lady Galadriel",
            "adminEmail", "aragorn@email.com",
            "adminPassword", "Aragorn1"
    );

    @Test
    void smokePageUrlTest() {
        browser.headerMenu.goToKindergartenAndSchoolSection();
        asserter.generalSection.checkCurrentUrl("https://team8-2022brno.herokuapp.com/objednavka/pridat");
    }

    @Test
    void createOrderAsTeacherCampRequired() {
        Map<String, String> orderClientDetails = Map.of(
                "client", "3v1",
                "ICO", "12345678",//string <=15//
                    "address", "60200 Bratislavska 12, Brno",
                "substitute", "Bilbo Baggins",
                "contact_name", "Frodo",
                "contact_surname", "Baggins",
                "contact_phone", "123456789", //phone number
                    "contact_mail", "email@email.com" //email
        );
        Map<String, String> orderDatesDetails = Map.of(
                "startDate1", "01.12.2025",
                //"startDate2", "date",
                //"startDate3", "date",
                "endDate1", "05.12.2025"
                //"endDate2", "date",
                //"endDate3", "date"
        );
        Map<String, String> orderCampDetails = Map.of(
                "students", "11", //number
                "age", "10", //number
                "adults", "1", //number
                "datePart", "forenoon" //forenoon, afternoon
        );
        //Should create order and check that user is notified
        browser.headerMenu.goToKindergartenAndSchoolSection();
        fillOutClientFields(orderClientDetails);
        fillOutDatesFields(orderDatesDetails);
        fillOutCampFields(orderCampDetails);
        browser.orderDetailSection.saveSuburbanCampOrder();
        asserter.orderSection.checkOrderIsCreated();

        // Should check that Admin can see new created order
        browser.headerMenu.goToHomePage();
        logIn(credentials.get("adminEmail"), credentials.get("adminPassword"));
        browser.internalMenu.goToOrdersSection();
        browser.orderSection.search(orderClientDetails.get("client"));
        asserter.orderSection.checkNumberOfOrders(1);
        browser.loginSection.logout();

        // Should check that Master Admin can see new created order and delete it
        browser.headerMenu.goToHomePage();
        logIn(credentials.get("masterEmail"), credentials.get("masterPassword"));
        browser.internalMenu.goToOrdersSection();
        browser.orderSection.search(orderClientDetails.get("client"));
        asserter.orderSection.checkNumberOfOrders(1);
        browser.orderSection.deleteOrder();
        asserter.orderSection.checkOrdersTableIsEmpty();
        browser.headerMenu.goToHomePage();
        browser.loginSection.logout();
    }

    @Test
    void createOrderAsTeacherNature() {
        Map<String, String> orderClientDetails = Map.of(
                "client", "3v1",
                "ICO", "12345678",//string <=15//
                    "address", "60200 Bratislavska 12, Brno",
                "substitute", "Bilbo Baggins",
                "contact_name", "Frodo",
                "contact_surname", "Baggins",
                "contact_phone", "123456789", //phone number
                    "contact_mail", "email@email.com"
        );
        Map<String, String> orderDatesDetails = Map.of(
                "startDate1", "01.12.2025",
                "endDate1", "02.12.2025",
                "startDate2", "12.12.2025",
                "endDate2", "14.12.2025",
                "startDate3", "01.01.2026",
                "endDate3", "03.01.2026"
        );
        Map<String, String> ordersNatureDetails = Map.of(
                "students", "14",
                "age", "6",
                "adults", "2",
                "startTime", "9",
                "startFood", "breakfast",
                "endTime", "19",
                "endFood", "dinner"
        );
        //Should create order and check that user is notified
        browser.headerMenu.goToKindergartenAndSchoolSection();
        fillOutClientFields(orderClientDetails);
        fillOutDatesFields(orderDatesDetails);
        fillOutNatureSchoolFields(ordersNatureDetails);
        browser.orderDetailSection.saveSchoolInNatureOrder();
        asserter.orderSection.checkOrderIsCreated();

        // Should check that Admin can see new created order
        browser.headerMenu.goToHomePage();
        logIn(credentials.get("adminEmail"), credentials.get("adminPassword"));
        browser.internalMenu.goToOrdersSection();
        browser.orderSection.search(orderClientDetails.get("client"));
        asserter.orderSection.checkNumberOfOrders(1);
        browser.loginSection.logout();

        // Should check that Master Admin can see new created order and delete it
        browser.headerMenu.goToHomePage();
        logIn(credentials.get("masterEmail"), credentials.get("masterPassword"));
        browser.internalMenu.goToOrdersSection();
        browser.orderSection.search(orderClientDetails.get("client"));
        asserter.orderSection.checkNumberOfOrders(1);
        browser.orderSection.deleteOrder();
        asserter.orderSection.checkOrdersTableIsEmpty();
        browser.headerMenu.goToHomePage();
        browser.loginSection.logout();
    }

    @Test
    void natureFieldsTesting() {
        Map<String, String> ordersNatureDetails = Map.of(
                "students", "14",
                "age", "6",
                "adults", "2",
                "startTime", "25",
                "startFood", "breakfast",
                "endTime", "-1",
                "endFood", "dinner"
        );
        browser.headerMenu.goToKindergartenAndSchoolSection();
        fillOutNatureSchoolFields(ordersNatureDetails);
    }

    void fillOutClientFields(Map<String, String> clientDetails) {
        browser.orderDetailSection.insertICO(clientDetails.get("ICO"));
        browser.waitFor(3);
        browser.orderDetailSection.insertClient(clientDetails.get("client"));
        browser.orderDetailSection.insertFullAddress(clientDetails.get("address"));
        browser.orderDetailSection.insertSubstitute(clientDetails.get("substitute"));
        browser.orderDetailSection.insertContactPersonNameAndSurname(clientDetails.get("contact_name"), clientDetails.get("contact_surname"));
        browser.orderDetailSection.insertContactPersonTelephone(clientDetails.get("contact_phone"));
        browser.orderDetailSection.insertContactPersonEmail(clientDetails.get("contact_mail"));
    }
    void fillOutDatesFields(Map<String, String> datesDetails) {
        browser.orderDetailSection.insertStartDate(datesDetails.get("startDate1"));
        browser.orderDetailSection.insertEndDate(datesDetails.get("endDate1"));
        if (datesDetails.containsKey("startDate2")){
            browser.orderDetailSection.insertStartDate2(datesDetails.get("startDate2"));
            browser.orderDetailSection.insertEndDate2(datesDetails.get("endDate2"));
        }
        if (datesDetails.containsKey("startDate3")){
            browser.orderDetailSection.insertStartDate3(datesDetails.get("startDate3"));
            browser.orderDetailSection.insertEndDate3(datesDetails.get("endDate3"));
        }
    }
    void fillOutCampFields(Map<String, String> campFields) {
        browser.orderSection.selectSuburbanCampOption();
        browser.orderDetailSection.insertChildrenCountToSuburbanCamp(Integer.parseInt(campFields.get("students")));browser.orderDetailSection.insertInAgeToSuburbanCamp(Integer.parseInt(campFields.get("age")));
        browser.orderDetailSection.insertAdultsCountToSuburbanCamp(Integer.parseInt(campFields.get("adults")));
        switch (campFields.get("datePart")) {
            case "afternoon":
                browser.orderDetailSection.selectAfternoonSuburbanCampVariant();
                break;
            case "forenoon":
                browser.orderDetailSection.selectForenoonSuburbanCampVariant();
        }
    }
    void fillOutNatureSchoolFields (Map<String, String> natureFields) {
        browser.orderSection.selectSchoolInNatureOption();
        browser.waitFor(2);
        browser.orderDetailSection.insertChildrenCountToSchoolInNature(Integer.parseInt(natureFields.get("students")));
        browser.orderDetailSection.insertInAgeToSchoolInNature(Integer.parseInt(natureFields.get("age")));
        browser.orderDetailSection.insertAdultsCountToSchoolInNature(Integer.parseInt(natureFields.get("adults")));
        browser.orderDetailSection.insertStartTime(natureFields.get("startTime"));
        browser.waitFor(1);
        browser.orderDetailSection.insertEndTime(natureFields.get("endTime"));

        switch (natureFields.get("startFood")) {
            case "breakfast":
                browser.orderDetailSection.selectBreakfastStartToSchoolInNature();
                break;
            case "lunch":
                browser.orderDetailSection.selectLunchStartToSchoolInNature();
                break;
            case "dinner":
                browser.orderDetailSection.selectDinnerStartToSchoolInNature();
        }
        switch (natureFields.get("endFood")) {
            case "breakfast":
                browser.orderDetailSection.selectBreakfastEndToSchoolInNature();
                break;
            case "lunch":
                browser.orderDetailSection.selectLunchEndToSchoolInNature();
                break;
            case "dinner":
                browser.orderDetailSection.selectDinnerEndToSchoolInNature();
        }
    }
    void logIn(String email, String password) {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail(email);
        browser.loginSection.insertPassword(password);
        browser.loginSection.clickLoginButton();
    }
}
