package QuanLyCuaHangBanSach;




import java.util.ArrayList;

public class DanhSachPhieuXuat implements DanhSach{
    private ArrayList<PhieuXuat> DanhSachPhieuXuat;
    private int count = 0;

    public DanhSachPhieuXuat(Nguoi nguoi, DanhSachHoaDon danhSachHoaDon)
    {
        DanhSachPhieuXuat = new ArrayList<>();
        int count = 0;
        for (HoaDon hoaDon : danhSachHoaDon.getlistHoaDon())
        {
            if(hoaDon.getTinhTrang().equals("Đã xác nhận"))
            {
                DanhSachChiTietPhieu dsctp = new DanhSachChiTietPhieu();
                DanhSachChiTietHoaDon dscthd = hoaDon.getlistCTHD();
                for (ChiTietHoaDon cthd : dscthd.getListChiTietHoaDon())
                {
                    ChiTietPhieu obj = new ChiTietPhieu(cthd.getMaSach(), cthd.getSLuong(), cthd.getGiaThanh());
                    dsctp.add(obj);
                }
                if(count <= 4)
                {
                    PhieuXuat phieuXuat = new PhieuXuat(getID(), hoaDon.getTimeXuat(), hoaDon.getMaNV(),
                            nguoi.getId(), dsctp, dsctp.tinhTongTien(), hoaDon.getMaHD());
                    DanhSachPhieuXuat.add(phieuXuat);
                    phieuXuat.xuatHang(nguoi, danhSachHoaDon);
                }
                else if(count == 5)
                {
                    PhieuXuat phieuXuat = new PhieuXuat(getID(), hoaDon.getTimeXuat(), hoaDon.getMaNV(),
                            nguoi.getId(), dsctp, dsctp.tinhTongTien(), hoaDon.getMaHD());
                    DanhSachPhieuXuat.add(phieuXuat);
                }
                count++;
            }
        }

        count = 0;
        for (HoaDon hoaDon : danhSachHoaDon.getlistHoaDon())
        {
            if(count <= 3)
            {
                if(hoaDon.getTinhTrang().equals("Đã xuất kho"))
                {
                    hoaDon.setTinhTrang("Đã nhận hàng");
                }
            }
            count++;
        }


   }

    public String getID() {
        count++;
        int a = count;
        String str = Integer.toString(a);
        while(str.length() != 3)
            str = "0" + str;
        str = "PX" + str;
        return str;
    }

    //┘ └ ┌ ┐ ├ ┤ ┴ ┬ ┼ │ ─
    public void xuatTieuDe() {
        System.out.println(Check.toBlueText("Danh sách phiếu xuất"));
        System.out.printf("┌%-8s┬%-8s┬%-12s┬%-16s┬%-25s┬%-25s┬%-16s┐\n", Check.repeatStr("─", 8),
                Check.repeatStr("─", 8), Check.repeatStr("─", 12),
                Check.repeatStr("─", 16), Check.repeatStr("─", 25),
                Check.repeatStr("─", 25), Check.repeatStr("─", 16));
        System.out.printf("│%-8s│%-8s│%-12s│%-16s│%-25s│%-25s│%-16s│\n", "ID phiếu", "Hóa đơn", "Date", "Tổng tiền",
                "ID nhân viên bán hàng", "ID nhân viên thủ kho", "Tình trạng");
        System.out.printf("├%-8s┼%-8s┼%-12s┼%-16s┼%-25s┼%-25s┼%-16s┤\n", Check.repeatStr("─", 8),
                Check.repeatStr("─", 8), Check.repeatStr("─", 12),
                Check.repeatStr("─", 16), Check.repeatStr("─", 25),
                Check.repeatStr("─", 25), Check.repeatStr("─", 16));
    }

    public void xuatDS() {
        if (!DanhSachPhieuXuat.isEmpty()) {
            for (PhieuXuat phieuXuat : DanhSachPhieuXuat) {
                phieuXuat.inPhieu();
            }
        } else {
            Check.printError("Danh sách phiếu đang rỗng");
        }
    }

    public Phieu timKiemTheoIDPhieu(String id) {
        return DanhSachPhieuXuat.stream().filter(x -> x.getIDPhieu().equals(id)).findFirst().orElse(null);
    }

    public void xoaPhieu() {
        if (DanhSachPhieuXuat.isEmpty()) {
            Check.printError("Danh sách phiếu đang rỗng");
            return;
        }
        String idPhieu = Check.takeStringInput("Nhập vào id phiếu cần xóa: ");
        PhieuXuat phieu = DanhSachPhieuXuat.stream()
                .filter(x -> x.IDPhieu.equals(idPhieu))
                .findAny()
                .orElse(null);
        if (phieu == null)
            Check.printError("Không có mã phiếu đó trong danh sách");
        else {
            DanhSachPhieuXuat.remove(phieu);
            Check.printMessage("Xóa phiếu thành công");
        }
    }

    private void timKiemTrongBang(){
        String tuKhoa = Check.takeStringInput("Nhập từ khóa cần tìm: ");
        ArrayList<PhieuXuat> filter = new ArrayList<>();
        int tongTien = 0;

        for (PhieuXuat phieuXuat : DanhSachPhieuXuat)
        {
            try{tongTien = Integer.parseInt(tuKhoa);}
            catch (NumberFormatException ignored){}

            boolean check = Check.subStrInStrIgnoreCase(phieuXuat.getDate(), tuKhoa) ||
                    Check.subStrInStrIgnoreCase(phieuXuat.getIDNhanVien(), tuKhoa) ||
                    Check.subStrInStrIgnoreCase(phieuXuat.getIDNhanVienThuKho(), tuKhoa) ||
                    Check.subStrInStrIgnoreCase(phieuXuat.getTinhTrang(), tuKhoa) ||
                    phieuXuat.getSumMoney() == tongTien;
            if(check)
                filter.add(phieuXuat);
        }

        System.out.println(Check.toBlueText("Kết quả tìm kiếm theo từ khóa: ")  + Check.toGreenText(tuKhoa));
        if(filter.isEmpty())
            Check.printError("Không tìm thấy");
        else
        {
            xuatTieuDe();
            for(PhieuXuat phieuXuat : filter)
                phieuXuat.inPhieu();
        }
    }

    public void add(HoaDon hoaDon){
        DanhSachChiTietPhieu dsctp = new DanhSachChiTietPhieu();
        DanhSachChiTietHoaDon dscthd = hoaDon.getListChiTietHoaDon();
        for (ChiTietHoaDon cthd : dscthd.getListChiTietHoaDon())
        {
            ChiTietPhieu obj = new ChiTietPhieu(cthd.getMaSach(), cthd.getSLuong(), cthd.getGiaThanh());
            dsctp.add(obj);
        }
        DanhSachPhieuXuat.add(new PhieuXuat(getID(), hoaDon.getTimeXuat(), hoaDon.getMaNV(),
                "", dsctp, dsctp.tinhTongTien(), hoaDon.getMaHD()));
    }

    public void xemChiTietPhieu(Nguoi nguoi, DanhSachHoaDon danhSachHoaDon){
        if(DanhSachPhieuXuat.isEmpty())
            Check.printError("Danh sách đang rỗng");
        else
        {
            String id = Check.takeStringInput("Nhập ID phiếu cần xem chi tiết: ");
            Phieu obj = timKiemTheoIDPhieu(id);
            if(obj == null)
            {
                Check.printError("Không có ID đó trong danh sách");
                return;
            }
            boolean out = false;
            do
            {
                obj.xemChiTietPhieu();
                System.out.println("1. Xác nhận xuất kho");
                System.out.println("0. Thoát");
                switch (Check.takeInputChoice(0, 1))
                {
                    case 1 -> ((PhieuXuat) obj).xuatHang(nguoi, danhSachHoaDon);
                    case 0 -> out = true;
                }
                if(!out)
                    Check.ClearConsole();
            }while(!out);

        }
    }

    public void menu(Nguoi nguoi, DanhSachHoaDon danhSachHoaDon)
    {
        boolean thoatXemDSPhieu = false;
        while(true)
        {
            xuatTieuDe();
            xuatDS();
            System.out.println(Check.toBlueText("Menu phiếu xuất"));
            System.out.println("1. Xem chi tiết phiếu xuất");
            System.out.println("2. Xóa phiếu xuất");
            System.out.println("3. Tìm kiếm trong bảng");
            System.out.println("0. Quay lại");
            switch (Check.takeInputChoice(0,3))
            {
                case 1 -> xemChiTietPhieu(nguoi, danhSachHoaDon);
                case 2 -> xoaPhieu();
                case 3 -> timKiemTrongBang();
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
