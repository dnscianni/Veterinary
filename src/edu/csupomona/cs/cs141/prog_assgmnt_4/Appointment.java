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
 * The Appointment object is made to keep track of the appointments set up in
 * the vet office. Each appointment has a date, a time, and a client, which will
 * be the animal, and not the owner.
 * 
 * @author David Scianni
 * 
 */
public class Appointment implements Serializable {

	/**
	 * This is the default serial ID for the Appointment Object.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This String will keep track of the date of the appointment. It will be
	 * set up in the {@code year/month/day} fashion.
	 */
	String date;
	/**
	 * This String will keep track of the time of the appointment. It will be
	 * set up in the {@code ##:##am/pm} fashion.
	 */
	String time;
	/**
	 * This is the Animal that the appointment is for. We keep track of the
	 * animal rather than the owner, since an owner could possibly have more
	 * than one animal.
	 */
	Animal client;

	/**
	 * The constructor will set up the date, time, and client of the
	 * Appointment.
	 * 
	 * @param d
	 *            The date that the appointment is set up for.
	 * @param t
	 *            The time that the appointment is set up for.
	 * @param c
	 *            The client that the appointment is set up for.
	 */
	public Appointment(String d, String t, Animal c) {
		date = d;
		time = t;
		client = c;
	}

	/**
	 * This will get the date of the Appointment
	 * 
	 * @return {@link #date}
	 */
	public String getDate() {
		return date;
	}

	/**
	 * This will get the time of the Appointment
	 * 
	 * @return {@link #time}
	 */
	public String getTime() {
		return time;
	}

	/**
	 * This will get the client of the Appointment
	 * 
	 * @return {@link #client}
	 */
	public Animal getClient() {
		return client;
	}

	/**
	 * This will print out all of the Appointment's information, as well as some
	 * of the client's information.
	 */
	public void printAppointment() {
		System.out.println("Date: " + date);
		System.out.println("Time: " + time);
		System.out.println("Client:");
		System.out.println("      Animal Name:  " + client.getName());
		System.out.println("      Animal Type:  " + client.getAnimalType());
		System.out
				.println("      Owner's Name: " + client.getOwner().getName());
		System.out.println();
	}
}
