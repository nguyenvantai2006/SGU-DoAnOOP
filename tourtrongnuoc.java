public class tourtrongnuoc extends tour {
    private String tinhthanh;
    private String dacsan;

    public tourtrongnuoc() {
    }

    public tourtrongnuoc(String matour, String tentour, int dongia, String thutuc, String diadiemKH,String diadiemden, String tinhthanh, String dacsan) {
        super(matour, tentour, dongia, thutuc, diadiemKH,diadiemden);
        this.tinhthanh = tinhthanh;
        this.dacsan = dacsan;
    }

    public tourtrongnuoc(tourtrongnuoc ttn) {
        super(ttn);
        this.tinhthanh = ttn.tinhthanh;
        this.dacsan = ttn.dacsan;
    }

    public String getTinhthanh() {
        return tinhthanh;
    }

    public String getDacsan() {
        return dacsan;
    }

    public void setTinhthanh(String tinhthanh) {
        this.tinhthanh = tinhthanh;
    }

    public void setDacsan(String dacsan) {
        this.dacsan = dacsan;
    }

    @Override
    public void nhap() {
        super.nhap();
        System.out.println("Nhap tinh thanh: ");
        tinhthanh = sc.nextLine();
        System.out.println("Nhap dac san: ");
        dacsan = sc.nextLine();
    }

    @Override
    public String getThongtinmorong() {
        return tinhthanh + " " + dacsan;
    }
}