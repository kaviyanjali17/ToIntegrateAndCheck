package com.ecom.Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Signup_Login_page {
    WebDriver driver;
    WebDriverWait wait;
    
    // 🔹 Constructor
    public Signup_Login_page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    // 🔹 Locators for Login
    private By loginEmailField = By.xpath("//input[@data-qa='login-email']");
    private By loginPasswordField = By.xpath("//input[@data-qa='login-password']");
    private By loginButton = By.xpath("//button[@data-qa='login-button']");
    private By loginErrorMsg = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");

    // 🔹 Locators for Signup
    private By signupNameField = By.name("name");
    private By signupEmailField = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");
    private By signupErrorMsg = By.xpath("//p[contains(text(),'Email Address already exist!')]");

    // 🔹 Common
    private By signupLoginLink = By.linkText("Signup / Login");
    private By loggedInAs = By.xpath("//a[contains(text(),'Logged in as')]");
    

    // 🔹 Subscription Section
    private By subscriptionEmailField = By.id("susbscribe_email");
    private By subscriptionButton = By.id("subscribe");
    private By subscriptionSuccessMsg = By.xpath("//div[contains(text(),'You have been successfully subscribed!')]");
    private By subscriptionErrorMsg = By.xpath("//div[contains(text(),'Email Address already exist!')]");

    // 🔹 Scroll Elements
    private By scrollToTopArrow = By.id("scrollUp");

    // 🔹 Static Texts
    private By newUserSignupText = By.xpath("//h2[text()='New User Signup!']");
    private By loginToAccountText = By.xpath("//h2[text()='Login to your account']");
    private By orText = By.xpath("//div[@class='signup-form']//form//p[text()='OR']");

    // 🔹 Navigation Buttons
    private By productsBtn = By.xpath("//a[text()=' Products']");
    private By cartBtn = By.xpath("//a[text()=' Cart']");
    private By videoTutorialsBtn = By.xpath("//a[text()=' Video Tutorials']");
    private By contactUsBtn = By.xpath("//a[text()=' Contact us']");
    private By testCasesBtn = By.xpath("//a[text()=' Test Cases']");
    private By apiTestingBtn = By.xpath("//a[text()=' API Testing']");
    


    // ================= LOGIN Methods =================
    public void clickSignupLoginLink() {
        wait.until(ExpectedConditions.elementToBeClickable(signupLoginLink)).click();
    }

    public void enterLoginEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmailField)).clear();
        driver.findElement(loginEmailField).sendKeys(email);
    }

    public void enterLoginPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPasswordField)).clear();
        driver.findElement(loginPasswordField).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean isLoginSuccessful() {
        return driver.findElements(loggedInAs).size() > 0;
    }

    public boolean isLoginErrorDisplayed() {
        return driver.findElements(loginErrorMsg).size() > 0;
    }

    public WebElement getSignupEmailField() {
        return driver.findElement(loginEmailField);
    }

    public WebElement getPasswordField() {
        return driver.findElement(loginPasswordField);
    }

    public boolean isLoginButtonVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // ================= SIGNUP Methods =================
    public void waitForSignupForm() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@action='/signup']")));
    }

    public void enterSignupName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupNameField)).clear();
        driver.findElement(signupNameField).sendKeys(name);
    }

    public void enterSignupEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupEmailField)).clear();
        driver.findElement(signupEmailField).sendKeys(email);
    }

    public void clickSignupButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signupButton)).click();
    }

    public boolean isSignupButtonVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(signupButton)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSignupErrorDisplayed() {
        return driver.findElements(signupErrorMsg).size() > 0;
    }

    // ================= SUBSCRIPTION Methods =================
    public void enterSubscriptionEmail(String email) {
        driver.findElement(subscriptionEmailField).clear();
        driver.findElement(subscriptionEmailField).sendKeys(email);
    }

    public void clickSubscriptionButton() {
        driver.findElement(subscriptionButton).click();
    }

    public boolean isSubscriptionSuccessDisplayed() {
        return driver.findElements(subscriptionSuccessMsg).size() > 0;
    }

    public boolean isSubscriptionErrorDisplayed() {
        return driver.findElements(subscriptionErrorMsg).size() > 0;
    }

    public boolean isSubscriptionButtonVisible() {
        return driver.findElements(subscriptionButton).size() > 0;
    }

    // ================= SCROLL Methods =================
    public void scrollDown() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Scroll failed: " + e.getMessage());
        }
    }

    public boolean isScrollToTopArrowVisible() {
        return driver.findElements(scrollToTopArrow).size() > 0;
    }

    // ================= STATIC TEXT Methods =================
    public boolean isNewUserSignupTextVisible() {
        return driver.findElements(newUserSignupText).size() > 0;
    }

    public boolean isLoginToAccountTextVisible() {
        return driver.findElements(loginToAccountText).size() > 0;
    }

    public boolean isOrTextVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(orText)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // ================= NAVIGATION BUTTONS =================
    public void clickProductsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(productsBtn)).click();
    }

    public void clickCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(cartBtn)).click();
    }
    public void clickVideoTutorialsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(videoTutorialsBtn)).click();
    }

    public void clickContactUsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(contactUsBtn)).click();
    }

    public void clickTestCasesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(testCasesBtn)).click();
    }

    public void clickApiTestingButton() {
        wait.until(ExpectedConditions.elementToBeClickable(apiTestingBtn)).click();
    }
    
    public boolean isProductsButtonPresent() {
        return driver.findElements(productsBtn).size() > 0;
    }

    public boolean isCartButtonPresent() {
        return driver.findElements(cartBtn).size() > 0;
    }
    public boolean isVideoTutorialsButtonPresent() {
        return driver.findElements(videoTutorialsBtn).size() > 0;
    }

    public boolean isContactUsButtonPresent() {
        return driver.findElements(contactUsBtn).size() > 0;
    }

    public boolean isTestCasesButtonPresent() {
        return driver.findElements(testCasesBtn).size() > 0;
    }

    public boolean isApiTestingButtonPresent() {
        return driver.findElements(apiTestingBtn).size() > 0;
    }

   
}
