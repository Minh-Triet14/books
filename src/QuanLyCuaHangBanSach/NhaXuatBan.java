package QuanLyCuaHangBanSach;

public class NhaXuatBan {
    private String maNXB;
    private String tenNXB;
    private String diaChi;
    private String sdt;
    private String email;

    public NhaXuatBan() {
        maNXB = null;
        tenNXB = null;
        diaChi = null;
        sdt = null;
        email= null;
    }

    public NhaXuatBan( String maNXB, String tenNXB, String diaChi, String sdt, String email) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
    }

    public String getMaNXB() {
        return maNXB;
    }    

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public String getTen() {
        return tenNXB;
    }

    public void setTen(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSDT() {
        return sdt;
    }

    public void setSDT(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void NhapNXB(String maNXB) {
        this.maNXB = maNXB;
        this.tenNXB = Check.takeStringInput("Nhap ten nha xuat ban: ");
        this.diaChi = Check.takeStringInput("Nhap dia chi: ");
        this.sdt = Check.takeStringInput("Nhap so dien thoai: ");
        this.email = Check.takeStringInput("Nhap email: ");
    }

    public void XuatNXB() {
        System.out.printf("|%-30s|%-30s|%-30s|%-30s|%-30s|%n",maNXB, tenNXB, diaChi, sdt, email);
        System.out.printf("├%-30s┼%-30s┼%-30s┼%-30s┼%-30s┤%n", Check.repeatStr("─", 30), Check.repeatStr("─", 30), Check.repeatStr("─", 30), Check.repeatStr("─", 30), Check.repeatStr("─", 30));
    }
}
