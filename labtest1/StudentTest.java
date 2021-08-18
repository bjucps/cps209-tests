import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentTest {
    @Test
    public void Max65_Constructor_ValidArgs_NoThrow() {
        Student bug = new Student(2.5, "growl");
        assertEquals("growl", bug.getName());
        assertEquals(2.5, bug.getGpa(), 0);
    }

    @Test
    public void Max65_Constructor_InvalidGPA_Throws() {
        try {
            Student bug = new Student(-5, "growl");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid GPA.", e.getMessage());
        }

        try {
            Student bug = new Student(4.1, "growl");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid GPA.", e.getMessage());
        }
    }

    @Test
    public void Max65_Constructor_MissingName_Throws() {
        try {
            Student bug = new Student(3, null);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Missing Name.", e.getMessage());
        }

        try {
            Student bug = new Student(3, "");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Missing Name.", e.getMessage());
        }
    }

    @Test
    public void Max65_Constructor_BadName_Throws() {
        try {
            Student bug = new Student(3, "Avery");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Bad Name.", e.getMessage());
        }
    }

    @Test
    public void Max80_ExtractLetters_Works() {
        var stu = new Student(2.5, "Fred");
        String result = stu.extractLetters();

        assertEquals("Fred", result);

        stu = new Student(2.5, "A1b2c3");
        result = stu.extractLetters();

        assertEquals("Abc", result);
    }

    @Test
    public void Max105_toArray_Works() {
        int[] result = Student.toArray(new ArrayList<String>(Arrays.asList("1", "5", "2")));
        assertEquals(3, result.length);
        assertEquals(100, result[0]);
        assertEquals(200, result[2]);

        result = Student.toArray(new ArrayList<String>(Arrays.asList("6")));
        assertEquals(1, result.length);
        assertEquals(600, result[0]);
    }

    @Test
    public void Max105_make2DArray_Works() {
        var result = Student.make2DArray(2, 3);
        check2DArray(result, 2, 3);

        result = Student.make2DArray(3, 5);
        check2DArray(result, 3, 5);
    }

    private void check2DArray(int[][] result, int rows, int cols) {
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                assertEquals(row + 1, result[row][col]);
            }
        }
    }

}