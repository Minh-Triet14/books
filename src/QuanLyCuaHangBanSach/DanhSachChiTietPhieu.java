package QuanLyCuaHangBanSach;

import java.util.Arrays;

//Danh sách này bắt chước theo vector trong c++
public class DanhSachChiTietPhieu {

    private ChiTietPhieu []chitietphieu;
    private int index;
    private int capacity;

    public DanhSachChiTietPhieu()
    {
        index = 0;
        capacity = 2;
        chitietphieu = new ChiTietPhieu[capacity];
    }

    public boolean empty()
    {
        return index == 0;
    }

// thêm phiếu
    public void add(ChiTietPhieu obj)
    {

        if(index + 1 > capacity)
            reSizeArray();

        chitietphieu[index] = obj;
        index++;
    }

    public void remove(String id)
    {
        int z = -1;
        for (int i = 0; i < index; i++)
        {
            if(chitietphieu[i].getIDSach().equals(id))
            {
                z = i;
                break;
            }
        }

        if(z == -1)
        {
            Check.printError("Không tìm thấy mã điện thoại: " + id);
            return;
        }

        index--;
        for (int j = z; j < index; j++) {
            chitietphieu[j] = chitietphieu[j+1];
        }
        Check.printMessage("Xóa thành công");
    }

    public ChiTietPhieu search(String id)
    {
        for (int i = 0; i < index; i++) {
            if(chitietphieu[i].getIDSach().equals(id))
                return chitietphieu[i];
        }
        return null;
    }

    public DanhSachChiTietPhieu searchSoLuong(int soLuong)
    {
        DanhSachChiTietPhieu searchArr = new DanhSachChiTietPhieu();
        for (int i = 0; i < index; i++) {
            if(chitietphieu[i].getSoLuong() == soLuong)
                searchArr.add(chitietphieu[i]);
        }
        return searchArr;
    }

    public DanhSachChiTietPhieu searchDonGia(int Gia)
    {
        DanhSachChiTietPhieu searchArr = new DanhSachChiTietPhieu();
        for (int i = 0; i < index; i++) {
            if(chitietphieu[i].getGia() == Gia)
                searchArr.add(chitietphieu[i]);
        }
        return searchArr;
    }
    //┘ └ ┌ ┐ ├ ┤ ┴ ┬ ┼ │ ─
    public static void xuatTuaDe()
    {
        System.out.printf("├%-16s┬%-16s┬%-16s┤\n", Check.repeatStr("─", 16), Check.repeatStr("─", 16), Check.repeatStr("─", 16));
        System.out.printf("│%-16s│%-16s│%-16s│\n", "ID điện thoại", "Số lượng", "Đơn giá");
        System.out.printf("├%-16s┼%-16s┼%-16s┤\n", Check.repeatStr("─", 16), Check.repeatStr("─", 16), Check.repeatStr("─", 16));
    }

    public void xuatDS()
    {
        xuatTuaDe();
        for (int i = 0; i < index; i++) {
            chitietphieu[i].inChiTietPhieu();
        }
    }

    public int tinhTongTien()
    {
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += chitietphieu[i].getGia() * chitietphieu[i].getSoLuong();
        }
        return sum;
    }

    //Sửa lại capacity
    private void reSizeArray()
    {
        capacity = capacity * 2;
        chitietphieu = Arrays.copyOf(chitietphieu, capacity);
    }


    public ChiTietPhieu[] getchitietphieu() {
        return chitietphieu;
    }

    public void setChitietphieu(ChiTietPhieu[] chitietphieu) {
        this.chitietphieu = chitietphieu;
    }

    public int getSize(){
        return index;
    }

    public int getCapacity(){
        return capacity;
    }
}
