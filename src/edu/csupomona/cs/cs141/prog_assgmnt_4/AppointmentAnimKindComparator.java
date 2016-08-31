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

import java.util.Comparator;

/**
 * This object is a comparator, that will compare Appointments by their Animal
 * Kind. It will order the types alphabetically, and will place any nulls to the
 * end of the list.
 * 
 * @author David Scianni
 * 
 */
public class AppointmentAnimKindComparator implements Comparator<Appointment> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Appointment app1, Appointment app2) {

		if (app1 != null && app2 != null) {
			return app1.getClient().getAnimalType()
					.compareToIgnoreCase(app2.getClient().getAnimalType());
		} else {
			return 1;
		}
	}

}
