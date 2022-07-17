abstract class Makan {      // abstract
    private String makanan;

    public void setMakanan(String food) {   // encapsulation (setter)
        this.makanan = food;
    }
    
    public String getMakanan() {    // encapsulation (getter)
        return this.makanan;
    }

    public void eat() {
        System.out.println("Makan " + makanan);
    }

    public void eat(String otherfood) {         // polymorphism
        System.out.println("Makan " + makanan);
    }
}

class Karnivora extends Makan {    // inheritance
    public Karnivora() {
        setMakanan("daging");       // set encapsulated data value 
    }
    
    public void eat() {
        System.out.println("Makan " + getMakanan());    // get encapsulated data value
    }

}

class Herbivora extends Makan {    // inheritance
    public Herbivora() {
        setMakanan("tumbuhan");     // set encapsulated data value 
    }
    
    public void eat() {
        System.out.println("Makan " + getMakanan());    // get encapsulated data value
    }
}

class Omnivora extends Makan {    // inheritance
    public Omnivora() {
        setMakanan("daging dan tumbuhan");      // set encapsulated data value 
    }
    
    public void eat() {
        System.out.println("Makan " + getMakanan());    // get encapsulated data value
    }
}

public class Hewan {
    public static void main(String[] args) {
        Karnivora Karnivora1 = new Karnivora();
        Karnivora1.eat();

        Herbivora Herbivora1 = new Herbivora();
        Herbivora1.eat();

        Omnivora Omnivora1 = new Omnivora();
        Omnivora1.eat();
    }
}
