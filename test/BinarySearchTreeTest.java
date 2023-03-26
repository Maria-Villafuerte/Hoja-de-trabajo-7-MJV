package  test;
package  src;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer, String> bst;

    @Before
    public void setUp() {
        bst = new BinarySearchTree<>();
        bst.insert(5, "five");
        bst.insert(3, "three");
        bst.insert(7, "seven");
        bst.insert(2, "two");
        bst.insert(4, "four");
        bst.insert(6, "six");
        bst.insert(8, "eight");
    }

    @Test
    public void testSearchExistingKey() {
        String value = bst.search(3);
        assertEquals("three", value);
    }

    @Test
    public void testSearchNonexistentKey() {
        String value = bst.search(1);
        assertNull(value);
    }

    @Test
    public void testInOrderTraversal() {
        ArrayList<String> values = new ArrayList<>();
        ITraversal<Integer, String> visitor = (key, value) -> values.add(value);
        bst.inOrderTraversal(visitor);
        assertEquals(Arrays.asList("two", "three", "four", "five", "six", "seven", "eight"), values);
    }

    @Test
    public void testDeleteLeafNode() {
        bst.delete(4);
        ArrayList<String> values = new ArrayList<>();
        ITraversal<Integer, String> visitor = (key, value) -> values.add(value);
        bst.inOrderTraversal(visitor);
        assertEquals(Arrays.asList("two", "three", "five", "six", "seven", "eight"), values);
    }

}
