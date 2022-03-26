package parser;

import utilities.Iterator;

public class ProgramRunner {

    public static void main(String[] args) {
        XMLParser parser = new XMLParser("unit.xml");
        parser.parseDocument();
        if (parser.getErrors().isEmpty()) {
            System.out.println("Valid xml");
        } else {
            Iterator<String> errorsIterator = parser.getErrors().iterator();
            while (errorsIterator.hasNext()) {
                System.out.println(errorsIterator.next());
            }
        }
    }
}
