/**
 * CS 141: Introduction to Programming and Problem Solving
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Assignment #4
 *
 * I am to make an administrative program for a veterinary office, which will keep track
 * of all the animals that need to be cared for, and all the appointments that are 
 * scheduled for the office.
 *
 * David Scianni
 */
package edu.csupomona.cs.cs141.prog_assgmnt_4;

import java.io.Serializable;

/**
 * This is the save class, which will save the animal list and the appointment
 * list, so that they can be retrieved from a file later.
 * 
 * @author David Scianni
 * 
 */
public class Save implements Serializable {

	/**
	 * This is the default serial ID for the Save object.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This is the animal array, that will be the way to save the animal list in
	 * main.
	 */
	private Animal[] theAnimList;
	/**
	 * This is the appointment array, that will be the way to save the
	 * appointment list in main.
	 */
	private Appointment[] theAppList;

	/**
	 * This constructor doesn't do anything because we set the lists after.
	 */
	public Save() {
	}

	/**
	 * This is used to set {@link #theAnimList} when the user wants to save.
	 * 
	 * @param a
	 *            the animal list from main
	 */
	public void setAnimal(Animal[] a) {
		theAnimList = a;
	}

	/**
	 * This is used to set {@link #theAppList} when the user wants to save.
	 * 
	 * @param a
	 *            the appointment list from main
	 */
	public void setAppointment(Appointment[] a) {
		theAppList = a;
	}

	/**
	 * This will retrieve the saved animal list when the program loads from a
	 * file
	 * 
	 * @return {@link #theAnimList}
	 */
	public Animal[] getAnimal() {
		return theAnimList;
	}

	/**
	 * This will retrieve the saved appointment list when the program loads from a
	 * file
	 * 
	 * @return {@link #theAppList}
	 */
	public Appointment[] getAppointment() {
		return theAppList;
	}
}
