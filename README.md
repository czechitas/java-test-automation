# Low-code Test Automation Framework

Framework for teaching the basics of low-code automation on projects of the Czechitas Digital Testing Academy.

In its default state, after launching, the framework should start a web browser (that you have already installed), without the need to download additional drivers. The assumption is that the user has one of the following web browsers installed: Firefox, Chrome, or Edge.

A sample test in the `ExampleTest` class will open a web browser and verify that the address *www.czechitas.cz* is present in the contacts section of the testing application.

# How to Write Tests

Write your tests inside `LowCodeAutomationTest.java`, or create similar file for each solution. Each test method must be annotated with `@Test`.

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
| `browser` | Perform actions in the browser (navigation, filling forms, clicking buttons) |
| `asserter` | Verify the state of the page |

The table below shows which sub-object to use for each area of the application:

| Area | `browser.*` | `asserter.*` |
|---|---|---|
| Top menu (public) | `browser.headerMenu` | — |
| Login / logout | `browser.loginSection` | — |
| Internal admin menu | `browser.internalMenu` | — |
| Public order form (MŠ/ZŠ) | `browser.orderSection` | — |
| Application list | `browser.applicationSection` | `asserter.applicationSection` |
| Application detail | `browser.applicationDetailsSection` | `asserter.applicationDetailAction` |
| Profile | `browser.profileSection` | — |
| General page checks | — | `asserter` (directly) |

## Application URL

The tests run against: `https://team8-2022brno.herokuapp.com/`

To override the URL, edit `src/test/resources/test.properties` or pass `-Dapp.url=<url>` to Maven.

# Hierarchy of Elements

Working with the framework is divided according to elements of the testing application as follows:

**ApplicationAction** - Allows you to work with application list (access via `browser.applicationSection`):
- `clickCreateNewApplicationButton()` - click on create new application button
- `selectProgrammingSection()` - select _Programming_ course category
- `clickCreatePythonApplicationButton()` - create a new application once programming category is selected
- `openFirstApplicationDetailsPage()` - open an existing application to see details
- `search("Jan")` - search for an application from Jan
- `clickEditFirstApplicationButton()` - open the first application to edit details

**ApplicationDetail** - Allows you to work with application details page (access via `browser.applicationDetailsSection`):
- `selectTerm(String term)` - select a term
- `insertStudentFirstName("Jan")` - insert student first name
- `insertStudentLastName("Novak")` - insert student last name
- `insertBirthdate("01.01.2000")` - insert student day of birth
- `insertNote("my personal note")` - insert a note
- `selectCashPaymentMethod()` - choose cash payment method
- `selectBankTransferPaymentMethod()` - choose bank transfer payment method
- `clickAcceptTermsCheckbox()` - accept Terms and Conditions
- `clickEditApplicationButton()` - save changes upon editing an application
- `clickCreateApplicationButton()` - click the button to create an application once all the details are provided

**InternalMenuAction** - Allows you to work with internal menu upon logging in (access via `browser.internalMenu`):
- `goToOrdersSection()` - go to Objednavky section
- `goToTermsSection()` - go to Terminy section
- `goToApplicationsSection()` - go to Prihlasky section
- `goToCategoriesSection()` - go to Kategorie section
- `goToNewsSection()` - go to Aktuality section
- `goToExportsSection()` - go to Exporty section

**LoginAction** - allows you to login and logout (access via `browser.loginSection`):
- `clickLoginMenuLink()` - click login link in top menu (top right corner)
- `insertEmail("test@czechitas.cz")` -  insert email
- `insertPassword("mySecurePass123")` - insert password
- `clickLoginButton()` - click login button once credentials are provided
- `logout()` - logout

**ProfileAction** - allows you to work with customer profile (access via `browser.profileSection`):
- `goToProfilePage()` - open profile page from top menu
- `insertPassword("new password")` - enter a new password. Change "new password" to the one you like based on security requirements (lowercase and uppercase letters, numbers, etc)
- `insertPasswordVerification("new password")` - enter a password to confirm
- `clickChangeButton()` - click the button to save changes

**OrderAction** - Allows you to work with the public order (Objednávka pro MŠ/ZŠ) form (access via `browser.orderSection`):
- `selectSuburbanCampOption()` - select Příměstský tábor tab
- `selectSchoolInNatureOption()` - select Škola v přírodě tab
- `insertICO("12345678")` - insert company ICO and wait for address lookup
- `insertChildrenCount(30)` - insert the number of children

**PublicMenuAction** - allows you to work with top level menu in page header (access via `browser.headerMenu`):
- `goToContactsSection()` - go to Kontakt section
- `goToHomePage()` - go to Domů page
- `goToInstructionsAndFormsForTeacherSection()` - go to Návody a formuláře (under Pro učitelé)
- `goToKindergartenAndSchoolSection()` - go to Objednávka pro MŠ/ZŠ
- `goToInstructionsAndFormsForParentSection()` - go to Návody a formuláře (under Pro rodiče)
- `goToCreateApplicationSection()` - go to Vytvořit přihlášku (under Pro rodiče)
- `goToApplicationsSection()` - go to Přihlášky section

# Assertions
**General** — called directly on `asserter`:
- `asserter.checkPageUrl("www.czechitas.cz")` - check that the page contains a link with the given URL text
- `asserter.checkIsLoggedIn()` - verify that the user is logged in (_Přihlášen_ label is visible)
- `asserter.checkProgrammingSectionPresence()` - verify that the _Programování_ section card is visible
- `asserter.checkRegistrationButtonPresence()` - verify that the _Zaregistrujte se_ button is visible

**Application list** — called on `asserter.applicationSection`:
- `asserter.applicationSection.checkColumnExists("Akce")` - check if _Akce_ column is visible on the page
- `asserter.applicationSection.checkApplicationsTableIsEmpty()` - ensure the application list is empty (_Žádné záznamy nenalezeny_ message is displayed)
- `asserter.applicationSection.checkNumberOfApplications(5)` - ensure the application list has exactly 5 applications

**Application detail view** — called on `asserter.applicationDetailAction`:
- `asserter.applicationDetailAction.checkPaymentMethod("Bankovní převod")` - ensure the application is paid through a bank transfer
- `asserter.applicationDetailAction.checkFirstName("Jan")` - check that the student first name is _Jan_
- `asserter.applicationDetailAction.checkLastName("Novak")` - check that the student last name is _Novak_
- `asserter.applicationDetailAction.checkDateOfBirth("01.01.2010")` - check that the student date of birth is _01.01.2010_
- `asserter.applicationDetailAction.checkNote("myPrivateNote")` - check that the note is _myPrivateNote_
- `asserter.applicationDetailAction.checkRemainingAmountToPay("100.00")` - check that remaining amount to pay is _100.00_ Kč
- `asserter.applicationDetailAction.checkTerm("05.02. - 09.02.2024")` - check that the term is _05.02. - 09.02.2024_
- `asserter.applicationDetailAction.checkMessageContainsStudentLastName("Novak")` - ensure that _Zpráva pro příjemce_ contains student last name _Novak_

# Utilities

The following utility methods are available directly on `browser`:

- `browser.waitFor(3)` - pause test execution for the given number of seconds
- `browser.generateRandomName(10)` - generate a random lowercase string of the given length (useful for creating unique test data, e.g. a unique student last name)

