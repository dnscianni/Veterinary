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
 * The Dog object is a subclass of Animal, so it will inherit all of it's fields
 * and methods. The Dog will have 5 different variety's of dog type, which will
 * help make each dog distinct.
 * 
 * @author David Scianni
 * 
 */
public class Dog extends Animal {

	/**
	 * This is the default serial ID for the Bird object.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This will keep the type of dog in it, from either {@link #DOG_TYPE_1},
	 * {@link #DOG_TYPE_2}, {@link #DOG_TYPE_3}, {@link #DOG_TYPE_4}, or
	 * {@link #DOG_TYPE_5}.
	 */
	private String dogType;
	/**
	 * This is set if a dog is a German Shepherd
	 */
	private final String DOG_TYPE_1 = "German Shepherd";
	/**
	 * This is set if a dog is a Chihuahua
	 */
	private final String DOG_TYPE_2 = "Chihuahua";
	/**
	 * This is set if a dog is a Greyhound
	 */
	private final String DOG_TYPE_3 = "Greyhound";
	/**
	 * This is set if a dog is a Labrador
	 */
	private final String DOG_TYPE_4 = "Labrador";
	/**
	 * This is set if a dog is a Poodle
	 */
	private final String DOG_TYPE_5 = "Poodle";
	/**
	 * The array of vaccinations that the dog will have been given in its
	 * lifetime.
	 */
	private String vaccinations[];

	/**
	 * This constructor will set the owner, name, age, and type of the dog
	 * depending on what is passed. It will also make the vaccinations array
	 * equal to an array of size 20, and will set them all to null
	 * 
	 * @param m
	 *            The owner of the dog
	 * @param n
	 *            The name of the dog
	 * @param a
	 *            The age of the dog
	 * @param type
	 *            The type of dog
	 */
	public Dog(Owner m, String n, int a, int type) {
		super(m, n, a);
		setAnimalType("Dog");
		switch (type) {
		case 1:
			dogType = DOG_TYPE_1;
			break;
		case 2:
			dogType = DOG_TYPE_2;
			break;
		case 3:
			dogType = DOG_TYPE_3;
			break;
		case 4:
			dogType = DOG_TYPE_4;
			break;
		default:
			dogType = DOG_TYPE_5;
		}
		vaccinations = new String[20];
		for (int i = 0; i < vaccinations.length; i++) {
			vaccinations[i] = null;
		}
	}

	/**
	 * First, this method will make a temporary variable {@code temp} and make
	 * it equal to 0. Then it will check the vaccinations array, and if the ith
	 * variable is not null, it will add 1 to temp. When a null pointer is
	 * found, then it will break the for loop, and return the temp number. This
	 * temp will be how many variables are in the array that are not null.
	 * 
	 * @return temp, which is the number of non-null variables in the array
	 */
	public int vaccinationSize() {
		int temp = 0;
		for (int i = 0; i < vaccinations.length; i++) {
			if (vaccinations[i] != null) {
				temp++;
			} else {
				break;
			}
		}
		return temp;
	}

	/**
	 * This will add a vaccination to the vaccinations array in the next
	 * available spot in the array, which would be at {@code vaccinationSize()}
	 * 
	 * @param v
	 *            Is the vaccination being added to the vaccinations array
	 */
	public void addVaccination(String v) {
		vaccinations[vaccinationSize()] = v;
	}

	/**
	 * Gets the type of dog it is
	 * 
	 * @return {@link #dogType}
	 */
	public String getDogType() {
		return dogType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.csupomona.cs.cs141.prog_assgmnt_4.Animal#printAnimal()
	 */
	public void printAnimal() {
		System.out.println("Owner:");
		System.out.println("       Name:         " + getOwner().getName());
		System.out.println("       Address:      " + getOwner().getAddress());
		System.out.println("       Phone Number: "
				+ getOwner().getPhoneNumber());
		System.out.println();
		System.out.println("Name of Dog: " + getName());
		System.out.println("Age of Dog:  " + getAge());
		System.out.println("Type of Dog:  " + dogType);
		System.out.println();
		System.out.println("Medical History:");
		printIllness();
		System.out.println();
		System.out.println("Vaccinations: ");
		printVaccination();
		System.out.println();
		System.out.println("Appointments: ");
		printAppointment();
		System.out.println();
	}

	/**
	 * This will print out the information of any and all vaccinations the
	 * animal has. If they have none, then {@code none} will be displayed
	 */
	private void printVaccination() {
		if (vaccinationSize() == 0) {
			System.out.println("       None");
		} else {
			for (int i = 0; i < vaccinationSize(); i++) {
				System.out.println("       " + vaccinations[i]);
			}

		}
	}
}
