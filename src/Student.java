import java.io.*;
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	static int maxID = 0;
	
	private int id;
	private String name;
	private double gpa;
	private String photo;
	private String address;
	private String note;
	
	// Constructor
	
	public Student() {
		this.id = ++maxID;
	};
	
	public Student(String name, double gpa, String photo, String address, String note) {
		this.id = ++maxID;
		this.name = name;
		this.gpa = gpa;
		this.photo = photo;
		this.address = address;
		this.note = note;
	}
	
	
	// Getter & Setter
	
	public int GetID() {
		return this.id;
	}
	
	public String GetName() {
		return this.name;
	}
	
	public void SetName(String name) {
		this.name = name;
	}
	
	public double GetGPA() {
		return this.gpa;
	}
	
	public void SetGPA(double gpa) {
		this.gpa = gpa;
	}
	
	public String GetPhoto() {
		return this.photo;
	}
	
	public void SetPhoto(String photo) {
		this.photo = photo;
	}
	
	public String GetAddress() {
		return this.address;
	}
	
	public void SetAddress(String address) {
		this.address = address;
	}
	
	public String GetNote() {
		return this.note;
	}
	
	public void SetNote(String note) {
		this.note = note;
	}
}
