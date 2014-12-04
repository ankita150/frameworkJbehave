package com.framework.project.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Level;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;


public class Logs {

	static{
		//		DOMConfigurator.configure("log4j.xml");//for configuring the xml location


	}


	final static Logger log= Logger.getLogger(Logs.class.getName());

	public static void info(String message){

		log.info(message);
	}

	public static void error(String message)
	{
		log.error(message);
	}

	public static void fatal(String message){
		log.fatal(message);
	}

	public static void warn(String message){
		log.warn(message);
	}

	public static void trace(String message){
		log.trace(message);
	}
	public static void debug(String message){
		log.debug(message);
	}

	public static void log4j(String fileName,String filepath){
		//SimpleDateFormat will format the name of file in the pattern we want
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = new Date();
		String modifyDate= formatter.format(date);
		System.out.println(filepath);
		String logFileName = filepath+fileName+modifyDate+".log";
		Logger rootLogger = Logger.getRootLogger();
		rootLogger.setLevel(Level.INFO);

		//Define log pattern layout
		PatternLayout layout = new PatternLayout("%d{ISO8601} [%t] %-5p %c %x - %m%n");

		//Add console appender to root logger
		rootLogger.addAppender(new ConsoleAppender(layout));
		try
		{
			//Define file appender with layout and output log file name
			//RollongFileAppender generates every time a new file
			RollingFileAppender fileAppender = new RollingFileAppender(layout, logFileName);

			//Add the appender to root logger
			rootLogger.addAppender(fileAppender);
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}



