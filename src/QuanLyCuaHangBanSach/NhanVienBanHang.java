package QuanLyCuaHangBanSach;

public class NhanVienBanHang extends NhanVien {

    public NhanVienBanHang(String id, String hoTen, String diaChi, String SDT, String ngaySinh, String gioiTinh, String CMND, String password, int mucLuong) {
        super(id, hoTen, diaChi, SDT, ngaySinh, gioiTinh, CMND, password, mucLuong);
    }

    @Override
    public void xuatThongTin() {
        System.out.printf("│%-16s│%-16s│%-16s│%-10s│%-10s│%-10s│%-9s│%-16s│%-10s│%-16s│%n", id, hoTen, diaChi,
                SDT, ngaySinh, gioiTinh, CMND, password, mucLuong, "Ban hang");
    }

}
