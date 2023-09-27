package java_core_bai4;

import java.util.ArrayList;
import java.util.List;

import common.Utilities;

public class HoGiaDinh {
	private String soNha;
	private List<Nguoi> thanhViens = new ArrayList<>();

	public String getSoNha() {
		return soNha;
	}

	public void setSoNha(String soNha) {
		this.soNha = soNha;
	}

	public List<Nguoi> getThanhViens() {
		return thanhViens;
	}

	public void setThanhViens(List<Nguoi> thanhViens) {
		this.thanhViens = thanhViens;
	}
	
	public void showHoGiaDinh() {
		System.out.println("-------------------------------------------------------------------");
		System.out.println("So nha: " + soNha);
		System.out.println("Danh sach thanh vien trong ho gia dinh:");
		thanhViens.stream().forEach(tv -> tv.showNguoi());
	}
	
	public void addThanhViens() {
		System.out.println("So nha: ");
		this.soNha = Utilities.instance().scanner.nextLine();
		System.out.print("Nhap so thanh vien muon them: ");
		int n = Utilities.instance().getValidatedNumber(1, 10, Integer.class);
		for (int i = 0; i < n; i++) {
			System.out.println("-------------");
			System.out.print("So CMND: ");
			String soCMND = Utilities.instance().getNewPrimaryKey("So CMND");
			System.out.print("Ho ten: ");
			String hoTen = Utilities.instance().scanner.nextLine();
			System.out.print("So tuoi: ");
			int tuoi = Utilities.instance().getValidatedNumber(0, 150, Integer.class);
			System.out.print("Nghe nghiep: ");
			String ngheNghiep = Utilities.instance().scanner.nextLine();
			
			Nguoi nguoi = new Nguoi(hoTen, tuoi, ngheNghiep, soCMND);
			this.thanhViens.add(nguoi);
		}
	}
}
