import org.junit.Test;
import static org.junit.Assert.*;

public class MyGuessTest
{  
    @Test
    public void testCheck_LowGuess_ReportsTooLow()
    {
        var g = new Guess();
        g.setSecret(5);
        String result = g.check(3);
        assertEquals("Too Low.", result);
    }

    @Test
    public void testCheck_BadSecret_ThrowsException()
    {
        var g = new Guess();
        try {
            g.setSecret(15);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void testCheck_ValidSecret_NoThrow()
    {
        var g = new Guess();
        g.setSecret(3);
    }
    
    @Test
    public void testCheck_CorrectGuess()
    {
        var g = new Guess();
        g.setSecret(3);
        String result = g.check(3);
        assertEquals("Correct!", result);
    }        
}
