package java_core_bai4;

import java.util.ArrayList;
import java.util.List;

import common.Utilities;

public class KhuPho {
	private List<HoGiaDinh> hoGiaDinhs = new ArrayList<>();

	public KhuPho(List<HoGiaDinh> hoGiaDinhs) {
		this.hoGiaDinhs = hoGiaDinhs;
	}

	public List<HoGiaDinh> getHoGiaDinhs() {
		return hoGiaDinhs;
	}

	public void setHoGiaDinhs(List<HoGiaDinh> hoGiaDinhs) {
		this.hoGiaDinhs = hoGiaDinhs;
	}
	
	public void addHoGiaDinh(HoGiaDinh hoGiaDinh) {
		this.hoGiaDinhs.add(hoGiaDinh);
	}
	
	public void showKhuPho() {
		System.out.println("Danh sach cac ho gia dinh trong khu pho:");
		hoGiaDinhs.stream().forEach(h -> h.showHoGiaDinh());
	}
	
	public void addHoGiaDinhs() {
		System.out.print("Nhap so ho gia dinh muon them: ");
		int n = Utilities.instance().getValidatedNumber(1, 5, Integer.class);
		for (int i = 0; i < n; i++) {
			System.out.println("-------------------------------------------------------------------------------");
			HoGiaDinh hgd = new HoGiaDinh();
			hgd.addThanhViens();
			this.hoGiaDinhs.add(hgd);
		}
	}
}
