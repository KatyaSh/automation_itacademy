package utilities;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class MyArrayListTest {

    private MyArrayList<Integer> testingArray;

    @BeforeMethod
    public void initArray() {
        testingArray = new MyArrayList<>();
    }

    @Test
    public void testInitialSize() {
        Assert.assertEquals(testingArray.size(), 0);
    }

    @Test(groups = "additionTests")
    public void testAddElement() {
        testingArray.add(5);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(testingArray.size(), 1);
        softAssert.assertEquals(testingArray.get(0).intValue(), 5);
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "testAddElement")
    public void testDeleteElement() {
        testingArray.add(5);
        testingArray.remove(0);
        Assert.assertTrue(testingArray.isEmpty());
    }

    @Test(dependsOnMethods = "testAddElement")
    public void testGetElement() {
        testingArray.add(10);
        testingArray.add(4);
        Assert.assertEquals(testingArray.get(1).intValue(), 4);
    }

    @Test
    public void testClearElement() {
        testingArray.add(6);
        testingArray.add(2);
        testingArray.clear();
        Assert.assertEquals(testingArray.size(), 0);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testBoundaryCheckIndexGreaterSize() {
        testingArray.add(2);
        testingArray.add(6);
        testingArray.get(2).intValue();
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testBoundaryCheckIndexIsNegative() {
        testingArray.add(2);
        testingArray.add(6);
        testingArray.get(-1).intValue();
    }

    @Test
    public void testAdd() {
        SoftAssert softAssert = new SoftAssert();
        testingArray.add(2);
        testingArray.add(6);
        testingArray.add(2, 8);
        softAssert.assertEquals(testingArray.size(), 3);
        softAssert.assertEquals(testingArray.get(2).intValue(), 8);
        softAssert.assertAll();
    }

    @Test
    public void testAddCapacityEqualsSize() {
        SoftAssert softAssert = new SoftAssert();
        testingArray = new MyArrayList<>(2);
        testingArray.add(3);
        testingArray.add(6);
        testingArray.add(8);
        softAssert.assertEquals(testingArray.size(), 3);
        softAssert.assertEquals(testingArray.get(2).intValue(), 8);
        softAssert.assertAll();
    }

    @Test
    public void testAddAll() {
        SoftAssert softAssert = new SoftAssert();
        testingArray = new MyArrayList<>(2);
        testingArray.add(3);
        testingArray.add(6);
        MyArrayList<Integer> additionalTestingArray = new MyArrayList<>(2);
        additionalTestingArray.add(4);
        additionalTestingArray.add(5);
        testingArray.addAll(additionalTestingArray);
        softAssert.assertEquals(testingArray.size(), 4);
        softAssert.assertEquals(testingArray.get(2).intValue(), 4);
        softAssert.assertEquals(testingArray.get(3).intValue(), 5);
        softAssert.assertAll();
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testAddAllException() {
        testingArray = new MyArrayList<>(2);
        testingArray.add(3);
        testingArray.add(6);
        testingArray.addAll(null);
    }

    @Test
    public void testGetIndex() {
        testingArray.add(3);
        testingArray.add(2);
        Assert.assertEquals(testingArray.get(1), 2);
    }

    @Test
    public void testRemoveElement() {
        SoftAssert softAssert = new SoftAssert();
        testingArray.add(3);
        testingArray.add(2);
        testingArray.add(1);
        testingArray.remove(Integer.valueOf(2));
        softAssert.assertEquals(testingArray.size(), 2);
        softAssert.assertEquals(testingArray.get(0).intValue(), 3);
        softAssert.assertEquals(testingArray.get(1).intValue(), 1);
        softAssert.assertAll();
    }

    @Test
    public void testSetElement() {
        testingArray.add(3);
        testingArray.add(2);
        testingArray.set(1, 10);
        Assert.assertEquals(testingArray.get(1), 10);
    }

    @Test()
    public void testContainsElement() {
        testingArray.add(3);
        testingArray.add(2);
        testingArray.add(1);
        testingArray.remove(Integer.valueOf(2));
        Assert.assertFalse(testingArray.contains(2));
    }

    @Test()
    public void testToArray() {
        testingArray.add(3);
        testingArray.add(2);
        Object[] result = testingArray.toArray();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(result.length, 2);
        softAssert.assertEquals(result[0], 3);
        softAssert.assertEquals(result[1], 2);
        softAssert.assertAll();

    }


}
