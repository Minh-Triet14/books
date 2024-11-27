package QuanLyCuaHangBanSach;

import java.util.Arrays;
import java.util.Locale;

public class DanhSachTacGia implements DanhSach {
    protected TacGia[] listTacGia;
    protected int soLuongTacGia;
    private int count = 0;

    public DanhSachTacGia() {
        this.soLuongTacGia = 4;
        listTacGia = new TacGia[4];
        listTacGia[0] = new TacGia(getID(), "Tac gia sach giao khoa", "ABC", "1234", "abc@gmail.com");
        listTacGia[1] = new TacGia(getID(), "Tac gia sach kham khao", "DEF", "456", "def@gmail.com");
        listTacGia[2] = new TacGia(getID(), "Tac gia sach ki nang song", "GHI", "789", "ghi@gmail.com");
        listTacGia[3] = new TacGia(getID(), "Tac gia truyen", "JKL", "795", "jkl@gmail.com");
    }

    @Override
    public String getID() {
        count++;
        int a = count;
        String str = String.valueOf(a);
        while(str.length() != 3) {
            str = "0" + str;
        }
        str = "TG" + str;
        return str;
    }

    @Override
    public void XuatTieuDe() {
        System.out.format("┌%-30s┬%-30s┬%-30s┬%-30s┬%-30s┐%n", Check.repeatStr("─", 30), Check.repeatStr("─", 30), Check.repeatStr("─", 30), Check.repeatStr("─", 30), Check.repeatStr("─", 30));
        System.out.format("|%-30s|%-30s|%-30s|%-30s|%-30s|%n", "Ma Tac Gia", "Ten Tac Gia", "Dia Chi", "So Dien Thoai", "Email");
        System.out.format("├%-30s┼%-30s┼%-30s┼%-30s┼%-30s┤%n", Check.repeatStr("─", 30), Check.repeatStr("─", 30), Check.repeatStr("─", 30), Check.repeatStr("─", 30), Check.repeatStr("─", 30));
    }

    @Override
    public void xuatDS() {
        if(soLuongTacGia == 0) {
            System.out.println("Danh sach tac gia rong !");
        } else {
            System.out.println(Check.toBlueText("-----Xuat Danh Sach Tac Gia-----"));
            XuatTieuDe();
            for (int i = 0; i < this.soLuongTacGia; i++) {
                listTacGia[i].XuatTacGia();
            }
        }
    }

    //Thêm tác giả
    public void ThemTacGia() {
        listTacGia = Arrays.copyOf(listTacGia, soLuongTacGia + 1);
        listTacGia[soLuongTacGia] = new TacGia();
        System.out.println(Check.toBlueText("--------Them tac gia moi--------"));
        listTacGia[soLuongTacGia].NhapTacGia(getID());
        soLuongTacGia++;
        Check.printMessage("Da them tac gia vao danh sach tac gia !");
    }

    //Xóa tác giả
    public void XoaTacGia() {
        String maTacGia = Check.takeStringInput("Nhap ma tac gia can xoa: ");
        int j = timkiemIDTacGia(maTacGia);
        if(j == -1) {
            Check.printError("Khong tim thay ma tac gia !");
        } else {
            for(int i = j; i < this.soLuongTacGia - 1; i++) {
                listTacGia[i] = listTacGia[i + 1];
            }
            listTacGia = Arrays.copyOf(listTacGia, soLuongTacGia - 1);
            soLuongTacGia--;
            Check.printMessage("Da xoa can bo co ma: " + maTacGia);
        }
    }

    public int timkiemIDTacGia(String maTacGia) {
		for (int i = 0; i < this.soLuongTacGia; i++) {
			if (listTacGia[i].getMaTacGia().equalsIgnoreCase(maTacGia)) {
				return i;
			}
		}
		return -1;
	}

    //Tìm kiếm trả về đối tượng
    public TacGia TimKiemTheoIDTacGia(String maTacGia) {
        for(int i = 0; i < this.soLuongTacGia; i++) {
            if(listTacGia[i].getMaTacGia().equalsIgnoreCase(maTacGia)) {
                return listTacGia[i]; 
            }
        }
        return null;
    }

    public void menuSuaTacGia() {
        String idSua = Check.takeStringInput("Nhap ma tac gia can sua: ");
        TacGia tacgiaSua = TimKiemTheoIDTacGia(idSua);
        if(tacgiaSua == null) {
            Check.printError("Khong tim thay ma tac gia !");
        } else {
            boolean out;
            do { 
                out = false;
                XuatTieuDe();
                tacgiaSua.XuatTacGia();
                System.out.println("1. Sua Ten Tac Gia");
                System.out.println("2. Sua Dia Chi");
                System.out.println("3. Sua So Dien Thoai");
                System.out.println("4. Sua Email");
                System.out.println("0. Thoat");

                switch (Check.takeInputChoice(0, 4)) {
                    case 1:
                        tacgiaSua.setTenTacGia(Check.takeStringInput("Nhap ten tac gia moi: "));
                        break;
                    case 2:
                        tacgiaSua.setDiaChiTacGia(Check.takeStringInput("Nhap dia chi moi: "));
                        break;
                    case 3:
                        tacgiaSua.setSDTTacGia(Check.takeStringInput("Nhap so dien thoai moi: "));
                        break;
                    case 4:
                        tacgiaSua.setEmailTacGia(Check.takeStringInput("Nhap email moi: "));
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

    public void timKiemTrongBang(){
		String tuKhoa = Check.takeStringInput("Nhap tu khoa: ");
		TacGia []tacgia = new TacGia[soLuongTacGia];
		int n = 0;
		for (int i = 0; i < this.soLuongTacGia; i++) {
			if(
                    listTacGia[i].getMaTacGia().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
					listTacGia[i].getTenTacGia().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
				    listTacGia[i].getDiaChiTacGia().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
					listTacGia[i].getSDTTacGia().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT)) ||
				    listTacGia[i].getEmailTacGia().toLowerCase(Locale.ROOT).contains(tuKhoa.toLowerCase(Locale.ROOT))
			)
			{
				tacgia[n++] = listTacGia[i];
			}
		}

		System.out.println(Check.toBlueText("Tim kiem trong bang theo tu khoa: ")  + Check.toGreenText(tuKhoa));
		if(n == 0)
		{
			Check.printError("Khong tim thay tu khoa !");
			return;
		}
		XuatTieuDe();
		for (int i = 0; i < n; i++) {
			tacgia[i].XuatTacGia();
		}
	}

    public void menuTacGia() {
        while (true) { 
            xuatDS();
            System.out.println("1. Them Tac Gia");
            System.out.println("2. Xoa Tac Gia");
            System.out.println("3. Tim Kiem");
            System.out.println("4. Sua");
            System.out.println("0. Thoat");
            boolean out = false;
            switch (Check.takeInputChoice(0, 5)) {
                case 1:
                    ThemTacGia();
                    break;
                case 2:
                    XoaTacGia();
                    break;
                case 3:
                    timKiemTrongBang();
                    break;
                case 4:
                    menuSuaTacGia();
                    break;
                case 0:
                    out = true;
            }
            if(out) {
                break;
            }
            Check.ClearConsole();
        }  
    }

    public TacGia[] getListTacGia() {
        return listTacGia;
    }

    public void setListTacGia(TacGia[] listTacGia) {
        this.listTacGia = listTacGia;
    }
}
