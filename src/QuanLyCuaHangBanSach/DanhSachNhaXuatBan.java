package QuanLyCuaHangBanSach;

import java.util.ArrayList;
import java.util.Locale;

public class DanhSachNhaXuatBan implements DanhSach {
    private ArrayList<NhaXuatBan> ListNhaXuatBan;
    private int count = 0;

    public DanhSachNhaXuatBan() {
        ListNhaXuatBan = new ArrayList<>();
        ListNhaXuatBan.add(new NhaXuatBan(getID(), "Ten nha xuat ban 1", "C11/46F", "08587345", "NXB1@gmail.com"));
        ListNhaXuatBan.add(new NhaXuatBan(getID(), "Ten nha xuat ban 2", "C12/56T", "072643743", "NXB2@gmail.com"));
        ListNhaXuatBan.add(new NhaXuatBan(getID(), "Ten nha xuat ban 3", "C13/43J", "05643568754", "NXB3@gmail.com"));
        ListNhaXuatBan.add(new NhaXuatBan(getID(), "Ten nha xuat ban 4", "C14/54H", "0357654765", "NXB4@gmail.com"));
    }

    @Override
    public String getID() {
        count++;
        int a = count;
        String str = String.valueOf(a);
        while(str.length() != 3) {
            str = "0" + str;
        }
        str = "NXB" + str;
        return str;
    }

    @Override
    public void XuatTieuDe() {
        System.out.format("┌%-30s┬%-30s┬%-30s┬%-30s┬%-30s┐%n", Check.repeatStr("─", 30), Check.repeatStr("─", 30), Check.repeatStr("─", 30), Check.repeatStr("─", 30), Check.repeatStr("─", 30));
        System.out.format("|%-30s|%-30s|%-30s|%-30s|%-30s|%n", "Ma Nha Xuat Ban", "Ten Nha Xuat Ban", "Dia Chi", "So Dien Thoai", "Email");
        System.out.format("├%-30s┼%-30s┼%-30s┼%-30s┼%-30s┤%n", Check.repeatStr("─", 30), Check.repeatStr("─", 30), Check.repeatStr("─", 30), Check.repeatStr("─", 30), Check.repeatStr("─", 30));
    }

    @Override
    public void xuatDS() {
        System.out.println(Check.toBlueText("-----Xuat Danh Sach Nha Xuat Ban------"));
        XuatTieuDe();
        for(NhaXuatBan nxb : ListNhaXuatBan) {
            nxb.XuatNXB();
        }
    }

    //Thêm nhà xuất bản
    public void ThemNXB() {
        NhaXuatBan nxb = new NhaXuatBan();
        System.out.println(Check.toBlueText("----Them Nha Xuat Ban Moi----"));
        nxb.NhapNXB(getID());
        ListNhaXuatBan.add(nxb);
    }

    //Tìm kiếm nhà xuất bản theo ID
    public NhaXuatBan TimKiemIDNXB(String maNXB) {
        for(NhaXuatBan nxb : ListNhaXuatBan) {
            if(nxb.getMaNXB().equalsIgnoreCase(maNXB)) {
                return nxb;
            }
        }
        return null;
    }

    //Xóa nhà xuất bản
    public void XoaNXB() {
        String id = Check.takeStringInput("Nhap ma nha xuat ban can xoa: ");
        NhaXuatBan nxb = TimKiemIDNXB(id);
        if(nxb == null) {
            Check.printError("Khong tim thay ma nha xuat ban !");
        } else {
            ListNhaXuatBan.remove(nxb);
            Check.printMessage("Da xoa nha xuat ban !");
        }
    }

    //Sửa thông tin nhà xuất bản
    public void MenuSuaNXB() {
        String id = Check.takeStringInput("Nhap ma nha xuat ban can sua: ");
        NhaXuatBan nxbSua = TimKiemIDNXB(id);
        if(nxbSua == null) {
            Check.printError("Khong tim thay ma nha xuat ban !");
        } else {
            while(true) {
                boolean out = false;
                XuatTieuDe();
                nxbSua.XuatNXB();
                System.out.println("1. Sua Ten Nha Xuat Ban");
                System.out.println("2. Sua Dia Chi");
                System.out.println("3. Sua So Dien Thoai");
                System.out.println("4. Sua Email");
                System.out.println("0. Thoat");

                switch(Check.takeInputChoice(0, 4)) {
                    case 1:
                        nxbSua.setTen(Check.takeStringInput("Nhap ten nha xuat ban moi: "));
                        Check.printMessage("Ten da duoc cap nhat !");
                        break;
                    case 2:
                        nxbSua.setDiaChi(Check.takeStringInput("Nhap dia chi moi: "));
                        break;
                    case 3:
                        nxbSua.setSDT(Check.takeStringInput("Nhap so dien thoai moi: "));
                        break;
                    case 4:
                        nxbSua.setEmail(Check.takeStringInput("Nhap email moi: "));
                        break;
                    case 0:
                        out = true;
                        break;
                }
                if(out) {
                    break;
                }
                Check.ClearConsole();
            }
        }
    }

    //Tìm kiếm nhà xuất bản
    public void TimKiemThongTinNXB() {
        String tuKhoa = Check.takeStringInput("Nhap tu khoa can tim kiem: ");
        ArrayList<NhaXuatBan> listNXB = new ArrayList<>();
        for(NhaXuatBan nxb : listNXB) {
            if(
                nxb.getMaNXB().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                nxb.getTen().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                nxb.getDiaChi().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                nxb.getSDT().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                nxb.getEmail().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT))
            ) {
                listNXB.add(nxb);
            }
        }
        System.out.println(Check.toBlueText("Tim kiem trong bang theo tu khoa: " + Check.toGreenText(tuKhoa)));
        if(listNXB.isEmpty()) {
            Check.printError("Khong tim thay tu khoa !");
            return;
        }
        XuatTieuDe();
        for(NhaXuatBan nxb : listNXB) {
            nxb.XuatNXB();
        }
    }

    public void MenuNXB() {
        while (true) { 
            boolean out = false;
            xuatDS();
            System.out.println("1. Them Nha Xuat Ban");
            System.out.println("2. Xoa Nha Xuat Ban");
            System.out.println("3. Tim Kiem Nha Xuat Ban");
            System.out.println("4. Sua Nha Xuat Ban");
            System.out.println("5. Xuat Danh Sach");
            System.out.println("0. Thoat");
            switch(Check.takeInputChoice(0, 5)) {
                case 1:
                    ThemNXB();
                    break;
                case 2:
                    XoaNXB();
                    break;
                case 3:
                    TimKiemThongTinNXB();
                    break;
                case 4:
                    MenuSuaNXB();
                    break;
                case 5:
                    xuatDS();
                    break;
                case 0:
                    out = true;
                    break;
            }
            if(out) {
                break;
            }
            Check.ClearConsole();
        }
    }

    public ArrayList<NhaXuatBan> getListNhaXuatBan() {
        return ListNhaXuatBan;
    }

    public void setListNhaXuatBan(ArrayList<NhaXuatBan> listNhaXuatBan) {
        this.ListNhaXuatBan = listNhaXuatBan;
    }
}
