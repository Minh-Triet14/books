package QuanLyCuaHangBanSach;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;


public class Check {
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_YELLOW = "\u001B[33m";

    //Dùng lặp lại chuỗi str với n lần
    public static String repeatStr(String str, int n) {
        return String.join("", Collections.nCopies(n, str));
    }

    //Nhận input là kiểu int
    public static int takeIntegerInput(String nhapGi) {
        Scanner sc = new Scanner(System.in);
        while (true) { 
            System.out.print(nhapGi);
            try {
                int input = Integer.parseInt(sc.nextLine());
                if (input < 0) {
                    Check.printError("Khong duoc nhap so < 0 !");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                Check.printError("Ban chi duoc phep nhap so !");
            }
        }
    }

    //Nhận input là kiểu float
    public static float takeFloatInput(String nhapGi) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print(nhapGi);
            try {
                float input = Float.parseFloat(sc.nextLine());
                if (input < 0) {
                    Check.printError("Khong duoc nhap so < 0 !");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                Check.printError("Ban chi duoc phep nhap so !");
            }
        }
    }

    //Nhận input là kiểu string
    public static String takeStringInput(String nhapGi) {
        Scanner sc = new Scanner(System.in);
        while (true) { 
            System.out.print(nhapGi);
            try {
                String input = sc.nextLine();
                if (input.isEmpty()) {
                    Check.printError("Ban chua nhap gi het !");
                } else if (input.length() > 20) {
                    Check.printError("Vui long nhap khong qua chieu dai !");
                } else {
                    return input;
                }
            } catch (NoSuchElementException e) {
                Check.printError("Bạn chua co nhap gi het !");
            }
        }
    }

    public static String KiemTraCapHoc(String nhapGi) {
        Scanner sc = new Scanner(System.in);
        while (true) { 
            System.out.print(nhapGi);
            try {
                String input = sc.nextLine();
                if (input.isEmpty()) {
                    Check.printError("Ban chua nhap gi het !");
                } else if (input.length() > 14) {
                    Check.printError("Vui long nhap khong qua chieu dai !");
                } else if ("Tieu hoc".equalsIgnoreCase(input) || "THCS ".equalsIgnoreCase(input) || "THPT".equalsIgnoreCase(input))  {
                    return input;
                } else {
                    Check.printError("Ban nhap khong dung cap hoc");
                }
            } catch (NoSuchElementException e) {
                Check.printError("Ban chua co nhap gi het !");
            } 
        }
    }

    // Hàm kiểm tra chuỗi chỉ chứa chữ (không chứa số)
    public static boolean isAlphabetOnly(String input) {
        // Regex: ^[a-zA-Z\s]+$ cho phép chữ cái và khoảng trắng
        return input.matches("^[a-zA-Z\\s]+$");
    }

    // Hàm tiện ích để nhập chuỗi hợp lệ từ người dùng
    public static String getAlphabetOnlyInput(String nhapGI) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(nhapGI);
            String input = sc.nextLine().trim(); // Loại bỏ khoảng trắng thừa ở đầu/cuối
            if (isAlphabetOnly(input)) {
                return input; // Dữ liệu hợp lệ, trả về chuỗi
            } else {
                Check.printError("Ban chi duoc phep nhap chu, khong duoc nhap so !");
            }
        }
    }

    //Nhận lựa chọn với khoảng từ min tới max
    public static int takeInputChoice(int min, int max) {
        int choice;
        Scanner sc = new Scanner(System.in);
        int attempts = 0;
        while (true) { 
            if(attempts == 0) {
                System.out.print("Nhap lua chon: ");
            } else if(attempts < 2) {
                System.out.print("Vui long nhap lai: ");
            } else {
                System.out.print("Vui long nhin lai lua chon roi nhap: ");
            }
            try {
                choice = sc.nextInt();
                if(choice >= min && choice <= max) {
                    return choice;
                }
                Check.printError("Lua chon cua ban khong dung !");
            } catch (InputMismatchException e) {
                Check.printError("Ban chi duoc phep nhap so !");
                sc.nextLine();
            }
            attempts++;
        }
    }

    //Nhập id tác giả dựa trên danh sách tác giả
    public static String NhapMaTacGia(DanhSachTacGia danhsachtacgia) {
        boolean check;
        String matg;
        danhsachtacgia.xuatDS();
        do { 
            check = false;
            matg = Check.takeStringInput("Nhap ma tac gia: ");
            if(danhsachtacgia.timkiemIDTacGia(matg) == -1) {
                Check.printError("Khong co ma tac gia !");
                check = true;
            }
        } while (check);
        return matg;
    }

    //Nhập id nhà xuất bản dựa trên danh sách nhà xuất bản
    public static String NhapMaNhaXuatBan(DanhSachNhaXuatBan danhsachnhaxuatban) {
        boolean check;
        String manxb;
        danhsachnhaxuatban.xuatDS();
        do { 
            check = false;
            manxb = Check.takeStringInput("Nhap ma nha xuat ban: ");
            if(danhsachnhaxuatban.TimKiemIDNXB(manxb) == null) {
                Check.printError("Khong co ma nha xuat ban !");
                check = true;
            }
        } while (check);
        return manxb; 
    } 

    //Nhập id sách dựa trên danh sách sách
    public static String NhapMaSach(DanhSachSach danhsachsach) {
        String masach;
        danhsachsach.xuatDS();
        do { 
            masach = Check.takeStringInput("Nhap ma sach: ");
            if(danhsachsach.TimKiemMaSach(masach) == -1) {
                Check.printError("Khong co ma sach !");
            } else {
                return masach;
            }
        } while (true);
    }

    public static String takePhoneNumberInput(String nhapGi)
    {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print(nhapGi);
            try{
                String input = sc.nextLine();
                // int check = Integer.parseInt(input);
                if(input.isEmpty())
                    Check.printError("Ban chua co nhap gi het !");
                else if(input.length() > 14)
                    Check.printError("Chieu dai chuoi vuot qua 14 !");
                else
                    return input;
            }catch (NoSuchElementException  e){
                Check.printError("Ban chua co nhap gi het !");
            }catch (NumberFormatException e) {
                Check.printError("Dien thoai chi chap nhan so !");
            }
        }
    }

   public static boolean checkDate(String date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    try {
        LocalDate.parse(date, formatter); // Kiểm tra xem chuỗi có thể chuyển thành LocalDate hay không
        return true; // Hợp lệ
    } catch (DateTimeParseException e) {
        return false; // Không hợp lệ
    }
}

    public static String takeDateInput(String nhapGi)
    {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print(nhapGi);
            try{
                String input = sc.nextLine();
                if(input.isEmpty())
                    Check.printError("Ban chua co nhap gi het !");
                else if(input.length() > 14)
                    Check.printError("Chieu dai chuoi vuot qua 14 !");
                else if(!checkDate(input))
                    Check.printError("Ngay khong dung dinh dang !");
                else
                    return input;
            }catch (NoSuchElementException  e){
                Check.printError("Ban chua co nhap gi het !");
            }
        }
    }

     public static boolean kiemTraKhoangThoiGian(String from, String between, String to)
    {
        Date dateFrom;
        Date dateTo;
        Date dateBetween;
        try {
            dateFrom = new SimpleDateFormat("dd/MM/yyyy").parse(from);
            dateTo = new SimpleDateFormat("dd/MM/yyyy").parse(to);
            dateBetween = new SimpleDateFormat("dd/MM/yyyy").parse(between);
        } catch (ParseException e) {return false;}

        return dateBetween.after(dateFrom) && dateBetween.before(dateTo);
    }

    public static boolean subStrInStrIgnoreCase(String str, String subStr)
    {
        return str.toLowerCase(Locale.ROOT).contains(subStr.toLowerCase(Locale.ROOT));
    }

    public static String getDateNow() {
        LocalDate date = LocalDate.now();
        return date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear();
    }

    //Dùng để clear console
    public static void ClearConsole() {
        Check.printMessage("Nhap bat ki de tiep tuc");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.printf("%-5s", Check.repeatStr("\n", 5));
    }

    //Hiển thị tin nhắn với text màu xanh
    public static void printMessage(String message)
    {
        System.out.printf("%30s " + TEXT_GREEN + " *** %s *** " + TEXT_RESET + " %30s%n", Check.repeatStr(" ", 30), message, Check.repeatStr(" ", 30));
    }

    //Hiển thị lỗi với text màu đỏ
    public static void printError(String message)
    {
        System.out.printf("%30s " + TEXT_RED + " *** %s *** " + TEXT_RESET + " %30s%n", Check.repeatStr(" ", 30), message, Check.repeatStr(" ", 30));
    }

    //Hiển thị text màu xanh
    public static String toBlueText(String text) {
        return TEXT_BLUE + text + TEXT_RESET;
    }

    //Hiển thị text màu xanh lá
    public static String toGreenText(String text) {
        return TEXT_GREEN + text + TEXT_RESET;
    }

    //Hiển thị text màu vàng
    public static String toYellowText(String text)
    {
        return TEXT_YELLOW + text + TEXT_RESET;
    }


       //Load file tham số obj là obj là cần load. Trả về null nếu lỗi và obj nếu đúng
       public static Object load(Object obj, String filename)
       {
           try
           {
               ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
               obj = ois.readObject();
           } catch (IOException | ClassNotFoundException | NullPointerException | NoClassDefFoundError IOE){
               printError("Load " + filename +  " thất bại => tạo dữ liệu mặc định");
               return null;
           }
           printMessage("Load " + filename +  " thành công");
           return obj;
       }
   
       //Save file tham số obj là obj cần save
       public static void save(Object obj, String filename)
       {
           try{
               ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
               oos.writeObject(obj);
               Check.printMessage("Save "  + filename + " thành công");
           } catch (IOException e) {
               e.printStackTrace();
               Check.printError("Save " + filename +  " thất bại");
           }
       }
}
