package pageObjects;

import org.openqa.selenium.By;

public class GridPage {
    private final By gridChartTab = By.xpath("//div[contains(text(),'Grid & chart')]");
    private final By gridFirstRow = By.xpath("//div[@class='ag-center-cols-clipper']/div[@role='presentation']/div[@role='presentation']/div[1]");
    private final By gridFirstCell = By.xpath("(//div[@role='gridcell'])[1]");
    private final By linesTab = By.xpath("//span[@class='chart-settings__title chart-mobile-title']");
}
