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
        assertEquals(9904,payment.getMonthlyAmount("19970606-7973", 19900, 100, 100));
    }

    @Test
    public void getstudyamounttest() throws IOException {
        PaymentImpl test = new PaymentImpl(getCalendar());
        int testnotime = test.getMonthlyAmount("19970606-7973",0,0,100);
        int testhalftime = test.getMonthlyAmount("19970606-7973",0,50,100);
        int testalmostfulltime = test.getMonthlyAmount("19970606-7973",0,99,100);
        int testfulltime = test.getMonthlyAmount("19970606-7973",0,100,100);
        assertEquals(0,testnotime);
        assertEquals(1396,testhalftime-3564);
        assertEquals(1396,testalmostfulltime-3564);
        assertEquals(2816,testfulltime-7088);
    }

    @Test
    public void getstudyratiotest() throws IOException {
        PaymentImpl test = new PaymentImpl(getCalendar());

        int testfull_noratio = test.getMonthlyAmount("19970606-7973",0,100,0);
        int testhalf_noratio = test.getMonthlyAmount("19970606-7973",0,50,0);
        int testno_noratio = test.getMonthlyAmount("19970606-7973",0,0,0);

        int testfull_halfratio = test.getMonthlyAmount("19970606-7973",0,100,50);
        int testhalf_halfratio = test.getMonthlyAmount("19970606-7973",0,50,50);
        int testno_halfratio = test.getMonthlyAmount("19970606-7973",0,0,50);

        int testfull_fullratio = test.getMonthlyAmount("19970606-7973",0,100,100);        
        int testhalf_fullratio = test.getMonthlyAmount("19970606-7973",0,50,100);      
        int testno_fullratio = test.getMonthlyAmount("19970606-7973",0,0,100);   

        assertEquals(0,testfull_noratio);
        assertEquals(0,testhalf_noratio);
        assertEquals(0,testno_noratio);

        assertEquals(7088+2816,testfull_halfratio);
        assertEquals(3564+1396,testhalf_halfratio);
        assertEquals(0,testno_halfratio);

        assertEquals(7088+2816,testfull_fullratio);
        assertEquals(3564+1396,testhalf_fullratio);
        assertEquals(0,testno_fullratio);
    }
}
