public class tournuocngoai extends tour {
    private String quocgia;
    private String ngoaite;

    public tournuocngoai() {
    }

    public tournuocngoai(String matour, String tentour, int dongia, String thutuc, String diadiemKH,String diadiemden, String quocgia, String ngoaite) {
        super(matour, tentour, dongia, thutuc, diadiemKH,diadiemden);
        this.quocgia = quocgia;
        this.ngoaite = ngoaite;
    }

    public tournuocngoai(tournuocngoai tnn) {
        super(tnn);
        this.quocgia = tnn.quocgia;
        this.ngoaite = tnn.ngoaite;
    }

    public String getQuocgia() {
        return quocgia;
    }

    public String getNgoaite() {
        return ngoaite;
    }

    public void setQuocgia(String quocgia) {
        this.quocgia = quocgia;
    }

    public void setNgoaite(String ngoaite) {
        this.ngoaite = ngoaite;
    }

    @Override
    public void nhap() {
        super.nhap();
        System.out.println("Nhap quoc gia: ");
        quocgia = sc.nextLine();
        System.out.println("Nhap ngoai te: ");
        ngoaite = sc.nextLine();
    }

    @Override
    public String getThongtinmorong() {
        return quocgia + " " + ngoaite;
    }
}