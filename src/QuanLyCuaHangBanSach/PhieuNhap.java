package QuanLyCuaHangBanSach;

public class PhieuNhap extends  Phieu  {
    private String IDNXB;

    public PhieuNhap(String IDPhieu, String date, String IDNXB, String IDNhanVien,
                     DanhSachChiTietPhieu dsChiTietPhieu, int sumMoney) {
        super(IDPhieu, date, dsChiTietPhieu, sumMoney, IDNhanVien);
        setIDNXB(IDNXB);
    }

    //┘ └ ┌ ┐ ├ ┤ ┴ ┬ ┼ │ ─
    public void inPhieu(){
        System.out.printf("│%-16s│%-16s│%-16s", IDPhieu, date, sumMoney);
        System.out.printf("│%-16s│%-16s│\n", IDNhanVien, IDNXB);
    }

    public void xemChiTietPhieu()
    {
        System.out.printf("┌%-50s┐\n", Check.repeatStr("─", 50));
        System.out.printf("│%-10s%-30s%-10s│\n", Check.repeatStr(" ", 10), "Chi tiết phiếu nhập", Check.repeatStr(" ", 10));
        System.out.printf("│%-50s│\n", ("ID phiếu: " + getIDPhieu()));
        System.out.printf("│%-50s│\n", ("Date: " + getDate()));
        System.out.printf("│%-50s│\n", ("Sum money: " + getSumMoney()));
        System.out.printf("│%-50s│\n", ("ID NV: " + getIDNhanVien()));
        System.out.printf("│%-50s│\n", ("ID NXB: " + getIDNXB()));
        dsChiTietPhieu.xuatDS();
        System.out.printf("└%-16s┴%-16s┴%-16s┘\n", Check.repeatStr("─", 16), Check.repeatStr("─", 16), Check.repeatStr("─", 16));

    }

    public String toString()
    {
        return super.toString() + "-" + IDNXB;
    }

    public String getIDNXB() {
        return IDNXB;
    }

    public void setIDNXB(String IDNXB) {
        this.IDNXB = IDNXB;
    }


}
