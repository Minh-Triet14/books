package QuanLyCuaHangBanSach;

public class ChiTietHoaDon {
    public String maSach;
    public int sLuong;
    public int giaThanh;

    public ChiTietHoaDon() {
        this.maSach = null;
        this.sLuong = 0;
        this.giaThanh = 0;
    }

    public ChiTietHoaDon(String maSach, int sLuong, int giaThanh) {
        setMaSach(maSach);
        setSLuong(sLuong);
        setGiaThanh(giaThanh);
    }


    public void xuatThongTin(String maHD) {
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%n", maHD, getMaSach(), getSLuong(), getGiaThanh());
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public int getSLuong() {
        return sLuong;
    }

    public void setSLuong(int soLuong) {
        this.sLuong = soLuong;
    }

    public int getGiaThanh() {
        return giaThanh;
    }

    public void setGiaThanh(int giaThanh) {
        this.giaThanh = giaThanh;
    }
}
