package QuanLyCuaHangBanSach;

import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Collectors;

public class BooksShop {
    ArrayList<Nguoi> listNguoi;
    int count = 0;

    public BooksShop() {
        listNguoi = new ArrayList<>();
        taoNguoiQuanLy();
        Nguoi nvbh = new NhanVienBanHang(getIDNV(), "Nguyen Van a", "C11", "012344", "12/08/3000", "Nam", "563456", "123", 100000);
        Nguoi nvtk = new NhanVienThuKho(getIDTK(), "Nguyen Van b", "C12", "3752475", "4/43/6565", "Nu", "53746", "123", 100000);
        Nguoi kh1 = new KhachHang(getIDKH(), "Nguyen Van c", "C13", "43767673", "43/6/5425", "Khac", "373435", "123");
        Nguoi kh2 = new KhachHang(getIDKH(), "Nguyen Van d", "C14", "3624273", "3/5/6455", "Nu", "22654", "123");
        listNguoi.add(nvbh);
        listNguoi.add(nvtk);
        listNguoi.add(kh1);
        listNguoi.add(kh2);
    }

    public String getIDNV() {
        count++;
        int a = count;
        String str = String.valueOf(a);
        while(str.length() != 3) {
            str = "0" + str;
        }
        str = "NVBH" + str;
        return str;
    }

    public String getIDTK() {
        count++;
        int a = count;
        String str = String.valueOf(a);
        while(str.length() != 3) {
            str = "0" + str;
        }
        str = "NVTK" + str;
        return str;
    }

    public String getIDKH() {
        count++;
        int a = count;
        String str = String.valueOf(a);
        while(str.length() != 3) {
            str = "0" + str;
        }
        str = "KH" + str;
        return str;
    }


    public Nguoi login() {
        Check.printMessage("Dang nhap");
        String id = Check.takeStringInput("Nhap id: ");
        String pass = Check.takeStringInput("Nhap password: ");
        return listNguoi.stream().filter(x -> x.getId().equals(id) && x.getPassword().equals(pass)).findAny().orElse(null);
    }

    private void taoNguoiQuanLy() {
        if(listNguoi.stream().filter(x -> x instanceof QuanLy).findAny().orElse(null) != null) {
            System.out.println("Cua hang chi co 1 nguoi quan ly");
            return;
        }
        Nguoi quanLy = new QuanLy("Admin", "Minh Triet", "C11/34F", "09875432", "14/11/2000", "Nam", "12345678", "admin", Integer.MAX_VALUE);
        listNguoi.add(quanLy);
    }

    public Nguoi timKiemTheoID(String id)
    {
        return listNguoi.stream().filter(x -> x.getId().equals(id)).findAny().orElse(null);
    }

    //dk = "KhachHang" | "NhanVienThuKho" | "NhanVienBanHang" | "NhanVien"
    public Nguoi timKiemTheoID(String id, String dk)
    {
        if(dk.equals("KhachHang"))
            return listNguoi.stream().filter(x -> x.id.equals(id) && x instanceof KhachHang).findFirst().orElse(null);
        else if(dk.equals("NhanVienThuKho"))
            return listNguoi.stream().filter(x -> x.id.equals(id) && x instanceof NhanVienThuKho).findFirst().orElse(null);
        else if(dk.equals("NhanVienBanHang"))
            return listNguoi.stream().filter(x -> x.id.equals(id) && x instanceof NhanVienBanHang).findFirst().orElse(null);
        else
            return listNguoi.stream().filter(x -> x.id.equals(id) && (x instanceof NhanVienBanHang || x instanceof NhanVienThuKho)).findFirst().orElse(null);
    }

    private String chonGioiTinh()
    {
        String gt = "";
        System.out.println("***Lua chon gioi tinh***");
        System.out.println("1. Nam");
        System.out.println("2. Nu");
        System.out.println("3. Khac");
        switch (Check.takeInputChoice(1, 3))
        {
            case 1 -> {gt = "Nam";}
            case 2 -> {gt = "Nu";}
            case 3 -> {gt = "Khac";}
        }
        return gt;
    }

    //Tạo người với lựa chọn. Choice = "KhachHang" | "NhanVien"
    public void taoNguoi(String choice) {
        String id;
        while (true) {
            id = Check.takeStringInput("Nhap id: ");
            if (timKiemTheoID(id) != null) {
                Check.printError("ID nay da co vui long chon id khac !");
            } else {
                break;
            }
        }
        String hoTen = Check.takeStringInput("Nhap ho ten: ");
        String diaChi = Check.takeStringInput("Nhap dia chi: ");
        String sdt = Check.takePhoneNumberInput("Nhap so dien thoai: ");
        String ns = Check.takeDateInput("Nhap ngay sinh (dd/MM/yyyy): ");
        String gt = chonGioiTinh();
        String cmnd = Check.takeStringInput("Nhap CMND: ");
        String pass = Check.takeStringInput("Nhap password: ");

        if (choice.equals("KhachHang")) {
            Nguoi kh = new KhachHang(id, hoTen, diaChi, sdt, pass, hoTen, cmnd, pass);
            listNguoi.add(kh);
        } else if (choice.equals("NhanVien")) {
            int mucLuong = Check.takeIntegerInput("Nhap muc luong: ");
            System.out.println("Chon chuc vu cua nhan vien");
            System.out.println("1. Nhan vien thu kho");
            System.out.println("2. Nhan vien ban hang");
            switch (Check.takeInputChoice(1, 2))
            {
                case 1 -> {
                    Nguoi nhanVienThuKho = new NhanVienThuKho(id, hoTen, diaChi, sdt, ns, gt, cmnd, pass, mucLuong);
                    listNguoi.add(nhanVienThuKho);
                }
                case 2 -> {
                    Nguoi nhanVienBanHang = new NhanVienBanHang(id, hoTen, diaChi, sdt, ns, gt, cmnd, pass, mucLuong);
                    listNguoi.add(nhanVienBanHang);
                }
            }
        }
    }

    public void inDanhsachNhanVien() {
        int count = 0;
        System.out.println(Check.toBlueText("-----Xuat Danh Sach Nhan Vien-----"));
        xuatTieuDeNhanVien();
        for (Nguoi nguoi : listNguoi) {
            if (nguoi instanceof NhanVienBanHang || nguoi instanceof NhanVienThuKho)
            {
                nguoi.xuatThongTin();
                count++;
            }
        }
        if(count == 0)
            Check.printError("Khong co nhan vien nao !");
    }

    public void inDanhsachNhanVien(ArrayList<Nguoi> list) {
        int count = 0;
        xuatTieuDeNhanVien();
        for (Nguoi nguoi : list) {
            if (nguoi instanceof NhanVienBanHang || nguoi instanceof NhanVienThuKho)
            {
                nguoi.xuatThongTin();
                count++;
            }
        }
        if(count == 0)
            Check.printError("Khong co nhan vien nao !");
    }

    public void inDanhSachKhangHang() {
        int count = 0;
        System.out.println(Check.toBlueText("-----Xuat Danh Sach Khach Hang-----"));
        xuatTieuDeKhachHang();
        for (Nguoi nguoi : listNguoi) {
            if (nguoi instanceof KhachHang)
            {
                nguoi.xuatThongTin();
                count++;
            }
        }
        if(count == 0)
            Check.printError("Khong co khach hang nao !");
    }

    public void xuatTieuDeKhachHang()
    {
        System.out.printf("┌%-16s┬%-16s┬%-16s┬%-10s┬%-10s┬%-10s┬%-9s┬%-16s┐%n",
                Check.repeatStr("─", 16), Check.repeatStr("─", 16), Check.repeatStr("─", 16),
                Check.repeatStr("─", 10), Check.repeatStr("─", 10), Check.repeatStr("─", 10),
                Check.repeatStr("─", 9), Check.repeatStr("─", 16));

        System.out.printf("|%-16s|%-16s|%-16s|%-10s|%-10s|%-10s|%-9s|%-16s|%n",
                "ID Khach Hang", "Ho Ten", "Dia Chi", "SDT", "Ngay Sinh", "Gioi Tinh", "CMND", "Password");

        System.out.printf("├%-16s┼%-16s┼%-16s┼%-10s┼%-10s┼%-10s┼%-9s┼%-16s┤%n",
                Check.repeatStr("─", 16), Check.repeatStr("─", 16), Check.repeatStr("─", 16),
                Check.repeatStr("─", 10), Check.repeatStr("─", 10), Check.repeatStr("─", 10),
                Check.repeatStr("─", 9), Check.repeatStr("─", 16));
    }

    public void xuatTieuDeNhanVien()
    {
        System.out.printf("┌%-16s┬%-16s┬%-16s┬%-10s┬%-10s┬%-10s┬%-9s┬%-16s┬%-10s┬%-16s┐%n",
                Check.repeatStr("─", 16), Check.repeatStr("─", 16), Check.repeatStr("─", 16),
                Check.repeatStr("─", 10), Check.repeatStr("─", 10), Check.repeatStr("─", 10),
                Check.repeatStr("─", 9), Check.repeatStr("─", 16), Check.repeatStr("─", 10),
                Check.repeatStr("─", 16));

        System.out.printf("|%-16s|%-16s|%-16s|%-10s|%-10s|%-10s|%-9s|%-16s|%-10s|%-16s|%n",
                "ID Nhan Vien", "Ho Ten", "Dia Chi", "SDT", "Ngay Sinh",
                "Gioi Tinh", "CMND", "Password", "Muc Luong", "Chuc Vu");

        System.out.printf("├%-16s┼%-16s┼%-16s┼%-10s┼%-10s┼%-10s┼%-9s┼%-16s┼%-10s┼%-16s┤%n",
                Check.repeatStr("─", 16), Check.repeatStr("─", 16), Check.repeatStr("─", 16),
                Check.repeatStr("─", 10), Check.repeatStr("─", 10), Check.repeatStr("─", 10),
                Check.repeatStr("─", 9), Check.repeatStr("─", 16), Check.repeatStr("─", 10),
                Check.repeatStr("─", 16));
    }

    private void menuSua(Nguoi nguoi)
    {
        int max = 7;
        if(nguoi instanceof NhanVienBanHang || nguoi instanceof NhanVienThuKho)
            max = 8;
        boolean out;
        do {
            out = false;
            if(nguoi instanceof KhachHang)
                xuatTieuDeKhachHang();
            else
                xuatTieuDeNhanVien();
            nguoi.xuatThongTin();
            System.out.println("1. Sua Ten");
            System.out.println("2. Sua Dia Chi");
            System.out.println("3. Sua SDT");
            System.out.println("4. Sua Ngay Sinh");
            System.out.println("5. Sua Gioi Tinh");
            System.out.println("6. Sua CMND");
            System.out.println("7. Sua Password");
            if(nguoi instanceof NhanVienBanHang || nguoi instanceof NhanVienThuKho)
                System.out.println("8. Sua Muc Luong");
            System.out.println("0. Thoat");

            switch (Check.takeInputChoice(0, max))
            {
                case 1 -> {nguoi.setHoTen(Check.takeStringInput("Nhap ho ten moi: "));}
                case 2 -> {nguoi.setDiaChi(Check.takeStringInput("Nhap dia chi moi: "));}
                case 3 -> {nguoi.setSDT(Check.takePhoneNumberInput("Nhap SDT moi: "));}
                case 4 -> {nguoi.setNgaySinh(Check.takeDateInput("Nhap ngay sinh moi: "));}
                case 5 -> {nguoi.setGioiTinh(chonGioiTinh());}
                case 6 -> {nguoi.setCMND(Check.takeStringInput("Nhap CMND moi: "));}
                case 7 -> {nguoi.setPassword(Check.takeStringInput("Nhap password moi: "));}
                case 8 -> {((NhanVien)nguoi).setMucLuong(Check.takeIntegerInput("Nhap muc luong moi: "));}
                case 0 -> {out = true;}
            }
            if(!out)
                Check.ClearConsole();
        }while (!out);
    }

    public void timKiemTrongBang(String s)
    {
        String tuKhoa = Check.takeStringInput("Nhap tu khoa: ");
        ArrayList<Nguoi> filter = new ArrayList<>();
        if(s.equals("KH"))
        {
            for(Nguoi nguoi : listNguoi)
            {
                if(nguoi instanceof KhachHang)
                {
                    if(
                            nguoi.getHoTen().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                            nguoi.getCMND().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                            nguoi.getNgaySinh().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                            nguoi.getPassword().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                            nguoi.getDiaChi().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                            nguoi.getGioiTinh().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                            nguoi.getSDT().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT))
                    )
                    {
                        filter.add(nguoi);
                    }
                }
            }

            System.out.println(Check.toBlueText("Ket qua tim kiem theo tu khoa: ")  + Check.toGreenText(tuKhoa));
            if(!filter.isEmpty())
            {
                xuatTieuDeKhachHang();
                for(Nguoi nguoi : filter)
                {
                    nguoi.xuatThongTin();
                }
            }
            else
                Check.printError("Khong tim thay !");
        }
        else
        {
            for(Nguoi nguoi : listNguoi)
            {
                if(nguoi instanceof NhanVien)
                {
                    if(
                            nguoi.getHoTen().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                            nguoi.getCMND().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                            nguoi.getNgaySinh().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                            nguoi.getPassword().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                            nguoi.getDiaChi().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                            nguoi.getGioiTinh().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
                            nguoi.getSDT().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT))
                    )
                    {
                        filter.add(nguoi);
                    }
                }
            }
            System.out.println(Check.toBlueText("Ket qua tim kiem theo tu khoa: ")  + Check.toGreenText(tuKhoa));
            if(!filter.isEmpty())
            {
                xuatTieuDeNhanVien();
                for(Nguoi nguoi : filter)
                {
                    nguoi.xuatThongTin();
                }
            }
            else
                Check.printError("Khong tim thay !");
        }
    }

    public void menuDanhSachKhachHang()
    {
        boolean out;
        do
        {
            out = false;
            inDanhSachKhangHang();
            System.out.println("1. Them Khach Hang");
            System.out.println("2. Tim Kiem Trong Bang");
            System.out.println("3. Xoa Khach Hang");
            System.out.println("4. Sua");
            System.out.println("0. Thoat");
            switch (Check.takeInputChoice(0, 4))
            {
                case 1 -> {taoNguoi("KhachHang");}
                case 2 -> timKiemTrongBang("KH");
                case 3 -> {
                    String id = Check.takeStringInput("Nhap ID khach hang can xoa: ");
                    Nguoi obj = timKiemTheoID(id, "KhachHang");
                    if(obj == null)
                        Check.printError("Khong tim thay !");
                    else{
                        listNguoi.remove(obj);
                        Check.printMessage("Xoa thanh cong");
                    }
                }
                case 4 -> {
                    String id = Check.takeStringInput("Nhap ID khach hang can sua: ");
                    Nguoi obj = timKiemTheoID(id, "KhachHang");
                    if(obj == null)
                        Check.printError("Khong tim thay !");
                    else{
                        menuSua(obj);
                    }
                }
                case 0 -> {out = true;}
            }
            if(!out)
                Check.ClearConsole();
        }while(!out);
    }

    //dk = "NhanVienBanHang" | "NhanVienThuKho"
    private ArrayList<Nguoi> locDanhSachNhanVien(String dk)
    {
        ArrayList<Nguoi> result;
        if (dk.equals("NhanVienBanHang"))
            result = listNguoi.stream()
                    .filter(x -> x instanceof NhanVienBanHang)
                    .collect(Collectors.toCollection(ArrayList::new));
        else
            result = listNguoi.stream()
                    .filter(x -> x instanceof NhanVienThuKho)
                    .collect(Collectors.toCollection(ArrayList::new));
        if(result.toString().equals("[]"))
            return null;
        return result;
    }

    public void menuDanhSachNhanVien()
    {
        boolean out;
        do
        {
            out = false;
            inDanhsachNhanVien();
            System.out.println("1. Them Nhan Vien");
            System.out.println("2. Tim Kiem Trong Bang");
            System.out.println("3. Xoa Nhan Vien");
            System.out.println("4. Sua");
            System.out.println("5. Loc Theo Chuc Vu");
            System.out.println("0. Thoat");
            switch (Check.takeInputChoice(0, 5))
            {
                case 1 -> {taoNguoi("NhanVien");}
                case 2 -> timKiemTrongBang("NV");
                case 3 -> {
                    String id = Check.takeStringInput("Nhap ID nhan vien can xoa: ");
                    Nguoi obj = timKiemTheoID(id, "NhanVien");
                    if(obj == null)
                        Check.printError("Khong tim thay !");
                    else{
                        listNguoi.remove(obj);
                        Check.printMessage("Xoa thanh cong");
                    }
                }
                case 4 -> {
                    String id = Check.takeStringInput("Nhap ID nhan vien can sua: ");
                    Nguoi obj = timKiemTheoID(id, "NhanVien");
                    if(obj == null)
                        Check.printError("Khong tim thay !");
                    else{
                        menuSua(obj);
                    }
                }
                case 5 -> {
                    System.out.println("1. Loc Theo Nhan Vien Thu kho");
                    System.out.println("2. Loc Theo Nhan Vien Ban Hang");
                    switch (Check.takeInputChoice(1, 2))
                    {
                        case 1 -> {
                            ArrayList<Nguoi> list = locDanhSachNhanVien("NhanVienThuKho");
                            if(list != null)
                                inDanhsachNhanVien(list);
                            else
                                Check.printError("Khong loc duoc !");
                        }
                        case 2 -> {
                            ArrayList<Nguoi> list = locDanhSachNhanVien("NhanVienBanHang");
                            if(list != null)
                                inDanhsachNhanVien(list);
                            else
                                Check.printError("Khong loc duoc !");
                        }
                    }
                }
                case 0 -> {out = true;}
            }
            if(!out)
                Check.ClearConsole();
        }while(!out);
    }

    public static void main(String[] args) {
        BooksShop bs = new BooksShop();
        boolean out = false;
        while(true) {
            System.out.println("1. Menu Khach Hang");
            System.out.println("2. Menu Nhan Vien");
            System.out.println("0. Thoat");

            switch(Check.takeInputChoice(0, 2)) {
                case 1:
                    bs.menuDanhSachKhachHang();
                    break;
                case 2:
                    bs.menuDanhSachNhanVien();
                    break;
                case 0:
                    out = true;
                    break;
            }
            Check.ClearConsole();
            if(out) {
                Check.printMessage("Da thoat chuong trinh !");
                break;
            }
        }
    }
}
