package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class ScreenshotMaker {
    private Logger logger = LogManager.getLogger(ScreenshotMaker.class);

    protected static Screenshot screenshotMaker;
    public static void initScreenshotMaker(WebDriver driver) {
        screenshotMaker = new AShot().takeScreenshot(driver);
    }

    public void MakeAScreenshot(String format, String path) {
        try {
            ImageIO.write(screenshotMaker.getImage(), format, new File(path));
            logger.info("Скриншот сохранен в " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}