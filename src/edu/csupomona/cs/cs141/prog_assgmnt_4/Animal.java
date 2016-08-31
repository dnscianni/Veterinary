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
 * The Animal object represents a general way to keep track of the animals that
 * come to our veterinary office. It will have subclasses that represent a Dog,
 * a Fish, and a Bird.
 * 
 * @author David Scianni
 * 
 */
public abstract class Animal implements Serializable {

	/**
	 * This is the default serial ID for the Animal object.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This is the owner of the Animal. Since every animal in our system has an
	 * owner, It is kept in the superclass, rather than writing one for each of
	 * the subclasses.
	 */
	private Owner master;

	/**
	 * This is the name of the animal. We keep the name so that we can keep
	 * track of the animal, and can use it's name to search for specific
	 * animals.
	 */
	private String name;

	/**
	 * We keep the age of the animal, so that we can reference any disorders or
	 * diseases that can affect the animal during certain years of its life.
	 */
	private int age;

	/**
	 * This array will keep track of any diseases that the animal has, or had
	 * during its lifetime..
	 */
	private Disease illness[];

	/**
	 * This array will hold all the appointments that the animal has at our
	 * hospital.
	 */
	private Appointment[] apps;

	/**
	 * This String will keep track of the subclass that is made. If a Dog is
	 * made, then the animalType will be {@code Dog}, if it's a Bird, then the
	 * animalType will be {@code Bird} and if a Fish, the animalType will be
	 * {@code Fish}.
	 */
	private String animalType;

	/**
	 * This constructor will set the master to m, the name to n and the age to
	 * a. Then it will instantiate and initialize the illness and apps arrays to
	 * size 50 and fill them with null pointers.
	 * 
	 * @param m
	 *            The owner of the animal
	 * @param n
	 *            The name of the animal
	 * @param a
	 *            the age of the animal
	 */
	public Animal(Owner m, String n, int a) {
		master = m;
		name = n;
		age = a;
		illness = new Disease[50];
		for (int i = 0; i < illness.length; i++) {
			illness[i] = null;
		}
		apps = new Appointment[50];
		for (int i = 0; i < apps.length; i++) {
			apps[i] = null;
		}
	}

	/**
	 * First, this method will make a temporary variable {@code temp} and make
	 * it equal to 0. Then it will check the apps array, and if the ith variable
	 * is not null, it will add 1 to temp. When a null pointer is found, then it
	 * will break the for loop, and return the temp number. This temp will be
	 * how many variables are in the array that are not null.
	 * 
	 * @return temp, which is the number of non-null variables in the array
	 */
	public int appSize() {
		int temp = 0;
		for (int i = 0; i < apps.length; i++) {
			if (apps[i] != null) {
				temp++;
			} else {
				break;
			}
		}
		return temp;
	}

	/**
	 * First, this method will make a temporary variable {@code temp} and make
	 * it equal to 0. Then it will check the illness array, and if the ith
	 * variable is not null, it will add 1 to temp. When a null pointer is
	 * found, then it will break the for loop, and return the temp number. This
	 * temp will be how many variables are in the array that are not null.
	 * 
	 * @return temp, which is the number of non-null variables in the array
	 */
	public int illnessSize() {
		int temp = 0;
		for (int i = 0; i < illness.length; i++) {
			if (illness[i] != null) {
				temp++;
			} else {
				break;
			}
		}
		return temp;
	}

	/**
	 * This will add an appointment to the apps array in the next available spot
	 * in the array, which would be at {@code appSize()}
	 * 
	 * @param a
	 *            Is the Appointment being added to the apps array
	 */
	public void addAppointment(Appointment a) {
		apps[appSize()] = a;
	}

	/**
	 * This will add a Disease to the illness array in the next available spot
	 * in the array, which would be at {@code illnessSize()}
	 * 
	 * @param d
	 *            Is the Disease being added to the illness array
	 */
	public void addDisease(Disease d) {
		illness[illnessSize()] = d;
	}

	/**
	 * This will take in an appointment and check all of the apps array for that
	 * appointment. If it is found, then it will make that app equal to the app
	 * in the next cell, and will continuously move them down one by one until
	 * all the apps are moved one cell to the left. It will then make the last
	 * cell into null, so to complete the subtraction of the appointment a.
	 * 
	 * @param a
	 *            The appointment you wish to subtract
	 */
	public void subtractAppointment(Appointment a) {
		for (int i = 0; i < apps.length; i++) {
			if (apps[i] == a) {
				for (int j = i; j < apps.length - 1; j++) {
					apps[j] = apps[j + 1];
				}
				apps[apps.length - 1] = null;
				break;
			}
		}
	}

	/**
	 * Sets the status of a disease in the illness array to either current or
	 * past.
	 * 
	 * @param n
	 *            The number of the disease in the illness array
	 * @param s
	 *            The status of the disease. {@code true} for {@code current} or
	 *            {@code false} for {@code past}.
	 */
	public void setDiseaseStatus(int n, boolean s) {
		illness[n].setStatus(s);
	}

	/**
	 * This gets the owner of the animal
	 * 
	 * @return master, or the owner of the animal
	 */
	public Owner getOwner() {
		return master;
	}

	/**
	 * Gets the name of the animal
	 * 
	 * @return name, which is the animals name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * gets the age of the animal
	 * 
	 * @return age, or the animals age.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Abstract method that will print out the animals information. It is
	 * different for the Dog object because Dog has vaccinations as well.
	 * Besides that, they all print out the Owner's info, their info, and any
	 * diseases and appointments they have.
	 */
	public abstract void printAnimal();

	/**
	 * This will print out any diseases that the animal has. If it doesn't have
	 * any it will print {@code none}, but if it does it will print the name of
	 * the disease and the status of it.
	 */
	public void printIllness() {
		String temp;
		if (illnessSize() == 0) {
			System.out.println("       None");
		} else {
			for (int i = 0; i < illnessSize(); i++) {
				System.out
						.println("       Disease: " + illness[i].getIllness());
				if (illness[i].getStatus()) {
					temp = "Current";
				} else {
					temp = "Past";
				}
				System.out.println("           Status: " + temp);
			}

		}
	}

	/**
	 * This will print out the information of any and all appointments the
	 * animal has. If they have none, then {@code none} will be displayed
	 */
	public void printAppointment() {
		if (appSize() == 0) {
			System.out.println("       None");
		} else {
			for (int i = 0; i < appSize(); i++) {
				System.out.println("       Appointment " + (i + 1) + ": ");
				System.out.println("              Date: " + apps[i].getDate());
				System.out.println("              Time: " + apps[i].getTime());
			}
		}
	}

	/**
	 * This will get the animal type, which is either {@code Dog}, {@code Bird},
	 * or {@code Fish}
	 * 
	 * @return the animal's type
	 */
	public String getAnimalType() {
		return animalType;
	}

	/**
	 * This sets the type of the animal to either {@code Dog}, {@code Bird}, or
	 * {@code Fish}
	 * 
	 * @param animalType
	 *            is the string that will be the animal type. Will be either
	 *            {@code Dog}, {@code Bird}, or {@code Fish}
	 */
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
}
