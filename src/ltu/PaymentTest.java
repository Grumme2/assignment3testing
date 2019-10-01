package ltu;

import static ltu.CalendarFactory.getCalendar;
import static org.junit.Assert.*;

import java.beans.Transient;
import java.io.IOException;

import java.text.*;
import java.util.*;

import org.junit.Test;

public class PaymentTest {
    @Test
    public void testSilly() {
        assertEquals(1, 1);
        assertEquals(4, 4);

    }

    @Test
    public void testsilly2() {
        assertEquals(1, 1);
    }

    @Test
    public void getpaymentamounttest() throws IOException {

        PaymentImpl payment;
        payment = new PaymentImpl(getCalendar());
        assertEquals(9904, payment.getMonthlyAmount("19970606-7973", 19900, 100, 100));
    }

    @Test
    public void getstudyamounttest() throws IOException {
        PaymentImpl test = new PaymentImpl(getCalendar());
        int testnotime = test.getMonthlyAmount("19970606-7973", 0, 0, 100);
        int testhalftime = test.getMonthlyAmount("19970606-7973", 0, 50, 100);
        int testalmostfulltime = test.getMonthlyAmount("19970606-7973", 0, 99, 100);
        int testfulltime = test.getMonthlyAmount("19970606-7973", 0, 100, 100);
        assertEquals(0, testnotime);
        assertEquals(1396, testhalftime - 3564);
        assertEquals(1396, testalmostfulltime - 3564);
        assertEquals(2816, testfulltime - 7088);
    }

    @Test
    public void getstudyratiotest() throws IOException {
        PaymentImpl test = new PaymentImpl(getCalendar());

        int testfull_noratio = test.getMonthlyAmount("19970606-7973", 0, 100, 0);
        int testhalf_noratio = test.getMonthlyAmount("19970606-7973", 0, 50, 0);
        int testno_noratio = test.getMonthlyAmount("19970606-7973", 0, 0, 0);

        int testfull_halfratio = test.getMonthlyAmount("19970606-7973", 0, 100, 50);
        int testhalf_halfratio = test.getMonthlyAmount("19970606-7973", 0, 50, 50);
        int testno_halfratio = test.getMonthlyAmount("19970606-7973", 0, 0, 50);

        int testfull_fullratio = test.getMonthlyAmount("19970606-7973", 0, 100, 100);
        int testhalf_fullratio = test.getMonthlyAmount("19970606-7973", 0, 50, 100);
        int testno_fullratio = test.getMonthlyAmount("19970606-7973", 0, 0, 100);

        assertEquals(0, testfull_noratio);
        assertEquals(0, testhalf_noratio);
        assertEquals(0, testno_noratio);

        assertEquals(7088 + 2816, testfull_halfratio);
        assertEquals(3564 + 1396, testhalf_halfratio);
        assertEquals(0, testno_halfratio);

        assertEquals(7088 + 2816, testfull_fullratio);
        assertEquals(3564 + 1396, testhalf_fullratio);
        assertEquals(0, testno_fullratio);
    }

    @Test
    public void getamounttest() throws IOException {
        PaymentImpl test = new PaymentImpl(getCalendar());

        int loantest_fulltime = test.getMonthlyAmount("19970606-7973", 0, 100, 100);
        int loantest_almostfulltime = test.getMonthlyAmount("19970606-7973", 0, 99, 100);
        int loantest_halftime = test.getMonthlyAmount("19970606-7973", 0, 50, 100);
        int loantest_almosthalftime = test.getMonthlyAmount("19970606-7973", 0, 49, 100);
        int loantest_notime = test.getMonthlyAmount("19970606-7973", 0, 0, 100);

        assertEquals(7088, loantest_fulltime - 2816);
        assertEquals(3564, loantest_almostfulltime - 1396);
        assertEquals(3564, loantest_halftime - 1396);
        assertEquals(0, loantest_almosthalftime);
        assertEquals(0, loantest_notime);

        for (int i = 0; i <= 100; i++) {
            int looptest = test.getMonthlyAmount("19970606-7973", 0, i, 100);
            if (i < 50) {
                assertEquals(0, looptest);
            } else if (i < 100) {
                assertEquals(3564, looptest - 1396);
            } else {
                assertEquals(7088, looptest - 2816);
            }
        }
    }

    @Test
    public void getpaydaytest() throws IOException {
        ICalendar cal = getCalendar();
        PaymentImpl test2 = new PaymentImpl(cal);

        String firstpayment = test2.getNextPaymentDay();
        String secondpayment = test2.getNextPaymentDay();
        String thirdpayment = test2.getNextPaymentDay();
        String fourthpayment = test2.getNextPaymentDay();
        String fifthpayment = test2.getNextPaymentDay();
        String sixthpayment = test2.getNextPaymentDay();

        assertEquals("20160129", firstpayment);   // "20160129" "Fri Jan 29"
        assertEquals("20160229", secondpayment);  // "20160229" "Mon Feb 29"
        assertEquals("20160331", thirdpayment);   // "20160331" "Thu Mar 31"
        assertEquals("20160429", fourthpayment);  //" 20160429" "Fri Apr 29"
        assertEquals("20160531", fifthpayment);   // "20160531" "Tue May 31"
        assertEquals("20160631", sixthpayment);   // "20160631" "Thu Jun 31"
    }
}
