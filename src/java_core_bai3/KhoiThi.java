package java_core_bai3;

public class KhoiThi {
	private String tenKhoi;
	private String[] monThiCuaKhoi;

	public KhoiThi(String tenKhoi, String[] monThiCuaKhoi) {
		this.tenKhoi = tenKhoi;
		this.monThiCuaKhoi = monThiCuaKhoi;
	}

	public String getTenKhoi() {
		return tenKhoi;
	}

	public void setTenKhoi(String tenKhoi) {
		this.tenKhoi = tenKhoi;
	}

	public String[] getMonThiCuaKhoi() {
		return monThiCuaKhoi;
	}

	public void setMonThiCuaKhoi(String[] monThiCuaKhoi) {
		this.monThiCuaKhoi = monThiCuaKhoi;
	}

}
