import java.util.Scanner;

class nhahang {
    private String manh;      
    private String tennh;
    private String diachi;
    private String sodt;
    private String makhtour;

    public nhahang() {
    }

    
    public nhahang(String manh, String tennh, String diachi, String sodt, String makhtour) {
        this.manh = manh;
        this.tennh = tennh;
        this.diachi = diachi;
        this.sodt = sodt;
        this.makhtour = makhtour;
    }

   
    public nhahang(nhahang nh) {
        this.manh = nh.manh;
        this.tennh = nh.tennh;
        this.diachi = nh.diachi;
        this.sodt = nh.sodt;
        this.makhtour = nh.makhtour;
    }

    
    public String getManh() {
        return manh;
    }

    public String getTennh() {
        return tennh;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getSodt() {
        return sodt;
    }

    public String getMakhtour() {
        return makhtour;
    }

  
    public void setManh(String manh) {
        this.manh = manh;
    }

    public void setTennh(String tennh) {
        this.tennh = tennh;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public void setMakhtour(String makhtour) {
        this.makhtour = makhtour;
    }

    Scanner sc = new Scanner(System.in);

    
    public void nhap() {
        String n="^NH[0-9]{3}$";
        while(true)
        {System.out.print("Nhap ma nha hang (co dinh dang NHXXX VD: NH001) :");
        manh = sc.nextLine();
        if(manh.matches(n)){break;}
        System.out.println("Loi ma nha hang khong dung dinh dang, vui long nhap lai.");
        }

        System.out.print("Nhap ten nha hang: ");
        tennh = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        diachi = sc.nextLine();

        String s="^0[0-9]{9}";
        while(true){
        System.out.println("Nhap so dien thoai: ");
        sodt = sc.nextLine();
        if(sodt.matches(s)){break;}
        System.out.println("Nhap sai dinh dang so dien thoai, vui long nhap lai");
        }

        String mt="^KHT[0-9]{3}$";
        while(true){
            System.out.println("Nhap ma ke hoach tour (co dinh dang KHTXXX, VD: KHT001)");
            makhtour=sc.nextLine();
            if(makhtour.matches(mt)){break;}
            System.out.println("Loi dinh dang, vui long nhap lai.");
        }
        }

    
    public void xuat() {
        System.out.printf("%-15s %-20s %-25s %-15s %-15s\n", manh, tennh, diachi, sodt, makhtour);
    }
    
}
