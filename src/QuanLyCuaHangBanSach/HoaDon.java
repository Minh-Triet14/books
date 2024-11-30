package QuanLyCuaHangBanSach;

public class HoaDon {
    private String maHD;
    private String maKH;
    private String maNV;
    private String timeXuat;
    private int tongTien;
    private DanhSachChiTietHoaDon dsCTHD;
    private String tinhTrang;

    public HoaDon() {
        this.maHD = null;
        this.tongTien = 0;
        this.dsCTHD = null;
    }

    public HoaDon(String maHD, String maKH, String maNV, String timeXuat, int tongTien, DanhSachChiTietHoaDon dsCTHD, String tinhTrang) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.timeXuat = timeXuat;
        this.tongTien = tongTien;
        this.dsCTHD = dsCTHD;
        this.tinhTrang = tinhTrang;
    }

    public void xuatThongTin() {
        String tinhTrang = null;
        if(getTinhTrang().equals("Dang cho xac nhan"))
            tinhTrang = Check.TEXT_BLUE + getTinhTrang() + Check.TEXT_RESET;
        else if(getTinhTrang().equals("Da xac nhan") || getTinhTrang().equals("Da xuat kho"))
            tinhTrang = Check.TEXT_YELLOW + getTinhTrang() + Check.TEXT_RESET;
        else if(getTinhTrang().equals("Da nhan hang"))
            tinhTrang = Check.TEXT_GREEN + getTinhTrang() + Check.TEXT_RESET;
        System.out.printf("│%-20s│%-20s│%-20s│%-10s│%-15s│%-25s \n", getMaHD() , getMaNV(), getMaKH(), getTimeXuat(), getTongTien(), tinhTrang);
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    
    
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTimeXuat() {
        return timeXuat;
    }

    public void setTimeXuat(String timeXuat) {
        this.timeXuat = timeXuat;
    }   

    public DanhSachChiTietHoaDon getlistCTHD() {
        return dsCTHD;
    }

    public void setListCTHD(DanhSachChiTietHoaDon dsCTHD) {
        this.dsCTHD = dsCTHD;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    public String getTinhTrang() {
        return tinhTrang;
    }

    public DanhSachChiTietHoaDon getListChiTietHoaDon() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getListChiTietHoaDon'");
    }

   
}
