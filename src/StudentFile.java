import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
public class StudentFile {
	
	private static final String FILE_NAME = "student-management-data.bin";
	
	public static void StoreData(ArrayList<Student> studentArrayList) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			oos.write(studentArrayList.size());
			for (Student student : studentArrayList) {
				oos.writeObject(student);
			}
			oos.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void LoadData(ArrayList<Student> studentArrayList) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
			Student student = null;
			int number = ois.read();
			for (int i = 0; i < number; i++) {
				student = (Student) ois.readObject();
				studentArrayList.add(student);
			}
			Student.maxID = studentArrayList.get(studentArrayList.size() - 1).GetID();
			ois.close();
		}
		catch(FileNotFoundException e) {
//			System.err.println("[Khong tim thay file " + FILE_NAME + "]");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void ExportCSV(String name, ArrayList<Student> studentArrayList) {
		try {
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(name + ".csv"), StandardCharsets.UTF_8);
			writer.write("MSH,Ho va ten,Diem trung binh,Hinh anh,Dia chi,Ghi chu\n");
			for (Student student : studentArrayList) {
				writer.write(student.GetID() + "," + student.GetName() + "," + student.GetGPA() + "," + 
			student.GetPhoto() + "," + student.GetAddress() + "," + student.GetNote() + "\n");
			}
			writer.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
