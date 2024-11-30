package QuanLyCuaHangBanSach;

public class Main {
    
    public static void main(String[] args) {

        //LoadFile nha cung cap----
    DanhSachNhaXuatBan dsnxb = null;
    dsnxb = (DanhSachNhaXuatBan) Check.load(dsnxb, "NXB.txt");
    if(dsnxb == null)
    {
        dsnxb = new DanhSachNhaXuatBan();
        Check.save(dsnxb, "NXB.txt");
    }

    //LoadFile nsx-------------
    DanhSachTacGia dstg = null;
    dstg = (DanhSachTacGia) Check.load(dstg, "TacGia.txt");
    if(dstg == null)
    {
        dstg = new DanhSachTacGia();
        Check.save(dstg, "TacGia.txt");
    }
        DanhSachSach sach = new DanhSachSach();
        sach.MenuSach(dstg, dsnxb);
    }
}
