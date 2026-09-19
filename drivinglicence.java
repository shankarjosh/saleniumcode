package ccst;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class drivinglicence {

    public static void main(String[] args) {
        // Initialize Playwright and Launch Browser
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500)
            );

            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            // 1. Navigate to the Driving Licence Assignment Page
            page.navigate("https://example.com/testcasesclassAssignment-drivingLicenceUI.html");

            System.out.println("Page Title: " + page.title());

            // ========================================================
            // 2. INTERACTING WITH TEXT FIELDS USING LOCATORS
            // ========================================================

            // Option A: Locate by ID or Name attribute
            Locator firstNameInput = page.locator("#firstName"); // using CSS ID selector
            firstNameInput.fill("John");

            Locator lastNameInput = page.locator("input[name='lastName']"); // using attribute selector
            lastNameInput.fill("Doe");

            // Option B: Locate by Placeholder
            Locator ageInput = page.getByPlaceholder("Enter your age");
            ageInput.fill("25");

            // Option C: Locate by Label
            Locator licenceNumberInput = page.getByLabel("Driving Licence Number");
            licenceNumberInput.fill("DL-9876543210");

            // Verify Text Field Inputs
            System.out.println("First Name entered: " + firstNameInput.inputValue());
            System.out.println("Age entered: " + ageInput.inputValue());


            // ========================================================
            // 3. INTERACTING WITH CHECKBOXES USING LOCATORS
            // ========================================================

            // Locate Checkbox by ID / CSS selector
            Locator termsCheckbox = page.locator("#chkTerms");

            // Check if not already checked
            if (!termsCheckbox.isChecked()) {
                termsCheckbox.check(); // Standard method for checkboxes
            }

            // Locate Checkbox by Label
            Locator eyeTestCheckbox = page.getByLabel("Passed Eye Test");
            eyeTestCheckbox.check();

            // Locate Checkbox using Role locator
            Locator medicalFitnessCheckbox = page.getByRole(AriaRole.CHECKBOX,
                    new Page.GetByRoleOptions().setName("Medically Fit"));
            medicalFitnessCheckbox.check();

            // Uncheck demonstration
            Locator newsletterCheckbox = page.locator("#chkNewsletter");
            newsletterCheckbox.check();   // Checked
            newsletterCheckbox.uncheck(); // Unchecked

            // Validations
            System.out.println("Terms Accepted: " + termsCheckbox.isChecked());
            System.out.println("Eye Test Passed: " + eyeTestCheckbox.isChecked());


            // ========================================================
            // 4. SUBMIT FORM
            // ========================================================
            Locator submitButton = page.getByRole(AriaRole.BUTTON,
                    new Page.GetByRoleOptions().setName("Submit Application"));

            if (submitButton.isVisible()) {
                submitButton.click();
            }

            // Clean up resources
            page.close();
            context.close();
            browser.close();

            System.out.println("Automation successfully completed!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}