package com.egnyte.utils.auditreporter;


/**
 * The Class Record.
 * @author Yasith Lokuge
 */
public class Record implements Comparable<Record>{

	/** The user name. */
	private String userName;
	
	/** The file name. */
	private String fileName;
	
	/** The file size. */
	private long fileSize;
	
	/**
	 * Instantiates a new record.
	 *
	 * @param userName the user name
	 * @param fileName the file name
	 * @param size the file size
	 */
	public Record(String userName, String fileName, long size){
		super();
		this.userName = userName;
		this.fileName = fileName;
		this.fileSize = size;
	}
	
	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * Gets the file name.
	 *
	 * @return the file name
	 */
	public String getFileName() {
		return fileName;
	}
	
	/**
	 * Sets the file name.
	 *
	 * @param fileName the new file name
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * Gets the file size.
	 *
	 * @return the file size
	 */
	public long getFileSize() {
		return fileSize;
	}
	
	/**
	 * Sets the file size.
	 *
	 * @param fileSize the new file size
	 */
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Record compareSize) {
		
		long compareQuantity = ((Record) compareSize).getFileSize(); 
				
		//descending order
		return (int) (compareQuantity - this.fileSize);
		
	}	
}
