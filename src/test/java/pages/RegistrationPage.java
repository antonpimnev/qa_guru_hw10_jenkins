package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.PictureUploader;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    PictureUploader pictureUploader = new PictureUploader();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private final String titleText = "Student Registration Form";
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement genderRadioButtons = $(byXpath("//label[contains(text(),'Male')]"));
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement userBDayInput = $("#dateOfBirthInput");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbiesCheckBoxes = $x("//div[@id='hobbiesWrapper']");
    private SelenideElement uploadPictureButton = $("#uploadPicture");
    private SelenideElement addressField = $("#currentAddress");
    private SelenideElement stateList = $x("//div[text()='Select State']");
    private SelenideElement cityList = $x("//div[text()='Select City']");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement closeButton = $x("//button[@id='closeLargeModal']");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderRadioButtons.click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setBDate(String day, String month, String year) {
        userBDayInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesCheckBoxes.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        pictureUploader.uploadPicture(uploadPictureButton, value);
        return this;
    }

    public RegistrationPage setAdress(String value) {
        addressField.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value) {
        stateList.click();
        $x("//div[text()='" + value + "']").click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityList.click();
        $x("//div[text()='" + value + "']").click();
        return this;
    }

    public RegistrationPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResults(key, value);
        return this;
    }

    public RegistrationPage clickClose() {
        closeButton.click();
        return this;
    }


}