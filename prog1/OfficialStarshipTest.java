import org.junit.Test;
import static org.junit.Assert.*;

public class OfficialStarshipTest
{  
    @Test
    public void testfromArgs_80_Valid_Success()
    {
        var s = Starship.fromArgs(new String[] { "--shields", "7", "--warp", "5.2", "--crew", "kirk,uhura,mccoy" });

        assertEquals(5.2, s.getWarp(), 0);
        assertEquals(false, s.getCloak());
        assertEquals(7, s.getShields());
        assertEquals(3, s.getCrew().size());
    }

    //Test fromArgs with an invalid argument
    @Test(expected = IllegalArgumentException.class)
    public void testfromArgs_80_IAE() {
        Starship.fromArgs(new String[] { "--launch" });
    }

    //Test fromArgs without '--cloak'
    @Test
    public void testfromArgs_80_NCFC() // NoCloak_FalseCloak()
    {
        var s = Starship.fromArgs(new String[] { });
        assertTrue(s.getCloak() == false);
    }

    //Test fromArgs with '--cloak'
    @Test
    public void testFromArgs_80_CTC() // Cloak_TrueCloak()
    {
        Starship s = Starship.fromArgs(new String[] { "--cloak" });
        assertTrue(s.getCloak() == true);
    }


    //Test fromArgs with '--warp' and a negative number
    @Test(expected = IllegalArgumentException.class)
    public void testFromArgs_90_NWE() // NegativeWarp_Exception
    {
        Starship.fromArgs(new String[] { "--warp", "-2.8" } );
    }

    //Test fromArgs with '--warp' and a large number
    @Test(expected = IllegalArgumentException.class)
    public void fromArgs_90_LWE()
    {
           Starship.fromArgs(new String[] { "--warp", "15.1" });
    }

    //Test fromArgs with '--warp' and an invalid number
    @Test(expected = IllegalArgumentException.class)
    public void fromArgs_90_BWE()
    {
           Starship.fromArgs(new String[] { "--warp", "a" });
    }

    //Test fromArgs with '--warp' and a missing number
    @Test(expected = IllegalArgumentException.class)
    public void fromArgs_90_MWE()
    {
           Starship.fromArgs(new String[] { "--warp" });
    }

    //Test fromArgs with '--shields' and a negative number
    @Test(expected = IllegalArgumentException.class)
    public void fromArgs_90_NSE() // NegativeShields_Exception
    {
            Starship.fromArgs(new String[] { "--shields", "-1" });
    }

    //Test fromArgs with '--shields' and a large number
    @Test(expected = IllegalArgumentException.class)
    public void fromArgs_90_LSE() // Largeshields_Exception
    {
            Starship.fromArgs(new String[] { "--shields", "11" });
    }


    //Test fromArgs with '--crew' and an invalid crew member
    @Test(expected = IllegalArgumentException.class)
    public void fromArgs_100_FCE() // FakeCrew_Exception
    {
            Starship.fromArgs(new String[] { "--crew", "luke" });
    }

}