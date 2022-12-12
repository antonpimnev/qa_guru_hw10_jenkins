package tests;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class DemoqaTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    //consts
    String userFirstName = "Anton",
            userLastName = "Pimnev",
            userEmail = "anton.pimnev@pochta.com",
            userGender = "Male",
            userNumber = "5865264115",
            userBDay = "10",
            userBMonth = "September",
            userBYear = "2000",
            userSubject = "Accounting",
            userHobbies = "Sports",
            userPicture = "src/test/resources/1.png",
            userPictureResult = "1.png",
            userAddress = "Moscow 1",
            userState = "NCR",
            userCity = "Delhi";

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName(userFirstName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setBDate(userBDay, userBMonth, userBYear)
                .setSubject(userSubject)
                .setHobbies(userHobbies)
                .uploadPicture(userPicture)
                .setAdress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .clickSubmit()
                .verifyResultsModalAppears()
                .verifyResult("Student Name", userFirstName+" "+userLastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", userBDay+ " " +userBMonth +"," +userBYear)
                .verifyResult("Subjects", userSubject)
                .verifyResult("Hobbies", userHobbies)
                .verifyResult("Picture", userPictureResult)
                .verifyResult("Address", userAddress)
                .verifyResult("State and City", userState+" "+userCity)
                .clickClose();
    }
}
