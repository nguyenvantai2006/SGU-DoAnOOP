
import java.util.Scanner;
interface ITour {
    void nhap();
    void xuat();
}

abstract class tour implements ITour {
    private String matour;
    private String tentour;
    private int dongia;
    private String thutuc;
    private String diadiemKH;
    private String diadiemden;
    public static Scanner sc = new Scanner(System.in);

    public tour() {
    }

    public tour(String matour, String tentour, int dongia, String thutuc, String diadiemKH,String diadiemden) {
        this.matour = matour;
        this.tentour = tentour;
        this.dongia = dongia;
        this.thutuc = thutuc;
        this.diadiemKH = diadiemKH;
        this.diadiemden=diadiemden;
    }

    public tour(tour t) {
        this.matour = t.matour;
        this.tentour = t.tentour;
        this.dongia = t.dongia;
        this.thutuc = t.thutuc;
        this.diadiemKH = t.diadiemKH;
        this.diadiemden=t.diadiemden;
    }

    public String getMatour() {
        return matour;
    }

    public String getTentour() {
        return tentour;
    }

    public int getDongia() {
        return dongia;
    }

    public String getThutuc() {
        return thutuc;
    }

    public String getDiadiemKH() {
        return diadiemKH;
    }
    public String getDiadiemden(){
        return diadiemden;
    }
    public void setMatour(String matour) {
        this.matour = matour;
    }

    public void setTentour(String tentour) {
        this.tentour = tentour;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public void setThutuc(String thutuc) {
        this.thutuc = thutuc;
    }

    public void setDiadiemKH(String diadiemKH) {
        this.diadiemKH = diadiemKH;
    }
    public void setDiadiemden(String diadiemden){
        this.diadiemden=diadiemden;
    }
    public static int nhapsonguyen(String mess){
        while(true){
            try{
                System.out.println(mess);
                String input =sc.nextLine();
                int num=Integer.parseInt(input);
                if(num<0){
                    System.out.println("Loi nhap gia tri nho hon 0, vui long nhap lai");
                    continue;
                }
                return num;
            }
            catch(NumberFormatException e){
                System.out.println("Nhap sai dinh dang so nguyen");
            }
        }
    }
    
    public abstract String getThongtinmorong();

    public void nhap() {
        final String t="^T[0-9]{3}$";
        while(true){
            System.out.println("Nhap ma tour (co dinh dang TXXX, VD: T000)");
            matour=sc.nextLine();
            if(matour.matches(t)){break;}
            System.out.println("Loi dinh dang, vui long nhap lai.");
        }
        System.out.println("Nhap ten tour: ");
        tentour = sc.nextLine();
        dongia=nhapsonguyen("Nhap don gia: ");
        System.out.println("Nhap thu tuc: ");
        thutuc = sc.nextLine();
        System.out.println("Nhap dia diem KH: ");
        diadiemKH = sc.nextLine();
        System.out.println("Nhap dia diem den ");
        diadiemden=sc.nextLine();
    }

    public void xuat() {
        System.out.printf("%-10s %-10s %-10s %-15s %-10s %-10s",
                matour, tentour, dongia, thutuc, diadiemKH,diadiemden);
        System.out.printf("%-15s %-15s\n",getThongtinmorong());
    }
}

