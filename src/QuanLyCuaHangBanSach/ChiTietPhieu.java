package QuanLyCuaHangBanSach;

public class ChiTietPhieu {
    private String IDSach;
    private int soLuong;
    private int Gia;

    public ChiTietPhieu(String IDSach, int soLuong, int Gia) {
        setIDSach(IDSach);
        setSoLuong(soLuong);
        setGia(Gia);
    }

    public void inChiTietPhieu() {
        System.out.printf("|%-16s|%-16s|%-16s|%-16s|%n", IDSach, soLuong, Gia);
    }

    public String getIDSach() {
        return IDSach;
    }

    public void setIDSach(String IDSach) {
        this.IDSach = IDSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }
}
