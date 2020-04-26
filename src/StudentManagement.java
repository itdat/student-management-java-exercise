import java.util.*;
public class StudentManagement {
	private ArrayList<Student> studentArrayList = new ArrayList<>();
	
	public StudentManagement() {
		StudentFile.LoadData(this.studentArrayList);
	}
	
	public boolean CheckValidID(int id) {
		boolean isValid = false;
		for (int i = 0; i< this.studentArrayList.size(); i++) {
			if (this.studentArrayList.get(i).GetID() == id) {
				isValid = true;
				break;
			}
		}
		return isValid;
	}
	
	public Student GetStudent(int id) {
		for (int i = 0; i < this.studentArrayList.size(); i++) {
			if (this.studentArrayList.get(i).GetID() == id) {
				return this.studentArrayList.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<Student> getStudentArrayList() {
		return this.studentArrayList;
	}
	
	public void AddStudent(Student newStudent) {
		this.studentArrayList.add(newStudent);
	}
	
	public void RemoveStudent(int id) {
		for (int i = 0; i < this.studentArrayList.size(); i++) {
			if (this.studentArrayList.get(i).GetID() == id) {
				this.studentArrayList.remove(i);
				break;
			}
		}
	}
	
	public void UpdateStudent(int id, Student newInfo) {
		for (int i = 0; i < this.studentArrayList.size(); i++) {
			if (this.studentArrayList.get(i).GetID() == id) {
				this.studentArrayList.set(i, newInfo);
				break;
			}
		}
	}
	
	public void ShowStudentList(String sortBy, boolean isAsc) {
		switch(sortBy) {
		case "id":
			Collections.sort(this.studentArrayList, new Comparator<Student>() {
				@Override
				public int compare(Student s1, Student s2) {
					if (isAsc)
						return s1.GetID() > s2.GetID()? 1 : -1;
						else return s1.GetID() < s2.GetID()? 1 : -1;
				}
			});
			break;
		case "gpa":
			Collections.sort(this.studentArrayList, new Comparator<Student>() {
				@Override
				public int compare(Student s1, Student s2) {
					if (isAsc)
						return s1.GetGPA() > s2.GetGPA()? 1 : -1;
						else return s1.GetGPA() < s2.GetGPA()? 1 : -1;
				}
			});
			break;
		}
		
		UserInterface ui = new UserInterface();
		ui.ShowStudentList(this.studentArrayList);
	}
}
