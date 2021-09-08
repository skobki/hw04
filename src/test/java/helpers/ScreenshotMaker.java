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

    public void MakeAScreenshot(String format, String name) {
        try {
            ImageIO.write(screenshotMaker.getImage(), format, new File("temp\\" + name + "." + format));
            logger.info("Скриншот сохранен в [temp/" + name + "." + format + "]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
