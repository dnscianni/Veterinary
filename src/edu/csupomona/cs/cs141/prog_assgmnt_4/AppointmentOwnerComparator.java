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
 * This object is a comparator, that will compare Appointments by their Owner's
 * name. It will order the names alphabetically, and will place any nulls to the
 * end of the list.
 * 
 * @author David Scianni
 * 
 */
public class AppointmentOwnerComparator implements Comparator<Appointment> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Appointment app1, Appointment app2) {

		if (app1 != null && app2 != null) {
			return app1.getClient().getOwner().getName()
					.compareToIgnoreCase(app2.getClient().getOwner().getName());
		} else {
			return 1;
		}

	}

}
