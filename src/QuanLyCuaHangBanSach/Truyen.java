package QuanLyCuaHangBanSach;

public class Truyen extends Sach {
   // Tên sách: Truyện tranh, Truyện ngắn, Tiểu thuyết...

    public Truyen() {
        loaiSach = null;
        this.loaiSach = "Truyen";
    }

    public Truyen(String maSach, String tenSach, String loaiSach,String doTuoiKhuyenDoc, String maNXB, String maTacGia, int giaThanh, int soLuong) {
        super(maSach, tenSach, loaiSach, doTuoiKhuyenDoc, maNXB, maTacGia, giaThanh, soLuong);
        this.loaiSach = "Truyen";
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
