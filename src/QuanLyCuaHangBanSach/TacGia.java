package QuanLyCuaHangBanSach;

public class TacGia {
    protected String maTacGia;
    protected String tenTacGia;
    protected String diaChi;
    protected String sdt;
    protected String email;

    public TacGia() {
        maTacGia = null;
        tenTacGia = null;
        diaChi = null;
        sdt = null;
        email = null;
    }

    public TacGia(String maTacGia, String tenTacGia, String diaChi, String sdt, String email) {
        setMaTacGia(maTacGia);
        setTenTacGia(tenTacGia);
        setDiaChiTacGia(diaChi);
        setSDTTacGia(sdt);
        setEmailTacGia(email);
    }

    public String getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(String maTacGia) {
        this.maTacGia = maTacGia;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }
    
    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getDiaChiTacGia() {
        return diaChi;
    }

    public void setDiaChiTacGia(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSDTTacGia() {
        return sdt;
    }

    public void setSDTTacGia(String sdt) {
        this.sdt = sdt;
    }

    public String getEmailTacGia() {
        return email;
    }

    public void setEmailTacGia(String email) {
        this.email = email;
    }

    public void NhapTacGia(String maTacGia) {
        this.maTacGia = maTacGia;
        this.tenTacGia = Check.takeStringInput("Nhap ten tac gia: ");
        this.diaChi = Check.takeStringInput("Nhap dia chi: ");
        this.sdt = Check.takeStringInput("Nhap so dien thoai: ");
        this.email = Check.takeStringInput("Nhap email: ");
    }

    public void XuatTacGia() {
        System.out.printf("|%-30s|%-30s|%-30s|%-30s|%-30s|%n", maTacGia, tenTacGia, diaChi, sdt, email);
    }

}
