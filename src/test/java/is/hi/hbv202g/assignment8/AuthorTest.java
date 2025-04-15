package is.hi.hbv202g.assignment8;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AuthorTest {
    
    @Test
    public void testAuthor(){
        Author author1 = new Author("test1");

        assertEquals("test1", author1.getName());

        author1.setName("test2");

        assertEquals("test2", author1.getName());

    }
}
