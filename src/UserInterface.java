import java.util.*;
public class UserInterface {
	public void ShowAlert(String msg) {
		System.out.println(msg);
	}
	
	public boolean ShowConfirm(String msg) {
		System.out.print(msg);
		Scanner sc = new Scanner(System.in);
		char comfirm = sc.next().charAt(0);
		if (comfirm == 'Y') return true;
		else return false;
	}
	
	public String ShowPrompt(String msg) {
		Scanner sc = new Scanner(System.in);
		String val;
		do {
			System.out.print(msg);
			val = sc.nextLine();
		} while (val.isEmpty());
		return val;
	}
	
	public void PauseProgram() {
		System.out.println("Bam phim bat ky de tro lai menu chinh.");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
	}

	public boolean GetFormInputStudent(Student student) {
		Scanner sc = new Scanner(System.in);
		
		String name;
		do {
			System.out.print("Nhap ho va ten hoc sinh: ");
			name = sc.nextLine();
		} while (name.isEmpty());
		
		double gpa;
		do {
			System.out.print("Nhap diem trung binh: ");
			gpa = sc.nextDouble();
		} while (gpa < 0 || gpa > 10);
		sc.nextLine();
		
		String photo;
		do {
			System.out.print("Nhap duong dan den hinh anh: ");
			photo = sc.nextLine();
		} while (photo.isEmpty());
		
		String address;
		do {
			System.out.print("Nhap dia chi: ");
			address = sc.nextLine();
		} while (address.isEmpty());
		
		String note;
		do {
			System.out.print("Nhap ghi chu: ");
			note = sc.nextLine();
		} while (note.isEmpty());
		
		// Confirm
		if (ShowConfirm("Vui long xac nhan thao tac (Y/N): ")) {
			student.SetName(name);
			student.SetGPA(gpa);
			student.SetPhoto(photo);
			student.SetAddress(address);
			student.SetNote(note);
			System.out.println("Thuc hien thanh cong.");
			return true;
		} else {
			System.out.println("Thao tac da huy bo.");
			return false;
		}
	}
	
	public int GetIDStudent() {
		Scanner sc = new Scanner(System.in);
		int id = -1;
		do {
			System.out.print("Nhap ma hoc sinh: ");
			id = sc.nextInt();
		} while (id < 1);
		return id;
	}
	
	public int GetMenuOption(String[] options) {
		for (int i = 0; i < options.length; i++) {
			System.out.println(i + 1 + ". " + options[i]);
		}
		
		int option;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Nhap lua chon: ");
			option =sc.nextInt();
		} while (option < 1 || option > options.length);
		return option;
	}
	
	public void ShowStudent(Student student) {
		if (student == null) {
			System.out.println("Hoc sinh khong ton tai.");
		} else {
			System.out.println("----------------------------------------");
			System.out.println("MHS: " + student.GetID());
			System.out.println("Ho va ten: " + student.GetName());
			System.out.println("Diem trung binh: " + student.GetGPA());
			System.out.println("Hinh anh: " + student.GetPhoto());
			System.out.println("Dia chi: " + student.GetAddress());
			System.out.println("Ghi chu: " + student.GetNote());
		}
	}
	
	public void ShowStudentList(ArrayList<Student> studentArrayList) {
		if (studentArrayList.size() == 0) {
			System.out.println("Danh sach rong!");
		} else {
			for (Student student : studentArrayList) {
				ShowStudent(student);
			}
			System.out.println("----------------------------------------");
		}
	}
}
