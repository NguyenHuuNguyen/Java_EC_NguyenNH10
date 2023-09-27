package java_core_bai4;

public class Nguoi {
	private String hoTen;
	private int tuoi;
	private String ngheNghiep;
	private String soCMND;

	public Nguoi(String hoTen, int tuoi, String ngheNghiep, String soCMND) {
		this.hoTen = hoTen;
		this.tuoi = tuoi;
		this.ngheNghiep = ngheNghiep;
		this.soCMND = soCMND;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getNgheNghiep() {
		return ngheNghiep;
	}

	public void setNgheNghiep(String ngheNghiep) {
		this.ngheNghiep = ngheNghiep;
	}

	public String getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}
	
	public void showNguoi() {
		String soCMNDFormatted = String.format("%-10s", soCMND);
		String hoTenFormatted = String.format("%-15s", hoTen);
		String tuoiFormatted = String.format("%-4s", tuoi);
		String ngheNghiepFormatted = String.format("%-20s", ngheNghiep);

		String nguoiFormatted = String.format("So SMND: %s | Ho ten: %s | Tuoi: %s | Nghe nghiep: %s"
				, soCMNDFormatted, hoTenFormatted, tuoiFormatted, ngheNghiepFormatted);
		System.out.println(nguoiFormatted);
	}
}
