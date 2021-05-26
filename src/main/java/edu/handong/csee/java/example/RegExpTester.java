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
		
		String pattern = "-+\\s([0-9]+).\\s([0-9]+).\\s([0-9]+).\\s-+";
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
		
		pattern = "([0-9]+):([0-9]+)";
		r = Pattern.compile(pattern);
		m = r.matcher(myStringToParse2);
		
		int hour = 0;
		int minute = 0;
		
		if(m.find()) {
			hour = Integer.parseInt(m.group(1));
			minute = Integer.parseInt(m.group(2));
		}
		
		System.out.println(String.format("%02d", hour) + ":" + String.format("%02d", minute));
		
		String[] lines = {"[Student] [오전 7:16] Yes I think so..",
				"[JC] [오전 8:24] Yes, I think so too. Private variables are created when we call super. But I'm not sure if two instances are created. Some developer said that one instance is created. https://stackoverflow.com/questions/9005851/does-an-instance-of-superclass-get-created-when-we-instantiate-an-object?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa but I think two instances are created but they are directly connected. Instance of subclass can't directly access private members in superclass. You may write some code to check it. It's interesting discussion. Thanks!"};
		
		pattern ="\\[(.+)\\]\\s\\[..\\s([0-9]+:[0-9]+)\\]\\s(.+)";
		r = Pattern.compile(pattern);
		for(String line:lines) {
			m = r.matcher(line);
			
			String name = "";
			String time = "";
			String strMessage = "";
			
			if(m.find()) {
				name = m.group(1);
				time = m.group(2);
				strMessage = m.group(3);
				
				System.out.println("name=" + name);
				System.out.println("time=" + time);
				System.out.println("strMessage=" + strMessage);
			}
		}
	}

}
