package pages.components;

import com.codeborne.selenide.SelenideElement;

import java.io.File;


public class PictureUploader {

    public void uploadPicture(SelenideElement element, String filePath) {
        element.uploadFile(new File(filePath));
    }
}