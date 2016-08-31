/**
 * CS 141: Introduction to Programming and Problem Solving
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment #4
 *
 * I am to make an administrative program for a veterinary office, which will keep track
 *  of all the animals that need to be cared for, and all the appointments that are 
 *  scheduled for the office.
 *
 * David Scianni
 */
package edu.csupomona.cs.cs141.prog_assgmnt_4;

import java.io.Serializable;

/**
 * Disease conatains the diseases that the animals might have. It has a disease
 * name, and the status of that disease.
 * 
 * @author David Scianni
 * 
 */
public class Disease implements Serializable {

	/**
	 * This is the default serial ID for the Disease object.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This is the name of the disease.
	 */
	private String illness;

	/**
	 * This will keep track of the status. If its {@code true}, then the disease
	 * is current, but if it is {@code false}, then it is a past disease.
	 */
	private boolean status;

	/**
	 * This constructor sets up the disease name and the status of that disease.
	 * 
	 * @param i
	 *            The disease name.
	 * @param s
	 *            The status of the disease.
	 */
	public Disease(String i, boolean s) {
		illness = i;
		status = s;
	}

	/**
	 * This will get the status of the disease, as a boolean
	 * 
	 * @return status, true for current, and false for past
	 */
	public boolean getStatus() {
		return status;
	}

	/**
	 * We can use this to change the status of a disease, if that disease goes
	 * away or comes back
	 * 
	 * @param status
	 *            The boolean that determines the new status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * This method will return the name of the disease.
	 * 
	 * @return {@link #illness}, which is the name of the disease.
	 */
	public String getIllness() {
		return illness;
	}
}
