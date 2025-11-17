package cz.czechitas.automation;

import org.junit.jupiter.api.Test;

import java.util.Map;

final class olgaCreateOrderAsTeacher extends TestRunner {

    Map<String, String> credentials = Map.of(
            "masterEmail", "ladymaster@gmail.com",
            "masterPassword","Lady123",
            "masterName", "Lady Galadriel"
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
        browser.headerMenu.goToKindergartenAndSchoolSection();
        fillOutClientFields(orderClientDetails);
        fillOutDatesFields(orderDatesDetails);
        fillOutCampFields(orderCampDetails);
        browser.orderDetailSection.saveSuburbanCampOrder();

        asserter.orderSection.checkOrderIsCreated();
    }

    @Test
    void createOrderAsTeacherNatureRequired() {
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
              //  "startDate2", "date",
              //  "startDate3", "date",
                    "endDate1", "05.12.2025"
              //  "endDate2", "date",
              //  "endDate3", "date"
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

        browser.headerMenu.goToKindergartenAndSchoolSection();
        fillOutClientFields(orderClientDetails);
        fillOutDatesFields(orderDatesDetails);
        fillOutNatureSchoolFields(ordersNatureDetails);
        browser.orderDetailSection.saveSchoolInNatureOrder();
        asserter.orderSection.checkOrderIsCreated();
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
    }
    void fillOutCampFields(Map<String, String> campFields) {
    browser.orderSection.selectSuburbanCampOption();
    browser.orderDetailSection.insertChildrenCountToSuburbanCamp(Integer.parseInt(campFields.get("students")));
    browser.orderDetailSection.insertInAgeToSuburbanCamp(Integer.parseInt(campFields.get("age")));
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
