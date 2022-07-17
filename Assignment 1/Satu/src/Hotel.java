class Kamar {
    public String nama;
    public int nomor;
    public boolean status = true;
    
    public Kamar(int nomor) {
        this.nomor = nomor;
    }
    
    public String pesanKamar(String nama) {
        this.status = false;
        return this.nama = nama;
    }

    public void kosongKamar() {
        this.status = true;
    }

    public void statusKamar() {
        if(status) {
            System.out.println("Kamar " + this.nomor + " : Kosong");
        }
        else {
            System.out.println("Kamar " + this.nomor + " : Terisi " + this.nama);
        }
    }
}

class Pesan {
    Kamar[] kamar = new Kamar[10];

    public Pesan() {
        for(int i = 0; i < kamar.length; i++) {
            kamar[i] = new Kamar(i+1);
        }
    }
    public Kamar getRoom(int i) {
        return kamar[i-1];
    }
    
}

public class Hotel {
    public static void main(String[] args) {
        Pesan hoho = new Pesan();
        hoho.getRoom(1).statusKamar();
        hoho.getRoom(1).pesanKamar("Joni");
        hoho.getRoom(1).statusKamar();
        hoho.getRoom(9).statusKamar();
        hoho.getRoom(9).pesanKamar("Parker");
        hoho.getRoom(9).statusKamar();
        hoho.getRoom(1).kosongKamar();
        hoho.getRoom(1).statusKamar();
    }
}