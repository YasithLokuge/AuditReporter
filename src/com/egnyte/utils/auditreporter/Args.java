package com.egnyte.utils.auditreporter;


/**
 * The Class Args.
 * @author Yasith Lokuge
 */
public class Args {

	/** The resource filename. */
	private String resourceFilename;
	
	/** The users filename. */
	private String usersFilename;	
	
	/** The top value. */
	private int topValue;	
	
	/** The is top active. */
	private boolean isTopActive;
	
	/** The is csv acive. */
	private boolean isCsvAcive;


	/**
	 * Gets the resource filename.
	 *
	 * @return the resource filename
	 */
	public String getResourceFilename() {
		return resourceFilename;
	}

	/**
	 * Sets the resource filename.
	 *
	 * @param resourceFilename the new resource filename
	 */
	public void setResourceFilename(String resourceFilename) {
		this.resourceFilename = resourceFilename;
	}

	/**
	 * Gets the users filename.
	 *
	 * @return the users filename
	 */
	public String getUsersFilename() {
		return usersFilename;
	}

	/**
	 * Sets the users filename.
	 *
	 * @param usersFilename the new users filename
	 */
	public void setUsersFilename(String usersFilename) {
		this.usersFilename = usersFilename;
	}

	/**
	 * Gets the top value.
	 *
	 * @return the top value
	 */
	public int getTopValue() {		
		return topValue;
	}

	/**
	 * Sets the top value.
	 *
	 * @param topValue the new top value
	 */
	public void setTopValue(int topValue) {
		this.topValue = topValue;
	}

	/**
	 * Checks if is top active.
	 *
	 * @return true, if is top active
	 */
	public boolean isTopActive() {
		return isTopActive;
	}

	/**
	 * Sets the top active.
	 *
	 * @param isTopActive the new top active
	 */
	public void setTopActive(boolean isTopActive) {
		this.isTopActive = isTopActive;
	}

	/**
	 * Checks if is csv acive.
	 *
	 * @return true, if is csv acive
	 */
	public boolean isCsvAcive() {
		return isCsvAcive;
	}

	/**
	 * Sets the csv acive.
	 *
	 * @param isCsvAcive the new csv acive
	 */
	public void setCsvAcive(boolean isCsvAcive) {
		this.isCsvAcive = isCsvAcive;
	}

	
}
