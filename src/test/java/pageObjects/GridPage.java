package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Collections;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GridPage {
    private static final Logger logger = LogManager.getLogger(GridPage.class);

    private final By gridChartTab = By.xpath("//div[contains(text(),'Grid & chart')]");
    private final By filterButton = By.cssSelector("button[title='Filters']");
    private final By toolPanelButton = By.cssSelector("button[ref='eToggleButton");
    private final By columnButton = By.cssSelector("span.ag-header-icon.ag-header-cell-menu-button");
    private final By thirdColumnButton = By.cssSelector("span.ag-icon.ag-icon-columns");
    private final By idCheckboxTab = By.xpath("//div[@class='ag-menu-column-select-wrapper']//span[@title='Id'][normalize-space()='Id']/preceding-sibling::*");
    private final By idCheckboxToolBar = By.xpath("//span[@title='Id']/preceding-sibling::*");
    private final By idColumn = By.cssSelector("div[col-id='orderId'] div[role='presentation'] div[role='presentation'] span[role='columnheader']");
    private final By idCheckboxFilter = By.xpath("//div[@class='ag-column-tool-panel-columns']//span[@title='Id'][normalize-space()='Id']/preceding-sibling::*");
    private final By columnHeaderDouble = By.xpath("//div[@ref='eLabel']/span[contains(text(),'Avg fill price')]");
    private final By columnHeaderInteger = By.xpath("//div[@ref='eLabel']/span[contains(text(),'Num of executions')]");
    private final By columnHeaderString = By.xpath("//div[@ref='eLabel']/span[contains(text(),'Type')]");
    private final By columnHeaderTime = By.xpath("//div[@ref='eLabel']/span[contains(text(),'Start time')]");
    private final By sortButtonAsc = By.cssSelector("span[ref='eSortAsc']");
    private final By sortButtonDesc = By.cssSelector("span[ref='eSortDesc']");
    private final By stringColumnValues = By.xpath("//div[@col-id='orderType']//span[@title]");
    private final By integerColumnValues = By.xpath("//div[@col-id='numberOfExecutions']//span[@title]");
    private final By doubleColumnValues = By.xpath("//div[@col-id='averageFillPrice']//span[@title]");
    private final By timeColumnValues = By.xpath("//div[@col-id='startTime']//span[@title]");

    @Step
    public void clickOnTab() {
        $(gridChartTab).shouldBe(visible).click();
        logger.info("Click on Grid Tab at the top menu");
    }

    @Step
    public void clickOnFilterButton() {
        $(filterButton).click();
        logger.info("Click on Filter button at the top menu");
        $("div.ag-column-tool-panel-container").shouldBe(visible);
    }

    @Step
    public void clickOnToolPanel() {
        $(toolPanelButton).click();
        logger.info("Click on Tool panel button ");
        $("div.ag-column-panel").shouldBe(visible);
    }

    @Step
    public void openColumnFilter() {
        $$(columnButton).get(0).click();
        logger.info("Click on column filter button ");
        $(thirdColumnButton).shouldBe(visible);
        $(thirdColumnButton).click();
        $("div.ag-menu-column-select-wrapper").shouldBe(visible);

    }

    @Step
    public boolean checkSwitchColumnDisplayFilter() {
        $(idCheckboxFilter).click();

        if ($(idColumn).exists()) {
            $(idCheckboxFilter).click();
            logger.info("Uncheck Checkbox");
            logger.info("Id column is not shown");
            return !$(idColumn).exists();

        } else {
            $(idCheckboxFilter).click();
            logger.info("Check Checkbox");
            logger.info("Id column is shown");
            return $(idColumn).exists();
        }
    }

    @Step
    public boolean checkSwitchColumnDisplayToolPanel() {
        $(idCheckboxToolBar).click();

        if ($(idColumn).exists()) {
            $(idCheckboxToolBar).click();
            logger.info("Uncheck Checkbox");
            logger.info("Id column is not shown");
            return !$(idColumn).exists();

        } else {
            $(idCheckboxToolBar).click();
            logger.info("Check Checkbox");
            logger.info("Id column is shown");
            return $(idColumn).exists();
        }
    }

    @Step
    public boolean checkSwitchColumnDisplayColumnFilter() {
        $(idCheckboxTab).click();

        if ($(idColumn).exists()) {
            $(idCheckboxTab).click();
            logger.info("Uncheck Checkbox");
            logger.info("Id column is not shown");
            return !$(idColumn).exists();

        } else {
            $(idCheckboxTab).click();
            logger.info("Check Checkbox");
            logger.info("Id column is shown");
            return $(idColumn).exists();
        }
    }

    @Step
    public void closeColumnFilterIfExists() {
        if ($("div[class='d-flex h-100']").isDisplayed()) {
            $("div[class='d-flex h-100']").click();
        }
    }

    @Step
    public void clickOnColumnHeader(String string) {
        logger.info("click on column header " + string);
        switch (string) {
            case "Avg fill price":
                SelenideElement header = $(columnHeaderDouble);
                executeJavaScript("arguments[0].scrollLeft = arguments[0].scrollIntoView(true);", header);
                $(columnHeaderDouble).click();
                break;
            case "Num of executions":
                SelenideElement header1 = $(columnHeaderInteger);
                $("div.ag-body-horizontal-scroll-viewport").click();
                executeJavaScript("arguments[0].scrollLeft = arguments[0].scrollIntoView(true);", header1);
                $(columnHeaderInteger).click();
                break;
            case "Type":
                SelenideElement header2 = $(columnHeaderString);
                executeJavaScript("arguments[0].scrollLeft = arguments[0].scrollIntoView(true)", header2);
                $(columnHeaderString).click();
                break;
            case "Start time":
                SelenideElement header3 = $(columnHeaderTime);
                executeJavaScript("arguments[0].scrollLeft = arguments[0].scrollIntoView(true);", header3);
                $(columnHeaderTime).click();
                break;
        }
    }

    @Step
    public boolean checkAscSortButtonDisplay() {
        executeJavaScript("arguments[0].scrollLeft = arguments[0].scrollIntoView(true);", $(sortButtonAsc));
        logger.info("check AscSort Button Display");
        return $(sortButtonAsc).exists();
    }

    @Step
    public boolean checkDeckSortButtonDisplay() {
        executeJavaScript("arguments[0].scrollLeft = arguments[0].scrollIntoView(true);", $(sortButtonDesc));
        logger.info("check DescSort Button Display");
        return $(sortButtonDesc).exists();
    }

    @Step
    public boolean checkAscSortButtonNotShown() {
        logger.info("check AscSort Button not shown");
        return !$(sortButtonAsc).exists();
    }

    @Step
    public boolean checkDeskSortButtonNotShown() {
        logger.info("check DescSort Button not shown");
        return !$(sortButtonDesc).isDisplayed();
    }

    @Step
    public boolean checkAscSortColumnHeader(String string) {
        logger.info("check asc sort for column" + string);
        switch (string) {
            case "Avg fill price":
                return checkAscSortStringApplied(doubleColumnValues);
            case "Num of executions":
                return checkAscSortIntegerApplied(integerColumnValues);
            case "Type":
                return checkAscSortStringApplied(stringColumnValues);
            case "Start time":
                return checkAscSortStringApplied(timeColumnValues);
        }
        return false;
    }

    @Step
    public boolean checkDescSortColumnHeader(String string) {
        logger.info("check desc sort for column" + string);
        switch (string) {
            case "Avg fill price":
                return checkDescSortStringApplied(doubleColumnValues);
            case "Num of executions":
                return checkDescSortIntegerApplied(integerColumnValues);
            case "Type":
                return checkDescSortStringApplied(stringColumnValues);
            case "Start time":
                return checkDescSortStringApplied(timeColumnValues);
        }
        return false;
    }

    @Step
    public boolean checkNoSortApplied(String string) {
        logger.info("check the sort is not applied for column" + string);
        switch (string) {
            case "Avg fill price":
                return checkSortStringIsNotApplied(doubleColumnValues);
            case "Num of executions":
                return checkSortIntegerIsNotApplied(integerColumnValues);
            case "Type":
                return checkSortStringIsNotApplied(stringColumnValues);
            case "Start time":
                return checkSortStringIsNotApplied(timeColumnValues);
        }
        return false;
    }

    private boolean checkAscSortStringApplied(By elements) {
        ArrayList<String> initialList = createInitialSortListString(elements);
        ArrayList<String> sortedList = createSortedListString(initialList);
        return sortedList.equals(initialList);
    }

    private boolean checkAscSortIntegerApplied(By elements) {
        ArrayList<Integer> initialList = createInitialSortListInteger(elements);
        ArrayList<Integer> sortedList = createSortedListInteger(initialList);
        return sortedList.equals(initialList);
    }

    private boolean checkDescSortStringApplied(By element) {
        ArrayList<String> initialList = createInitialSortListString(element);
        ArrayList<String> sortedList = createSortedListString(initialList);
        Collections.reverse(sortedList);
        return sortedList.equals(initialList);

    }

    private boolean checkDescSortIntegerApplied(By element) {
        ArrayList<Integer> initialList = createInitialSortListInteger(element);
        ArrayList<Integer> sortedList = createSortedListInteger(initialList);
        Collections.reverse(sortedList);
        return sortedList.equals(initialList);

    }

    private boolean checkSortStringIsNotApplied(By element) {
        ArrayList<String> initialList = createInitialSortListString(element);
        ArrayList<String> sortedList = createSortedListString(initialList);
        if (sortedList.equals(initialList)) {
            return false;
        }
        Collections.reverse(sortedList);
        return !sortedList.equals(initialList);

    }

    private boolean checkSortIntegerIsNotApplied(By element) {
        ArrayList<Integer> initialList = createInitialSortListInteger(element);
        ArrayList<Integer> sortedList = createSortedListInteger(initialList);
        if (sortedList.equals(initialList)) {
            return false;
        }
        Collections.reverse(sortedList);
        System.out.println(sortedList);
        return !sortedList.equals(initialList);

    }


    private ArrayList<String> createInitialSortListString(By element) {
        ElementsCollection getColumnValue = $$(element);
        sleep(5000);
        ArrayList<String> initialList = new ArrayList<>();
        for (int i = 0; i < getColumnValue.size() - 1; i++) {
            initialList.add(getColumnValue.get(i).getText());
        }
        return initialList;
    }

    private ArrayList<String> createSortedListString(ArrayList<String> initialList) {
        ArrayList<String> sortedList = new ArrayList<>();
        for (int i = 0; i < initialList.size(); i++) {
            sortedList.add(initialList.get(i));
        }
        Collections.sort(sortedList);
        return sortedList;
    }

    private ArrayList<Integer> createInitialSortListInteger(By element) {
        ElementsCollection getColumnValue = $$(element);
        sleep(5000);
        ArrayList<Integer> initialList = new ArrayList<>();
        for (int i = 0; i < getColumnValue.size() - 1; i++) {
            initialList.add(Integer.valueOf(getColumnValue.get(i).getText().replace(",", "")));
        }
        return initialList;
    }

    private ArrayList<Integer> createSortedListInteger(ArrayList<Integer> initialList) {
        ArrayList<Integer> sortedList = new ArrayList<>();
        for (int i = 0; i < initialList.size(); i++) {
            sortedList.add(initialList.get(i));
        }
        Collections.sort(sortedList);
        return sortedList;
    }


}




