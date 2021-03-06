package testCases;

import browsers.base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.createANotePage;
import pages.loginPage;

import java.io.File;
import java.io.IOException;

/**
 * Created by musti on 22/06/2017.
 */
public class archiveNoteTest extends base {

        @Test
        public void ArchiveNote() throws InterruptedException, IOException {

        loginPage lp = new loginPage(driver);
        lp.doLogin("xxxxxxxx@gmail.com", "xxxxxxxx"); // please supply valid username and password
        Thread.sleep(1000);

        createANotePage canp = new createANotePage(driver);
        canp.doCreateNote("Test1", "Yieldify test to verify archive note test");
        canp.ConfirmCreateNote();

        canp.ArchiveNoteP();
        Assert.assertTrue(canp.AssertArchiveNote());

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("C:\\WIP2\\InterviewTests\\David\\src\\main\\java\\screenshots\\ArchiveNoteTest.jpg"));

        driver.close();
    }
}
