package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenShot {

    /**
     * Method Create Directory Screenshot to store images for failure test
     *
     * @param ScreenShotName Name of the Test.png
     */
    public static void CaptureScreenshots(String ScreenShotName) {
        Path dest = Paths.get(".//ScreenShots//", ScreenShotName + ".png");
        try {
            Files.createDirectories(dest.getParent());  //Create Directory for ScreenShot images
            FileOutputStream out = new FileOutputStream(dest.toString());   //Create object for Image file of type output stream
            out.write(((TakesScreenshot) UiActions.driver).getScreenshotAs(OutputType.BYTES)); //Write in file the image taken output bytes (.png)
            out.close();

        } catch (IOException e) {
            HandleExceptions.IOExceptionHandling(e); //Handle Output file exception thrown
            System.out.println("Exception While taking screenshots" + e.getMessage()); //Output message for exception
        }
    }


}
