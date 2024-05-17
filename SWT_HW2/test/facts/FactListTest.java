package facts;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FactListTest {
    private FactList factList;

    @Before
    public void setUp() {
        factList = new FactList();
    }
    
    @Test // test that a fact with valid types will be added and have it's type assigned properly
    public void testAddFactWithValidType() {
        String author = "TestAuthor";
        String type = "TestType";
        String text = "TestText";

        factList.addFact(author, type, text);

        assertEquals(1, factList.getSize());
        assertEquals("TestType", factList.get(0).getType());
    }
    
    @Test // test that a fact with valid types will be added and have it's type assigned properly
    public void testAddFactWithEmptyAuthor() {
        String author = ""; // Empty author
        String type = "TestType";
        String text = "TestText";

        factList.addFact(author, type, text);

        assertEquals(0, factList.getSize());
    }
    
    @Test
    public void testAddFactWithEmptyType() {
        String author = "Test Author";
        String type = ""; // Empty type
        String text = "Test Text";

        factList.addFact(author, type, text);

        assertEquals(0, factList.getSize());
    }

    @Test
    public void testAddFactWithEmptyText() {
        String author = "Test Author";
        String type = "TestType";
        String text = ""; // Empty text

        factList.addFact(author, type, text);

        assertEquals(0, factList.getSize());
    }
    

}
