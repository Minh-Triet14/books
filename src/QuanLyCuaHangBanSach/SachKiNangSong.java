package QuanLyCuaHangBanSach;

public class SachKiNangSong extends Sach {
    // Tên sách: Giao tiếp, Lãnh đạo,...

    public SachKiNangSong() {
        loaiSach = null;
        this.loaiSach = "Sach ki nang song";
    }

    public SachKiNangSong(String maSach, String tenSach, String loaiSach, String doTuoiKhuyenDoc, String maNXB, String maTacGia, int giaThanh, int soLuong) {
        super(maSach, tenSach, loaiSach, doTuoiKhuyenDoc, maNXB, maTacGia, giaThanh, soLuong);
        this.loaiSach = "Sach ki nang song";
    }

    @Override
    public void Nhap(String maSach) {
        this.tenSach = Check.getAlphabetOnlyInput("Nhap ten sach: ");
        super.Nhap(maSach);
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
    }
}
