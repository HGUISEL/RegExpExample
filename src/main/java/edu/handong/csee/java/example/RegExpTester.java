package edu.handong.csee.java.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpTester {

	public static void main(String[] args) {
		RegExpTester tester = new RegExpTester();
		tester.run();
	}

	private void run() {
		String myStringToParse = "-------- 2018년 5월 21일 --------";
		
		String pattern = "([0-9]+).\\s([0-9]+).\\s([0-9]+)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(myStringToParse);

		int year = 0;
		int month = 0;
		int day = 0;
		if (m.find()) {
		
			year = Integer.parseInt(m.group(1));
			month = Integer.parseInt(m.group(2));
			day = Integer.parseInt(m.group(3));
		}
			
		System.out.println(year + "-" + String.format("%02d", month) + "-" + day);
		
		
		String myStringToParse2 = "[오전 9:01]";
		
		pattern = "(.{2})\\s([0-9]+):([0-9]+)";
		r = Pattern.compile(pattern);
		m = r.matcher(myStringToParse2);
		
		String ampm = "";
		String hour = "";
		String min = "";
		if (m.find()) {
			ampm = m.group(1);
			hour = m.group(2);
			min = m.group(3);
			
		}
		
		System.out.println(ampm + " " + hour + " " + min);
		
		String myStringToParse3 = "[9:01 AM]";
	}

}
