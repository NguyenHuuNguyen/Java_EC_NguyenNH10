package common;

import java.util.ArrayList;
import java.util.List;

import java_core_bai3.KhoiThi;
import java_core_bai5.RoomType;

public class Constants {
	public static final List<KhoiThi> KHOI_THIS = createKhoiThis();
	public static final String[] MONTHI_ALLOWED = {"Toan", "Ly", "Hoa", "Sinh", "Van", "Su", "Dia"};
	public static final List<RoomType> ROOM_TYPES = createRoomTypes();
	public static final String METER_NUMBER = "Meter number";
	
	// Ko xài static, hoặc xài lazy initialization, nhưng mà chơi static constant đi a :D
    private static List<KhoiThi> createKhoiThis() {
        List<KhoiThi> khoiThis = new ArrayList<>();
        khoiThis.add(new KhoiThi("A", new String[]{"Toan", "Ly", "Hoa"}));
        khoiThis.add(new KhoiThi("B", new String[]{"Toan", "Hoa", "Sinh"}));
        khoiThis.add(new KhoiThi("C", new String[]{"Van", "Su", "Dia"}));
        return khoiThis;
    }

	private static List<RoomType> createRoomTypes() {
		List<RoomType> roomTypes = new ArrayList<>();
		roomTypes.add(new RoomType("A", 500));
		roomTypes.add(new RoomType("B", 300));
		roomTypes.add(new RoomType("C", 100));
		return roomTypes;
	}
}
