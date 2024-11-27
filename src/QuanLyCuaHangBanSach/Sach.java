package QuanLyCuaHangBanSach;

public abstract class Sach {
    protected String maSach;
    protected String tenSach;
    protected String loaiSach;
    protected String doTuoiKhuyenDoc;
    protected String maNXB;
    protected String maTacGia;
    protected int giaThanh;
    protected int soLuong;
    
    public Sach() {
        this.maSach = null;
        this.tenSach = null;
        this.loaiSach = null;
        this.doTuoiKhuyenDoc = null;
        this.maNXB = null;
        this.maTacGia = null;
        this.giaThanh = 0;
        this.soLuong = 0;
    }
    
    public Sach(String maSach, String tenSach, String loaiSach, String doTuoiKhuyenDoc, String maNXB, String maTacGia, int giaThanh, int soLuong) {
        setMaSach(maSach);
        setTenSach(tenSach);
        setLoaiSach(loaiSach);
        setDoTuoi(doTuoiKhuyenDoc);
        setMaNXB(maNXB);
        setMaTacGia(maTacGia);
        setGiaThanh(giaThanh);
        setSoLuong(soLuong);
    }
    
    public boolean mua(int soLuongMua) {
        if (soLuongMua > soLuong) {
                return false;
        } else {
                soLuong -= soLuongMua;
                return true;
        }
    }
    
    public String getMaSach() {
        return maSach;
    }
    
    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }
    
    public String getTenSach() {
        return tenSach;
    }
    
    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getLoaiSach() {
        return loaiSach;
    }

    public void setLoaiSach(String loaiSach) {
        this.loaiSach = loaiSach;
    }

    public String getDoTuoi() {
        return doTuoiKhuyenDoc;
    }

    public void setDoTuoi(String doTuoiKhuyenDoc) {
        this.doTuoiKhuyenDoc = doTuoiKhuyenDoc;
    }
    
    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }
    
    public String getMaTacGia() {
        return maTacGia;
    }
    
    public void setMaTacGia(String maTacGia) {
        this.maTacGia = maTacGia;
    }
    
    public int getGiaThanh() {
        return giaThanh;
    }
    public void setGiaThanh(int giaThanh) {
        this.giaThanh = giaThanh;
    }
    
    public int getSoLuong() {
        return soLuong;
    }
    
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    } 
    
    public void Nhap(String maSach, String maTacGia, String maNXB) {
        this.maSach = maSach;
        this.tenSach = Check.takeStringInput("Nhap ten sach: ");
        this.doTuoiKhuyenDoc = Check.takeStringInput("Nhap do tuoi khuyen doc: ");
        this.maNXB = maNXB;
        this.maTacGia = maTacGia;
        this.giaThanh = Check.takeIntegerInput("Nhap gia thanh sach: ");
        this.soLuong = Check.takeIntegerInput("Nhap so luong sach trong kho: ");
    }
    
    public void Nhap(String maSach) {
        this.maSach = maSach;
        this.doTuoiKhuyenDoc = Check.takeStringInput("Nhap do tuoi khuyen doc: ");
        this.maNXB = Check.takeStringInput("Nhap ma nha xuat ban: ");
        this.maTacGia = Check.takeStringInput("Nhap ma tac gia: ");
        this.giaThanh = Check.takeIntegerInput("Nhap gia thanh sach: ");
        this.soLuong = Check.takeIntegerInput("Nhap so luong sach trong kho: ");
    }
    
    public void xuatThongTin() {
        System.out.printf("│%-20s│%-20s│%-20s│%-20s│%-20s│%-20s│%-20s│%n", maSach, tenSach, loaiSach, doTuoiKhuyenDoc, maNXB, maTacGia, giaThanh, soLuong);
    }
    
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int luaChon = 0;
    
    //     while (luaChon == 0) {
    //         Sach[] arrSach = new Sach[4];
    //         for(int i = 0; i < arrSach.length; i++) {
    //             System.out.println("Chon cac so 1,2,3,4 tuong ung voi ten sach:");
    //             System.out.println("1.Sach giao khoa");
    //             System.out.println("2.Sach kham khao");
    //             System.out.println("3.Sach ki nang");
    //             System.out.println("4.Truyen tranh");
    //             System.out.print("Nhap lua chon: ");
    //             luaChon = sc.nextInt();
    
    //             switch(luaChon) {
    //                 case 1 -> {
    //                     arrSach[i] = new SachGiaoKhoa();
    //                     arrSach[i].Nhap(maSach);
    //                     arrSach[i].xuatThongTin();
    //                 }
    //                 case 2 -> {
    //                     arrSach[i] = new SachKhamKhao();
    //                     arrSach[i].Nhap(maSach);
    //                     arrSach[i].xuatThongTin();
    //                 }
    //                 case 3 -> {
    //                     arrSach[i] = new SachKiNangSong();
    //                     arrSach[i].xuatThongTin();
    //                 }
    //                 case 4 -> {
    //                     arrSach[i] = new Truyen();
    //                     arrSach[i].xuatThongTin();
    //                 }
    //                 default -> {
    //                     System.out.println("Nhap lua chon khong dung, vui long nhap lai !");
    //                     System.out.println();
    //                 }
    //             }
    //         }
    //     }
    // }
}
