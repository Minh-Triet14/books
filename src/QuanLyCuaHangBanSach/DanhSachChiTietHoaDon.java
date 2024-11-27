package QuanLyCuaHangBanSach;

import java.util.ArrayList;

public class DanhSachChiTietHoaDon {
    private ArrayList<ChiTietHoaDon> listChiTietHoaDon = new ArrayList<>();

    public ChiTietHoaDon timKiemTheoIDHoaDon(String id) {
        return listChiTietHoaDon.stream().filter(x -> x.getMaSach().equals(id)).findFirst().orElse(null);
    }

    public void NhapChiTietHoaDon(DanhSachSach danhSachSach) {
        danhSachSach.xuatDS();
        boolean stop = false;
        do { 
            String maSach = Check.NhapMaSach(danhSachSach);
            Sach sach = danhSachSach.getListSach()[danhSachSach.TimKiemMaSach(maSach)];
            int sLuong = Check.takeIntegerInput("Nhap so luong: ");
            int gia = sach.getGiaThanh();
            if(!sach.mua(sLuong)) {
                Check.printError("Khong the mua !");
                System.out.println("Trong kho chi con: " + sach.getSoLuong());
                continue;
            }
            // Kiểm tra sản phẩm trong chi tiết hóa đơn
            boolean daCo = false;
            for(ChiTietHoaDon cthd : listChiTietHoaDon) {
                if(cthd.getMaSach().equals(maSach)) {
                    daCo = true;
                    cthd.setSLuong(cthd.getSLuong() + sLuong);
                }
            }
            if(!daCo) {
                listChiTietHoaDon.add(new ChiTietHoaDon(maSach, sLuong, gia));
            }
            System.out.println("1. Mua tiep");
            System.out.println("0. Dung dat hang");
            if(Check.takeInputChoice(0, 1) == 0) {
                stop = true;
            }
        } while (!stop);
    }

    public void XuatCTHD()
    {
         int length = 60 - "Chi tiet hoa don".length();
         System.out.printf("│%-50s%-65s│ \n", Check.repeatStr(" ", 50), "Chi tiet hoa don" + Check.repeatStr(" ", length));
         System.out.printf("│%-20s┌%-20s┬%-20s┬%-25s─┐%-25s│ \n", Check.repeatStr(" ", 20), Check.repeatStr("─", 20), Check.repeatStr("─", 20), Check.repeatStr("─", 25), Check.repeatStr(" ", 25));
         System.out.printf("│%-20s│%-20s│%-20s│%-25s │%-25s│ \n", Check.repeatStr(" ", 20), "Ma Sach","So Luong","Gia", Check.repeatStr(" ", 25));
         System.out.printf("│%-20s├%-20s┼%-20s┼%-25s─┤%-25s│ \n", Check.repeatStr(" ", 20), Check.repeatStr("─", 20), Check.repeatStr("─", 20), Check.repeatStr("─", 25), Check.repeatStr(" ", 25));
         for (ChiTietHoaDon cthd : listChiTietHoaDon) {
             System.out.printf("│%-20s│%-20s│%-20s│%-25s │%-25s│ \n", Check.repeatStr(" ", 20), cthd.getMaSach(), cthd.getSLuong(), cthd.getGiaThanh(), Check.repeatStr(" ", 25));
         }
     }

     public void delete(ChiTietHoaDon cthd)
    {
        listChiTietHoaDon.remove(cthd);
    }

    public int tinhTongTien(){
        int sumMoney = 0;
        for (ChiTietHoaDon cthd : listChiTietHoaDon)
        {
            sumMoney += cthd.getGiaThanh()*cthd.getSLuong();
        }
        return sumMoney;
    }

    public ArrayList<ChiTietHoaDon> getListChiTietHoaDon() {
        return listChiTietHoaDon;
    }

    public void setListChiTietHoaDon(ArrayList<ChiTietHoaDon> listChiTietHoaDon) {
        this.listChiTietHoaDon = listChiTietHoaDon;
    }
}


