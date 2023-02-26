import org.junit.jupiter.api.*;
import pages.RegistrationPage;

public class TextBoxForm extends TestBase {
    RegistrationPage registrationFormPage = new RegistrationPage();

    String firstNameUser = "Firstname",
            lastNameUser = "Secondname",
            email = "useremail@mail.ma",
            gender = "Female",
            phone = "1234567890",
            yearOfBirth = "1998",
            monthOfbirth = "May",
            dayOfbirth = "16",
            address = "Russia, Spb, 21",
            subjectOne = "Economics",
            subjectSecond = "Biology",
            hobbyOne = "Sports",
            hobbySecond = "Music",
            state = "Uttar Pradesh",
            city = "Lucknow",
            file = "cat.png";

    @DisplayName("Fill in the registration form")
    @Test
    @Tags({@Tag("Blocker"), @Tag("UI_test")})
    void successfulSubmitFormTest() {
        registrationFormPage
                .openPage()
                .setFirstName(firstNameUser)
                .setLastName(lastNameUser)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setDateOfBirth(dayOfbirth, monthOfbirth, yearOfBirth)
                .setSubject(subjectOne, subjectSecond)
                .setHobby(hobbyOne, hobbySecond)
                .uploadPicture()
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstNameUser + " " + lastNameUser)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phone)
                .verifyResult("Date of Birth", dayOfbirth + " " + monthOfbirth + "," + yearOfBirth)
                .verifyResult("Subjects", subjectOne + ", " + subjectSecond)
                .verifyResult("Hobbies", hobbyOne + ", " + hobbySecond)
                .verifyResult("Picture", file)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);

    }

    @DisplayName("Phone validation")
    @Test
    void fillFormTestWithoutPhoneValidation() {
        registrationFormPage
                .openPage()
                .setFirstName(firstNameUser)
                .setLastName(lastNameUser)
                .setEmail(email)
                .setGender(gender)
                // .setPhone(phone)
                .setDateOfBirth(dayOfbirth, monthOfbirth, yearOfBirth)
                .setSubject(subjectOne, subjectSecond)
                .setHobby(hobbyOne, hobbySecond)
                .uploadPicture()
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();

    }

    @Disabled
    @DisplayName("Email Validation")
    @Test
    void fillFormTestWithoutEmailValidation() {
        registrationFormPage
                .openPage()
                .setFirstName(firstNameUser)
                .setLastName(lastNameUser)
                .setGender(gender)
                 .setPhone(phone)
                .setDateOfBirth(dayOfbirth, monthOfbirth, yearOfBirth)
                .setSubject(subjectOne, subjectSecond)
                .setHobby(hobbyOne, hobbySecond)
                .uploadPicture()
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmit();

    }
}
