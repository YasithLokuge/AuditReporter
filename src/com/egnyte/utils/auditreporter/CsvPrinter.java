package com.egnyte.utils.auditreporter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CsvPrinter {	
	
	List<String> output = new ArrayList<String>();		
	List<Record> records = new ArrayList<Record>();
	
	public CsvPrinter(List<List<String>> users, List<List<String>> files) {	
		
		for (List<String> userRow : users) {
			long userId = Long.parseLong(userRow.get(0));
			String userName = userRow.get(1);

			
			for (List<String> fileRow : files) {
				//String fileId = fileRow.get(0);
				long size = Long.parseLong(fileRow.get(1));
				String fileName = fileRow.get(2);
				long ownerUserId = Long.parseLong(fileRow.get(3));
				if (ownerUserId == userId) {					
					output.add(userName+","+fileName+","+size+"\r\n");	
					Record record = new Record(userName, fileName, size);
					records.add(record);
				}
			}
		}		
	}
	
	public void print() {		
		writeToFile(output);		
	}
	
	public void printTop(int number) {
		output.clear();
		Collections.sort(records);	
		int i = 1;
		if(number > records.size())
			number = records.size();
		
		for (Record record : records) {
			
			if(i > number)
				break;
			
			output.add(record.getFileName()+","+record.getUserName()+","+record.getFileSize()+"\r\n");
			i++;
		}
		writeToFile(output);
	}

	private void writeToFile(List<String> records) {
		
		File file = new File("resources/output.csv");
		FileWriter fw;
		
		try {

			if (!file.exists()) {
				file.createNewFile();
			}

			fw = new FileWriter(file.getAbsoluteFile());

			for (String record : records) {				
				fw.write(record);
			}

			BufferedWriter bw = new BufferedWriter(fw);			
			bw.close();
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
