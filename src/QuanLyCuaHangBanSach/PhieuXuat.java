package QuanLyCuaHangBanSach;

public class PhieuXuat extends Phieu{
    private String IDNhanVienThuKho;
    private String IDHoaDon;
    private String tinhTrang = "Cho xuat kho";
    public PhieuXuat(String IDPhieu, String date, String IDNhanVienBanHang, String IDNhanVienThuKho,
                     DanhSachChiTietPhieu dsChiTietPhieu, int sumMoney, String IDHoaDon) {
        super(IDPhieu, date, dsChiTietPhieu, sumMoney, IDNhanVienBanHang);
        this.IDNhanVienThuKho = IDNhanVienThuKho;
        this.IDHoaDon = IDHoaDon;
    }

    public void inPhieu(){
        System.out.printf("│%-8s│%-8s│%-12s│%-16s", IDPhieu, IDHoaDon, date, sumMoney);
        String colorTinhTrang = tinhTrang;
        if(tinhTrang.equals("Cho xuat kho"))
            colorTinhTrang = Check.toYellowText(tinhTrang);
        else
            colorTinhTrang = Check.toGreenText(tinhTrang);
        System.out.printf("│%-25s│%-25s│%-16s\n", IDNhanVien, IDNhanVienThuKho, colorTinhTrang);
    }
    //┘ └ ┌ ┐ ├ ┤ ┴ ┬ ┼ │ ─
    public void xemChiTietPhieu()
    {
        System.out.printf("┌%-50s┐\n", Check.repeatStr("─", 50));
        System.out.printf("│%-10s%-30s%-10s│\n", Check.repeatStr(" ", 10), "Chi tiet phieu xuat:", Check.repeatStr(" ", 10));
        System.out.printf("│%-50s│\n", ("ID phiue: " + getIDPhieu()));
        System.out.printf("│%-50s│\n", ("Date: " + getDate()));
        System.out.printf("│%-50s│\n", ("SumMoney: " + getSumMoney()));
        System.out.printf("│%-50s│\n", ("ID nhan vien ban hang: " + getIDNhanVien()));
        System.out.printf("│%-50s│\n", ("ID nhan vien phu kho: " + getIDNhanVienThuKho()));
        System.out.printf("│%-50s│\n", ("Tinh trang: " + getTinhTrang()));
        dsChiTietPhieu.xuatDS();
        System.out.printf("└%-16s┴%-16s┴%-16s┘\n", Check.repeatStr("─", 16), Check.repeatStr("─", 16), Check.repeatStr("─", 16));
    }

    public void xuatHang(Nguoi nguoi, DanhSachHoaDon danhSachHoaDon)
    {
        if(tinhTrang.equals("Da xuat kho"))
            return;
        IDNhanVienThuKho = nguoi.getId();
        tinhTrang = "Da xuat kho";
        for (HoaDon hoaDon : danhSachHoaDon.getlistHoaDon())
            if(hoaDon.getMaHD().equals(IDHoaDon))
                hoaDon.setTinhTrang("Da xuat kho");
    }


    public String toString()
    {
        return super.toString();
    }

    public String getIDNhanVien() {
        return IDNhanVien;
    }

    public void setIDNhanVien(String IDNhanVien) {
        this.IDNhanVien = IDNhanVien;
    }

    public String getIDNhanVienThuKho() {
        return IDNhanVienThuKho;
    }

    public void setIDNhanVienThuKho(String IDNhanVienThuKho) {
        this.IDNhanVienThuKho = IDNhanVienThuKho;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
