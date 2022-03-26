package parser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import parser.XMLParser;

import java.io.FileNotFoundException;

public class XMLParserTest {

    XMLParser parser;


    @Test(expectedExceptions = FileNotFoundException.class)
    public void XMLParserTest() {
        parser = new XMLParser("dffdf.xml");
    }

    @Test
    public void parseValidDocumentTest() {
        parser = new XMLParser("unit.xml");
        parser.parseDocument();
        Assert.assertEquals(parser.getErrors().size(), 0, "XML doc is not valid");
    }

    @DataProvider(name = "DataProvider")
    public Object[][] createTestData() {
        return new Object[][]{
                {"startWithoutRootTag.xml", "Document should start from root tag or instruction. "},
                {"dataBehindRootTag.xml", "All data should be inside of the root tag"},
                {"neverClosedTag.xml", "Tag suite name never closed. Tag names must have format <name>."},
                {"WithoutInstructionTag.xml", "Instruction tag is not closed"},
                {"tagWithoutClosing.xml", "The tag test closed incorrectly. Missing >"},
                {"UnexpectedClosingTag.xml", "Unexpected closing tag clasdses"}
        };
    }

    @Test(dataProvider = "DataProvider")
    public void testParserErrors(String filename, String message) {
        parser = new XMLParser(filename);
        parser.parseDocument();
        Assert.assertEquals(parser.getErrors().get(0), message);
    }

}
