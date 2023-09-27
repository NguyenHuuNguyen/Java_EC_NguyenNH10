package java_core_bai2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import common.Utilities;

public class QuanLySach {
	private List<TaiLieu> taiLieus = new ArrayList<>();
	private static QuanLySach _instance;

	public static QuanLySach instance() {
		if (_instance == null) {
			_instance = new QuanLySach();
		}
		return _instance;
	}

	private QuanLySach() {
	}

	public void themMoiTaiLieu() {
		System.out.println("1. Sach");
		System.out.println("2. Tap chi");
		System.out.println("3. Bao");
		System.out.print("Chon loai tai lieu can them: ");
		int loaiTaiLieu = Utilities.instance().getValidatedNumber(1, 3, Integer.class);

		String loaiTaiLieuText = "";
		switch (loaiTaiLieu) {
		case 1:
			loaiTaiLieuText = "Sach";
			break;
		case 2:
			loaiTaiLieuText = "Tap chi";
			break;
		case 3:
			loaiTaiLieuText = "Bao";
			break;
		default:
			System.out.println("Loai tai lieu khong hop le.");
			return;
		}

		System.out.print("Ma tai lieu: ");
		String maTaiLieu = Utilities.instance().getNewPrimaryKey("Ma tai lieu");
		System.out.print("Ten nha xuat ban: ");
		String tenNhaXuatBan = Utilities.instance().getValidatedString("^(?!\\s*$).+$", "Ten nha xuat ban:");
		System.out.print("So ban phat hanh: ");
		int soBanPhatHanh = Utilities.instance().getValidatedNumber(1, 1000, Integer.class);

		if (loaiTaiLieuText.equals("Sach")) {
			System.out.print("Ten tac gia: ");
			String tenTacGia = Utilities.instance().getValidatedString("^(?!\\s*$).+$", "Ten tac gia:");
			System.out.print("So trang: ");
			int soTrang = Utilities.instance().getValidatedNumber(1, 10000, Integer.class);

			taiLieus.add(new Sach(maTaiLieu, tenNhaXuatBan, soBanPhatHanh, tenTacGia, soTrang));
		} else if (loaiTaiLieuText.equals("Tap chi")) {
			System.out.print("So phat hanh: ");
			int soPhatHanh = Utilities.instance().getValidatedNumber(1, 100, Integer.class);
			System.out.print("Thang phat hanh: ");
			int thangPhatHanh = Utilities.instance().getValidatedNumber(1, 12, Integer.class);

			taiLieus.add(new TapChi(maTaiLieu, tenNhaXuatBan, soBanPhatHanh, soPhatHanh, thangPhatHanh));
		} else if (loaiTaiLieuText.equals("Bao")) {
			System.out.print("Ngay phat hanh (dd-MM-yyyy): ");
			String ngayPhatHanh = Utilities.instance().getValidatedString("\\d{2}-\\d{2}-\\d{4}",
					"Ngay phat hanh (dd-MM-yyyy): ");

			taiLieus.add(new Bao(maTaiLieu, tenNhaXuatBan, soBanPhatHanh, ngayPhatHanh));
		}
	}

	public void xoaTaiLieu() {
		if (taiLieus.isEmpty()) {
			System.out.println("Danh sach tai lieu rong. Khong co tai lieu de xoa.");
			return;
		}

		System.out.print("Nhap ma tai lieu can xoa: ");
		String maTaiLieu = Utilities.instance().getExistingPrimaryKey("Ma tai lieu");
		TaiLieu taiLieu = taiLieus.stream().filter(t -> t.getMaTaiLieu().equalsIgnoreCase(maTaiLieu)).findFirst()
				.orElse(null);

		if (taiLieu == null) {
			System.out.println("Khong tim thay tai lieu co ma " + maTaiLieu);
		} else {
			taiLieus.remove(taiLieu);
			System.out.println("Tai lieu co ma " + maTaiLieu + " da bi xoa.");
		}
	}

	public void hienThiThongTinTaiLieu() {
		if (taiLieus.isEmpty()) {
			System.out.println("Danh sach tai lieu rong. Khong co tai lieu de hien thi.");
			return;
		}

		System.out.println("Danh sach tai lieu:");
		for (TaiLieu taiLieu : taiLieus) {
			System.out.println(taiLieu.showInfor());
		}
	}

	public void timKiemTaiLieuTheoLoai() {
		if (taiLieus.isEmpty()) {
			System.out.println("Danh sach tai lieu rong. Khong co tai lieu de tim kiem.");
			return;
		}

		System.out.println("1. Sach");
		System.out.println("2. Tap chi");
		System.out.println("3. Bao");
		System.out.print("Chon loai tai lieu can tim kiem:");
		
		int loaiTaiLieu = Utilities.instance().getValidatedNumber(1, 3, Integer.class);

		List<TaiLieu> taiLieuTheoLoai = new ArrayList<>();

		switch (loaiTaiLieu) {
		case 1:
			taiLieuTheoLoai = taiLieus.stream().filter(t -> t instanceof Sach).collect(Collectors.toList());
			break;
		case 2:
			taiLieuTheoLoai = taiLieus.stream().filter(t -> t instanceof TapChi).collect(Collectors.toList());
			break;
		case 3:
			taiLieuTheoLoai = taiLieus.stream().filter(t -> t instanceof Bao).collect(Collectors.toList());
			break;
		default:
			System.out.println("Loai tai lieu khong hop le.");
			return;
		}

		if (taiLieuTheoLoai.isEmpty()) {
			System.out.println("Khong tim thay tai lieu loai " + loaiTaiLieu);
		} else {
			System.out.println("Danh sach tai lieu loai " + loaiTaiLieu + ":");
			for (TaiLieu taiLieu : taiLieuTheoLoai) {
				System.out.println(taiLieu.showInfor());
			}
		}
	}
}
