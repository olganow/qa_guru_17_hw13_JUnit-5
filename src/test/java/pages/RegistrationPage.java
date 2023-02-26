package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    //private final String TITLE_TEXT = "Student Registration Form";
    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final File file = new File("src/test/resources/cat.png");
    // Element
    private final SelenideElement
            firstNameInput = $("#firstName"),
            secondNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbyInput = $("#hobbiesWrapper"),
            pictureUpload = $x("//input[@id='uploadPicture']"),
            addressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitButton = $("#submit");

    //Actions
    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixeban').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage clearFirstName(String value) {
        firstNameInput.clear();
        return this;
    }

    public RegistrationPage setLastName(String value) {
        secondNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPhone(String value) {
        phoneInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String subjectOne, String subjectSecond) {
        subjectInput.setValue(subjectOne).pressEnter();
        subjectInput.setValue(subjectSecond).scrollTo().pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String hobbyOne, String hobbySecond) {
        hobbyInput.$(byText(hobbyOne)).click();
        hobbyInput.$(byText(hobbySecond)).click();

        return this;
    }

    public RegistrationPage uploadPicture() {
        pictureUpload.uploadFile(file);

        return this;
    }

    public RegistrationPage setAddress(String address) {
        addressInput.scrollIntoView(true).setValue(address);

        return this;
    }

    public RegistrationPage setState(String state) {
        stateInput.setValue(state).pressEnter();

        return this;
    }

    public RegistrationPage setCity(String city) {
        cityInput.setValue(city).pressEnter();

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
        registrationResultsModal.verifyResult(key, value);

        return this;
    }

}
