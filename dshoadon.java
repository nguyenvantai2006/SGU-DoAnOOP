import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
public class dshoadon {
    private hoadon[] ds;
    private int N;
    private Scanner sc = new Scanner(System.in);

    public dshoadon() {
        N = 0;
        ds = new hoadon[0];
    }

    public dshoadon(hoadon[] ds, int N) {
        this.ds = ds;
        this.N = N;
    }

    public dshoadon(dshoadon dshd) {
        this.ds = dshd.ds;
        this.N = dshd.N;
    }

    public void nhapDsHD() {
        System.out.print("Nhap so luong hoa don: ");
        N = Integer.parseInt(sc.nextLine());
        ds = new hoadon[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Nhap hoa don thu " + (i + 1) + ":");
            ds[i] = new hoadon();
            ds[i].nhap();
        }
        N = ds.length;
    }
    public int getN(){
        return N;
    }
    public hoadon[] getDs(){
        return ds;
    }
    public void xuatDsHD() {
        System.out.printf("%-10s %-10s %-12s %-10s %-10s %-10s\n", "MaHD", "MaKH", "MaKHTour","Ngaylap", "SoVe", "TongTien");
        for (int i = 0; i < N; i++) {
            ds[i].xuat();
        }
    }

    public int timTheoMa(String mahoadon) {
        for (int i = 0; i < N; i++) {
            if (ds[i].getMahd().equalsIgnoreCase(mahoadon)) {
                return i;
            }
        }
        return -1;
    }

    public hoadon timHD(String mahoadon) {
        int idx = timTheoMa(mahoadon);
        if (idx == -1) {
            return null;
        }
        return ds[idx];
    }

    public void timTheoMaKH(String makh) {
        boolean found = false;
        System.out.printf("%-10s %-10s %-12s %-10s\n", "MaHD", "MaKH", "MaKHTour", "TongTien");
        for (int i = 0; i < N; i++) {
            if (ds[i].getMakh().equalsIgnoreCase(makh)) {
                ds[i].xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println(" Khong co hoa don nao thuoc ve khach hang co ma: " + makh);
        }
    }

    public void themHDCoTs(hoadon h) {
        for(int i=0;i<N;i++){
            if(ds[i].getMahd().equalsIgnoreCase(h.getMahd())){
                System.out.println(" Ma hoa don da ton tai, khong the them!");
                return;
            }
        }
        ds = Arrays.copyOf(ds, N + 1);
        ds[N] = new hoadon(h);
        N++;
        System.out.println(" Da them hoa don (tham so) thanh cong!");

    }

    public void xoaHDCoTs(String mahoadon) {
        int idx = timTheoMa(mahoadon);
        if (idx == -1) {
            System.out.println(" Khong tim thay hoa don co ma: " + mahoadon);
            return;
        }
        for (int i = idx; i < N - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, N - 1);
        N--;
        System.out.println(" Da xoa hoa don co ma: " + mahoadon);
    }

    public void thongKeTheoMaKH() {
        System.out.print("Nhap ma khach hang can thong ke: ");
        String makh = sc.nextLine();
        int dem = 0;
        int tongTien = 0;

        for (int i = 0; i < N; i++) {
            if (ds[i].getMakh().equalsIgnoreCase(makh)) {
                dem++;
                tongTien += ds[i].getTongtien();
            }
        }

        if (dem == 0) {
            System.out.println(" Khong co hoa don nao thuoc ve khach hang co ma: " + makh);
        } else {
            System.out.println(" Khach hang co ma " + makh + " co " + dem + " hoa don.");
            System.out.println(" Tong tien cua khach hang nay: " + tongTien);
        }
    }

    public void suaHD(String mahoadon, dskehoachtour dskht) { 
        int idx = timTheoMa(mahoadon);
        if (idx == -1) {
            System.out.println(" Khong tim thay hoa don co ma: " + mahoadon);
            return;
        }

        hoadon h = ds[idx];
        int soVeCu = h.getSove(); 
        
        int chon;
        do {
            System.out.println("\n===== SUA THONG TIN HOA DON =====");
            System.out.println("1. Sua ma khach hang");
            System.out.println("2. Sua ma ke hoach tour");
            System.out.println("3. Sua so ve");
            System.out.println("4. Sua tong tien");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            
            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                chon = -1;
            }

            switch (chon) {
                case 1:
                    System.out.print("Nhap ma khach hang moi: ");
                    h.setMakh(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Nhap ma ke hoach tour moi: ");
                    h.setMakhtour(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Nhap so ve moi: ");
                    try {
                        int soVeMoi = Integer.parseInt(sc.nextLine());
                        if (soVeMoi < 0) {
                            System.out.println("So ve phai la so duong!");
                            break;
                        }
                        
                        kehoachtour kht = dskht.timKHT(h.getMakhtour());
                        if (kht == null) {
                            System.out.println("Loi: Ke hoach tour nay khong ton tai!");
                            break;
                        }
                        
                        int chenhLech = soVeMoi - soVeCu;
                        
                        if (chenhLech > kht.getSoveconlai()) {
                            System.out.println("Loi: Khong du ve. " + kht.getMakhtour() + " chi con " + kht.getSoveconlai() + " ve.");
                            System.out.println("Ban dang co gang them " + chenhLech + " ve (Tu " + soVeCu + " len " + soVeMoi + ").");
                        } else {
                            h.setSove(soVeMoi);
                            System.out.println("Da cap nhat so ve.");
                        }
                        
                    } catch (NumberFormatException e) {
                        System.out.println("Vui long nhap so!");
                    }
                    break;
                case 4:
                    System.out.print("Nhap tong tien moi: ");
                    try {
                        h.setTongtien(Integer.parseInt(sc.nextLine()));
                    } catch (NumberFormatException e) {
                        System.out.println("Vui long nhap so!");
                    }
                    break;
                case 0:
                    System.out.println(" Thoat sua thong tin.");
                    break;
                default:
                    System.out.println(" Lua chon khong hop le!");
            }
        } while (chon != 0);

        ds[idx] = h;
        System.out.println(" Da cap nhat thong tin hoa don co ma: " + mahoadon);
    }


    public void docFile(String file){
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            int n=0;
            ds=new hoadon[100];
            String line="";
            while((line=br.readLine())!=null){

                String[] part=line.split("\\|");
                if(part.length>=6){
                    String mahoadon=part[0].trim();
                    String makh=part[1].trim();
                    String makhtour=part[2].trim();
                    LocalDate ngaylap=LocalDate.parse(part[3],kehoachtour.df);
                    int sove=Integer.parseInt(part[4].trim());
                    int tongtien=Integer.parseInt(part[5].trim());

                    ds[n++]=new hoadon(mahoadon, makh, makhtour,ngaylap, sove, tongtien);
                }
            }
            br.close();
            N=n;
            ds=Arrays.copyOf(ds,N);
            System.out.println("Da doc "+N+" hoa don tu file "+file);
        }catch(Exception e){
            System.out.println("Loi doc file "+e.getMessage());
            e.printStackTrace();
        }
    }
    public void ghiFile(String file){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for(int i=0;i<N;i++){
                hoadon h=ds[i];
                String line="";

                line=String.join("|",
                h.getMahd(),
                h.getMakh(),
                h.getMakhtour(),
                String.valueOf(h.getNgaylap().format(kehoachtour.df)),
                String.valueOf(h.getSove()),
                String.valueOf(h.getTongtien()));
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            System.out.println("Da ghi "+N+" hoa don vao file");
        }
        catch(Exception e){
            System.out.println("Loi ghi file "+e.getMessage());
            e.printStackTrace();
        }
    }
    
}
