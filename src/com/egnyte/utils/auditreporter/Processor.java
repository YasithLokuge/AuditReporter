package com.egnyte.utils.auditreporter;

import java.util.ArrayList;
import java.util.Arrays;

public class Processor {
	
	private static final String TOP_ARGUMENT = "--top";
	private static final String CSV_ARGUMENT = "-c";
	

	public Args Process(String[] args){	
		
		Args argsObject = new Args();
		ArrayList<String> argsList= new ArrayList<String>(Arrays.asList(args));
		
		argsObject.setUsersFilename(argsList.get(argsList.size()-2));
		argsObject.setResourceFilename(argsList.get(argsList.size()-1));
		
		if(argsList.size() > 2){
			
				
			if(argsList.contains(TOP_ARGUMENT)){
				
				int indexOfTopValue = argsList.indexOf(TOP_ARGUMENT)+1;
				String topValString = argsList.get(indexOfTopValue);
				
				try {			        
			        int topValInt = Integer.parseInt(topValString);
					argsObject.setTopValue(topValInt);
			        argsObject.setTopActive(true);
			    } catch (NumberFormatException nfe) {
			        System.out.println("Unacceptable values for --top argument");
			        System.out.println("--top #");
			        System.exit(1);			        
			    }			
			}
			
			if(argsList.contains(CSV_ARGUMENT)){
				argsObject.setCsvAcive(true);				
			}
			
			if(argsList.size() > 5){
				System.out.println("argument limit exceeds");
				System.exit(1);
			}
			
		}	
		return argsObject;
	}	
	
}