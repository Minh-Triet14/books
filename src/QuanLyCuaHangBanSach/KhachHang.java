package QuanLyCuaHangBanSach;

public class KhachHang extends Nguoi {

    public KhachHang(String id, String hoTen, String diaChi, String SDT, String ngaySinh, String gioiTinh, String CMND, String password) {
        super(id, hoTen, diaChi, SDT, ngaySinh, gioiTinh, CMND, password);
    }

    @Override
    public void xuatThongTin() {
        System.out.printf("│%-16s│%-16s│%-16s│%-10s│%-10s│%-10s│%-9s│%-16s│%n", id, hoTen, diaChi, SDT, ngaySinh, gioiTinh, CMND, password);
    }   

    @Override
    public String toString()
    {
        return super.toString();
    }
}
