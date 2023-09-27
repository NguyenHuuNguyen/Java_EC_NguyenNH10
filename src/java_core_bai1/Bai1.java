package java_core_bai1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class CanBo {
	private String hoTen;
	private int tuoi;
	private String gioiTinh;
	private String diaChi;

	public CanBo(String hoTen, int tuoi, String gioiTinh, String diaChi) {
		this.hoTen = hoTen;
		this.tuoi = tuoi;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
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

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
}

// Class CongNhan kế thừa từ CanBo
class CongNhan extends CanBo {
	private int bac;

	public CongNhan(String hoTen, int tuoi, String gioiTinh, String diaChi, int bac) {
		super(hoTen, tuoi, gioiTinh, diaChi);
		this.bac = bac;
	}

	public int getBac() {
		return bac;
	}

	public void setBac(int bac) {
		this.bac = bac;
	}
}

// Class KySu kế thừa từ CanBo
class KySu extends CanBo {
	private String nganhDaoTao;

	public KySu(String hoTen, int tuoi, String gioiTinh, String diaChi, String nganhDaoTao) {
		super(hoTen, tuoi, gioiTinh, diaChi);
		this.nganhDaoTao = nganhDaoTao;
	}

	public String getNganhDaoTao() {
		return nganhDaoTao;
	}

	public void setNganhDaoTao(String nganhDaoTao) {
		this.nganhDaoTao = nganhDaoTao;
	}
}

// Class NhanVien kế thừa từ CanBo
class NhanVien extends CanBo {
	private String congViec;

	public NhanVien(String hoTen, int tuoi, String gioiTinh, String diaChi, String congViec) {
		super(hoTen, tuoi, gioiTinh, diaChi);
		this.congViec = congViec;
	}

	public String getCongViec() {
		return congViec;
	}

	public void setCongViec(String congViec) {
		this.congViec = congViec;
	}
}

// Class quản lý cán bộ (QLCB)
class QLCB {
	private List<CanBo> danhSachCanBo = new ArrayList<>();

	public void themCanBo(CanBo canBo) {
		danhSachCanBo.add(canBo);
	}

	public void timKiemTheoHoTen(String hoTen) {
		boolean timThay = false;
		for (CanBo canBo : danhSachCanBo) { // Nên đưa vào ToString
			if (canBo.getHoTen().equalsIgnoreCase(hoTen)) {
				System.out.println("Thong tin can bo: ");
				System.out.println("Ho ten: " + canBo.getHoTen());
				System.out.println("Tuoi: " + canBo.getTuoi());
				System.out.println("Gioi tinh: " + canBo.getGioiTinh());
				System.out.println("Dia chi: " + canBo.getDiaChi());

				if (canBo instanceof CongNhan) {
					System.out.println("Bac: " + ((CongNhan) canBo).getBac());
				} else if (canBo instanceof KySu) {
					System.out.println("Nganh dao tao: " + ((KySu) canBo).getNganhDaoTao());
				} else if (canBo instanceof NhanVien) {
					System.out.println("Cong viec: " + ((NhanVien) canBo).getCongViec());
				}

				timThay = true;
				break;
			}
		}

		if (!timThay) {
			System.out.println("Khong tim thay can bo co ten: " + hoTen);
		}
	}

	public void hienThiDanhSach() {
		System.out.println("Danh sach cac can bo:");
		for (CanBo canBo : danhSachCanBo) {
			String hoTen = canBo.getHoTen();
			String tuoi = Integer.toString(canBo.getTuoi());
			String gioiTinh = canBo.getGioiTinh();
			String diaChi = canBo.getDiaChi();

			// �?ộ dài cố định cho mỗi thuộc tính
			int maxLength = 15;

			// �?ịnh dạng thông tin. �?ưa vô ToString cho khoẻ
			String hoTenFormatted = String.format("%-20s", hoTen);
			String tuoiFormatted = String.format("%-" + maxLength + "s", tuoi);
			String gioiTinhFormatted = String.format("%-" + maxLength + "s", gioiTinh);
			String diaChiFormatted = String.format("%-" + maxLength + "s", diaChi);

			String thongTinCanBo = String.format("Ho ten: %s | Tuoi: %s | Gioi tinh: %s | Dia chi: %s", hoTenFormatted,
					tuoiFormatted, gioiTinhFormatted, diaChiFormatted);

			if (canBo instanceof CongNhan) {
				CongNhan congNhan = (CongNhan) canBo;
				String bac = Integer.toString(congNhan.getBac());
				String bacFormatted = String.format("%-" + maxLength + "s", bac);
				thongTinCanBo += String.format(" | Bac: %s", bacFormatted);
			} else if (canBo instanceof KySu) {
				KySu kySu = (KySu) canBo;
				String nganhDaoTao = kySu.getNganhDaoTao();
				String nganhDaoTaoFormatted = String.format("%-" + maxLength + "s", nganhDaoTao);
				thongTinCanBo += String.format(" | Nganh dao tao: %s", nganhDaoTaoFormatted);
			} else if (canBo instanceof NhanVien) {
				NhanVien nhanVien = (NhanVien) canBo;
				String congViec = nhanVien.getCongViec();
				String congViecFormatted = String.format("%-" + maxLength + "s", congViec);
				thongTinCanBo += String.format(" | Cong viec: %s", congViecFormatted);
			}

			System.out.println(thongTinCanBo);
		}
	}
}

public class Bai1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		QLCB quanLyCB = new QLCB();

		while (true) {
			System.out.println("===== Quan Ly Can Bo =====");
			System.out.println("1. Them moi can bo");
			System.out.println("2. Tim kiem theo ho ten");
			System.out.println("3. Hien thi danh sach can bo");
			System.out.println("4. Thoat");
			System.out.print("Chon chuc nang (1/2/3/4): ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				// Thêm mới cán bộ
				int loaiCanBo;
				while (true) {
					System.out.print("Nhap loai can bo (1: Cong nhan, 2: Ky su, 3: Nhan vien): ");
					loaiCanBo = scanner.nextInt();
					scanner.nextLine();
					if (loaiCanBo > 3 || loaiCanBo < 1) {
						System.out.println("Loai can bo khong hop le. Vui long nhap lai: ");
					} else
						break;
				}
				;

				System.out.print("Nhap ho ten: "); // Check null
				String hoTen = scanner.nextLine();

				System.out.print("Nhap tuoi: ");
				int tuoi = scanner.nextInt();
				scanner.nextLine();

				String gioiTinh;
				while (true) {
					System.out.print("Nhap gioi tinh(Nam/Nu/Attack Helicopter): ");
					gioiTinh = scanner.nextLine();
					List<String> gioiTinhCheckList = Arrays.asList(new String[] { "Nam", "Nu", "Attack Helicopter" });
					if (!gioiTinhCheckList.stream().anyMatch(gioiTinh::equalsIgnoreCase)) {
						System.out.println("Gioi tinh khong hop le. Vui long nhap lai: ");
					} else
						break;
				}

				System.out.print("Nhap dia chi: ");
				String diaChi = scanner.nextLine();

				CanBo canBo = null;

				switch (loaiCanBo) {
				case 1:
					// Thêm công nhân
					int bac;
					while (true) {
						System.out.print("Nhap bac(1-10): ");
						bac = scanner.nextInt();
						scanner.nextLine();
						if (bac > 10 || bac < 1) {
							System.out.println("Bac khong hop le. Vui long nhap lai: ");
						} else
							break;
					}
					;
					canBo = new CongNhan(hoTen, tuoi, gioiTinh, diaChi, bac);
					break;
				case 2:
					// Thêm kỹ sư
					System.out.print("Nhap nganh dao tao: ");
					String nganhDaoTao = scanner.nextLine();
					canBo = new KySu(hoTen, tuoi, gioiTinh, diaChi, nganhDaoTao);
					break;
				case 3:
					// Thêm nhân viên
					System.out.print("Nhap cong viec: ");
					String congViec = scanner.nextLine();
					canBo = new NhanVien(hoTen, tuoi, gioiTinh, diaChi, congViec);
					break;
				default:
					System.out.println("Lua chon khong hop le. Vui long chon lai");
					break;
				}

				if (canBo != null) {
					quanLyCB.themCanBo(canBo);
					System.out.println("Them can bo thanh cong.");
				}
				break;
			case 2:
				// Tìm kiếm theo h�? tên
				System.out.print("Nhap ho ten can tim: ");
				String tenCanTim = scanner.nextLine();
				quanLyCB.timKiemTheoHoTen(tenCanTim);
				break;
			case 3:
				// Hiển thị danh sách cán bộ
				quanLyCB.hienThiDanhSach();
				break;
			case 4:
				// Thoát chương trình
				System.out.println("Da thoat chuong trinh.");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Lua chon khong hop le. Vui long chon lai.");
				break;
			}
			scanner.nextLine();
			System.out.println("");
		}
	}
}