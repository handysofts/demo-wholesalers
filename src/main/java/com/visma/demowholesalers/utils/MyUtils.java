package com.visma.demowholesalers.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


/**
 * General Utility Methods
 */
public class MyUtils {

    private static Logger logger = LoggerFactory.getLogger(MyUtils.class);
	public static Random randomizer = new Random();

    /**
     * Get Requester's IP address
     *
     * @param req
     * @return
     */
	public static String getIPAddress(HttpServletRequest req) {
		String ipAddress = req.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null)
			ipAddress = req.getRemoteAddr();
		
		return ipAddress;
	}

	
	
	
	/**
	 * Check is Uploaded file is image or not
	 * 
	 * @param file
	 * @return
	 */
	public static boolean isImage(MultipartFile file){
		return file.getContentType().indexOf("image/") > -1;
	}
	
	
	
	
	
	
	/**
	 * Generate unique Thread Name using passed param + Current Time + Random number
	 * 
	 * @param param - any text
	 * @return unique name for thread
	 */
	public static String getUniqueThreadName(String param){
		return getUniqueThreadName(param, "_");
	}

	public static String getUniqueThreadName(String param, String splitter){
		String template = "%s"+splitter+"%d"+splitter+"%d";
		return String.format(template, param, System.currentTimeMillis(), randomizer.nextInt(9999999));
	}


    /**
     * Change time as minus 1 day, minus 20 hour, minus 5 min and etc.
     *
     * @param date
     * @param calendarUnit
     * @param count
     * @return changed date or passed date in case of error
     */
    public static Date changeTime(Date date, int calendarUnit, int count)  {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(calendarUnit, count);
            return cal.getTime();
        }catch (Exception e){
            logger.error("There was an error while changing date|time", e);
            return date;
        }
    }

}
