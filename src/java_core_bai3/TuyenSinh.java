package java_core_bai3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import common.Constants;
import common.Utilities;

public class TuyenSinh {
	private static TuyenSinh _instance;
	private List<ThiSinh> thiSinhs = new ArrayList<>();
	
	// Singleton pattern
	public static TuyenSinh instance() {
		if (_instance == null) {
			_instance = new TuyenSinh();
		}
		return _instance;
	}
	
	private TuyenSinh() {
		
	}

	public List<ThiSinh> getThiSinhs() {
		return thiSinhs;
	}

	public void setThiSinhs(List<ThiSinh> thiSinhs) {
		this.thiSinhs = thiSinhs;
	}
	
	public void addThiSinh() {
		System.out.print("So bao danh: ");
		String soBD = Utilities.instance().getNewPrimaryKey("So bao danh");
		System.out.print("Ho ten: ");
		String hoTen = Utilities.instance().scanner.nextLine();
		System.out.print("Dia chi: ");
		String diaChi = Utilities.instance().scanner.nextLine();
		System.out.print("Muc uu tien(1-10): ");
		int mucUuTien = Utilities.instance().getValidatedNumber(1, 10, Integer.class);
		List<MonThi> monThis = new ArrayList<>();
		
		while (true) {
            System.out.print("Nhap diem (nhap break de ket thuc): ");
            String input = Utilities.instance().getValidatedString("break|^(\\w+):\\s*([0-9]|10)$", "Cu phap khong hop le.\n");

            if (input.equalsIgnoreCase("break")) {
                break;
            }
            
            String[] parts = input.split(":\\s*");
            String tenMon = parts[0];
            if (Arrays.asList(Constants.MONTHI_ALLOWED).contains(tenMon)) {
                int diem = Integer.parseInt(parts[1]);
                monThis.add(new MonThi(tenMon, diem));
            } else {
                System.out.println("Mon thi khong hop le.");
            }
        }
		
		ThiSinh thiSinh = new ThiSinh(soBD, hoTen, diaChi, mucUuTien, monThis);
		this.thiSinhs.add(thiSinh);
	}
	
	public void showThiSinhs() {
		thiSinhs.stream().forEach(ts -> ts.showThiSinh());
	}

	public void searchThiSinh(String soBD) {
		Optional<ThiSinh> thiSinhOptional = thiSinhs.stream()
	            .filter(ts -> ts.getSoBD().equals(soBD))
	            .findFirst();
	    
	    if (thiSinhOptional.isPresent()) {
	        thiSinhOptional.get().showThiSinh();
	    } else {
	        System.out.println("Không tim thay thi sinh voi so bao danh " + soBD);
	    }
	}
}
