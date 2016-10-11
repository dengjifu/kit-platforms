package com.kit.platforms.util;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * @author carwen
 *
 */
public class DateTimeUtils {
//	private static final Logger log = Logger.getLogger(DateTimeUtils.class);

	// string to set the date time format
	public final static String LONG_DATE_FORMAT_STRING = "yyyy-MM-dd HH:mm";
	public final static String SHORT_DATE_FORMAT_STRING = "yyyy-MM-dd";
	public final static String STRING_DATE_FORMAT_STRING = "yyyyMMddHHmmss";
	public final static String STRING_DATE_FORMAT_YYYYMMDD ="yyyyMMdd";

	// Date format instance
	public final static DateFormat DATE_FORMAT = new SimpleDateFormat(
			LONG_DATE_FORMAT_STRING);

	/**
	 * get now date
	 * 
	 * @return now date
	 */
	public static Date getNowDate() {
		return new Date();
	}

	public static String getNowDateString() {
		return DATE_FORMAT.format(new Date());
	}

	public static Date getCurrentlyDate() throws ParseException {
		return parseDate(SHORT_DATE_FORMAT_STRING, getNowDateString());
	}

	public static String parseDate(String formatString, Date date) {
		DateFormat dateFormat = new SimpleDateFormat(formatString);
		return dateFormat.format(date);
	}

	public static Date parseDate(String formatString, String date)
			throws ParseException {
		if(date != null && date.trim().length() > 0){
			DateFormat dateFormat = new SimpleDateFormat(formatString);
			return dateFormat.parse(date);
		}
		return null;
	}

	public static String getNowdataToMinite() {
		String result = getNowYear() + "";
		String month = getNowMonth() + "";
		if (month.length() < 2) {
			month = "0" + month;
		}
		String date = getTodayDate() + "";
		if (date.length() < 2) {
			date = "0" + date;
		}
		String hour = getTodayHour() + "";
		if (hour.length() < 2) {
			hour = "0" + hour;
		}
		String minute = getTodayMinute() + "";
		if (minute.length() < 2) {
			minute = "0" + minute;
		}
		result += month;
		result += date;
		result += hour;
		result += minute;
		return result;
	}

	public static int getNowYear() {
		Date nowdate = new Date();
		int year = nowdate.getYear() + 1900;
		return year;
	}

	public static int getNowMonth() {
		Date nowdate = new Date();
		int month = nowdate.getMonth() + 1;
		return month;
	}

	public static int getTodayDate() {
		Date nowdate = new Date();
		int date = nowdate.getDate();
		return date;
	}

	public static int getTodayHour() {
		Date nowdate = new Date();
		int date = nowdate.getHours();
		return date;
	}

	public static int getTodayMinute() {
		Date nowdate = new Date();
		int date = nowdate.getMinutes();
		return date;
	}

	public static Date parseFormatDate(String datestr) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = df.parse(datestr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	public static String format(Date date, String format) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				result = sdf.format(date);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 获得给定日期所在月的第一天
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date getFirstDayOfMonthByDate(Date givenDate) {
		if (givenDate == null) {
			try {
				return parseDate(SHORT_DATE_FORMAT_STRING,
						getPreviousMonthBegin());
			} catch (ParseException e) {
				return null;
			}
		} else {
			Calendar c = Calendar.getInstance();
			c.setTime(givenDate);
			c.set(Calendar.DATE, 1);// 把日期设置为当月第一天

			return c.getTime();
		}
	}

	/**
	 * 获得上月第一天的日期
	 * 
	 * @return
	 */
	public static String getPreviousMonthBegin() {
		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, -1);// 减一个月
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		return parseDate(SHORT_DATE_FORMAT_STRING, lastDate.getTime());
	}

	/**
	 * 获得给定日期所在月的最后一天
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date getLastDayOfMonthByDate(Date givenDate) {
		if (givenDate == null) {
			try {
				return parseDate(SHORT_DATE_FORMAT_STRING,
						getPreviousMonthEnd());
			} catch (ParseException e) {
				return null;
			}
		} else {
			Calendar c = Calendar.getInstance();
			c.setTime(givenDate);
			c.set(Calendar.DATE, 1);// 把日期设置为当月第一天
			c.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天

			return c.getTime();
		}
	}

	/**
	 * 获得上月最后一天的日期
	 * 
	 * @return
	 */
	public static String getPreviousMonthEnd() {
		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, -1);// 减一个月
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
		return parseDate(SHORT_DATE_FORMAT_STRING, lastDate.getTime());
	}


	private static String[] getCalendarDays(Date d) {
		int week = getFirstWeekOfMonth(d);
		int idx = week - 1;
		String[] days = new String[getLastDayIndexOfMonth(d) + idx];
		for (int i = 0; i < idx; i++) {
			days[i] = " ";
		}
		for (int i = idx; i < days.length; i++) {
			days[i] = String.valueOf(i - idx + 1);
		}
		return days;
	}

	public static int getLastDayIndexOfMonth(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.set(Calendar.DATE, 1);
		c.roll(Calendar.DATE, -1);
		return c.get(Calendar.DATE);
	}
	/***
	 * 得到dateStr之后afterDateNum天的日期格式,
	   afterDateNum>0表示之后afterDateNum天,
	   afterDateNum<0表示之前afterDateNum天
	 * @param dateStr
	 * @param afterDateNum
	 * @return
	 */
	
	public static  String getDateStrAfterNowDate(String dateStr,int afterDateNum)throws Exception{
		   SimpleDateFormat sd=new SimpleDateFormat("yyyyMMdd");
		   Date dataday=sd.parse(dateStr);
		   Calendar cal = Calendar.getInstance();
		   cal.setTime(dataday);
		   cal.add(Calendar.DATE, afterDateNum);
		   return sd.format(cal.getTime());
	}
	public static Date getFirstDayOfMonth(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.set(Calendar.DATE, 1);
		return c.getTime();
	}

	public static int getFirstWeekOfMonth(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.set(Calendar.DATE, 1);
		return c.get(Calendar.DAY_OF_WEEK);
	}

	public static Date getAroundDate(Date date, int field, int number) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(field, number);
		return c.getTime();
	}

	public static boolean isInSameMonth(Date date1, Date date2) {
		Calendar c = Calendar.getInstance();
		c.setTime(date1);

		int y1 = c.get(Calendar.YEAR);
		int m1 = c.get(Calendar.MONTH);

		c.setTime(date2);

		int y2 = c.get(Calendar.YEAR);
		int m2 = c.get(Calendar.MONTH);

		return (y1 == y2 && m1 == m2);
	}

	public static boolean isWeekend(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY;
	}

	/**
	 * 调整时间到当天的第0秒
	 * 
	 * @param date
	 * @return
	 */
	public static Date resetToStart(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

	/**
	 * 调整时间到当天的最后一秒
	 * 
	 * @param date
	 * @return
	 */
	public static Date resetToEnd(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		return c.getTime();
	}

	public static Date getFirstDateOfWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.setFirstDayOfWeek(Calendar.SUNDAY);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
		return c.getTime();
	}

	public static Date getLastDateOfWeek(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.setFirstDayOfWeek(Calendar.SUNDAY);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6);
		return c.getTime();
	}

	public static int compare(Date date1, Date date2) {
		if(date1.getTime()>date2.getTime()){
			return 1;
		}else{
			return -1;
		}
	}

	public static Date getSpecificDateFromToday(Date date, int interval) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + interval);
		return c.getTime();
	}

	public static Date getSpecificHourFromToday(Date date, int interval) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, c.get(Calendar.HOUR_OF_DAY) + interval);
		return c.getTime();
	}

	public static Date getSpecificMonthFromToday(Date date, int interval) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.MONTH, c.get(Calendar.MONTH) + interval);
		return c.getTime();
	}
	
	public static Long getCurrentDateToLong(){
		SimpleDateFormat sdf = new SimpleDateFormat(STRING_DATE_FORMAT_STRING);
		String result = sdf.format(new Date());
		return Long.parseLong(result);
	}
	
	public static String getDateYYYYmmdd(){
		DateFormat dateFormat = new SimpleDateFormat(STRING_DATE_FORMAT_YYYYMMDD);
		return dateFormat.format(new Date());
	}

//	public static void main(String[] args) throws ParseException {
////		Calendar c = Calendar.getInstance();
////		c.setFirstDayOfWeek(Calendar.MONDAY);
////		c.setTime(new Date());
////		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
////		System.out.println(c.getTime().toString());
//		DateFormat dateFormat = new SimpleDateFormat(STRING_DATE_FORMAT_YYYYMMDD);
//		dateFormat.format(new Date());
//		System.out.println(dateFormat.format(new Date()));
//	}

}
