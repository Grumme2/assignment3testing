//"student100loan=7088\nstudent100subsidy=2816\nstudent50loan=3564\nstudent50subsidy=1396\nstudent0loan=0\nstudent0subsidy=0\nfulltimeIncome=85813\nparttimeIncome=128722\n";


package ltu;
import static ltu.CalendarFactory.getCalendar;
import static org.junit.Assert.*;

import java.beans.Transient;
import java.io.IOException;
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

        int yearborn19 =  2019-19;
        String yearstring19 = Integer.toString(yearborn19) + "1001-0000";

        int yearborn20 =  2019-20;
        String yearstring20 = Integer.toString(yearborn20) + "1001-0000";

        int yearborn21 =  2019-21;
        String yearstring21 = Integer.toString(yearborn21) + "1001-0000";

        int yearborn46 =  2019-46;
        String yearstring46 = Integer.toString(yearborn46) + "1001-0000";

        int yearborn47 =  2019-47;
        String yearstring47 = Integer.toString(yearborn47) + "1001-0000";

        int yearborn48 =  2019-48;
        String yearstring48 = Integer.toString(yearborn48) + "1001-0000";

        int yearborn55 =  2019-55;
        String yearstring55 = Integer.toString(yearborn55) + "1001-0000";

        int yearborn56 =  2019-56;
        String yearstring56 = Integer.toString(yearborn56) + "1001-0000";

        int yearborn57 =  2019-57;
        String yearstring57 = Integer.toString(yearborn57) + "1001-0000";

        assertEquals(zero,payment.getMonthlyAmount(yearstring19, 19900, 100, 100));
        assertEquals(fullloan+fullsubs,payment.getMonthlyAmount(yearstring20, 19900, 100, 100));
        assertEquals(fullloan+fullsubs,payment.getMonthlyAmount(yearstring21, 19900, 100, 100));
        assertEquals(fullloan+fullsubs,payment.getMonthlyAmount(yearstring46, 19900, 100, 100));
        assertEquals(zero+fullsubs,payment.getMonthlyAmount(yearstring47, 19900, 100, 100));
        assertEquals(zero+fullsubs,payment.getMonthlyAmount(yearstring48, 19900, 100, 100));
        assertEquals(fullsubs,payment.getMonthlyAmount(yearstring55, 19900, 100, 100));
        assertEquals(fullsubs,payment.getMonthlyAmount(yearstring56, 19900, 100, 100));
        assertEquals(zero,payment.getMonthlyAmount(yearstring57, 19900, 100, 100));

    }

    @Test
    public void incomeWhileStudyingRequierments(){
        PaymentImpl payment;
        payment = new PaymentImpl(getCalendar());

        assertEquals(zero,payment.getMonthlyAmount("19990808-0000", 19900, 100, 100));


        
    }

}
