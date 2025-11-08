import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

class khachhang {
    private String makh;
    private String ho;
    private String ten;
    private LocalDate ngaysinh;
    private String gioitinh;
    private String diachi;
    private String sdt;
    private Scanner sc = new Scanner(System.in);
    public khachhang() {
    }

    public khachhang(String makh, String ho, String ten, LocalDate ngaysinh, String gioitinh, String diachi, String sdt) {
        this.makh = makh;
        this.ho = ho;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.sdt = sdt;
    }

    public khachhang(khachhang k) {
        this.makh = k.makh;
        this.ho = k.ho;
        this.ten = k.ten;
        this.ngaysinh = k.ngaysinh;
        this.gioitinh = k.gioitinh;
        this.diachi = k.diachi;
        this.sdt = k.sdt;
    }

    public String getMakh() {
        return makh;
    }

    public String getHo() {
        return ho;
    }

    public String getTen() {
        return ten;
    }

    public LocalDate getNgaysinh() {
        return ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setNgaysinh(LocalDate ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void nhap() {
        String k="KH[0-9]{3}$";
        while (true)
        {System.out.println("Nhap ma khach hang (co dinh dang KHXXX) VD: KH001 :");
        makh = sc.nextLine();
        if(makh.matches(k)){break;}
        System.out.println("Sai dinh dang ma khach hang, vui long nhap lai.");
        }
        System.out.println("Nhap ho: ");
        ho = sc.nextLine();
        System.out.println("Nhap ten: ");
        ten = sc.nextLine();
        
        while(true) {
            System.out.println("Nhap ngay sinh (dd/MM/yyyy): ");
            try {
                ngaysinh = LocalDate.parse(sc.nextLine(), kehoachtour.df);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Loi dinh dang ngay. Vui long nhap lai.");
            }
        }
        
        System.out.println("Nhap gioi tinh: ");
        gioitinh = sc.nextLine();
        System.out.println("Nhap dia chi: ");
        diachi = sc.nextLine();
        String s="^0[0-9]{9}";
        while(true){
        System.out.println("Nhap so dien thoai: ");
        sdt = sc.nextLine();
        if(sdt.matches(s)){break;}
        System.out.println("Nhap sai dinh dang so dien thoai, vui long nhap lai");
        }
    }

    public void xuat() {
        System.out.printf("%-10s %-10s %-10s %-15s %-10s %-15s %-20s\n",
                makh, 
                ho, 
                ten, 
                ngaysinh.format(kehoachtour.df), 
                gioitinh, 
                sdt,
                diachi);
    }
}