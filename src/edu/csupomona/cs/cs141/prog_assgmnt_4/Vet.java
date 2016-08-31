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

import java.io.*;
import java.util.*;

/**
 * This is the class that holds the main. It sets up the interface, and has
 * several searches that help the user when interacting with the interface.
 * 
 * @author David Scianni
 * 
 */
/**
 * @author Jabba
 * 
 */
public class Vet {

	/**
	 * The list of animals that the program uses in main
	 */
	private static Animal[] animList;
	/**
	 * The list of appointments that the program uses in main
	 */
	private static Appointment[] appList;

	/**
	 * This contains all the things necessary in the interface that the user
	 * uses. First it creates any variables that are needed. Then it sets up the
	 * lists as new arrays and fills them with null pointers. Then it checks to
	 * see if there is a save file, and if there is, then the program sets the
	 * lists as the ones from the save file. Then the user is given 6 options to
	 * choose from in the main menu. These options are, to add an animal to the
	 * registry, to see the lists, to search for an appointment, to search for
	 * medical history, to save, or to quit.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		Save saveState = new Save();
		FileInputStream fis;
		int resp;
		Owner o;
		String name;
		String address;
		String phone;
		String vacc;
		String dis;
		String date;
		String time;
		int age;
		boolean bool;
		Disease illness;
		Appointment ap;
		Animal a;
		Dog d;
		Bird b;
		Fish f;

		animList = new Animal[200];
		for (int i = 0; i < animList.length; i++) {
			animList[i] = null;
		}

		appList = new Appointment[200];
		for (int i = 0; i < appList.length; i++) {
			appList[i] = null;
		}

		try {
			fis = new FileInputStream("saved.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			saveState = (Save) ois.readObject();
			animList = saveState.getAnimal();
			appList = saveState.getAppointment();
			fis.close(); // closes saved file
			ois.close(); // closes saved file

		} catch (ClassNotFoundException | IOException e1) {

		}

		System.out.println("*******************************************");
		System.out.println("*                                         *");
		System.out.println("*    Cal Poly Pomona Veterinary Office    *");
		System.out.println("*                                         *");
		System.out.println("*******************************************");

		do {
			System.out.println("*******************************************");
			System.out.println("*        What would You like to do        *");
			System.out.println("*******************************************");
			System.out.println("*                                         *");
			System.out.println("* 1. Add an Animal to the registry        *");
			System.out.println("* 2. See a list of Appointments or Animals*");
			System.out.println("* 3. Search for an Appointment            *");
			System.out.println("* 4. Search for Medical History           *");
			System.out.println("* 5. Save Registry                        *");
			System.out.println("* 6. Quit                                 *");
			System.out.println("*                                         *");
			System.out.println("*******************************************");
			resp = getInput();

			if (resp < 1 || resp > 6) {
				System.out.println();
				System.out.println("Invalid Input. Try again.");
				System.out.println();
				continue;
			}

			/*
			 * In order to quit, 6 must be pressed, and if it is the program
			 * terminates with a thank you message.
			 */
			if (resp == 6) {
				System.out.println("Thank you. Goodbye.");
				System.exit(0);
			}

			/*
			 * If 1 is pressed, then the user is asked for the information about
			 * the animal, which includes all the user's information. After
			 * getting the user's information, the user is asked for the animal
			 * type, and then asked for all the animal's info, including
			 * vaccinations if it is a dog, and for any diseases and or
			 * appointments.
			 */
			if (resp == 1) {
				System.out.println("Owner: ");
				System.out.println("    What is the Onwer's name: ");
				name = scn.nextLine();
				System.out
						.println("    What is the address(Street number/name, City, State, ZIP): ");
				address = scn.nextLine();
				System.out
						.println("    What is the Phone Number(###-###-####): ");
				phone = scn.nextLine();

				o = new Owner(name, address, phone);

				do {
					if (resp < 1 || resp > 3) {
						System.out.println("Invalid Input. Try again.");
					}
					System.out
							.println("Is the animal a dog(1), a bird(2), or a fish(3): ");
					resp = getInput();
				} while (resp < 1 || resp > 3);
				if (resp == 1) {
					System.out.println("Dog: ");
					System.out.println("    What is the Dog's name: ");
					name = scn.nextLine();
					System.out.println("    What is the Dog's age: ");
					age = getInput();
					System.out.println("    What kind of Dog is it: ");
					System.out.println("          1. German Shepherd");
					System.out.println("          2. Chihuahua");
					System.out.println("          3. Greyhound");
					System.out.println("          4. Labrador");
					System.out.println("          5. Poodle");
					resp = getInput();
					while (resp < 1 || resp > 5) {
						System.out.println("Invalid Input. Try again.");
						resp = getInput();
					}
					d = new Dog(o, name, age, resp);
					addAnimal(d);

					do {
						System.out
								.println("Would You like to add a vaccination(1 for yes 2 for no): ");
						resp = getInput();
						if (resp < 1 || resp > 2) {
							System.out.println("Invalid Input. Try again.");
							continue;
						} else if (resp == 2) {
							break;
						} else {
							System.out.println("Please enter the vaccination");
							vacc = scn.nextLine();
							d.addVaccination(vacc);
						}
					} while (true);
				} else if (resp == 2) {
					System.out.println("Bird: ");
					System.out.println("    What is the Bird's name: ");
					name = scn.nextLine();
					System.out.println("    What is the Bird's age: ");
					age = getInput();
					System.out.println("    What kind of Bird is it: ");
					System.out.println("          1. Finch");
					System.out.println("          2. Parrot");
					System.out.println("          3. Canary");
					System.out.println("          4. Cockatoo");
					System.out.println("          5. Parakeet");
					resp = getInput();
					while (resp < 1 || resp > 5) {
						System.out.println("Invalid Input. Try again.");
						resp = getInput();
					}
					b = new Bird(o, name, age, resp);
					addAnimal(b);
				} else if (resp == 3) {
					System.out.println("Fish: ");
					System.out.println("    What is the Fish's name: ");
					name = scn.nextLine();
					System.out.println("    What is the Fish's age: ");
					age = getInput();
					System.out.println("    What kind of Fish is it: ");
					System.out.println("          1. Tetra");
					System.out.println("          2. Platy");
					System.out.println("          3. Danio");
					System.out.println("          4. Guppy");
					System.out.println("          5. Molly");
					resp = getInput();
					while (resp < 1 || resp > 5) {
						System.out.println("Invalid Input. Try again.");
						resp = getInput();
					}
					f = new Fish(o, name, age, resp);
					addAnimal(f);
				}
				do {
					System.out
							.println("Would You like to add a disease(1 for yes 2 for no): ");
					resp = getInput();
					if (resp < 1 || resp > 2) {
						System.out.println("Invalid Input. Try again.");
						continue;
					} else if (resp == 2) {
						break;
					} else {
						System.out.println("Please enter the disease name");
						dis = scn.nextLine();
						System.out
								.println("Is the disease current(1) or past(2)");
						resp = getInput();
						while (resp < 1 || resp > 2) {
							System.out.println("Invalid Input. Try again.");
							resp = getInput();
						}
						if (resp == 1) {
							bool = true;
						} else {
							bool = false;
						}
						illness = new Disease(dis, bool);
						animList[animSize() - 1].addDisease(illness);
					}
				} while (true);

				do {
					System.out
							.println("Would You like to add an appointment(1 for yes 2 for no): ");
					resp = getInput();
					if (resp < 1 || resp > 2) {
						System.out.println("Invalid Input. Try again.");
						continue;
					} else if (resp == 2) {
						break;
					} else {
						System.out
								.println("Please enter a date(year/month/day): ");
						date = scn.nextLine();
						System.out.println("Please enter a time(##:##am/pm): ");
						time = scn.nextLine();
						ap = new Appointment(date, time,
								animList[animSize() - 1]);
						animList[animSize() - 1].addAppointment(ap);
						addAppointment(ap);
					}
				} while (true);
				resp = 0;
			}

			/*
			 * This is if the user chose the second option. First the user is
			 * asked whether they want to see the appointment list or the animal
			 * list. If they choose appointment, then they are asked to see it
			 * by owner, date, or animal kind. If they chose owner or date, then
			 * it will sort the array, and display it, and ask if they want to
			 * resolve any of these appointments. If they choose animal kind, it
			 * will just display the appointments of that animal kind. If they
			 * chose to look at the animal list, then it will just display the
			 * list of animals
			 */
			if (resp == 2) {
				System.out
						.println("Would you like to see appointments(1), or animals(2): ");
				resp = getInput();
				while (resp < 1 || resp > 2) {
					System.out.println("Invalid Input. Try again.");
					resp = getInput();
				}
				if (resp == 1) {
					System.out
							.println("Would you like to see the appointments by Owner(1), Date(2), Animal Type(3): ");
					resp = getInput();
					while (resp < 1 || resp > 3) {
						System.out.println("Invalid Input. Try again.");
						resp = getInput();
					}
					if (resp == 1) {
						Arrays.sort(appList, new AppointmentOwnerComparator());
						printAppointment();
						do {
							System.out
									.println("Would you like to change the status on any of these appointments(1 for yes, 2 for no): ");
							resp = getInput();
							if (resp < 1 || resp > 2) {
								System.out.println("Invalid Input. Try again.");
								resp = getInput();
								continue;
							} else if (resp == 2) {
								break;
							} else {
								System.out
										.println("Which appointment number would you like to change: ");
								resp = getInput();
								while (resp < 1 || resp > appSize()) {
									System.out
											.println("Invalid Input. Try again.");
									resp = getInput();
								}
								appList[resp - 1].getClient()
										.subtractAppointment(appList[resp - 1]);
								subtractAppointment(appList[resp - 1]);
							}

						} while (true);
					} else if (resp == 2) {
						Arrays.sort(appList, new AppointmentDateComparator());
						printAppointment();
						do {
							System.out
									.println("Would you like to change the status on any of these appointments(1 for yes, 2 for no): ");
							resp = getInput();
							if (resp < 1 || resp > 2) {
								System.out.println("Invalid Input. Try again.");
								resp = getInput();
								continue;
							} else if (resp == 2) {
								break;
							} else {
								System.out
										.println("Which appointment number would you like to change: ");
								resp = getInput();
								while (resp < 1 || resp > appSize()) {
									System.out
											.println("Invalid Input. Try again.");
									resp = getInput();
								}
								appList[resp - 1].getClient()
										.subtractAppointment(appList[resp - 1]);
								subtractAppointment(appList[resp - 1]);
							}

						} while (true);
					} else {
						System.out
								.println("Which Animals do you wish to see. Dog(1), Bird(2), or Fish(3): ");
						resp = getInput();
						while (resp < 1 || resp > 3) {
							System.out.println("Invalid Input. Try again.");
							resp = getInput();
						}
						Arrays.sort(appList,
								new AppointmentAnimKindComparator());
						if (resp == 1) {
							for (int i = 0; i < appSize(); i++) {
								if (appList[i].getClient().getAnimalType()
										.equalsIgnoreCase("Dog")) {
									appList[i].printAppointment();
								}
							}
						} else if (resp == 2) {
							for (int i = 0; i < appSize(); i++) {
								if (appList[i].getClient().getAnimalType()
										.equalsIgnoreCase("Bird")) {
									appList[i].printAppointment();
								}
							}
						} else {
							for (int i = 0; i < appSize(); i++) {
								if (appList[i].getClient().getAnimalType()
										.equalsIgnoreCase("Fish")) {
									appList[i].printAppointment();
								}
							}
						}
					}
				} else if (resp == 2) {
					printAnimal();
				}
				resp = 0;
			}

			/*
			 * If the user chooses the third option, then they are asked if they
			 * want to search by owner or date. Whichever one they choose, they
			 * will be asked for an appointment and their respective binary
			 * search will be called and will return the appointment that they
			 * were searching for. If no appointment is found, then it will say
			 * that there was no appointment found.
			 */
			if (resp == 3) {
				System.out
						.println("Would you like to search by Owner(1) or by Date(2): ");
				resp = getInput();
				while (resp < 1 || resp > 2) {
					System.out.println("Invalid Input. Try again.");
					resp = getInput();
				}
				if (resp == 1) {
					System.out
							.println("Which Owner do you want to search for: ");
					name = scn.nextLine();
					Arrays.sort(appList, new AppointmentOwnerComparator());
					ap = appSearchOwner(name);
					if (ap != null) {
						ap.printAppointment();
					} else {
						System.out.println("No Owner by that name found.");
					}
				} else {
					System.out
							.println("Which date do you want to search for: ");
					date = scn.nextLine();
					Arrays.sort(appList, new AppointmentDateComparator());
					ap = appSearchDate(date);
					if (ap != null) {
						ap.printAppointment();
					} else {
						System.out.println("No date found.");
					}
				}
				resp = 0;
			}

			/*
			 * If the fourth option is chosen, then it will ask if they want to
			 * search by owner or by the animals name. No matter which they
			 * choose, they will be asked for the information, and their
			 * respective binary searches will be called. If no animal is found,
			 * then it will say so, but if one is found, it will print their
			 * info, and will ask if you would like to any more appointments for
			 * that animal.
			 */
			if (resp == 4) {
				System.out
						.println("Do you want look by Name(1) or by Owner(2): ");
				resp = getInput();
				while (resp < 1 || resp > 2) {
					System.out.println("Invalid Input. Try again.");
					resp = getInput();
				}
				if (resp == 1) {
					System.out.println("What's the name of the Animal: ");
					name = scn.nextLine();
					Arrays.sort(animList, new AnimalNameComparator());
					a = animSearchName(name);
					if (a != null) {
						a.printAnimal();
					} else {
						System.out.println("No Animal by that name found.");
					}
				} else {
					System.out.println("What's the name of the Owner: ");
					name = scn.nextLine();
					Arrays.sort(animList, new AnimalOwnerComparator());
					a = animSearchOwner(name);
					if (a != null) {
						a.printAnimal();
					} else {
						System.out.println("No Owner by that name found.");
					}
				}

				do {
					System.out
							.println("Would you like to add an appointment(1 for yes, 2 for no: ");
					resp = getInput();
					while (resp < 1 || resp > 2) {
						System.out.println("Invalid Input. Try again.");
						resp = getInput();
					}
					if (resp == 2) {
						break;
					} else {
						System.out
								.println("Please enter a date(year/month/day): ");
						date = scn.nextLine();
						System.out.println("Please enter a time(##:##am/pm): ");
						time = scn.nextLine();
						ap = new Appointment(date, time, a);
						a.addAppointment(ap);
						addAppointment(ap);
					}
				} while (true);
				resp = 0;
			}

			/*
			 * Lastly, if the 5th option is chosen, then the lists will be saved
			 * in the save class
			 */
			if (resp == 5) {
				saveIt(saveState, animList, appList);
				System.out.println("saved.");
				resp = 0;
			}
		} while (true);
	}

	/**
	 * This method will search the appointment list by owner. it is recursive,
	 * so it will use the aid of the search helper method, so as to help in the
	 * binary search
	 * 
	 * @param name
	 *            The name you are looking for in the array
	 * @return the appointment you are looking for, or null if it doesn't exist
	 */
	private static Appointment appSearchOwner(String name) {

		return searchHelperOwner(name, 0, appSize() - 1);
	}

	/**
	 * This method will recursively call itself until either the appointment is
	 * found, or you reach the end, in which case null will be passed back. It
	 * uses the basic binary search mechanic to search for the appointment you
	 * want.
	 * 
	 * @param name
	 *            The name you are looking for
	 * @param low
	 *            The bottom border of the binary search
	 * @param high
	 *            The top border of the binary search
	 * @return Either the appointment or null
	 */
	private static Appointment searchHelperOwner(String name, int low, int high) {
		if (low == high) {
			if (appList[low].getClient().getOwner().getName()
					.compareToIgnoreCase(name) == 0) {
				return appList[low];
			} else {
				return null;
			}
		}
		int mid = (low + high) / 2;
		if (appList[mid].getClient().getOwner().getName()
				.compareToIgnoreCase(name) == 0) {
			return appList[mid];
		} else if (appList[mid].getClient().getOwner().getName()
				.compareToIgnoreCase(name) < 0) {
			return searchHelperOwner(name, mid + 1, high);
		} else {
			return searchHelperOwner(name, low, mid - 1);
		}
	}

	/**
	 * This method will search the appointment list by date. it is recursive, so
	 * it will use the aid of the search helper method, so as to help in the
	 * binary search
	 * 
	 * @param date
	 *            The date you are looking for in the array
	 * @return the appointment you are looking for, or null if it doesn't exist
	 */
	private static Appointment appSearchDate(String date) {

		return searchHelperDate(date, 0, appSize() - 1);
	}

	/**
	 * This method will recursively call itself until either the appointment is
	 * found, or you reach the end, in which case null will be passed back. It
	 * uses the basic binary search mechanic to search for the appointment you
	 * want.
	 * 
	 * @param date
	 *            The date you are looking for
	 * @param low
	 *            The bottom border of the binary search
	 * @param high
	 *            The top border of the binary search
	 * @return Either the appointment or null
	 */
	private static Appointment searchHelperDate(String date, int low, int high) {
		if (low == high) {
			if (appList[low].getDate().compareToIgnoreCase(date) == 0) {
				return appList[low];
			} else {
				return null;
			}
		}
		int mid = (low + high) / 2;
		if (appList[mid].getDate().compareToIgnoreCase(date) == 0) {
			return appList[mid];
		} else if (appList[mid].getDate().compareToIgnoreCase(date) < 0) {
			return searchHelperDate(date, mid + 1, high);
		} else {
			return searchHelperDate(date, low, mid - 1);
		}
	}

	/**
	 * This method will search the animal list by name. it is recursive, so it
	 * will use the aid of the search helper method, so as to help in the binary
	 * search
	 * 
	 * @param name
	 *            The name you are looking for in the array
	 * @return the animal you are looking for, or null if it doesn't exist
	 */
	private static Animal animSearchName(String name) {

		return searchHelperName(name, 0, animSize() - 1);
	}

	/**
	 * This method will recursively call itself until either the animal is
	 * found, or you reach the end, in which case null will be passed back. It
	 * uses the basic binary search mechanic to search for the animal you want.
	 * 
	 * @param name
	 *            The name you are looking for
	 * @param low
	 *            The bottom border of the binary search
	 * @param high
	 *            The top border of the binary search
	 * @return Either the appointment or null
	 */
	private static Animal searchHelperName(String name, int low, int high) {
		if (low == high) {
			if (animList[low].getName().compareToIgnoreCase(name) == 0) {
				return animList[low];
			} else {
				return null;
			}
		}
		int mid = (low + high) / 2;
		if (animList[mid].getName().compareToIgnoreCase(name) == 0) {
			return animList[mid];
		} else if (animList[mid].getName().compareToIgnoreCase(name) < 0) {
			return searchHelperName(name, mid + 1, high);
		} else {
			return searchHelperName(name, low, mid - 1);
		}
	}

	/**
	 * This method will search the animal list by owner. it is recursive, so it
	 * will use the aid of the search helper method, so as to help in the binary
	 * search
	 * 
	 * @param name
	 *            The name you are looking for in the array
	 * @return the animal you are looking for, or null if it doesn't exist
	 */
	private static Animal animSearchOwner(String name) {

		return searchHelperAnimOwner(name, 0, animSize() - 1);
	}

	/**
	 * This method will recursively call itself until either the animal is
	 * found, or you reach the end, in which case null will be passed back. It
	 * uses the basic binary search mechanic to search for the animal you want.
	 * 
	 * @param name
	 *            The name you are looking for
	 * @param low
	 *            The bottom border of the binary search
	 * @param high
	 *            The top border of the binary search
	 * @return Either the appointment or null
	 */
	private static Animal searchHelperAnimOwner(String name, int low, int high) {
		if (low == high) {
			if (animList[low].getOwner().getName().compareToIgnoreCase(name) == 0) {
				return animList[low];
			} else {
				return null;
			}
		}
		int mid = (low + high) / 2;
		if (animList[mid].getOwner().getName().compareToIgnoreCase(name) == 0) {
			return animList[mid];
		} else if (animList[mid].getOwner().getName().compareToIgnoreCase(name) < 0) {
			return searchHelperAnimOwner(name, mid + 1, high);
		} else {
			return searchHelperAnimOwner(name, low, mid - 1);
		}
	}

	/**
	 * First, this method will make a temporary variable {@code temp} and make
	 * it equal to 0. Then it will check the animal array, and if the ith
	 * variable is not null, it will add 1 to temp. When a null pointer is
	 * found, then it will break the for loop, and return the temp number. This
	 * temp will be how many variables are in the array that are not null.
	 * 
	 * @return temp, which is the number of non-null variables in the array
	 */
	public static int animSize() {
		int temp = 0;
		for (int i = 0; i < animList.length; i++) {
			if (animList[i] != null) {
				temp++;
			} else {
				break;
			}
		}
		return temp;
	}

	/**
	 * First, this method will make a temporary variable {@code temp} and make
	 * it equal to 0. Then it will check the appointment array, and if the ith
	 * variable is not null, it will add 1 to temp. When a null pointer is
	 * found, then it will break the for loop, and return the temp number. This
	 * temp will be how many variables are in the array that are not null.
	 * 
	 * @return temp, which is the number of non-null variables in the array
	 */
	public static int appSize() {
		int temp = 0;
		for (int i = 0; i < appList.length; i++) {
			if (appList[i] != null) {
				temp++;
			} else {
				break;
			}
		}
		return temp;
	}

	/**
	 * This will take in an appointment and check all of the appointment array
	 * for that appointment. If it is found, then it will make that appointment
	 * equal to the appointment in the next cell, and will continuously move
	 * them down one by one until all the appointments are moved one cell to the
	 * left. It will then make the last cell into null, so to complete the
	 * subtraction of the appointment a.
	 * 
	 * @param a
	 *            The appointment you wish to subtract
	 */
	public static void subtractAppointment(Appointment a) {
		for (int i = 0; i < appList.length; i++) {
			if (appList[i] == a) {
				for (int j = i; j < appList.length - 1; j++) {
					appList[j] = appList[j + 1];
				}
				appList[appList.length - 1] = null;
				break;
			}
		}
	}

	/**
	 * This will add an appointment to the appointment array in the next
	 * available spot in the array, which would be at {@code appSize()}
	 * 
	 * @param a
	 *            Is the Appointment being added to the appointment array
	 */
	public static void addAppointment(Appointment a) {
		appList[appSize()] = a;
	}

	/**
	 * This will add an animal to the animal array in the next available spot in
	 * the array, which would be at {@code animSize()}
	 * 
	 * @param a
	 *            Is the Animal being added to the animal array
	 */
	public static void addAnimal(Animal a) {
		animList[animSize()] = a;
	}

	/**
	 * This will print no appointments if there are none, and all the
	 * appointments if there are some. It will also increment them on screen as
	 * appointment 1, appointment 2, etc.
	 */
	public static void printAppointment() {
		if (appSize() == 0) {
			System.out.println("No Appointments");
		} else {
			for (int i = 0; i < appSize(); i++) {
				System.out.println("Appointment " + (i + 1) + ": ");
				System.out.println();
				appList[i].printAppointment();
			}
		}
	}

	/**
	 * This will print no animals if there are none, and all the animals if
	 * there are some. It will also increment them on screen as animal 1, animal
	 * 2, etc.
	 */
	private static void printAnimal() {
		if (animSize() == 0) {
			System.out.println("No Animals");
		} else {
			for (int i = 0; i < animSize(); i++) {
				System.out.println("Animal " + (i + 1) + ": ");
				System.out.println();
				animList[i].printAnimal();
			}
		}
	}

	/**
	 * Used to make sure that only ints are being entered for the parts where
	 * ints are needed.
	 * 
	 * @return the response of the user, or 10 if it's not an int.
	 */
	public static int getInput() {

		int resp; // input of the user

		System.out.print("Input: ");
		Scanner scn = new Scanner(System.in); // object to take input
		try {
			resp = scn.nextInt();
		} catch (InputMismatchException e1) { // catches if the input is not an
												// integer
			resp = 10;
			scn.next();
		}
		return resp; // returns input of the user
	}

	/**
	 * This will save the two lists in the save object, and make a file,
	 * saved.dat, so that you can load it at a later time.
	 * 
	 * @param saveState
	 *            The save object needed to save the lists
	 * @param anim
	 *            the animal list.
	 * @param app
	 *            the appointment list.
	 */
	public static void saveIt(Save saveState, Animal[] anim, Appointment[] app) {
		saveState.setAnimal(anim);
		saveState.setAppointment(app);

		FileOutputStream fos;

		try {
			fos = new FileOutputStream("saved.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(saveState);
			fos.close(); // closes file
			oos.close(); // closes file

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
