package pageObjects;

import org.openqa.selenium.By;

public class SummaryPage {
    private final By summaryTab = By.xpath("//div[contains(text(),'Summary')]");
    private final By algoPerformanceTable = By.xpath("//div[@algo_performance]");
}
