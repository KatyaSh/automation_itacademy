package pageObjects;

import org.openqa.selenium.By;

public class ScatterplotPage {
    private final By scatterPlotTab = By.xpath("//div[contains(text(),'Scatter-plot')]");
    private final By scatterPlotDiagram = By.xpath("//div[@class='scatter-plot-container']");
    private final By xAttributeSetting = By.xpath("//input[@title='Multiplier']");
    private final By yAttributeSetting = By.xpath("//input[@title='Sequence number']");
    private final By intervalSetting = By.xpath("//input[@title='10']");
}
