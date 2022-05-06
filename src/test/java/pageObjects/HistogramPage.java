package pageObjects;

import org.openqa.selenium.By;

public class HistogramPage {
    private final By histogramTab = By.xpath("//div[contains(text(),'Histogram')]");
    private final By histogram = By.xpath("//div[@class='histogram-container']");
    private final By attributeSetting = By.xpath("//deltix-ng-autocomplete[@class='ng-untouched ng-pristine ng-valid']");
    private final By intervalSetting = By.xpath("//deltix-ng-autocomplete[@class='d-block ng-untouched ng-pristine ng-valid']");
}
