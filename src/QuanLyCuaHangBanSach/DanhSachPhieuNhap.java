package QuanLyCuaHangBanSach;

import java.util.ArrayList;

public class DanhSachPhieuNhap implements DanhSach{
    private ArrayList<PhieuNhap> dsPhieuNhap;
    private int count = 0;

    public DanhSachPhieuNhap(DanhSachSach DanhSachSach) { 
        dsPhieuNhap = new ArrayList<>();
        Sach dt1 = DanhSachSach.getListSach()[0];
        Sach dt2 = DanhSachSach.getListSach()[1]; 
        Sach dt3 = DanhSachSach.getListSach()[2];

        DanhSachChiTietPhieu ct1 = new DanhSachChiTietPhieu();
        ct1.add(new ChiTietPhieu(dt1.getMaSach(), 5, dt1.getGiaThanh()));
        dsPhieuNhap.add(new PhieuNhap(getID(), "23/8/2020", "NXB001", "BOY", ct1, ct1.tinhTongTien()));

        DanhSachChiTietPhieu ct2 = new DanhSachChiTietPhieu();
        ct2.add(new ChiTietPhieu(dt2.getMaSach(), 6, dt2.getGiaThanh()));
        ct2.add(new ChiTietPhieu(dt2.getMaSach(), 9, dt3.getGiaThanh()));
        dsPhieuNhap.add(new PhieuNhap(getID(), "8/8/2021", "NXB001", "GAY", ct2, ct2.tinhTongTien()));
    }

    public String getID() {
        count++;
        int a = count;
        String str = Integer.toString(a);
        while(str.length() != 3)
            str = "0" + str;
        str = "PN" + str;
        return str;
    }

    //┘ └ ┌ ┐ ├ ┤ ┴ ┬ ┼ │ ─
    public void xuatTieuDe() {
        System.out.printf("┌%-16s┬%-16s┬%-16s┬%-16s┬%-16s┐\n",
                Check.repeatStr("─", 16), Check.repeatStr("─", 16),
                Check.repeatStr("─", 16), Check.repeatStr("─", 16),
                Check.repeatStr("─", 16));
        System.out.printf("│%-16s│%-16s│%-16s│%-16s│%-16s│\n", "ID Phieu", "Date", "SumMoney", "ID NV", "ID NXB");
        System.out.printf("├%-16s┼%-16s┼%-16s┼%-16s┼%-16s┤\n",
                Check.repeatStr("─", 16), Check.repeatStr("─", 16),
                Check.repeatStr("─", 16), Check.repeatStr("─", 16),
                Check.repeatStr("─", 16));
    }

    public void xuatDS() {
        if (!dsPhieuNhap.isEmpty()) {
            for (PhieuNhap phieuNhap : dsPhieuNhap) {
                phieuNhap.inPhieu();
            }
        } else {
            Check.printError("Danh Sach Phieu Dang Rong");
        }
    }

    public void xemChiTietPhieu(){
        if(dsPhieuNhap.isEmpty())
            Check.printError("Danh Sach Phieu Dang Rong");
        else
        {
            String id = Check.takeStringInput("Nhap ID Phieu -> Xem chi tiet: ");
            Phieu obj = timKiemTheoIDPhieu(id);
            if(obj == null)
            {
                Check.printError("Khong Co ID");
                return;
            }
            obj.xemChiTietPhieu();
        }
    }

    public Phieu timKiemTheoIDPhieu(String id) {
        return dsPhieuNhap.stream().filter(x -> x.getIDPhieu().equals(id)).findFirst().orElse(null);
    }

    public void xoaPhieu() {
        if (dsPhieuNhap.isEmpty()) {
            Check.printError("Danh Sach Phieu Dang Rong");
            return;
        }

        String idPhieu = Check.takeStringInput("Nhap ID Phieu Muon Delete: ");
        PhieuNhap phieu = dsPhieuNhap.stream()
                .filter(x -> x.getIDPhieu().equals(idPhieu))
                .findAny()
                .orElse(null);
        if (phieu == null)
            Check.printError("Khong Co ID Phieu Nay");
        else {
            dsPhieuNhap.remove(phieu);
            Check.printMessage("Delete Thanh Cong");
        }
    }

    private void timKiemTrongBang(){
        String tuKhoa = Check.takeStringInput("Nhap Tu Khoa Can Timf: ");
        ArrayList<PhieuNhap> filter = new ArrayList<>();
        int tongTien = 0;

        for (PhieuNhap phieuNhap : dsPhieuNhap)
        {
            try{tongTien = Integer.parseInt(tuKhoa);}
            catch (NumberFormatException ignored){}

            boolean check = Check.subStrInStrIgnoreCase(phieuNhap.getIDNXB(), tuKhoa) ||
                            Check.subStrInStrIgnoreCase(phieuNhap.getDate(), tuKhoa) ||
                            Check.subStrInStrIgnoreCase(phieuNhap.getIDNhanVien(), tuKhoa) ||
                            phieuNhap.getSumMoney() == tongTien;
            if(check)
                filter.add(phieuNhap);
        }

        System.out.println(Check.toBlueText("Ket Qua Tim Kiem: ")  + Check.toGreenText(tuKhoa));
        if(filter.isEmpty())
            Check.printError("Khong Tim Thay");
        else
        {
            xuatTieuDe();
            for(PhieuNhap phieuNhap : filter)
                phieuNhap.inPhieu();
        }
    }

    public String nhapNXB(DanhSachNhaXuatBan DanhSachNhaXuatBan){
        String idNXB;
        while(true)
        {
            DanhSachNhaXuatBan.xuatDS();
            idNXB = Check.takeStringInput("Nhap ID NXB: ");
            if(DanhSachNhaXuatBan.TimKiemIDNXB(idNXB) != null)
                return idNXB;
            else
                Check.printError("Khong Co ID NXB nay");
        }
    }

    public void add(Nguoi nguoi, DanhSachSach DanhSachSach, DanhSachNhaXuatBan DanhSachNhaXuatBan){
        String idPhieu = getID();
        String idNXB = nhapNXB(DanhSachNhaXuatBan);

        DanhSachChiTietPhieu DanhSachChiTietPhieu = new DanhSachChiTietPhieu();
        boolean finish = false;
        do {
            DanhSachSach.xuatDS();
            System.out.println("1. Nhap dien thoai");
            System.out.println("2. Xac nhan da nhan hang");
            switch (Check.takeInputChoice(1, 2))
            {
                case 1 -> {
                    String iddt = Check.takeStringInput("Nhap ma sach: ");
                    int index = DanhSachSach.TimKiemMaSach(iddt);
                    if(index != -1)
                    {
                        int sl = Check.takeIntegerInput("Nhap so luong: ");
                        ChiTietPhieu chiTietPhieu = DanhSachChiTietPhieu.search(iddt);
                        if(chiTietPhieu != null)
                            chiTietPhieu.setSoLuong(chiTietPhieu.getSoLuong() + sl);
                        else
                            DanhSachChiTietPhieu.add(new ChiTietPhieu(iddt, sl, DanhSachSach.getListSach()[index].getGiaThanh()));
                    }
                    else
                        Check.printError("Khong co sach nay");
                }
                case 2 -> finish = true;
            }
            if(!finish)
                Check.ClearConsole();
        }while (!finish);

        dsPhieuNhap.add(new PhieuNhap(idPhieu, Check.getDateNow(), idNXB, nguoi.getId(), DanhSachChiTietPhieu, DanhSachChiTietPhieu.tinhTongTien()));

        for (int i = 0; i < DanhSachChiTietPhieu.getSize(); i++)
        {
            ChiTietPhieu chiTietPhieu = DanhSachChiTietPhieu.getchitietphieu()[i];
            Sach Sach = DanhSachSach.getListSach()[DanhSachSach.TimKiemMaSach(chiTietPhieu.getIDSach())];
            Sach.setSoLuong(Sach.getSoLuong() + chiTietPhieu.getSoLuong());
        }
    }

    public void menu(DanhSachSach DanhSachSach, Nguoi nguoi, BooksShop bookshop, DanhSachNhaXuatBan DanhSachNhaXuatBan)
    {
        boolean thoatXemDSPhieu = false;
        while(true)
        {
            xuatTieuDe();
            xuatDS();
            System.out.println("1. Xem chi tiet phieu nhap");
            System.out.println("2. Add phieu nhap");
            System.out.println("3. Delete phieu nhap");
            System.out.println("4. Tim kiem trong bang");
            System.out.println("0. Thoat");
            switch (Check.takeInputChoice(0,4))
            {
                case 1 -> xemChiTietPhieu();
                case 2 -> add(nguoi, DanhSachSach, DanhSachNhaXuatBan);
                case 3 -> xoaPhieu();
                case 4 -> timKiemTrongBang();
                case 0 -> thoatXemDSPhieu = true;
            }
            if (thoatXemDSPhieu)
                break;
            Check.ClearConsole();
        }
    }

    @Override
    public void XuatTieuDe() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'XuatTieuDe'");
    }



}
