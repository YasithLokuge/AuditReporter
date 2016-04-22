package com.egnyte.utils.auditreporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlainTextPrinter {
			
	List<Record> records = new ArrayList<Record>();
	
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
	
	private void printHeader() {
		System.out.println("Audit Report");
		System.out.println("============");
	}
	
	private void printTopHeader(int number) {
		System.out.println("Top #"+number+" Report");
		System.out.println("==================");
	}

	private void printUserHeader(String userName) {
		System.out.println("## User: " + userName);
	}

	private void printFile(String fileName, long fileSize) {
		System.out.println("* " + fileName + " ==> " + fileSize + " bytes");
	}

}
