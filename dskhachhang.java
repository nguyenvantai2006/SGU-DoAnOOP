import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeParseException;

class dskhachhang {
    private khachhang[] ds;
    private int N;
    private Scanner sc = new Scanner(System.in);

    public dskhachhang() {
        N = 0;
        ds = new khachhang[0];
    }

    public dskhachhang(khachhang[] ds, int N) {
        this.ds = ds;
        this.N = N;
    }

    public dskhachhang(dskhachhang dskh) {
        this.ds = dskh.ds;
        this.N = dskh.N;
    }

    public khachhang[] getDs() {
        return ds;
    }

    public int getN() {
        return N;
    }

    public void setDs(khachhang[] ds) {
        this.ds = ds;
    }

    public void setN(int N) {
        this.N = N;
    }

    private int nhapSoNguyen(String message) {
        while (true) {
            System.out.println(message);
            String input = sc.nextLine();
            try {
                int num = Integer.parseInt(input);
                if (num < 0) {
                    System.out.println("Phai nhap gia tri lon hon 0, vui long nhap lai.");
                    continue;
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Dinh dang khong hop le, vui long nhap lai.");
            }
        }
    }
    
    private LocalDate nhapNgay(String message) {
         while (true) {
            System.out.println(message + " (dd/MM/yyyy): ");
            String input = sc.nextLine();
            try {
                return LocalDate.parse(input, kehoachtour.df);
            } catch (DateTimeParseException e) {
                System.out.println("Loi dinh dang ngay. Vui long nhap lai (vi du: 25/12/2023).");
            }
        }
    }

    public void nhapds() {
        N = nhapSoNguyen("Nhap so luong khach hang: ");
        ds = new khachhang[N];
        for (int i = 0; i < N; i++) {
            System.out.println("\nNhap khach hang thu " + (i + 1) + ": ");
            ds[i] = new khachhang();
            ds[i].nhap();
        }
    }

    public void xuatds() {
        System.out.printf("%-10s %-10s %-10s %-15s %-10s %-15s %-20s\n",
                "MaKH", "Ho", "Ten", "NgaySinh", "GioiTinh", "SDT", "DiaChi");
        for (int i = 0; i < N; i++) {
            ds[i].xuat();
        }
    }

    public int timTheoMa(String makh) {
        for (int i = 0; i < N; i++) {
            if (ds[i].getMakh().equalsIgnoreCase(makh)) {
                return i;
            }
        }
        return -1;
    }

    public khachhang timKH(String makh) { 
        int vt = timTheoMa(makh);
        if (vt == -1) {
            return null;
        }
        return ds[vt];
    }
    
    public khachhang timKhachHang(String makh) {
        return timKH(makh);
    }

    public void timKhachTheoTen(String ten) {
        boolean found = false;
        System.out.printf("%-10s %-10s %-10s %-15s %-10s %-15s %-20s\n",
                "MaKH", "Ho", "Ten", "NgaySinh", "GioiTinh", "SDT", "DiaChi");
        for (int i = 0; i < N; i++) {
            if (ds[i].getTen().equalsIgnoreCase(ten)) {
                ds[i].xuat();
                found = true;
            }
        }
        if (!found) {
            System.out.println(" Khong tim thay khach hang co ten: " + ten);
        }
    }

    public void themKhachHang(khachhang k) {
        ds = Arrays.copyOf(ds, N + 1);
        ds[N] = new khachhang(k);
        N++;
        System.out.println(" Da them khach hang thanh cong!");
    }

    public void xoaKhachHang(String makh) {
        int idx = timTheoMa(makh);
        if (idx == -1) {
            System.out.println(" Khong tim thay khach hang co ma: " + makh);
            return;
        }
        for (int i = idx; i < N - 1; i++) {
            ds[i] = ds[i + 1];
        }
        ds = Arrays.copyOf(ds, N - 1);
        N--;
        System.out.println(" Da xoa khach hang co ma: " + makh);
    }

    public void suaKhachHang() {
        System.out.print("Nhap ma khach hang can sua: ");
        String makh = sc.nextLine();
        int idx = timTheoMa(makh);
        if (idx == -1) {
            System.out.println(" Khong tim thay khach hang co ma: " + makh);
            return;
        }

        khachhang k = ds[idx];
        int chon;
        do {
            System.out.println("\n===== SUA THONG TIN KHACH HANG =====");
            System.out.println("1. Sua ho ten");
            System.out.println("2. Sua ngay sinh");
            System.out.println("3. Sua gioi tinh");
            System.out.println("4. Sua dia chi");
            System.out.println("5. Sua so dien thoai");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");
            chon = nhapSoNguyen("");

            switch (chon) {
                case 1:
                    System.out.print("Nhap ho moi: ");
                    k.setHo(sc.nextLine());
                    System.out.print("Nhap ten moi: ");
                    k.setTen(sc.nextLine());
                    break;
                case 2:
                    k.setNgaysinh(nhapNgay("Nhap ngay sinh moi"));
                    break;
                case 3:
                    System.out.print("Nhap gioi tinh moi: ");
                    k.setGioitinh(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Nhap dia chi moi: ");
                    k.setDiachi(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Nhap so dien thoai moi: ");
                    k.setSdt(sc.nextLine());
                    break;
                case 0:
                    System.out.println(" Thoat sua thong tin.");
                    break;
                default:
                    System.out.println(" Lua chon khong hop le!");
            }
        } while (chon != 0);

        ds[idx] = k;
        System.out.println(" Da cap nhat thong tin khach hang co ma: " + makh);
    }

    public void thongKeMaKH() {
        System.out.print("Nhap ma khach hang can thong ke (de trong de xem tat ca): ");
        String makh = sc.nextLine();
        if (makh.isEmpty()) {
            System.out.println("Tong so khach hang: " + N);
        } else {
            khachhang k = timKH(makh);
            if (k != null) {
                System.out.println("Thong tin khach hang:");
                k.xuat();
            } else {
                System.out.println("Khong tim thay ma " + makh);
            }
        }
    }

    public void docFile(String file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            int n = 0;
            ds = new khachhang[100]; 

            String line;
            while ((line = br.readLine()) != null) {
                String[] part = line.split("\\|");
                if (part.length >= 7) {
                    String makh = part[0].trim();
                    String ho = part[1].trim();
                    String ten = part[2].trim();
                    LocalDate ngaysinh = LocalDate.parse(part[3].trim(), kehoachtour.df);
                    String gioitinh = part[4].trim();
                    String diachi = part[5].trim();
                    String sdt = part[6].trim();

                    ds[n++] = new khachhang(makh, ho, ten, ngaysinh, gioitinh, diachi, sdt);
                }
            }
            br.close();
            N = n;
            ds = Arrays.copyOf(ds, N); 
            System.out.println("Da doc " + N + " khach hang tu file " + file);
        } catch (IOException | DateTimeParseException | NumberFormatException e) {
            System.out.println("Loi doc file dskhachhang.txt: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void ghiFile(String file) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < N; i++) {
                khachhang k = ds[i];
                String line = String.join("|",
                        k.getMakh(),
                        k.getHo(),
                        k.getTen(),
                        k.getNgaysinh().format(kehoachtour.df),
                        k.getGioitinh(),
                        k.getDiachi(),
                        k.getSdt());
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            System.out.println("Da ghi " + N + " khach hang vao file " + file);
        } catch (IOException e) {
            System.out.println("Loi ghi file dskhachhang.txt: " + e.getMessage());
            e.printStackTrace();
        }
    }




    //THỐNG KÊ LỚN 2 
    
  public void thongketisuathoadon2025(dshoadon dshd) {
    System.out.println("TI SUAT HOA DON THEO KHACH HANG NAM 2025:");
    System.out.printf("%-10s %-15s %-10s\n", "Khach Hang", "Tong tien", "Ti le(%)");

    if (dshd == null || dshd.getN() == 0) {
        System.out.println("Khong co du lieu hoa don.");
        return;
    }

    String[] makh = new String[100];  
    long[] tienkh = new long[100];     
    int sokh = 0;                    
    long tongtien = 0;

   
    for (int i = 0; i < dshd.getN(); i++) {
        hoadon hd = dshd.getDs()[i];
        if (hd == null) continue;
        if (hd.getNgaylap().getYear() == 2025) {
            String ma = hd.getMakh();
            long tien = hd.getTongtien();
            tongtien += tien;

           
            int vitri = -1;
            for (int j = 0; j < sokh; j++) {
                if (makh[j].equalsIgnoreCase(ma)) {
                    vitri = j;
                    break;
                }
            }

           
            if (vitri == -1) {
                makh[sokh] = ma;
                tienkh[sokh] = tien;
                sokh++;
            } else {
                tienkh[vitri] += tien; 
            }
        }
    }

    if (tongtien == 0) {
        System.out.println("Khong co hoa don nao trong nam 2025.");
        return;
    }

    for (int i = 0; i < sokh - 1; i++) {
        for (int j = i + 1; j < sokh; j++) {
            if (makh[i].compareToIgnoreCase(makh[j]) > 0) {
                String tamMa = makh[i];
                makh[i] = makh[j];
                makh[j] = tamMa;

                long tamTien = tienkh[i];
                tienkh[i] = tienkh[j];
                tienkh[j] = tamTien;
            }
        }
    }

    for (int i = 0; i < sokh; i++) {
        double tile = (tienkh[i] * 100.0) / tongtien;
        System.out.printf("%-10s %-15d %.2f%%\n", makh[i], tienkh[i], tile);
    }
}}