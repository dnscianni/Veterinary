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
 * This object is a comparator, that will compare Animals by their Owner's name.
 * It will order the names alphabetically, and will place any nulls to the end
 * of the list.
 * 
 * @author David Scianni
 * 
 */
public class AnimalOwnerComparator implements Comparator<Animal> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Animal anim1, Animal anim2) {

		if (anim1 != null && anim2 != null) {
			return anim1.getOwner().getName()
					.compareToIgnoreCase(anim2.getOwner().getName());
		} else {
			return 1;
		}
	}

}
