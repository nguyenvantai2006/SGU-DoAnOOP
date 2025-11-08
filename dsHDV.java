import java.util.Arrays;
import java.util.Scanner;
import java.time.LocalDate;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.format.DateTimeParseException;

class dsHDV {
    private hdv[] ds;
    private int N;
    Scanner sc = new Scanner(System.in);

   
    public dsHDV() {
        ds = new hdv[100];
        N = 0;
    }

    public dsHDV(hdv[] ds, int n) {
        this.ds = ds;
        this.N = n;
    }

    public dsHDV(dsHDV dshdv) {
        this.ds = dshdv.ds;
        this.N = dshdv.N;
    }

  
    public hdv[] getDs() {
        return ds;
    }

    public int getN() {
        return N;
    }

    public void setDs(hdv[] ds) {
        this.ds = ds;
    }

    public void setN(int n) {
        this.N = n;
    }

   
    public void nhapDshdv() {
        System.out.print("Nhap so luong HDV: ");
        N = Integer.parseInt(sc.nextLine());
        ds = new hdv[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Nhap thong tin HDV thu " + (i + 1) + ": ");
            ds[i] = new hdv();
            ds[i].nhap();
        }
    }

    public void xuatDshdv() {
        System.out.printf("%-10s %-10s %-10s %-10s %-15s %-10s %-15s %-20s%n",
                "MaHDV", "MaTour", "Ho", "Ten", "NgaySinh", "GioiTinh", "SoDT", "DiaChi");
        for (int i = 0; i < N; i++) {
            ds[i].xuat();
        }
    }
  
    public void themCots(hdv h) {
        ds = Arrays.copyOf(ds, N + 1);
        ds[N] = h;
        N++;
        System.out.println(" Da them HDV moi!");
    }

    public void themHDVCoTs(hdv h) {
        themCots(h);
    }

    public hdv timHDV(String mahdv) {
        return timCots(mahdv);
    }
   
    public int timTheoMa(String maHDV) {
        for (int i = 0; i < N; i++) {
            if (ds[i].getMahdv().equals(maHDV)) {
                return i;
            }
        }
        return -1;
    }

    public hdv timCots(String maHDV) {
        int idx = timTheoMa(maHDV);
        if (idx != -1) return ds[idx];
        return null;
    }

    
    public void timTheoTen(String ten) {
        boolean found = false;
        System.out.printf("%-10s %-10s %-10s %-10s %-15s %-10s %-15s %-20s%n",
                "MaHDV", "MaTour", "Ho", "Ten", "NgaySinh", "GioiTinh", "SoDT", "DiaChi");
        for (int i = 0; i < N; i++) {
            if (ds[i].getTen().equalsIgnoreCase(ten)) {
                ds[i].xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println(" Khong tim thay HDV co ten: " + ten);
        }
    }


    public void xoaHDVCoTs(String mahdv) {
        int idx = timTheoMa(mahdv);
        if (idx == -1) {
            System.out.println(" Khong tim thay HDV co ma: " + mahdv);
            return;
        }

        for (int i = idx; i < N - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, N - 1);
        N--;
        System.out.println(" Da xoa HDV co ma: " + mahdv);
    }


  
    public void thongKeTheoMaTour() {
        if (N == 0) {
            System.out.println(" Danh sach HDV rong!");
            return;
        }

        System.out.print("Nhap ma ke hoach tour can thong ke: ");
        String makht = sc.nextLine();

        int count = 0;
        System.out.println("\n=== DANH SACH HDV THUOC TOUR: " + makht + " ===");
        System.out.printf("%-10s %-10s %-10s %-10s %-15s %-10s %-15s %-20s%n",
                "MaHDV", "MaTour", "Ho", "Ten", "NgaySinh", "GioiTinh", "SoDT", "DiaChi");

        for (int i = 0; i < N; i++) {
            if (ds[i].getMakhtour().equalsIgnoreCase(makht)) {
                ds[i].xuat();
                count++;
            }
        }

        if (count == 0) {
            System.out.println(" Khong co HDV nao thuoc tour co ma: " + makht);
        } else {
            System.out.println(" Tong so HDV phu trach tour '" + makht + "': " + count);
        }
    }

  
    public void suaHDV() {
        System.out.print("Nhap ma HDV can sua: ");
        String maHDV = sc.nextLine();
        int idx = timTheoMa(maHDV);
        if (idx == -1) {
            System.out.println(" Khong tim thay HDV co ma: " + maHDV);
            return;
        }

        hdv h = ds[idx];
        int chon;
        do {
            System.out.println("\n===== MENU SUA THONG TIN HDV =====");
            System.out.println("1. Sua ma ke hoach tour");
            System.out.println("2. Sua ho ten");
            System.out.println("3. Sua ngay sinh");
            System.out.println("4. Sua so dien thoai");
            System.out.println("5. Sua gioi tinh");
            System.out.println("6. Sua dia chi");
            System.out.println("0. Thoat sua");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Nhap ma ke hoach tour moi: ");
                    h.setMakhtour(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Nhap ho moi: ");
                    h.setHo(sc.nextLine());
                    System.out.print("Nhap ten moi: ");
                    h.setTen(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Nhap ngay sinh moi (dd/MM/yyyy): ");
                    try {
                        h.setNgaysinh(LocalDate.parse(sc.nextLine(), kehoachtour.df));
                    } catch (DateTimeParseException e) {
                        System.out.println("Sai dinh dang ngay!");
                    }
                    break;
                case 4:
                    System.out.print("Nhap so dien thoai moi: ");
                    h.setSdt(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Nhap gioi tinh moi: ");
                    h.setGioitinh(sc.nextLine());
                    break;
                case 6:
                    System.out.print("Nhap dia chi moi: ");
                    h.setDiachi(sc.nextLine());
                    break;
                case 0:
                    System.out.println(" Thoat sua thong tin.");
                    break;
                default:
                    System.out.println(" Lua chon khong hop le!");
            }
        } while (chon != 0);

        ds[idx] = h;
        System.out.println(" Da cap nhat thong tin HDV co ma: " + maHDV);
    }

    public void suaHDV(String maHDV) {
        int idx = timTheoMa(maHDV);
        if (idx == -1) {
            System.out.println(" Khong tim thay HDV co ma: " + maHDV);
            return;
        }

        hdv h = ds[idx];
        int chon;
        do {
            System.out.println("\n===== MENU SUA THONG TIN HDV =====");
            System.out.println("1. Sua ma ke hoach tour");
            System.out.println("2. Sua ho ten");
            System.out.println("3. Sua ngay sinh");
            System.out.println("4. Sua so dien thoai");
            System.out.println("5. Sua gioi tinh");
            System.out.println("6. Sua dia chi");
            System.out.println("0. Thoat sua");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Nhap ma ke hoach tour moi: ");
                    h.setMakhtour(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Nhap ho moi: ");
                    h.setHo(sc.nextLine());
                    System.out.print("Nhap ten moi: ");
                    h.setTen(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Nhap ngay sinh moi (dd/MM/yyyy): ");
                    try {
                        h.setNgaysinh(LocalDate.parse(sc.nextLine(), kehoachtour.df));
                    } catch (DateTimeParseException e) {
                        System.out.println("Sai dinh dang ngay!");
                    }
                    break;
                case 4:
                    System.out.print("Nhap so dien thoai moi: ");
                    h.setSdt(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Nhap gioi tinh moi: ");
                    h.setGioitinh(sc.nextLine());
                    break;
                case 6:
                    System.out.print("Nhap dia chi moi: ");
                    h.setDiachi(sc.nextLine());
                    break;
                case 0:
                    System.out.println(" Thoat sua thong tin.");
                    break;
                default:
                    System.out.println(" Lua chon khong hop le!");
            }
        } while (chon != 0);

        ds[idx] = h;
        System.out.println(" Da cap nhat thong tin HDV co ma: " + maHDV);
    }
    
    public void docFile(String file){
        try {
            BufferedReader br=new BufferedReader(new FileReader(file));

            int n=0;
            ds=new hdv[100];

            String line="";
            while((line=br.readLine())!=null){
                String[] part=line.split("\\|");

                if(part.length>=8){
                    String mahdv=part[0];
                    String makhtour=part[1];
                    String ho=part[2];
                    String ten=part[3];
                    LocalDate ngaysinh=LocalDate.parse(part[4], kehoachtour.df);
                    String gioitinh=part[5];
                    String diachi=part[6];
                    String sdt=part[7];
                    
                    ds[n++]=new hdv(mahdv, makhtour, ho, ten, ngaysinh, gioitinh, diachi, sdt);
                }
            
            }
            N=n;
            ds=Arrays.copyOf(ds,N);
            br.close();
            System.out.println("Da doc "+N+" huong dan vien tu file "+file);
        }
        catch(Exception e){
            System.out.println("Loi khong doc duoc file "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void ghiFile(String file){
        try {   
            BufferedWriter bw=new BufferedWriter(new FileWriter(file));
            for(int i=0;i<N;i++){
                hdv h=ds[i];
                String line="";
                line=String.join("|",
                h.getMahdv(),
                h.getMakhtour(),
                h.getHo(),
                h.getTen(),
                h.getNgaysinh().format(kehoachtour.df),
                h.getGioitinh(),
                h.getDiachi(),
                h.getSdt());
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            System.out.println("Da ghi "+N+" huong dan vien vao file "+file);
        }
        catch(Exception e){
            System.out.println("Loi ghi file "+e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void linkData(dskehoachtour DSKHT) {
        if (DSKHT == null) { return; }
        int count = 0;
        for (int i = 0; i < N; i++) {
            String makhtour_id = ds[i].getMakhtour();
            kehoachtour kht_obj = DSKHT.timKHT(makhtour_id);
            if (kht_obj != null) {
                ds[i].setKehoachtour(kht_obj);
                count++;
            }
        }
        System.out.println("Da lien ket xong: " + count + "/" + N + " HDV.");
    }
}