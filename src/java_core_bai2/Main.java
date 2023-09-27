package java_core_bai2;

import common.Utilities;

public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.println("===== Quan Ly Tai Lieu =====");
            System.out.println("1. Them moi tai lieu");
            System.out.println("2. Xoa tai lieu");
            System.out.println("3. Hien thi danh sach tai lieu");
            System.out.println("4. Tim kiem tai lieu theo loai");
            System.out.println("5. Thoat");
            System.out.print("Chon chuc nang (1-5): ");

            int choice = Utilities.instance().getValidatedNumber(1, 5, Integer.class);

            switch (choice) {
                case 1:
                    QuanLySach.instance().themMoiTaiLieu();
                    break;
                case 2:
                    QuanLySach.instance().xoaTaiLieu();
                    break;
                case 3:
                    QuanLySach.instance().hienThiThongTinTaiLieu();
                    break;
                case 4:
                    QuanLySach.instance().timKiemTaiLieuTheoLoai();
                    break;
                case 5:
                    System.out.println("Da thoat chuong trinh.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
            Utilities.instance().scanner.nextLine();
        }
    }
}