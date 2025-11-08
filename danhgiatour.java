import java.util.Scanner;

class danhgiatour {
    private String madg;       
    private String makhtour;   
    private String tenkh;      
    private int sao;            
    private String nhanxet;     

    public danhgiatour() {
    }

 
    public danhgiatour(String madg, kehoachtour makhtour, String tenkh, int sao, String nhanxet) {
        this.madg = madg;
        this.makhtour = getMakhtour();
        this.tenkh = tenkh;
        this.sao = sao;
        this.nhanxet = nhanxet;
    }

    public danhgiatour(String madg,String makhtour,String tenkh,int sao,String nhanxet){
        this.madg=madg;
        this.makhtour=makhtour;
        this.tenkh=tenkh;
        this.sao=sao;
        this.nhanxet=nhanxet;
    }
    public danhgiatour(danhgiatour dg) {
        this.madg = dg.madg;
        this.makhtour = dg.makhtour;
        this.tenkh = dg.tenkh;
        this.sao = dg.sao;
        this.nhanxet = dg.nhanxet;
    }

  
    public String getMadg() {
        return madg;
    }

    public String getMakhtour() {
        return makhtour;
    }

    public String getTenkh() {
        return tenkh;
    }

    public int getSao() {
        return sao;
    }

    public String getNhanxet() {
        return nhanxet;
    }

    public void setMadg(String madg) {
        this.madg = madg;
    }

    public void setMakhtour(String makhtour) {
        this.makhtour = makhtour;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public void setSao(int sao) {
        this.sao = sao;
    }

    public void setNhanxet(String nhanxet) {
        this.nhanxet = nhanxet;
    }

    Scanner sc = new Scanner(System.in);

 
    public void nhap() {
        String mdg="^DG[0-9]{3}";
        while(true)
        {System.out.print("Nhap ma danh gia: ");
        madg = sc.nextLine();
        if(madg.matches(mdg)){break;}
        System.out.println("Ma danh gia ko dung dinh dang, vui long nhap lai.");
        }
        System.out.print("Nhap ma ke hoach tour (khoa ngoai): ");
        makhtour = sc.nextLine();
        System.out.print("Nhap ten khach hang: ");
        tenkh = sc.nextLine();
        do {
            System.out.print("Nhap so sao (1–5): ");
            sao = Integer.parseInt(sc.nextLine());
        } while (sao < 1 || sao > 5);
        System.out.print("Nhap nhan xet: ");
        nhanxet = sc.nextLine();
    }

  
    public void xuat() {
        System.out.printf("%-10s %-12s %-20s %-6d %-30s\n",
                madg, makhtour, tenkh, sao, nhanxet);
    }
}
