package QuanLyCuaHangBanSach;

public class QuanLy extends NhanVien {

    public QuanLy(String id, String hoTen, String diaChi, String SDT, String ngaySinh, String gioiTinh, String CMND, String password, int mucLuong) {
        super(id, hoTen, diaChi, SDT, ngaySinh, gioiTinh, CMND, password, mucLuong);
    }


    @Override
    public void xuatThongTin() {
        System.out.printf("|%-16s|%-16s|%-16s|%-10s|%-10s|%-10s|%-9s|%-16s|", id, hoTen, diaChi, SDT, ngaySinh, gioiTinh, CMND, password);
        System.out.println();
    }

    @Override
    public String toString()
    {
        return super.toString();
    }

}
