package com.pol.bss.pol_bss_automationtest.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.apache.commons.lang3.tuple.Pair;

public class DatesUtils {

    public Calendar calendar;

    public DatesUtils() {

    }

    public long getCurrentSecondsOnOTP() {
        calendar = GregorianCalendar.getInstance(TimeZone.getTimeZone("UTC"));
        long currentTimeSeconds = calendar.getTimeInMillis() / 1000;
        return currentTimeSeconds % 30;
    }

	/**
	 * Calculates a date range from the @dayBack back to @months months
	 * 
	 * @param months  months back to calculate the range
	 * @param dayBack day from which to calculate the range.
	 * @return a DatesPair extends @see <a href=
	 *         "https://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/tuple/Pair.html">org.apache.commons.lang3.tuple.Pair</a>
	 */
	public static DatesPair dateRangeMonths(Integer months, String dayBack) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime dateTime;
		if (dayBack.trim().equalsIgnoreCase("yesterday")) {
			dateTime = LocalDateTime.now().minusDays(1);
		} else {
			dateTime = LocalDateTime.parse(dayBack, formatter);
		}
		LocalDateTime dateTo = dateTime;
		LocalDateTime dateFrom = dateTime.minusMonths(months);
		return new DatesPair(dateFrom, dateTo);
	}

	/**
	 * Parses a date in string with a given format
	 * 
	 * @param date: date to parsed
	 * @param format: specific format to parse the string
	 * @return LocalDateTime parsed.
	 */
	public static LocalDateTime parse(String date, String format) {
		return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(format));
	}

	/**
	 * Parses a date in string with ISO Date time format.
	 * 
	 * @param date: date to parsed
	 * @return LocalDateTime parsed.
	 */
	public static LocalDateTime parse(String date) {
		return parse(date, DateTimeFormatter.ISO_DATE_TIME.toString());
	}

	/**
	 * Converts a LocalDateTime into a Date
	 * 
	 * @param local: LocalDateTime to be converted.
	 * @return Date converted
	 */
	public static Date asDate(LocalDateTime local) {
		return Date.from(local.atZone(ZoneId.systemDefault()).toInstant());
	}

	public static class DatesPair extends Pair<LocalDateTime, LocalDateTime> {

		private static final long serialVersionUID = 1L;
		LocalDateTime dateTo;
		LocalDateTime dateFrom;

		public DatesPair() {
			super();
		}

		public DatesPair(LocalDateTime dateFrom, LocalDateTime dateTo) {
			super();
			this.dateTo = dateTo;
			this.dateFrom = dateFrom;
		}

		@Override
		public LocalDateTime setValue(LocalDateTime arg0) {
			return null;
		}

		/**
		 * Returns de "from" part of the range
		 */
		@Override
		public LocalDateTime getLeft() {
			return this.dateFrom;
		}

		/**
		 * Returns de "to" part of the range
		 */
		@Override
		public LocalDateTime getRight() {
			return this.dateTo;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + ((dateFrom == null) ? 0 : dateFrom.hashCode());
			result = prime * result + ((dateTo == null) ? 0 : dateTo.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			DatesPair other = (DatesPair) obj;
			if (dateFrom == null) {
				if (other.dateFrom != null)
					return false;
			} else if (!dateFrom.equals(other.dateFrom)) {				
				return false;
			}
			if (dateTo == null) {
				if (other.dateTo != null)
					return false;
			} else if (!dateTo.equals(other.dateTo)) {				
				return false;
			}
			return true;
		}
		
		

	}
}
