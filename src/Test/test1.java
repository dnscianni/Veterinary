package Test;

import edu.csupomona.cs.cs141.prog_assgmnt_4.*;

public class test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Owner o = new Owner("David Scianni", "7818 Danby Ave. Whittier, Ca, 90606", "562-652-3806");
		Dog d = new Dog(o, "Jazzi", 7, 2);
		
		Disease d1 = new Disease("Dry Skin", true);
		Disease d2 = new Disease("Fleas", false);
		
		d.addDisease(d1);
		d.addDisease(d2);
		
		d.addVaccination("Rabies Shot");
		d.addVaccination("Lyme Disease Shot");
		
		Appointment a1 = new Appointment("12/05/13", "5:30pm", d);
		Appointment a2 = new Appointment("12/07/13", "5:30pm", d);
		Appointment a3 = new Appointment("12/09/13", "5:30pm", d);
		Appointment a4 = new Appointment("12/11/13", "5:30pm", d);
		Appointment a5 = new Appointment("13/01/13", "5:30pm", d);
		
		d.addAppointment(a1);
		d.addAppointment(a2);
		d.addAppointment(a3);
		d.addAppointment(a4);
		d.addAppointment(a5);
		
		d.printAnimal();
		
		d.subtractAppointment(a3);
		d.setDiseaseStatus(1, true);
		
		d.printAnimal();
	}

}
