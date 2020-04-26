
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentManagement sm = new StudentManagement();
		
		UserInterface ui = new UserInterface();
		
		String[] mainMenu = {"Them hoc sinh", "Cap nhat thong tin hoc sinh", "Xoa hoc sinh", 
				"Xem danh sach hoc sinh", "Xuat danh sach ra file .csv", "Thoat chuong trinh"};
		
		String[] sortBy = {"Sap xep theo MHS", "Sap xep theo diem trung binh"};
		
		String[] order = {"Tang dan", "Giam dan"};
		
		while (true) {
			int option = ui.GetMenuOption(mainMenu);
			switch (option) {
			case 1:
				Student newStudent = new Student();
				if (ui.GetFormInputStudent(newStudent)) {
					sm.AddStudent(newStudent);
				} else {
					Student.maxID--;
				}
				StudentFile.StoreData(sm.getStudentArrayList());
				break;
			case 2:
				int idToUpdate = ui.GetIDStudent();
				if (sm.CheckValidID(idToUpdate)) {
					Student student = sm.GetStudent(idToUpdate);
					ui.ShowStudent(student);
					if (ui.GetFormInputStudent(student)) {
						sm.UpdateStudent(idToUpdate, student);
						StudentFile.StoreData(sm.getStudentArrayList());
					}	
				} else {
					ui.ShowAlert("Ma hoc sinh khong ton tai.");
				}
				break;
			case 3:
				int idToRemove = ui.GetIDStudent();
				if (sm.CheckValidID(idToRemove)) {
					ui.ShowAlert("Ban muon xoa hoc sinh " + sm.GetStudent(idToRemove).GetName() + ", MHS " + idToRemove + "?");
					if (ui.ShowConfirm("Vui long xac nhan thao tac (Y/N): ")) {
						sm.RemoveStudent(idToRemove);
						StudentFile.StoreData(sm.getStudentArrayList());
						ui.ShowAlert("Xoa hoc sinh thanh cong.");
					} else {
						ui.ShowAlert("Thao tac xoa da bi huy.");
					}
				} else {
					ui.ShowAlert("Ma hoc sinh khong ton tai.");
				}
				break;
			case 4:
				String sortByKey = "id";
				boolean isAsc = true;
				int opt = ui.GetMenuOption(sortBy);
				if (opt == 2) {
					sortByKey = "gpa";
				}
				opt = ui.GetMenuOption(order);
				if (opt == 2) {
					isAsc = false;
				}
				sm.ShowStudentList(sortByKey, isAsc);
				break;
			case 5:
				String name = ui.ShowPrompt("Vui long nhap ten file (khong can .csv): ");
				StudentFile.ExportCSV(name, sm.getStudentArrayList());
				ui.ShowAlert("Export thanh cong: " + name + ".csv");
				break;
			case 6:
				ui.ShowAlert("Program is exited!");
				System.exit(0);
			}
			ui.PauseProgram();
		}
		
	}

}
