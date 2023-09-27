package java_core_bai3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import common.Constants;

public class ThiSinh {
	private String soBD;
	private String hoTen;
	private String diaCHi;
	private int mucUuTien;
	private List<MonThi> monThis = new ArrayList<>();

	public ThiSinh(String soBD, String hoTen, String diaCHi, int mucUuTien, List<MonThi> monThis) {
		this.soBD = soBD;
		this.hoTen = hoTen;
		this.diaCHi = diaCHi;
		this.mucUuTien = mucUuTien;
		this.monThis = monThis;
	}

	public String getSoBD() {
		return soBD;
	}

	public void setSoBD(String soBD) {
		this.soBD = soBD;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaCHi() {
		return diaCHi;
	}

	public void setDiaCHi(String diaCHi) {
		this.diaCHi = diaCHi;
	}

	public int getMucUuTien() {
		return mucUuTien;
	}

	public void setMucUuTien(int mucUuTien) {
		this.mucUuTien = mucUuTien;
	}

	public List<MonThi> getMonThis() {
		return monThis;
	}

	public void setMonThis(List<MonThi> monThis) {
		this.monThis = monThis;
	}
	
	public void showThiSinh() {
		System.out.println("----------------------------------------------------------");
		String soCMNDFormatted = String.format("%-10s", soBD);
		String hoTenFormatted = String.format("%-15s", hoTen);
		String mucUuTienFormatted = String.format("%-4s", mucUuTien);
		String diaChiFormatted = String.format("%-15s", diaCHi);
		String khoiThis = getKhoiThiThichHop();
		
		String thiSinhFormatted = String.format("So bao danh: %s | Ho ten: %s | Dia chi: %s | Muc uu tien: %s"
				, soCMNDFormatted, hoTenFormatted, diaChiFormatted, mucUuTienFormatted);
		System.out.println(thiSinhFormatted);
		
		System.out.println("Khoi thi: " + khoiThis);
		monThis.stream()
        .sorted(Comparator.comparing(MonThi::getTenMon))
        .forEach(m -> {
            System.out.println(String.format("Ten mon: %-7s, Diem: %s", m.getTenMon(), m.getDiem()));
        });
	}
	
	public String getKhoiThiThichHop() {
	    List<String> tenMonThis = new ArrayList<>();
	    for (MonThi monThi : monThis) {
	    	tenMonThis.add(monThi.getTenMon());
	    }

	    StringBuilder khoiThiThichHop = new StringBuilder();

	    for (KhoiThi khoiThi : Constants.KHOI_THIS) {
	        boolean isKhoiThiThichHop = true;
	        for (String monThiKhoi : khoiThi.getMonThiCuaKhoi()) {
	            if (!tenMonThis.contains(monThiKhoi)) {
	            	isKhoiThiThichHop = false;
	                break;
	            }
	        }
	        if (isKhoiThiThichHop) {
	            if (!khoiThiThichHop.isEmpty()) {
	                khoiThiThichHop.append(", ");
	            }
	            khoiThiThichHop.append(khoiThi.getTenKhoi());
	        }
	    }

	    return khoiThiThichHop.toString();
	}
}
