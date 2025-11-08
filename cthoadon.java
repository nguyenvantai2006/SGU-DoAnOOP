import java.util.Scanner;
class cthoadon{
    private String mahd;
    private String makh;
    private String makhtour;
    public cthoadon(){
    }
    
    public cthoadon(hoadon h,khachhang kh,kehoachtour kht,String mahd, String makh, String makhtour) {
        this.mahd = h.getMahd();
        this.makh = kh.getMakh();
        this.makhtour = kht.getMakhtour();
    }

    public cthoadon(String mahd,String makh,String makhtour){
        this.mahd=mahd;
        this.makh=makh;
        this.makhtour=makhtour;
    }

    public cthoadon(cthoadon ct){
        this.mahd = ct.mahd;
        this.makh = ct.makh;
        this.makhtour = ct.makhtour;
    }
    public String getMahd() {
        return mahd;
    }
    public String getMakh() {
        return makh;
    }
    public String getMakhtour() {
        return makhtour;
    }
    public void setMahd(String mahd) {
        this.mahd = mahd;
    }
    public void setMakh(String makh) {
        this.makh = makh;
    }
    public void setMakhtour(String makhtour) {
        this.makhtour = makhtour;
    }
    Scanner sc = new Scanner(System.in);
    public void nhap(){
        String hd="^HD[0-9]{3}$";
        while(true){
        System.out.println("Nhap ma hoa don: ");
        mahd = sc.nextLine();
        if(mahd.matches(hd)){break;}
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
    }
    public void xuat(){
        System.out.printf("%-15s %-15s %-15s\n",mahd,makh,makhtour);
    }
}