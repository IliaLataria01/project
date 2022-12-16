package com.qaprosoft.carina.demo.gui.test.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(AboutPage.class);

    @FindBy(xpath = "//div[@aria-label='Video Player']")
    private ExtendedWebElement video;

    @FindBy(xpath = "//div[@id='videoModal']//button[@class='btn btn-secondary' and contains(text(),'Close')]")
    private ExtendedWebElement closeButton;

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isVideoPresent() { return video.isElementPresent(); }

    public void playVideo(int time) throws InterruptedException {
        video.click();
        Thread.sleep(time);
    }

    public void clickCloseButton() {
        assertElementPresent(closeButton);
        closeButton.click();
    }
}
