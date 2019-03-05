package com.customermgmt.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	private static final String DATE_FORMAT = "dd-mm-yyyy";
	public static Date buildDateObjFromStringDate(String strDate) throws Exception{
		return new SimpleDateFormat(DATE_FORMAT).parse(strDate);
	}
}
