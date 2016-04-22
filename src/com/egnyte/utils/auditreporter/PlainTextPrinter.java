package com.egnyte.utils.auditreporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * The Class PlainTextPrinter.
 * @author Yasith Lokuge
 */
public class PlainTextPrinter {
			
	/** The records. */
	List<Record> records = new ArrayList<Record>();
	
	/**
	 * Instantiates a new plain text printer.
	 *
	 * @param users the users
	 * @param files the files
	 */
	public PlainTextPrinter(List<List<String>> users, List<List<String>> files) {
		
		for (List<String> userRow : users) {
			long userId = Long.parseLong(userRow.get(0));
			String userName = userRow.get(1);
			
			for (List<String> fileRow : files) {
				//String fileId = fileRow.get(0);
				long size = Long.parseLong(fileRow.get(1));
				String fileName = fileRow.get(2);
				long ownerUserId = Long.parseLong(fileRow.get(3));
				
				if (ownerUserId == userId) {					
					
					Record record = new Record(userName, fileName, size);
					records.add(record);
				}
			}
		}
	}

	/**
	 * Prints the top.
	 *
	 * @param number the number
	 */
	public void printTop(int number){
		
		
		Collections.sort(records);	
		printTopHeader(number);
		int i = 1;
		
		if(number > records.size())
			number = records.size();
		
		for (Record record : records) {					
			
			if(i > number)
				break;
			
			printFile(record.getFileName(), record.getFileSize());
			i++;
		}
	}
	
	/**
	 * Prints the.
	 */
	public void print(){
		printHeader();
		String user = "";
		for (Record record : records) {
			
			if(!user.equals(record.getUserName())){
				printUserHeader(record.getUserName());								
			}

			user = record.getUserName();
			printFile(record.getFileName(), record.getFileSize());
		}
	}
	
	/**
	 * Prints the header.
	 */
	private void printHeader() {
		System.out.println("Audit Report");
		System.out.println("============");
	}
	
	/**
	 * Prints the top header.
	 *
	 * @param number the number
	 */
	private void printTopHeader(int number) {
		System.out.println("Top #"+number+" Report");
		System.out.println("==================");
	}

	/**
	 * Prints the user header.
	 *
	 * @param userName the user name
	 */
	private void printUserHeader(String userName) {
		System.out.println("## User: " + userName);
	}

	/**
	 * Prints the file.
	 *
	 * @param fileName the file name
	 * @param fileSize the file size
	 */
	private void printFile(String fileName, long fileSize) {
		System.out.println("* " + fileName + " ==> " + fileSize + " bytes");
	}

}
