# 🤖 Low-code Test Automation Framework

A framework for teaching the basics of low-code automation as part of the **Czechitas Digital Testing Academy**.

After launching, the framework automatically starts a web browser you already have installed — no additional driver downloads needed. Supported browsers: **Firefox**, **Chrome**, or **Edge**.

> 💡 **Quick check:** The `ExampleTest` class contains a sample test that opens a browser and verifies that *www.czechitas.cz* is present in the contacts section of the testing application.

---

# ✍️ How to Write Tests

Write your tests inside `LowCodeAutomationTest.java`, or create a similar file for each solution. Each test method must be annotated with `@Test`.

```java
final class LowCodeAutomationTest extends TestRunner {

    @Test
    void myFirstTest() {
        // navigate using browser.*
        browser.headerMenu.goToContactsSection();

        // verify using asserter.*
        asserter.checkPageUrl("www.czechitas.cz");
    }
}
```

Two objects are available in every test:

| Object | Purpose |
|---|---|
| `browser` | 🖱️ Perform actions in the browser (navigation, filling forms, clicking buttons) |
| `asserter` | ✅ Verify the state of the page |

The table below shows which sub-object to use for each area of the application:

| Area | `browser.*` | `asserter.*` |
|---|---|---|
| 🔝 Top menu (public) | `browser.headerMenu` | — |
| 🔐 Login / logout | `browser.loginSection` | — |
| 🗂️ Internal admin menu | `browser.internalMenu` | — |
| 📋 Public order form (MŠ/ZŠ) | `browser.orderSection` | — |
| 📑 Application list | `browser.applicationSection` | `asserter.applicationSection` |
| 🔍 Application detail | `browser.applicationDetailsSection` | `asserter.applicationDetailAction` |
| 👤 Profile | `browser.profileSection` | — |
| 🌐 General page checks | — | `asserter` (directly) |

## 🌐 Application URL

The tests run against: `https://team8-2022brno.herokuapp.com/`

To override the URL, edit `src/test/resources/test.properties` or pass `-Dapp.url=<url>` to Maven.

---

# 🗂️ Browser Actions

## 📑 ApplicationAction
Access via `browser.applicationSection` — work with the application list.

| Method | Description |
|---|---|
| `clickCreateNewApplicationButton()` | Click the _Create new application_ button |
| `selectProgrammingSection()` | Select the _Programming_ course category |
| `clickCreatePythonApplicationButton()` | Create a new application once programming category is selected |
| `openFirstApplicationDetailsPage()` | Open an existing application to see its details |
| `search("Jan")` | Search for an application from Jan |
| `clickEditFirstApplicationButton()` | Open the first application to edit its details |

## 🔍 ApplicationDetail
Access via `browser.applicationDetailsSection` — work with the application details page.

| Method | Description |
|---|---|
| `selectTerm(String term)` | Select a term |
| `insertStudentFirstName("Jan")` | Insert student first name |
| `insertStudentLastName("Novak")` | Insert student last name |
| `insertBirthdate("01.01.2000")` | Insert student date of birth |
| `insertNote("my personal note")` | Insert a note |
| `selectCashPaymentMethod()` | Choose cash payment method |
| `selectBankTransferPaymentMethod()` | Choose bank transfer payment method |
| `clickAcceptTermsCheckbox()` | Accept Terms and Conditions |
| `clickEditApplicationButton()` | Save changes when editing an application |
| `clickCreateApplicationButton()` | Submit the form to create a new application |

## 🗂️ InternalMenuAction
Access via `browser.internalMenu` — work with the internal admin menu after login.

| Method | Description |
|---|---|
| `goToOrdersSection()` | Go to _Objednávky_ section |
| `goToTermsSection()` | Go to _Termíny_ section |
| `goToApplicationsSection()` | Go to _Přihlášky_ section |
| `goToCategoriesSection()` | Go to _Kategorie_ section |
| `goToNewsSection()` | Go to _Aktuality_ section |
| `goToExportsSection()` | Go to _Exporty_ section |

## 🔐 LoginAction
Access via `browser.loginSection` — log in and out of the application.

| Method | Description |
|---|---|
| `clickLoginMenuLink()` | Click the login link in the top-right corner |
| `insertEmail("test@czechitas.cz")` | Insert email |
| `insertPassword("mySecurePass123")` | Insert password |
| `clickLoginButton()` | Click the login button once credentials are provided |
| `logout()` | Log out |

## 👤 ProfileAction
Access via `browser.profileSection` — work with the customer profile.

| Method | Description |
|---|---|
| `goToProfilePage()` | Open profile page from the top menu |
| `insertPassword("new password")` | Enter a new password (must meet security requirements: lower/uppercase letters, numbers, etc.) |
| `insertPasswordVerification("new password")` | Enter the password again to confirm |
| `clickChangeButton()` | Save changes |

## 📋 OrderAction
Access via `browser.orderSection` — work with the public order form (_Objednávka pro MŠ/ZŠ_).

| Method | Description |
|---|---|
| `selectSuburbanCampOption()` | Select the _Příměstský tábor_ tab |
| `selectSchoolInNatureOption()` | Select the _Škola v přírodě_ tab |
| `insertICO("12345678")` | Insert company ICO and wait for address lookup |
| `insertChildrenCount(30)` | Insert the number of children |

## 🔝 PublicMenuAction
Access via `browser.headerMenu` — navigate the top-level page header menu.

| Method | Description |
|---|---|
| `goToContactsSection()` | Go to _Kontakt_ section |
| `goToHomePage()` | Go to _Domů_ page |
| `goToInstructionsAndFormsForTeacherSection()` | Go to _Návody a formuláře_ (under _Pro učitelé_) |
| `goToKindergartenAndSchoolSection()` | Go to _Objednávka pro MŠ/ZŠ_ |
| `goToInstructionsAndFormsForParentSection()` | Go to _Návody a formuláře_ (under _Pro rodiče_) |
| `goToCreateApplicationSection()` | Go to _Vytvořit přihlášku_ (under _Pro rodiče_) |
| `goToApplicationsSection()` | Go to _Přihlášky_ section |

---

# ✅ Assertions

## 🌐 General
Called directly on `asserter`:

| Method | Description |
|---|---|
| `asserter.checkPageUrl("www.czechitas.cz")` | Check that the page contains a link with the given URL text |
| `asserter.checkIsLoggedIn()` | Verify the user is logged in (_Přihlášen_ label is visible) |
| `asserter.checkProgrammingSectionPresence()` | Verify that the _Programování_ section card is visible |
| `asserter.checkRegistrationButtonPresence()` | Verify that the _Zaregistrujte se_ button is visible |

## 📑 Application list
Called on `asserter.applicationSection`:

| Method | Description |
|---|---|
| `asserter.applicationSection.checkColumnExists("Akce")` | Check if the _Akce_ column is visible |
| `asserter.applicationSection.checkApplicationsTableIsEmpty()` | Ensure the application list is empty (_Žádné záznamy nenalezeny_) |
| `asserter.applicationSection.checkNumberOfApplications(5)` | Ensure the application list has exactly 5 applications |

## 🔍 Application detail view
Called on `asserter.applicationDetailSection`:

| Method | Description |
|---|---|
| `asserter.applicationDetailSection.checkPaymentMethod("Bankovní převod")` | Ensure the application is paid via bank transfer |
| `asserter.applicationDetailSection.checkFirstName("Jan")` | Check that the student first name is _Jan_ |
| `asserter.applicationDetailSection.checkLastName("Novak")` | Check that the student last name is _Novak_ |
| `asserter.applicationDetailSection.checkDateOfBirth("01.01.2010")` | Check that the student date of birth is _01.01.2010_ |
| `asserter.applicationDetailSection.checkNote("myPrivateNote")` | Check that the note is _myPrivateNote_ |
- `asserter.applicationDetailSection.checkRemainingAmountToPay("100.00")` - check that remaining amount to pay is _100.00_ Kč
- `asserter.applicationDetailSection.checkTerm("05.02. - 09.02.2024")` - check that the term is _05.02. - 09.02.2024_
- `asserter.applicationDetailSection.checkMessageContainsStudentLastName("Novak")` - ensure that _Zpráva pro příjemce_ contains student last name _Novak_

# 🔧 Utilities

The following utility methods are available directly on `browser`:

- `browser.waitFor(3)` - pause test execution for the given number of seconds
- `browser.generateRandomName(10)` - generate a random lowercase string of the given length (useful for creating unique test data, e.g. a unique student last name)

