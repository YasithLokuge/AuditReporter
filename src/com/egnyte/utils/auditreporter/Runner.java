package com.egnyte.utils.auditreporter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 * The Class Runner.
 * @author Yasith Lokuge
 */
public class Runner {

	/** The users. */
	private static List<List<String>> users;
	
	/** The files. */
	private static List<List<String>> files;

	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		Runner r = new Runner();
		
		if(args.length < 2){
			System.out.println("Insufficient Arguments, please enter two files");
			System.out.println("command format: [OPTIONS] USERS_FILENAME RESOURCE_FILENAME");
			System.out.println("----------------------------------------------------------");
			System.out.println("Options : ");
			System.out.println("--top n : print n-largest files sorted by size ");
			System.out.println("-c      : print the report in csv instead of plain text");
			
		}else{
			
			Processor processorObject = new Processor();	
			Args argsObject = processorObject.Process(args);
			r.loadData(argsObject.getUsersFilename(), argsObject.getResourceFilename());
			
			
			
			if(argsObject.isCsvAcive()){
				
				CsvPrinter csvPrinter = new CsvPrinter(users, files);
				
				if(argsObject.isTopActive()){
					csvPrinter.printTop(argsObject.getTopValue());					
				}else{
					csvPrinter.print();
				}
				
			}else{
				
				PlainTextPrinter plainTextPrinter = new PlainTextPrinter(users, files);

				if(argsObject.isTopActive()){
					plainTextPrinter.printTop(argsObject.getTopValue());
				}else{
					plainTextPrinter.print();
				}				
			}

			
			
		}
		
	}	
	
	/**
	 * Load data.
	 *
	 * @param userFn the user fn
	 * @param filesFn the files fn
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void loadData(String userFn, String filesFn) throws IOException {
		String line;

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(userFn));
			users = new ArrayList<List<String>>();

			reader.readLine(); // skip header

			while ((line = reader.readLine()) != null) {
				users.add(Arrays.asList(line.split(",")));
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

		reader = null;
		try {
			reader = new BufferedReader(new FileReader(filesFn));
			files = new ArrayList<List<String>>();

			reader.readLine(); // skip header

			while ((line = reader.readLine()) != null) {
				files.add(Arrays.asList(line.split(",")));
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}	
}
