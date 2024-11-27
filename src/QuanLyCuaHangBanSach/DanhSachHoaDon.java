package QuanLyCuaHangBanSach;

import java.util.ArrayList;
import java.util.Locale;

public class DanhSachHoaDon implements DanhSach {
    private ArrayList<HoaDon> listHoaDon = new ArrayList<>();
    private int count = 0;

    public DanhSachHoaDon(DanhSachSach dsSach) {
        DanhSachChiTietHoaDon a = new DanhSachChiTietHoaDon();
        Sach sach1 = dsSach.getListSach()[0];
        Sach sach2 = dsSach.getListSach()[1];
        Sach sach3 = dsSach.getListSach()[2];
        Sach sach4 = dsSach.getListSach()[3];
        a.getListChiTietHoaDon().add(new ChiTietHoaDon(sach1.getMaSach(), 50, sach1.getGiaThanh()));
        a.getListChiTietHoaDon().add(new ChiTietHoaDon(sach2.getMaSach(), 40, sach2.getGiaThanh()));
        a.getListChiTietHoaDon().add(new ChiTietHoaDon(sach3.getMaSach(), 45, sach3.getGiaThanh()));
        sach1.mua(50);
        sach2.mua(40);
        sach3.mua(45);
        listHoaDon.add(new HoaDon(getID(), "nam", "minh", "12/12/2020", a.tinhTongTien(), a, "Da xac nhan"));

        DanhSachChiTietHoaDon b = new DanhSachChiTietHoaDon();
        b.getListChiTietHoaDon().add(new ChiTietHoaDon(sach2.getMaSach(), 6, sach2.getGiaThanh()));
        b.getListChiTietHoaDon().add(new ChiTietHoaDon(sach3.getMaSach(), 4, sach3.getGiaThanh()));
        sach2.mua(6);
        sach3.mua(4);
        listHoaDon.add(new HoaDon(getID(), "nam", "minh", "1/2/2021", b.tinhTongTien(),  b, "Da xac nhan"));

        DanhSachChiTietHoaDon c = new DanhSachChiTietHoaDon();
        c.getListChiTietHoaDon().add(new ChiTietHoaDon(sach1.getMaSach(), 22, sach1.getGiaThanh()));
        c.getListChiTietHoaDon().add(new ChiTietHoaDon(sach3.getMaSach(), 40, sach3.getGiaThanh()));
        sach1.mua(22);
        sach3.mua(40);
        listHoaDon.add(new HoaDon(getID(), "nam", "sinh", "11/2/2021", c.tinhTongTien(),  c, "Da xac nhan"));

        DanhSachChiTietHoaDon d = new DanhSachChiTietHoaDon();
        d.getListChiTietHoaDon().add(new ChiTietHoaDon(sach1.getMaSach(), 55, sach1.getGiaThanh()));
        d.getListChiTietHoaDon().add(new ChiTietHoaDon(sach3.getMaSach(), 11, sach3.getGiaThanh()));
        sach1.mua(55);
        sach3.mua(11);
        listHoaDon.add(new HoaDon(getID(), "nam", "sinh", "26/5/2021", d.tinhTongTien(),  d, "Da xac nhan"));

        DanhSachChiTietHoaDon e = new DanhSachChiTietHoaDon();
        e.getListChiTietHoaDon().add(new ChiTietHoaDon(sach1.getMaSach(), 33, sach1.getGiaThanh()));
        e.getListChiTietHoaDon().add(new ChiTietHoaDon(sach2.getMaSach(), 61, sach2.getGiaThanh()));
        sach1.mua(33);
        sach2.mua(61);
        listHoaDon.add(new HoaDon(getID(), "nam", "minh", "30/7/2021", e.tinhTongTien(),  e, "Da xac nhan"));

        DanhSachChiTietHoaDon f = new DanhSachChiTietHoaDon();
        f.getListChiTietHoaDon().add(new ChiTietHoaDon(sach1.getMaSach(), 11, sach3.getGiaThanh()));
        f.getListChiTietHoaDon().add(new ChiTietHoaDon(sach2.getMaSach(), 22, sach4.getGiaThanh()));
        sach3.mua(11);
        sach4.mua(22);
        listHoaDon.add(new HoaDon(getID(), "nam", "minh", "29/8/2021", f.tinhTongTien(),  f, "Da xac nhan"));

        DanhSachChiTietHoaDon g = new DanhSachChiTietHoaDon();
        g.getListChiTietHoaDon().add(new ChiTietHoaDon(sach1.getMaSach(), 5, sach2.getGiaThanh()));
        g.getListChiTietHoaDon().add(new ChiTietHoaDon(sach2.getMaSach(), 7, sach4.getGiaThanh()));
        sach2.mua(5);
        sach4.mua(7);
        listHoaDon.add(new HoaDon(getID(), "", "minh", "28/12/2021", g.tinhTongTien(),  g, "Dang cho xac nhan"));
    }

    private HoaDon timKiemHoaDonTheoID(String id, Nguoi nguoi) {
        if(nguoi instanceof NhanVienBanHang)
            return listHoaDon.stream().filter(x -> x.getMaHD().equals(id)).findAny().orElse(null);
        else
            return listHoaDon.stream().filter(x -> x.getMaHD().equals(id) && x.getMaKH().equals(nguoi.getId())).findAny().orElse(null);
    }

    @Override
    public String getID() {
        count++;
        int a = count;
        String str = String.valueOf(a);
        while(str.length() != 3) {
            str = "0" + str;
        }
        str = "HD" + str;
        return str;
    }

    public void themHDCuaKhachHang(DanhSachSach danhSachSach, Nguoi nguoi, BooksShop booksshop) {
        System.out.println(Check.toBlueText("****Mua Sach****"));
        String maHD = getID();
        String maNV = "";
        String maKH = nguoi.getId();

        DanhSachChiTietHoaDon ds = new DanhSachChiTietHoaDon();
        ds.NhapChiTietHoaDon(danhSachSach);

        String timeXuat = Check.getDateNow();
        listHoaDon.add(new HoaDon(maHD, maNV, maKH, timeXuat, ds.tinhTongTien(), ds, "Dang cho xac nhan"));
    }

    public void suaHD(DanhSachSach danhSachSach, Nguoi nguoi, BooksShop booksshop) {
        String id = Check.takeStringInput("Ma hoa don can sua: ");
        HoaDon hoaDon = timKiemHoaDonTheoID(id, nguoi);
        if(hoaDon == null)
        {
            Check.printError("Khong co ma hoa don !");
            return;
        }
        boolean out = false;
        do {
            xuatChiTietHoaDon(hoaDon);
            System.out.println(Check.toBlueText("****Sua Thong Tin Chi Tiet Hoa Don****"));
            System.out.println("1. Sua so luong trong chi tiet hoa don");
            System.out.println("2. Xoa sach trong chi tiet hoa don");
            System.out.println("0. Thoat");
            switch (Check.takeInputChoice(0, 2))
            {
                case 1 -> {
                    String idsach = Check.takeStringInput("Nhap ma sach can sua: ");
                    ChiTietHoaDon chiTietHoaDon = hoaDon.getlistCTHD().timKiemTheoIDHoaDon(idsach);
                    if(chiTietHoaDon == null)
                        Check.printError("Khong co ma sach nay trong chi tiet hoa don !");
                    else
                    {
                        int num = Check.takeIntegerInput("Nhap so luong moi: ");
                        chiTietHoaDon.setSLuong(num);
                        hoaDon.setTongTien(hoaDon.getlistCTHD().tinhTongTien());
                    }
                }
                case 2 -> {
                    String idsach = Check.takeStringInput("Nhap ma hoa don can xoa: ");
                    ChiTietHoaDon chiTietHoaDon = hoaDon.getlistCTHD().timKiemTheoIDHoaDon(idsach);
                    if(chiTietHoaDon == null)
                        Check.printError("Khong co ma sach nay trong chi tiet hoa don !");
                    else
                        hoaDon.getlistCTHD().delete(chiTietHoaDon);
                }
                case 0 -> out = true;
            }
            if(!out)
                Check.ClearConsole();
        }while(!out);
    }

    public void timHD(Nguoi nguoi) {
        System.out.println("****Tim Hoa Don****");
        String tuKhoa = Check.takeStringInput("Nhap tu khoa can tim: ");
        ArrayList<HoaDon> filter = new ArrayList<>();
        for (HoaDon hoaDon: listHoaDon)
        {
            int gia;
            try {gia = Integer.parseInt(tuKhoa);}
            catch (NumberFormatException ignored) {gia = Integer.MIN_VALUE;}
            if(hoaDon.getMaKH().equals(nguoi.getId()) || nguoi instanceof NhanVienBanHang)
            {
                if(
                        hoaDon.getMaHD().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                                hoaDon.getMaKH().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                                hoaDon.getTinhTrang().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                                hoaDon.getTongTien() == gia ||
                                hoaDon.getTimeXuat().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT))
                )
                {
                    filter.add(hoaDon);
                }
            }

        }

        System.out.println(Check.toBlueText("Ket qua tim kiem theo tu khoa: ")  + Check.toGreenText(tuKhoa));
        if(filter.isEmpty())
            Check.printError("Khong co hoa don nao !");
        else
        {
            XuatTieuDe();
            for (HoaDon hoaDon : filter)
                    hoaDon.xuatThongTin();
        }

    }

    public void xoaHD(Nguoi nguoi) {
        System.out.println(Check.toBlueText("****Xoa Hoa Don****"));
        String idHoaDon = Check.takeStringInput("Nhap ma hoa don can xoa: ");
        HoaDon hoaDon = timKiemHoaDonTheoID(idHoaDon, nguoi);
       
        if(hoaDon != null){
            listHoaDon.remove(hoaDon);
            Check.printMessage("Hoa don da xoa khoi danh sach");
        }else{
            Check.printError("Hoa don khong co trong danh sach !");
        }
   }

    @Override
    public void XuatTieuDe() {
        System.out.printf("┌%-20s┬%-20s┬%-20s┬%-10s┬%-15s┬%-25s┐ \n", Check.repeatStr("─", 20), Check.repeatStr("─", 20), Check.repeatStr("─", 20), Check.repeatStr("─", 10), Check.repeatStr("─", 15), Check.repeatStr("─", 25));
        System.out.printf("|%-20s│%-20s│%-20s│%-10s│%-15s│%-25s| \n", "Ma Hoa Don" , "Ma Nhan Vien","Ma Khach Hang","Thoi gian","Tong Tien", "Tinh Trang");
        System.out.printf("├%-20s┼%-20s┼%-20s┼%-10s┼%-15s┼%-25s┤ \n", Check.repeatStr("─", 20) , Check.repeatStr("─", 20), Check.repeatStr("─", 20), Check.repeatStr("─", 10), Check.repeatStr("─", 15), Check.repeatStr("─", 25));    
    }

    private void xuatChiTietHoaDon(HoaDon hoaDon) {
       XuatTieuDe();
       hoaDon.xuatThongTin();
       System.out.printf("├%-20s┴%-20s┴%-20s┴%-10s┴%-15s┴%-25s┤ \n", Check.repeatStr("─", 20), Check.repeatStr("─", 20), Check.repeatStr("─", 20), Check.repeatStr("─", 10), Check.repeatStr("─", 15), Check.repeatStr("─", 25));
       hoaDon.getlistCTHD().XuatCTHD();
       System.out.printf("└%-20s┴%-20s┴%-20s┴%-10s─%-15s┴%-25s┘ \n", Check.repeatStr("─", 20), Check.repeatStr("─", 20), Check.repeatStr("─", 20), Check.repeatStr("─", 10), Check.repeatStr("─", 15), Check.repeatStr("─", 25));
   }

    @Override
    public void xuatDS() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void xuatHD(Nguoi nguoi){
        int count = 0;
        System.out.println(Check.toBlueText("****Danh Sach Hoa Don****"));
        XuatTieuDe();
        for (HoaDon hoaDon : listHoaDon)
        {
            if(hoaDon.getMaKH().equals(nguoi.getId()) || nguoi instanceof NhanVienBanHang)
            {
                hoaDon.xuatThongTin();
                count++;
            }
        }

        if(count == 0)
            Check.printError("Khong co hoa don nao !");
    }

    private void xemChiTietHoaDon(Nguoi nguoi)
    {
        String id = Check.takeStringInput("Nhap ma hoa don can xem: ");
        HoaDon hoaDon = timKiemHoaDonTheoID(id, nguoi);
        if (hoaDon == null)
            Check.printError("Khong co hoa don nay !");
        else
            xuatChiTietHoaDon(hoaDon);
    }

}
