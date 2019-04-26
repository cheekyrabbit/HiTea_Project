package com.ht.hitea.teabag.tb.calendar;

import java.util.List;

public interface TeabagCalendarMapper {
	public abstract int writeCalendar(Calendar c);
	public abstract List<Calendar> getCalendarByTNo(Calendar c);
	public abstract int deleteCalendarByNo(Calendar c);
}
