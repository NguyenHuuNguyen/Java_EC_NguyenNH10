package java_core_bai3;

import common.Utilities;

public class Main {

	public static void main(String[] args) {
		while (true) {
			System.out.println("===== Quan Ly Thi Sinh =====");
			System.out.println("1. Them moi thi sinh");
			System.out.println("2. Xem danh sach thi sinh");
			System.out.println("3. Tim kiem thi sinh");
			System.out.println("4. Thoat");
			System.out.print("Chon chuc nang (1/2/3/4): ");
			int choice = Utilities.instance().getValidatedNumber(1, 4, Integer.class);

			switch (choice) {
				case 1:
					TuyenSinh.instance().addThiSinh();
					break;
				case 2:
					TuyenSinh.instance().showThiSinhs();
					break;
				case 3:
					System.out.print("Nhap SBD: ");
					String soBD = Utilities.instance().scanner.nextLine()
;					TuyenSinh.instance().searchThiSinh(soBD);
					break;
				case 4:
					System.out.println("===Da thoat chuong trinh===");
					System.exit(0);
				default:
					System.out.println("Lua chon khong hop le");
			}
			Utilities.instance().scanner.nextLine();
		}
	}

}
