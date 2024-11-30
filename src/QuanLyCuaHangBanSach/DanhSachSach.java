

package QuanLyCuaHangBanSach;

import java.util.Arrays;
import java.util.Locale;

public class DanhSachSach implements DanhSach {
    protected Sach[] listSach;
    private int count = 0;

    public DanhSachSach() {
        listSach = new Sach[4];
        listSach[0] = new SachGiaoKhoa(getID(), "Sach ngu van", "Sach giao khoa","10+", "NXB001", "TG001", 25000, 150);
        listSach[1] = new SachKhamKhao(getID(), "Sach khoa hoc", "Sach kham khao","10+", "NXB002", "TG002", 30000, 200);
        listSach[2] = new SachKiNangSong(getID(), "Sach giao tiep", "Sach ki nang song","10+", "NXB003", "TG003", 30000, 250);
        listSach[3] = new Truyen(getID(), "Tieu thuyet", "Truyen","10+", "NXB004", "TG004", 20000, 200); 
    }

    @Override
    public String getID() {
        count++;
        int a = count;
        String str = String.valueOf(a);
        while(str.length() != 3) {
            str = "0" + str;
        }
        str = "S" + str;
        return str;
    }

    @Override
    public void XuatTieuDe() {
        String smaSach, stenSach, sloaiSach,sdoTuoiKhuyenDoc, smaNXB, smatacGia, sgiaThanh, ssoLuong;
        smaSach = "Ma Sach";
        stenSach = "Ten Sach";
        sloaiSach = "Loai Sach";
        sdoTuoiKhuyenDoc = "Do Tuoi Khuyen Doc";
        smaNXB = "Ma Nha Xuat Ban";
        smatacGia = "Ma Tac Gia";
        sgiaThanh = "Gia Thanh";
        ssoLuong = "Ton Kho";

        System.out.format("┌%-20s┬%-20s┬%-20s┬%-20s┬%-20s┬%-20s┬%-20s┐%n", 
            Check.repeatStr("─", 20), Check.repeatStr("─", 20), Check.repeatStr("─", 20), 
            Check.repeatStr("─", 20), Check.repeatStr("─", 20), Check.repeatStr("─", 20), 
            Check.repeatStr("─", 20));
        System.out.format("│%-20s│%-20s│%-20s│%-20s│%-20s│%-20s│%-20s│%n", smaSach, stenSach, sloaiSach,sdoTuoiKhuyenDoc, smaNXB, smatacGia, sgiaThanh, ssoLuong);
        System.out.format("├%-20s┼%-20s┼%-20s┼%-20s┼%-20s┼%-20s┼%-20s┼%n",
            Check.repeatStr("─", 20), Check.repeatStr("─", 20), Check.repeatStr("─", 20), 
            Check.repeatStr("─", 20), Check.repeatStr("─", 20), Check.repeatStr("─", 20), 
            Check.repeatStr("─", 20));
    }

    @Override
    public void xuatDS() {
        if(getSoLuong() == 0) {
            Check.printError("Danh sach sach rong !");
        } else {
            XuatTieuDe();
            for (int i = 0; i < getSoLuong(); i++) {
                listSach[i].xuatThongTin();
            }
        }
    }

    //Thêm sách
    public void ThemSach(DanhSachTacGia dstg, DanhSachNhaXuatBan dsnxb) {
        String maSach = getID();
        String maTacGia = Check.NhapMaTacGia(dstg);
        if(maTacGia.equals("Stop")) {
            return;
        } 
        String maNhaXuatBan = Check.NhapMaNhaXuatBan(dsnxb);
        listSach = Arrays.copyOf(listSach, getSoLuong() + 1);
        switch(dstg.TimKiemTheoIDTacGia(maTacGia).getTenTacGia()) {
            case "SachGiaoKhoa" -> listSach[getSoLuong() - 1] = new SachGiaoKhoa();
            case "SachKhamKhao" -> listSach[getSoLuong() - 1] = new SachKhamKhao();
            case "SachKiNangSong" -> listSach[getSoLuong() - 1] = new SachKiNangSong();
            case "Truyen" -> listSach[getSoLuong() - 1] = new Truyen();
        }
        listSach[getSoLuong() - 1].Nhap(maSach, maTacGia, maNhaXuatBan);
    }

    //Tìm kiếm sách theo mã sách
    public int TimKiemMaSach(String maSach) {
        for(int i = 0; i < getSoLuong(); i++) {
            if(listSach[i].getMaSach().equals(maSach)) {
                return i;
            } 
        }
        return -1;
    }

    //Xóa sách
    public void XoaSach() {
        String maSach = Check.takeStringInput("Nhap ma sach can xoa: ");
        int j = TimKiemMaSach(maSach);
        if(j == -1) {
            Check.printError("Khong tim thay ma sach !");
        } else {
            for(int i = j; i < getSoLuong() - 1; i++) {
                listSach[i] = listSach[i + 1];
            }
            listSach[getSoLuong() - 1] = null;
            listSach = Arrays.copyOf(listSach, getSoLuong() - 1);
        }
    }

    //Sửa thông tin sách theo mã
    public void MenuSuaSach(DanhSachTacGia dstg, DanhSachNhaXuatBan dsnxb) {
        String id = Check.takeStringInput("Nhap ma sach can sua: ");
        int n = TimKiemMaSach(id);
        if(n == -1) {
            Check.printError("Khong tim thay ma sach !");
        } else {
            boolean out = false;
            do { 
                XuatTieuDe();
                getListSach()[n].xuatThongTin();
                System.out.println("1. Sua Ten Sach");
                System.out.println("2. Sua Do Tuoi Khuyen Doc");
                System.out.println("3. Sua Ma Nha Xuat Ban");
                System.out.println("4. Sua Ma Tac Gia");
                System.out.println("5. Sua Gia Thanh");
                System.out.println("0. Thoat");

                switch(Check.takeInputChoice(0, 5)) {
                    case 1:
                        getListSach()[n].setTenSach(Check.takeStringInput("Nhap ten sach moi: "));
                        break;
                    case 2:
                        getListSach()[n].setDoTuoi(Check.takeStringInput("Nhap lua tuoi khuyen doc moi: "));
                        break;
                    case 3:
                        getListSach()[n].setMaNXB(Check.NhapMaNhaXuatBan(dsnxb));
                        break;
                    case 4:
                        getListSach()[n].setMaTacGia(Check.NhapMaTacGia(dstg));
                        break;
                    case 5:
                        getListSach()[n].setGiaThanh(Check.takeIntegerInput("Nhap gia thanh moi: "));
                        break;
                    case 0:
                        out = true;
                        break;
                }
                if(!out) {
                    Check.ClearConsole();
                }
            } while (!out);
        }

    }

    //Tìm kiếm thông tin sách theo từ khoá
    public void TimKiemThongTinSach() {
        String tuKhoa = Check.takeStringInput("Nhap tu khoa can tim kiem: ");
        Sach[] sach = new Sach[getSoLuong()];
        int gia;
        try {
            gia = Integer.parseInt(tuKhoa);
        } catch (NumberFormatException e) {
            gia = Integer.MIN_VALUE;
        }
        int n = 0;

        for(int i = 0; i < getSoLuong(); i++) {
            if(
                listSach[i].getMaSach().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                listSach[i].getTenSach().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                listSach[i].getLoaiSach().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                listSach[i].getDoTuoi().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                listSach[i].getMaNXB().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                listSach[i].getMaTacGia().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                listSach[i].getGiaThanh() == gia
            ) {
                sach[n++] = listSach[i];
            }
        }
        System.out.println(Check.toBlueText("Tim kiem sach trong bang theo tu khoa: " + Check.toGreenText(tuKhoa)));
        if(n == 0) {
            Check.printError("Khong tim thay tu khoa !");
        } else {
            XuatTieuDe();
            for (int i = 0; i < n; i++) {
                    sach[i].xuatThongTin();
            }
        }
    }

    public void setListSach(Sach[] sach) {
        this.listSach = sach;
    }

    public Sach[] getListSach() {
        return listSach;
    }

    public void setSoluong(int soLuong) {
        this.listSach = Arrays.copyOf(listSach, soLuong);
    }

    public int getSoLuong() {
        return listSach.length;
    }

    public void MenuSach(DanhSachTacGia dstg, DanhSachNhaXuatBan dsnxb) {
        boolean out = false;
        while (true) { 
            xuatDS();
            System.out.println("===== MENU SACH ====");
            System.out.println("1. Them Sach");
            System.out.println("2. Sua Sach");
            System.out.println("3. Xoa Sach");
            System.out.println("4. Tim Kiem Sach");
            System.out.println("0. Thoat");

            switch(Check.takeInputChoice(0, 5)) {
                case 1:
                    ThemSach(dstg, dsnxb);
                    break;
                case 2:
                    MenuSuaSach(dstg, dsnxb);
                    break;
                case 3:
                    XoaSach();
                    break;
                case 4:
                    TimKiemThongTinSach();
                    break;
                case 0:
                    out = true;
                    break;
            }
            if(out) {
                Check.printMessage("Da Thoat Chuong Trinh !");
                break;
            }
            Check.ClearConsole();
        }
    }

  public static void main(String[] args) {
      DanhSachSach sach = new DanhSachSach();
      sach.MenuSach(null, null);
  }
}
