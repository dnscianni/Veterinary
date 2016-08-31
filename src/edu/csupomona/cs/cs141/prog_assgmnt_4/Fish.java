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

/**
 * The Fish object is a subclass of Animal, so it will inherit all of it's
 * fields and methods. The Fish will have 5 different variety's of fish type,
 * which will help make each fish distinct.
 * 
 * @author David Scianni
 * 
 */
public class Fish extends Animal {

	/**
	 * This is the default serial ID for the Bird object.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This will keep the type of fish in it, from either {@link #FISH_TYPE_1},
	 * {@link #FISH_TYPE_2}, {@link #FISH_TYPE_3}, {@link #FISH_TYPE_4}, or
	 * {@link #FISH_TYPE_5}.
	 */
	private String fishType;
	/**
	 * This is set if a fish is a Tetra.
	 */
	private final String FISH_TYPE_1 = "Tetra";
	/**
	 * This is set if a fish is a Platy.
	 */
	private final String FISH_TYPE_2 = "Platy";
	/**
	 * This is set if a fish is a Danio.
	 */
	private final String FISH_TYPE_3 = "Danio";
	/**
	 * This is set if a fish is a Guppy.
	 */
	private final String FISH_TYPE_4 = "Guppy";
	/**
	 * This is set if a fish is a Molly.
	 */
	private final String FISH_TYPE_5 = "Molly";

	/**
	 * This constructor will set the owner, name, age, and type of the fish
	 * depending on what is passed.
	 * 
	 * @param m
	 *            The owner of the fish
	 * @param n
	 *            The name of the fish
	 * @param a
	 *            The age of the fish
	 * @param type
	 *            The type of fish
	 */
	public Fish(Owner m, String n, int a, int type) {
		super(m, n, a);
		setAnimalType("Fish");
		switch (type) {
		case 1:
			fishType = FISH_TYPE_1;
			break;
		case 2:
			fishType = FISH_TYPE_2;
			break;
		case 3:
			fishType = FISH_TYPE_3;
			break;
		case 4:
			fishType = FISH_TYPE_4;
			break;
		default:
			fishType = FISH_TYPE_5;
		}
	}

	/**
	 * Gets the type of fish it is
	 * 
	 * @return {@link #fishType}
	 */
	public String getFishType() {
		return fishType;
	}

	/* (non-Javadoc)
	 * @see edu.csupomona.cs.cs141.prog_assgmnt_4.Animal#printAnimal()
	 */
	public void printAnimal() {
		System.out.println("Owner:");
		System.out.println("       Name:         " + getOwner().getName());
		System.out.println("       Address:      " + getOwner().getAddress());
		System.out.println("       Phone Number: "
				+ getOwner().getPhoneNumber());
		System.out.println();
		System.out.println("Name of Fish: " + getName());
		System.out.println("Age of Fish:  " + getAge());
		System.out.println("Type of Fish:  " + fishType);
		System.out.println();
		System.out.println("Medical History:");
		printIllness();
		System.out.println();
		System.out.println("Appointments: ");
		printAppointment();
		System.out.println();
	}
}
