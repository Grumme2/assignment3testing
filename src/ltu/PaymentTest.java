package ltu;
import static ltu.CalendarFactory.getCalendar;
import static org.junit.Assert.*;

import java.beans.Transient;
import java.io.IOException;

import org.junit.Test;

public class PaymentTest
{
    @Test
    public void testSilly()
    {
        assertEquals(1, 1);
        assertEquals(4, 4);
        
        
    }
    @Test
    public void testsilly2(){
        assertEquals(1, 1);
    }

    @Test
    public void getpaymentamounttest() throws IOException{
        
        PaymentImpl payment;
        payment = new PaymentImpl(getCalendar());
        assertEquals(9904,payment.getMonthlyAmount("19990808-0000", 19900, 100, 100));
    }
}
