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
 * This is an object representing a human who is the owner of a pet or pets who
 * come to this Veterinary office. The Owner will have a {@link #name}, and an
 * {@link #address} and {@link #phoneNumber} so that the owner can be contacted.
 * 
 * @author David Scianni
 * 
 */
public class Owner implements Serializable {

	/**
	 * This is the default serial ID for the Owner object.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This represents the name of the Owner. We will need to know the name of
	 * each pet owner so that we can return the pet to them when their
	 * appointment has been resolved. Without a name, we wouldn't be able to
	 * keep track of who owns which pet.
	 */
	private String name;

	/**
	 * This is the location where the owner lives. We keep their address so that
	 * we can contact them at their house if need be. We will keep the address
	 * as {@code houseNumber streetName, city, state, zipCode}.
	 */
	private String address;

	/**
	 * This is the phone number that we can contact the owner through. It is
	 * written as a string because we are going to keep it in the form
	 * {@code ###) ###-####}.
	 */
	private String phoneNumber;

	/**
	 * This will set up the owner, with a name, an address, and a phone number.
	 * 
	 * @param n
	 *            The name of the owner.
	 * @param a
	 *            The address of the owner.
	 * @param p
	 *            The phone number of the owner.
	 */
	public Owner(String n, String a, String p) {
		name = n;
		address = a;
		phoneNumber = p;
	}

	/**
	 * This method will return the name of the Owner
	 * 
	 * @return {@link #name}, which is the Owner's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method will return the address of the Owner
	 * 
	 * @return {@link #address}, which is the Owner's address.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * This method will return the phone number of the Owner
	 * 
	 * @return {@link #phoneNumber}, which is the Owner's phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
}
