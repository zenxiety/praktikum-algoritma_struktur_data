public class Parkir {
    public static void main(String[] args) {
        Mobil nissan = new Mobil("Nissan", 2);
        Mobil toyota = new Mobil("Toyota", 3);
        Mobil honda = new Mobil("Honda", 10);
        nissan.status();
        toyota.status();
        honda.status();
    }
}

class Mobil {
    private String model;
    private int waktu, tarif;

    public Mobil(String model, int waktu) {
        this.model = model;
        this.waktu = waktu;
    }

    public void status() {
        this.tarif = 2000 * waktu;

        System.out.println("Model : " + model);
        System.out.println("Waktu : " + waktu + " jam");
        System.out.println("Tarif : Rp" + tarif);
        System.out.println();
    }
}
