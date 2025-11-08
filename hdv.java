import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

class hdv {
    private String mahdv;
    private String makhtour;
    private String ho;
    private String ten;
    private LocalDate ngaysinh;
    private String gioitinh;
    private String diachi;
    private String sdt;
    
    private kehoachtour kht;
    private Scanner sc = new Scanner(System.in);

    public hdv(){
    }

    public hdv(String mahdv, String makhtour, String ho, String ten, LocalDate ngaysinh, String gioitinh, String diachi, String sdt) {
        this.mahdv = mahdv;
        this.makhtour = makhtour;
        this.ho = ho;
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.kht = null;
    }
    public hdv(hdv h) {
        this.mahdv = h.mahdv;
        this.makhtour = h.makhtour;
        this.ho = h.ho;
        this.ten = h.ten;
        this.ngaysinh = h.ngaysinh;
        this.gioitinh = h.gioitinh;
        this.diachi = h.diachi;
        this.sdt = h.sdt;
        this.kht = h.kht;
    }

    public String getMahdv() { return mahdv; }
    public String getMakhtour() { return makhtour; }
    public String getHo() { return ho; }
    public String getTen() { return ten; }
    public LocalDate getNgaysinh() { return ngaysinh; }
    public String getGioitinh() { return gioitinh; }
    public String getDiachi() { return diachi; }
    public String getSdt() { return sdt; }
    public kehoachtour getKehoachtour() { return kht; }


    public void setMahdv(String mahdv) { this.mahdv = mahdv; }
    public void setMakhtour(String makhtour) { this.makhtour = makhtour; }
    public void setHo(String ho) { this.ho = ho; }
    public void setTen(String ten) { this.ten = ten; }
    public void setNgaysinh(LocalDate ngaysinh) { this.ngaysinh = ngaysinh; }
    public void setGioitinh(String gioitinh) { this.gioitinh = gioitinh; }
    public void setDiachi(String diachi) { this.diachi = diachi; }
    public void setSdt(String sdt) { this.sdt = sdt; }
    public void setKehoachtour(kehoachtour kht) { this.kht = kht; }

    
    public void nhap() {
        String h="HDV[0-9]{3}";
        while(true)
        {System.out.println("Nhap ma huong dan vien: ");
        mahdv = sc.nextLine();
        if(mahdv.matches(h)){break;}
        System.out.println("Nhap sai dinh dang ma huong dan vien, vui long nhap lai.");
        }
        String mt="^KHT[0-9]$";
        while(true){
            System.out.println("Nhap ma ke hoach tour (co dinh dang KHTXXX, VD: KHT001)");
            makhtour=sc.nextLine();
            if(makhtour.matches(mt)){break;}
            System.out.println("Loi dinh dang, vui long nhap lai.");
        }

        System.out.print("Nhap ho: ");
        ho = sc.nextLine();
        System.out.print("Nhap ten: ");
        ten = sc.nextLine();
        
        while(true) {
            System.out.print("Nhap ngay sinh (dd/MM/yyyy): ");
            try {
                ngaysinh = LocalDate.parse(sc.nextLine(), kehoachtour.df);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Sai dinh dang ngay!");
            }
        }
        
        System.out.print("Nhap gioi tinh: ");
        gioitinh = sc.nextLine();
        System.out.print("Nhap dia chi: ");
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
        System.out.printf("%-10s %-10s %-10s %-10s %-15s %-10s %-15s %-20s%n",
                mahdv,
                makhtour,
                ho,
                ten,
                ngaysinh.format(kehoachtour.df),
                gioitinh,
                sdt,
                diachi);
    }
}
