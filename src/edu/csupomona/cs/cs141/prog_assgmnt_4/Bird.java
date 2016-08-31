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
 * The Bird object is a subclass of Animal, so it will inherit all of it's
 * fields and methods. The Bird will have 5 different variety's of bird type,
 * which will help make each bird distinct.
 * 
 * @author David Scianni
 * 
 */
public class Bird extends Animal {

	/**
	 * This is the default serial ID for the Bird object.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This will keep the type of bird in it, from either {@link #BIRD_TYPE_1},
	 * {@link #BIRD_TYPE_2}, {@link #BIRD_TYPE_3}, {@link #BIRD_TYPE_4}, or
	 * {@link #BIRD_TYPE_5}.
	 */
	private String birdType;
	/**
	 * This is set if a bird is a finch.
	 */
	private final String BIRD_TYPE_1 = "Finch";
	/**
	 * This is set if a bird is a parrot.
	 */
	private final String BIRD_TYPE_2 = "Parrot";
	/**
	 * This is set if a bird is a canary.
	 */
	private final String BIRD_TYPE_3 = "Canary";
	/**
	 * This is set if a bird is a cockatoo.
	 */
	private final String BIRD_TYPE_4 = "Cockatoo";
	/**
	 * This is set if a bird is a parakeet.
	 */
	private final String BIRD_TYPE_5 = "Parakeet";

	/**
	 * This constructor will set the owner, name, age, and type of the bird
	 * depending on what is passed.
	 * 
	 * @param m
	 *            The owner of the bird
	 * @param n
	 *            The name of the bird
	 * @param a
	 *            The age of the bird
	 * @param type
	 *            The type of bird
	 */
	public Bird(Owner m, String n, int a, int type) {
		super(m, n, a);
		setAnimalType("Bird");
		switch (type) {
		case 1:
			birdType = BIRD_TYPE_1;
			break;
		case 2:
			birdType = BIRD_TYPE_2;
			break;
		case 3:
			birdType = BIRD_TYPE_3;
			break;
		case 4:
			birdType = BIRD_TYPE_4;
			break;
		default:
			birdType = BIRD_TYPE_5;
		}
	}

	/**
	 * Gets the type of bird it is
	 * 
	 * @return {@link #birdType}
	 */
	public String getBirdType() {
		return birdType;
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
		System.out.println("Name of Bird: " + getName());
		System.out.println("Age of Bird:  " + getAge());
		System.out.println("Type of Bird:  " + birdType);
		System.out.println();
		System.out.println("Medical History:");
		printIllness();
		System.out.println();
		System.out.println("Appointments: ");
		printAppointment();
		System.out.println();
	}
}
