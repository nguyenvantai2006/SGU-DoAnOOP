import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class dstour {
    private tour[] ds;
    private int N;
    private Scanner sc = new Scanner(System.in);

    public dstour() {
        N = 0;
        ds = new tour[0];
    }

    public void nhapDstour() {
        System.out.print("Nhap so luong tour: ");
        N = Integer.parseInt(sc.nextLine());
        ds = new tour[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Nhap tour thu " + (i + 1) + ": ");
            System.out.println("Chon loai tour: 1 - Trong nuoc, 2 - Nuoc ngoai");
            int loai = Integer.parseInt(sc.nextLine());
            if (loai == 1) {
                ds[i] = new tourtrongnuoc();
            } else {
                ds[i] = new tournuocngoai();
            }
            ds[i].nhap();
        }
    }

    public void xuatDstour() {
    System.out.printf("%-10s %-20s %-10s %-15s %-15s %-15s %-15s %-15s\n", 
            "MaTour", "TenTour", "DonGia", "ThuTuc", "DiaDiemKH", "DiaDiemDen", "Tinh/QGia", "DacSan/NgoaiTe");
            
    for (int i = 0; i < N; i++) {
        ds[i].xuat();
    }
}

    public int timTheoMa(String matour) {
        for (int i = 0; i < N; i++) {
            if (ds[i].getMatour().equalsIgnoreCase(matour)) {
                return i;
            }
        }
        return -1;
    }

    public void timTheoMaTour(String matour) {
        int idx = timTheoMa(matour);
        if (idx == -1) {
            System.out.println(" Khong tim thay tour co ma: " + matour);
            return;
        }
        System.out.println("=== TIM THAY TOUR ===");
        ds[idx].xuat();
    }

    public tour timTour(String matour) {
        int idx = timTheoMa(matour);
        if (idx == -1) {
            return null;
        }
        return ds[idx];
    }

    public void timTheoTenTour(String tentour) {
        boolean found = false;
        System.out.println("===== DANH SACH TOUR CO TEN: " + tentour + " =====");
        for (int i = 0; i < N; i++) {
            if (ds[i].getTentour().equalsIgnoreCase(tentour)) {
                ds[i].xuat();
                System.out.println("---------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println(" Khong tim thay tour nao co ten: " + tentour);
        }
    }

    public void themTourCoTs(tour t) {
    if (timTheoMa(t.getMatour()) != -1) {
        System.out.println("Ma tour da ton tai!");     //Kiểm tra trùng mã
        return;
    }
    ds = Arrays.copyOf(ds, N + 1);
    ds[N] = t;
    N++;
    System.out.println("Da them tour thanh cong!");
}

    public void xoaTourCoTs(String matour) {
        int idx = timTheoMa(matour);
        if (idx == -1) {
            System.out.println(" Khong tim thay tour co ma: " + matour);
            return;
        }
        for (int i = idx; i < N - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, N - 1);
        N--;
        System.out.println(" Da xoa tour co ma: " + matour);
    }

    public void thongKeTheoLoaiTour() {
        int demTrongNuoc = 0, demNuocNgoai = 0;

        for (int i = 0; i < N; i++) {
            if (ds[i] instanceof tourtrongnuoc) {
                demTrongNuoc++;
            } else if (ds[i] instanceof tournuocngoai) {
                demNuocNgoai++;
            }
        }

        System.out.println("\n===== THONG KE THEO LOAI TOUR =====");
        System.out.println(" Tour trong nuoc: " + demTrongNuoc);
        System.out.println(" Tour nuoc ngoai: " + demNuocNgoai);
        System.out.println(" Tong cong: " + N);
    }

    
    public void suaTour(String matour) {
        int idx = timTheoMa(matour);
        if (idx == -1) {
            System.out.println(" Khong tim thay tour co ma: " + matour);
            return;
        }

        tour t = ds[idx];
        int chon;
        do {
            System.out.println("\n===== SUA THONG TIN TOUR =====");
            System.out.println("1. Sua ten tour");
            System.out.println("2. Sua don gia");
            System.out.println("3. Sua thu tuc va dia diem KH");
            if (t instanceof tourtrongnuoc) {
                System.out.println("4. Sua tinh thanh & dac san");
            }
            if (t instanceof tournuocngoai) {
                System.out.println("4. Sua quoc gia & ngoai te");
            }
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());

        switch (chon) {
                case 1:
                    System.out.print("Nhap ten tour moi: ");
                    t.setTentour(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Nhap don gia moi: ");
                    t.setDongia(Integer.parseInt(sc.nextLine()));
                    break;
                case 3:
                    System.out.print("Nhap thu tuc moi: ");
                    t.setThutuc(sc.nextLine());
                    System.out.print("Nhap dia diem KH moi: ");
                    t.setDiadiemKH(sc.nextLine());
                    break;
                case 4:
                    if (t instanceof tourtrongnuoc) {
                        tourtrongnuoc tn = (tourtrongnuoc) t;
                        System.out.print("Nhap tinh thanh moi: ");
                        tn.setTinhthanh(sc.nextLine());
                        System.out.print("Nhap dac san moi: ");
                        tn.setDacsan(sc.nextLine());
                    } else if (t instanceof tournuocngoai) {
                        tournuocngoai tq = (tournuocngoai) t;
                        System.out.print("Nhap quoc gia moi: ");
                        tq.setQuocgia(sc.nextLine());
                        System.out.print("Nhap ngoai te moi: ");
                        tq.setNgoaite(sc.nextLine());
                    }
                    break;
                case 0:
                    System.out.println(" Thoat sua thong tin tour.");
                    break;
                default:
                    System.out.println(" Lua chon khong hop le!");
            }
        } while (chon != 0);

        ds[idx] = t;
        System.out.println(" Da cap nhat tour co ma: " + matour);
    }
    public void docFile(String file) {
    try {
        FileInputStream fis = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        
        int n = 0;
        ds = new tour[100]; 
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\|");

            if (parts.length >= 9) {
                String loai = parts[0].trim();
                String ma = parts[1].trim();
                String ten = parts[2].trim();
                int gia = Integer.parseInt(parts[3].trim());
                String thutuc = parts[4].trim();
                String diadiem = parts[5].trim();
                String diadiemden =parts[6].trim();
                String qg_or_tt = parts[7].trim();
                String ds_or_nt = parts[8].trim();

                if (loai.equalsIgnoreCase("TN")) {
                    ds[n++] = new tourtrongnuoc(ma, ten, gia, thutuc, diadiem,diadiemden, qg_or_tt, ds_or_nt);
                } else if (loai.equalsIgnoreCase("NN")) {
                    ds[n++] = new tournuocngoai(ma, ten, gia, thutuc, diadiem,diadiemden, qg_or_tt, ds_or_nt);
                }
            }
        }

        N = n;
        ds = Arrays.copyOf(ds, N); 
        br.close();

        System.out.println("Da doc " + N + " tour tu file "+file);
    } catch (Exception e) {
        System.out.println("Loi khong doc duoc file: " + e.getMessage());
        e.printStackTrace();
    }
}
    public void ghiFile(String file) {
    try {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));

        for (int i = 0; i < N; i++) {
            tour t = ds[i];
            String line = "";

            if (t instanceof tourtrongnuoc) {
                tourtrongnuoc tn = (tourtrongnuoc) t;
                line = String.join("|",
                        "TN",
                        tn.getMatour(),
                        tn.getTentour(),
                        String.valueOf(tn.getDongia()),
                        tn.getThutuc(),
                        tn.getDiadiemKH(),
                        tn.getDiadiemden(),
                        tn.getTinhthanh(),
                        tn.getDacsan()
                );
            } else if (t instanceof tournuocngoai) {
                tournuocngoai nn = (tournuocngoai) t;
                line = String.join("|",
                        "NN",
                        nn.getMatour(),
                        nn.getTentour(),
                        String.valueOf(nn.getDongia()),
                        nn.getThutuc(),
                        nn.getDiadiemKH(),
                        nn.getDiadiemden(),
                        nn.getQuocgia(),
                        nn.getNgoaite()
                );
            }

            bw.write(line);
            bw.newLine();
        }

        bw.close();
        System.out.println("Da ghi "+N+" tour vao file "+file);
    } catch (Exception e) {
        System.out.println("Loi ghi file: " + e.getMessage());
        e.printStackTrace();
    }
}

}