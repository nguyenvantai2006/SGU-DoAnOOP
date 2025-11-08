
import java.util.Scanner;
class hopdong{
    private String mahd;
    private String matour;
    private String makh;
    private String dieukhoan;
    public hopdong(){
    }
    public hopdong(khachhang kh,tour t,String mahd, String matour, String makh, String dieukhoan) {
        this.mahd = mahd;
        this.matour = t.getMatour();
        this.makh = kh.getMakh();
        this.dieukhoan = dieukhoan;
    }
    public hopdong(String mahd,String matour,String makh,String dieukhoan){
        this.mahd=mahd;
        this.matour=matour;
        this.makh=makh;
        this.dieukhoan=dieukhoan;
    }
    public hopdong(hopdong h){
        this.mahd = h.mahd;
        this.matour = h.matour;
        this.makh = h.makh;
        this.dieukhoan = h.dieukhoan;
    }
    public String getMahd() {
        return mahd;
    }
    public String getMatour() {
        return matour;
    }
    public String getMakh() {
        return makh;
    }
    public String getDieukhoan() {
        return dieukhoan;
    }
    public void setMahd(String mahd) {
        this.mahd = mahd;
    }
    public void setMatour(String matour) {
        this.matour = matour;
    }
    public void setMakh(String makh) {
        this.makh = makh;
    }
    public void setDieukhoan(String dieukhoan) {
        this.dieukhoan = dieukhoan;
    }
    Scanner sc = new Scanner(System.in);
    public void nhap(){
        String h="^HDONG[0-9]{3}$";
        while(true){
        System.out.println("Nhap ma hop dong (co dinh dang HDONGXXX VD: HDONG001 ): ");
        mahd = sc.nextLine();
        if(mahd.matches(h)){
            break;
        }
        System.out.println("Sai dinh dang ma hop dong, vui long nhap lai.");
        }
        String t="^T[0-9]{3}$";
        while(true)
        {System.out.println("Nhap ma tour (co dinh dang TXXX VD: T001) :");
        matour = sc.nextLine();
        if(matour.matches(t)){break;}
        System.out.println("Sai dinh dang ma tou, vui long nhap lai.");
        }
        String k="KH[0-9]{3}$";
        while (true)
        {System.out.println("Nhap ma khach hang (co dinh dang KHXXX) VD: KH001 :");
        makh = sc.nextLine();
        if(makh.matches(k)){break;}
        System.out.println("Sai dinh dang ma khach hang, vui long nhap lai.");
        }
        System.out.println("Nhap dieu khoan: ");
        dieukhoan = sc.nextLine();
    }
    public void xuat(){
        System.out.printf("%-15s %-15s %-15s %-15s\n", mahd, matour, makh, dieukhoan);
    }
}
