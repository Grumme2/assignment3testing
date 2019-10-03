//"student100loan=7088\nstudent100subsidy=2816\nstudent50loan=3564\nstudent50subsidy=1396\nstudent0loan=0\nstudent0subsidy=0\nfulltimeIncome=85813\nparttimeIncome=128722\n";


package ltu;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import ltu.testtimeclass;


import static ltu.CalendarFactory.getCalendar;
import static org.junit.Assert.*;

import java.beans.Transient;
import java.io.IOException;
import java.util.Date;
import java.util.zip.ZipError;

import org.junit.Test;

public class PaymentTest{
    int fullloan = 7088;
    int halfloan = 3564;
    int zero = 0;
    int fullsubs = 2816;
    int halfsubs = 1396;
    int fulltime = 85813;
    int parttime = 128722;

    // @Test
    // public void testSilly()
    // {
        // assertEquals(1, 1);
        // assertEquals(4, 4);
        // 
        // 
    // }
    // @Test
    // public void testsilly2(){
        // assertEquals(1, 1);
    // }

    @Test
    public void getpaymentamounttestage() throws IOException{
        PaymentImpl payment;
        payment = new PaymentImpl(getCalendar());

        boolean thrownpid= false;
        boolean throwncomp=false; 
        boolean thrownmoney= false;
        boolean thrownrate = false;

        try {
                payment.getMonthlyAmount(null, 900, 100, 100);
        } catch (IllegalArgumentException e) {
                thrownpid = true;
        }
        try {
                payment.getMonthlyAmount("19990505-0000", -5, 100, 100);
        } catch (IllegalArgumentException e) {
                thrownmoney = true;
        }
        try {
                payment.getMonthlyAmount("19990505-0000", 900, -3, 100);
        } catch (IllegalArgumentException e) {
                thrownrate = true;
        }
        try {
                payment.getMonthlyAmount("19990505-0000", 900, 100, -2);
        } catch (IllegalArgumentException e) {
                throwncomp = true;
        }

        assertTrue("thrownpid",thrownpid);
        assertTrue("thrownmoney", thrownmoney);
        assertTrue("thrownrate", thrownrate);
        assertTrue("throwncomp", throwncomp);

        for(int i = 0; i<100; i++){
            int yearborn =  2019-i;
            String yearstring = Integer.toString(yearborn) + "1001-0000";

            if (i<20) {
                 assertEquals(zero,payment.getMonthlyAmount(yearstring, 19900, 100, 100));
            }else if (i<47){
                 assertEquals(fullloan+fullsubs,payment.getMonthlyAmount(yearstring, 19900, 100, 100));
            }else if (i<= 56){
                 assertEquals(zero+fullsubs,payment.getMonthlyAmount(yearstring, 19900, 100, 100));
            }else{
                 assertEquals(zero,payment.getMonthlyAmount(yearstring, 19900, 100, 100));
            }

        }

        // int yearborn19 =  2019-19;
        // String yearstring19 = Integer.toString(yearborn19) + "1001-0000";
// 
        // int yearborn20 =  2019-20;
        // String yearstring20 = Integer.toString(yearborn20) + "1001-0000";
// 
        // int yearborn21 =  2019-21;
        // String yearstring21 = Integer.toString(yearborn21) + "1001-0000";
// 
        // int yearborn46 =  2019-46;
        // String yearstring46 = Integer.toString(yearborn46) + "1001-0000";
// 
        // int yearborn47 =  2019-47;
        // String yearstring47 = Integer.toString(yearborn47) + "1001-0000";
// 
        // int yearborn48 =  2019-48;
        // String yearstring48 = Integer.toString(yearborn48) + "1001-0000";
// 
        // int yearborn55 =  2019-55;
        // String yearstring55 = Integer.toString(yearborn55) + "1001-0000";
// 
        // int yearborn56 =  2019-56;
        // String yearstring56 = Integer.toString(yearborn56) + "1001-0000";
// 
        // int yearborn57 =  2019-57;
        // String yearstring57 = Integer.toString(yearborn57) + "1001-0000";
// 
        // assertEquals(zero,payment.getMonthlyAmount(yearstring19, 19900, 100, 100));
        // assertEquals(fullloan+fullsubs,payment.getMonthlyAmount(yearstring20, 19900, 100, 100));
        // assertEquals(fullloan+fullsubs,payment.getMonthlyAmount(yearstring21, 19900, 100, 100));
        // assertEquals(fullloan+fullsubs,payment.getMonthlyAmount(yearstring46, 19900, 100, 100));
        // assertEquals(zero+fullsubs,payment.getMonthlyAmount(yearstring47, 19900, 100, 100));
        // assertEquals(zero+fullsubs,payment.getMonthlyAmount(yearstring48, 19900, 100, 100));
        // assertEquals(fullsubs,payment.getMonthlyAmount(yearstring55, 19900, 100, 100));
        // assertEquals(fullsubs,payment.getMonthlyAmount(yearstring56, 19900, 100, 100));
        // assertEquals(zero,payment.getMonthlyAmount(yearstring57, 19900, 100, 100));
// 
    }

    @Test
    public void incomeWhileStudyingRequierments() throws IOException{
        PaymentImpl payment;
        payment = new PaymentImpl(getCalendar());

        for (int i = 0; i<150000; i++){
                if (i <= fulltime){
                        assertEquals(fullloan+fullsubs,payment.getMonthlyAmount("19970808-0000", i, 100, 100));
                } else{
                        assertEquals(zero,payment.getMonthlyAmount("19970808-0000", i, 100, 100));       
                }

                if (i<=parttime){
                        assertEquals(halfloan+halfsubs,payment.getMonthlyAmount("19970808-0000", i, 50, 100));
                }else {
                        assertEquals(zero,payment.getMonthlyAmount("19970808-0000", i, 50, 100));
                }
        }

        // assertEquals(fullloan+fullsubs,payment.getMonthlyAmount("19970808-0000", fulltime-10, 100, 100));
        // assertEquals(fullloan+fullsubs,payment.getMonthlyAmount("19970808-0000", fulltime, 100, 100));
        // assertEquals(zero,payment.getMonthlyAmount("19970808-0000", fulltime+10, 100, 100));
        // assertEquals(halfloan+halfsubs,payment.getMonthlyAmount("19970808-0000", parttime-10, 50, 100));
        // assertEquals(halfloan+halfsubs,payment.getMonthlyAmount("19970808-0000", parttime, 50, 100));
        // assertEquals(zero,payment.getMonthlyAmount("19970808-0000", parttime+10, 50, 100));
        //assertEquals(zero,payment.getMonthlyAmount("19970808-0000", fulltime, 100, 100));

    }

    @Test
    public void timetest() throws IOException{
        //testtimeclass testtime;
        PaymentImpl payment;
        ICalendar calendar = getCalendar("ltu.testtimeclass");
        // payment = new PaymentImpl(calendar);
// 
        

        // DateFormat format = new SimpleDateFormat("yyyyMMdd");
        // Calendar cal = Calendar.getInstance();    
        // cal.setTime(calendar.getDate());
        // cal.add(Calendar.YEAR,-3);
        // cal.add(Calendar.MONTH,-9);
        // cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        // 
// 
        // int weekDay = cal.get(Calendar.DAY_OF_WEEK);
        // if (weekDay == Calendar.SUNDAY)
        // {      // payment = new PaymentImpl(calendar);
// 
        

        // DateFormat format = new SimpleDateFormat("yyyyMMdd");
        // Calendar cal = Calendar.getInstance();    
        // cal.setTime(calendar.getDate());
        // cal.add(Calendar.YEAR,-3);
        // cal.add(Calendar.MONTH,-9);
        // cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        // 
// 
        // int weekDay = cal.get(Calendar.DAY_OF_WEEK);
        // if (weekDay == Calendar.SUNDAY)
        // {
        //     cal.add(Calendar.DATE, -2);
// 
        // } else if (weekDay == Calendar.SATURDAY)
        // {
        //     cal.add(Calendar.DATE, -1);
        //     format.format(cal.getTime());
        // }
        // ICalendar calen = (ICalendar) cal;
        //     cal.add(Calendar.DATE, -2);
// 
        // } else if (weekDay == Calendar.SATURDAY)
        // {
        //     cal.add(Calendar.DATE, -1);
        //     format.format(cal.getTime());
        // }
        // ICalendar calen = (ICalendar) cal;
        payment = new PaymentImpl(calendar);

        assertEquals("20160129", payment.getNextPaymentDay());

        assertEquals("20160229", payment.getNextPaymentDay());


        // assertEquals("20160129", payment.getNextPaymentDay());   // "20160129" "Fri Jan 29"
        // assertEquals("20160229", payment.getNextPaymentDay());  // "20160229" "Mon Feb 29"
        assertEquals("20160331", payment.getNextPaymentDay());   // "20160331" "Thu Mar 31"
        assertEquals("20160429", payment.getNextPaymentDay());  //" 20160429" "Fri Apr 29"
        assertEquals("20160531", payment.getNextPaymentDay());   // "20160531" "Tue May 31"
        assertEquals("20160630", payment.getNextPaymentDay());   // "20160631" "Thu Jun 31"

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


}
