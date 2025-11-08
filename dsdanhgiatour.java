import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
public class dsdanhgiatour {
    private danhgiatour[] ds;
    private int N;
    Scanner sc = new Scanner(System.in);

    public dsdanhgiatour() {
        N = 0;
        ds = new danhgiatour[0];
    }

    public dsdanhgiatour(dsdanhgiatour dsdg) {
        this.ds = dsdg.ds;
        this.N = dsdg.N;
    }

    public danhgiatour[] getDs() {
        return ds;
    }

    public int getN() {
        return N;
    }

    public void setDs(danhgiatour[] ds) {
        this.ds = ds;
    }

    public void setN(int N) {
        this.N = N;
    }

    public void nhapDsDG() {
        System.out.print("Nhap so luong danh gia: ");
        N = Integer.parseInt(sc.nextLine());
        ds = new danhgiatour[N];
        for (int i = 0; i < N; i++) {
            System.out.println("\nNhap danh gia thu " + (i + 1) + ": ");
            ds[i] = new danhgiatour();
            ds[i].nhap();
        }
        N = ds.length;
    }


    public void xuatDsDG() {
        System.out.printf("%-10s %-12s %-20s %-6s %-30s\n",
                "MaDG", "MaKHTour", "TenKH", "Sao", "NhanXet");
        for (int i = 0; i < N; i++) {
            ds[i].xuat();
        }
    }


    public int timTheoMa(String madg) {
        for (int i = 0; i < N; i++) {
            if (ds[i].getMadg().equalsIgnoreCase(madg)) {
                return i;
            }
        }
        return -1;
    }

    public danhgiatour timDG(String madg) {
        int vt = timTheoMa(madg);
        if (vt == -1) return null;
        return ds[vt];
    }

public void timTheoMaKHTour(String makhtour) {
    boolean found = false;
    System.out.printf("%-10s %-12s %-20s %-6s %-30s\n",
            "MaDG", "MaKHTour", "TenKH", "Sao", "NhanXet");

    for (int i = 0; i < N; i++) {
        if (ds[i].getMakhtour().equalsIgnoreCase(makhtour)) {
            ds[i].xuat();
            found = true;
        }
    }

    if (!found) {
        System.out.println(" Khong co danh gia nao thuoc ma ke hoach tour: " + makhtour);
    }
}



    public void themDGCoTs(danhgiatour dg) {
        ds = Arrays.copyOf(ds, N + 1);
        ds[N] = new danhgiatour(dg); // dùng constructor sao chép để an toàn
        N++;
        System.out.println(" Da them danh gia (tham so) thanh cong!");
    }

    public void xoaDGCoTs(String madg) {
        int idx = timTheoMa(madg);
        if (idx == -1) {
            System.out.println(" Khong tim thay danh gia co ma: " + madg);
            return;
        }
        for (int i = idx; i < N - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, N - 1);
        N--;
        System.out.println(" Da xoa danh gia co ma: " + madg);
    }


public void thongKeTheoMaKHTour() {
    if (N == 0) {
        System.out.println(" Danh sach danh gia rong!");
        return;
    }

    System.out.print("Nhap ma ke hoach tour can thong ke: ");
    String makhtour = sc.nextLine();

    int count = 0;
    int tongSao = 0;

    for (int i = 0; i < N; i++) {
        if (ds[i].getMakhtour().equalsIgnoreCase(makhtour)) {
            count++;
            tongSao += ds[i].getSao();
        }
    }

    if (count == 0) {
        System.out.println(" Khong co danh gia nao thuoc ma ke hoach tour: " + makhtour);
    } else {
        double tbSao = (double) tongSao / count;
        System.out.println(" Ma ke hoach tour '" + makhtour + "' co tong " + count + " danh gia.");
        System.out.printf(" Trung binh so sao: %.2f\n", tbSao);
    }
}


    public void suaDG() {
        System.out.print("Nhap ma danh gia can sua: ");
        String madg = sc.nextLine();
        int idx = timTheoMa(madg);
        if (idx == -1) {
            System.out.println(" Khong tim thay danh gia co ma: " + madg);
            return;
        }

        danhgiatour dg = ds[idx];
        int chon;
        do {
            System.out.println("\n===== SUA THONG TIN DANH GIA TOUR =====");
            System.out.println("1. Sua ten khach hang");
            System.out.println("2. Sua so sao");
            System.out.println("3. Sua nhan xet");
            System.out.println("4. Sua ma ke hoach tour (khoa ngoai)");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Nhap ten khach hang moi: ");
                    dg.setTenkh(sc.nextLine());
                    break;
                case 2:
                    int s;
                    do {
                        System.out.print("Nhap so sao moi (1-5): ");
                        s = Integer.parseInt(sc.nextLine());
                    } while (s < 1 || s > 5);
                    dg.setSao(s);
                    break;
                case 3:
                    System.out.print("Nhap nhan xet moi: ");
                    dg.setNhanxet(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Nhap ma ke hoach tour moi: ");
                    dg.setMakhtour(sc.nextLine());
                    break;
                case 0:
                    System.out.println(" Thoat sua thong tin.");
                    break;
                default:
                    System.out.println(" Lua chon khong hop le!");
            }
        } while (chon != 0);

        ds[idx] = dg;
        System.out.println(" Da cap nhat danh gia co ma: " + madg);
    }

    public void suaDG(String madg) {
        int idx = timTheoMa(madg);
        if (idx == -1) {
            System.out.println(" Khong tim thay danh gia co ma: " + madg);
            return;
        }

        danhgiatour dg = ds[idx];
        int chon;
        do {
            System.out.println("\n===== SUA THONG TIN DANH GIA TOUR =====");
            System.out.println("1. Sua ten khach hang");
            System.out.println("2. Sua so sao");
            System.out.println("3. Sua nhan xet");
            System.out.println("4. Sua ma ke hoach tour (khoa ngoai)");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    System.out.print("Nhap ten khach hang moi: ");
                    dg.setTenkh(sc.nextLine());
                    break;
                case 2:
                    int s;
                    do {
                        System.out.print("Nhap so sao moi (1-5): ");
                        s = Integer.parseInt(sc.nextLine());
                    } while (s < 1 || s > 5);
                    dg.setSao(s);
                    break;
                case 3:
                    System.out.print("Nhap nhan xet moi: ");
                    dg.setNhanxet(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Nhap ma ke hoach tour moi: ");
                    dg.setMakhtour(sc.nextLine());
                    break;
                case 0:
                    System.out.println(" Thoat sua thong tin.");
                    break;
                default:
                    System.out.println(" Lua chon khong hop le!");
            }
        } while (chon != 0);

        ds[idx] = dg;
        System.out.println(" Da cap nhat danh gia co ma: " + madg);
    }

    public void docFile(String file){
        try {
            BufferedReader br=new BufferedReader(new FileReader(file));
            int n=0;
            ds=new danhgiatour[100];
            String line="";
            while((line=br.readLine())!=null){
                String[] part=line.split("\\|");

                if(part.length>=5){
                    String madg=part[0];
                    String makhtour=part[1];
                    String tenkh=part[2];
                    int sao=Integer.parseInt(part[3]);
                    String nhanxet=part[4];

                    ds[n++]=new danhgiatour(madg,makhtour,tenkh,sao,nhanxet);
                }
            }
            br.close();
                N=n;
                ds=Arrays.copyOf(ds,N);
                System.out.println("Da doc "+N+" danh gia tour tu file "+file);
        }
        catch(Exception e){
            System.out.println("Loi doc file "+e.getMessage());
            e.printStackTrace();
        }
    }
    public void ghiFile(String file){
        try{
            BufferedWriter bw=new BufferedWriter(new FileWriter(file));
            for(int i=0;i<N;i++){
                danhgiatour d=ds[i];
                String line="";
                line=String.join("|",
                d.getMadg(),
                d.getMakhtour(),
                d.getTenkh(),
                String.valueOf(d.getSao()),
                d.getTenkh());
                bw.write(line);
                bw.newLine();
            }
        bw.close();
        System.out.println("Da ghi "+N+"vao file "+file);
        }
        catch(Exception e){
            System.out.println("Loi ghi file "+e.getMessage());
            e.printStackTrace();
        }
    }
}