package Java.test.CC150;

import org.junit.Test;
import static org.junit.Assert.*;

import Java.src.CC150.ArrayAndString;

/**
 * Created by YHWH on 12/11/14.
 */

public class ArrayAndStringTest {
    ArrayAndString arrayStringTest = new ArrayAndString();

    @Test
    public void isUniqueCharsTest(){
        String str = "abcdefg";
        assertTrue(arrayStringTest.isUniqueChars(str));
    }

    @Test
    public void isPermutationTest(){
        String str1 = "All test methods are annotated with @Test. Unlike JUnit3 tests, you do not need to prefix the method name with \"test\"";
        String str2 = "To run a test on the command line. Use something like this";

        assertFalse(arrayStringTest.isPermutation(str1, str2));

        String str3 = "hello moto";
        String str4 = "moto hello";
        assertTrue(arrayStringTest.isPermutation(str3, str4));
    }

    @Test
    public void replaceSpaceTest(){
        String str = "Mr John Smith  ";
        //char[] chars = str.toCharArray();
        String result = "Mr%20John%20Smith";
        int length = 13;
        assertEquals(result, arrayStringTest.replaceSpace(str, length));
    }

    @Test
    public void stringCompressTest(){
        String str = "aabcccccaaadddd";
        String result = arrayStringTest.stringCompress(str);
        String expected = "a2b1c5a3d4";
        assertEquals(expected,result);
    }

    @Test
    public void countCompressTest(){
        String str = "aabcccccaaa";
        int result = arrayStringTest.countCompress(str);
        int expected = 8;
        assertEquals(expected, result);
    }

    @Test
    public void checkIsSubstringTest(){
        String s1, s2;
        s1 = "erbottlewat";
        s2 = "waterbottle";
        assertTrue(arrayStringTest.checkIsSubstring(s1, s2));
    }

    @Test
    public void setZeroMatrixTest() {
        int[][] matrix = new int[][]{{0, 0, 1}, {2, 3, 4}, {5, 6, 7}};
        int[][] expected = new int[][]{{0, 0, 0}, {0, 0, 4}, {0, 0, 7}};
        assertArrayEquals(expected,arrayStringTest.setZeroMatrix(matrix));
    }

    @Test
    public void rotateMatrixTest(){
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,0,1,2},{3,4,5,6}};
        int[][] expected = new int[][]{{3,9,5,1},{4,0,6,2},{5,1,7,3},{6,2,8,4}};
        assertArrayEquals(expected,arrayStringTest.rotateMatrix(matrix,4));
    }
}
