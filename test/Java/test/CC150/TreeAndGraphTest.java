package Java.test.CC150;

import org.junit.Test;
import static org.junit.Assert.*;
import Java.src.CC150.TreeAndGraph;
import Java.src.CC150.TreeAndGraph.*;
/**
 * Created by YHWH on 1/26/15.
 */
public class TreeAndGraphTest {
    @Test
    public void isBalanced(){
        int[] sample = {6,3,8,2,5,4,10,1};

        TreeAndGraph tree = new TreeAndGraph(sample);
        boolean result =tree.isBalanced();
        assertTrue(result);
    }
}
