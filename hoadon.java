
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
class hoadon {
    private String mahoadon;
    private String makh;
    private String makhtour;
    private LocalDate ngaylap;
    private int sove;
    private int tongtien;
    private Scanner sc = new Scanner(System.in);

    public hoadon(){}
    public hoadon(String mahoadon,String makh,String makhtour,LocalDate ngaylap,int sove,int tongtien){
        this.mahoadon=mahoadon;
        this.makh=makh;
        this.makhtour=makhtour;
        this.ngaylap=ngaylap;
        this.sove=sove;
        this.tongtien = tongtien;
    }
    public hoadon(hoadon hd) {
        this.mahoadon = hd.mahoadon;
        this.makh = hd.makh;
        this.makhtour = hd.makhtour;
        this.ngaylap = hd.ngaylap;
        this.tongtien = hd.tongtien;
        this.sove = hd.sove;
    }

    public String getMahd() {
        return mahoadon;
    }

    public String getMakh() {
        return makh;
    }

    public String getMakhtour() {
        return makhtour;
    }
    
    public LocalDate getNgaylap() {
        return ngaylap;
    }

    public int getTongtien() {
        return tongtien;
    }
    public int getSove(){
        return sove;
    }

    public void setMahd(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public void setMakhtour(String makhtour) {
        this.makhtour = makhtour;
    }

    public void setNgaylap(LocalDate ngaylap) {
        this.ngaylap = ngaylap;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public void setSove(int sove) {
        this.sove = sove;
    }


    public void nhap() {
        String hd="^HD[0-9]{3}$";
        while(true){
        System.out.println("Nhap ma hoa don: ");
        mahoadon = sc.nextLine();
        if(mahoadon.matches(hd)){break;}
        }
        String k="KH[0-9]{3}$";
        while (true)
        {System.out.println("Nhap ma khach hang (co dinh dang KHXXX) VD: KH001 :");
        makh = sc.nextLine();
        if(makh.matches(k)){break;}
        System.out.println("Sai dinh dang ma khach hang, vui long nhap lai.");
        }
        String mt="^KHT[0-9]{3}$";
        while(true){
            System.out.println("Nhap ma ke hoach tour (co dinh dang KHTXXX, VD: KHT001)");
            makhtour=sc.nextLine();
            if(makhtour.matches(mt)){break;}
            System.out.println("Loi dinh dang, vui long nhap lai.");
        }
        while(true)
        {System.out.println("Nhap ngay lap (dd/MM/yyyy): ");
        String dateInput = sc.nextLine();
        try {
            ngaylap=LocalDate.parse(dateInput,kehoachtour.df);
            break;
        }
        catch(DateTimeParseException e){    
            System.out.println("Loi dinh dang ngay khong dung "+e.getMessage());
            e.printStackTrace();
        }}
        sove = sc.nextInt();
        tongtien = sc.nextInt();
        sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-10s %-10s %-10s %-10s %-10d %-15d\n", mahoadon, makh, makhtour, ngaylap, sove, tongtien);
    }
    public int nhapsonguyen(String mess){
        while(true)
        {   try{
            System.out.println(mess);
            int num=Integer.parseInt(sc.nextLine());
            if(num<0){
                System.out.println("Loi nhap gia tri be hon 0, vui long nhap lai.");
                continue;
            }
            return num;}
            catch(NumberFormatException e){
                System.out.println("Loi nhap so");
            }
        }
    }
}