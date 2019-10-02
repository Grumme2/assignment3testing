package ltu;

import java.util.Calendar;
import java.util.Date;

public class testtimeclass implements ICalendar
{	Calendar calendar;
	@Override
	public Date getDate() {
		if (calendar == null){
        	Calendar cal = Calendar.getInstance();
        	cal.add(Calendar.YEAR, -3);
			cal.add(Calendar.MONTH,-9);
			calendar = cal;
			Date time = cal.getTime();
			increase();
			return time;
		}
		Date time = calendar.getTime();
		increase();
		return time;

	}

	public void increase(){
		calendar.add(Calendar.MONTH,+1);
	} 
}