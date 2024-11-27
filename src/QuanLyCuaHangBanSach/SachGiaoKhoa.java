package QuanLyCuaHangBanSach;


public class SachGiaoKhoa extends Sach {
    // Tên sách: Ngữ văn, Toán, Lịch sử,...

    public SachGiaoKhoa() {
        loaiSach = null;
        this.loaiSach = "Sach giao khoa";
    }

    public SachGiaoKhoa(String maSach, String tenSach, String loaiSach,String doTuoiKhuyenDoc, String maNXB, String maTacGia, int giaThanh, int soLuong) {
        super(maSach, tenSach, loaiSach, doTuoiKhuyenDoc, maNXB, maTacGia, giaThanh, soLuong);
        this.loaiSach = "Sach Giao Khoa";
    }

    @Override
    public void Nhap(String maSach) {
        this.tenSach = Check.takeStringInput("Nhap ten sach: ");
        super.Nhap(maSach);
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
    }
}
