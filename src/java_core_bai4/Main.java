package java_core_bai4;

import java.util.ArrayList;

import common.Utilities;

public class Main {
	private static KhuPho kp = new KhuPho(new ArrayList<HoGiaDinh>());	

	public static void main(String[] args) {
		while (true) {
			System.out.println("===== Quan Ly Khu Pho =====");
			System.out.println("1. Them moi ho dan");
			System.out.println("2. Xem danh sach ho dan");
			System.out.println("3. Thoat");
			System.out.print("Chon chuc nang (1/2/3): ");
			int choice = Utilities.instance().getValidatedNumber(1, 3, Integer.class);

			switch (choice) {
				case 1:
					kp.addHoGiaDinhs();
					break;
				case 2:
					kp.showKhuPho();
					break;
				case 3:
					System.out.println("===Da thoat chuong trinh===");
					System.exit(0);
				default:
					System.out.println("Lua chon khong hop le");
			}
			Utilities.instance().scanner.nextLine();
		}
	}

}
