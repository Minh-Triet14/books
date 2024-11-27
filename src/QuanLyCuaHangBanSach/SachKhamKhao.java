package QuanLyCuaHangBanSach;

public class SachKhamKhao extends Sach{
    // Tên sách: Khoa học, Văn học, Kỹ thuật...

    public SachKhamKhao() {
        loaiSach = null;
        this.loaiSach = "Sach kham khao";
    }

    public SachKhamKhao(String maSach, String tenSach, String loaiSach, String doTuoiKhuyenDoc, String maNXB, String maTacGia, int giaThanh, int soLuong) {
        super(maSach, tenSach, loaiSach, doTuoiKhuyenDoc, maNXB, maTacGia, giaThanh, soLuong);
        this.loaiSach = "Sach kham khao";
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


