package P0169495;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

import static P0169495.HashCollisionChecker.countOfUniqueHashCodes;
import static org.junit.Assert.assertEquals;

public class HashCollisionCheckerSampleTest {
    @Test
    public void testCountOfUniqueHashCodesEmptyHashSet() {
        assertEquals(0, countOfUniqueHashCodes(new HashSet<>()));
    }

    @Test
    public void testCountOfUniqueHashCodesNonEmptyHashSet() {
        HashSet<String> set = new HashSet<>();
        set.add("c#c#c#c#c#c#bBc#c#c#c#bBc#");
        set.add("c#c#c#c#c#c#bBc#c#c#c#c#aa");
        set.add("c#c#c#c#c#c#bBc#c#c#c#c#bB");
        assertEquals(1, countOfUniqueHashCodes(set));
    }

    @Test
    public void testCountOfUniqueHashCodesEmptyHashMap() {
        assertEquals(0, countOfUniqueHashCodes(new HashMap<>()));
    }

    @Test
    public void testCountOfUniqueHashCodesNonEmptyHashMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("c#c#c#c#c#c#bBc#c#c#c#bBc#", 5);
        map.put("c#c#c#c#c#c#bBc#c#c#c#c#aa", 5);
        map.put("c#c#c#c#c#c#bBc#c#c#c#c#bB", 5);
        map.put("c#c#c#c#c#c#c#aaaaaaaac#c#", 5);
        map.put("c#c#c#c#c#c#c#aaaaaabBaaax", 5);
        assertEquals(2, countOfUniqueHashCodes(map));
    }
}