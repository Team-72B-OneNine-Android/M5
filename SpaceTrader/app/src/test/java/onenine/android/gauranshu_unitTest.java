package onenine.android;

import org.junit.Test;
import onenine.android.Model.Ship;
import onenine.android.Model.ShipType;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class gauranshu_unitTest {
    @SuppressWarnings("JavaDoc")
    @Test
    public void nonEmptyCargo() {
        Ship og = new Ship(ShipType.GNAT);
        og.setCargoUsed(50);
        og.emptyCargo();

        assertEquals(0, og.getCargoUsed());
    }

    @SuppressWarnings("JavaDoc")
    @Test
    public void emptyCargo() {
        Ship og = new Ship(ShipType.GNAT);
        og.setCargoUsed(0);
        og.emptyCargo();

        assertEquals(0, og.getCargoUsed());
    }
}