import java.util.Scanner;

public class Balik {
    public static void main(String[] args) {
        Kata kata = new Kata();
        kata.inputKata();
        kata.balikKata();
    }
}

class Kata {
    private String kata;
    private char[] kataArray, balik;

    public char[] inputKata() {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Kata yang akan dibalik\t: ");
        kata = input.nextLine();
        
        balik = new char[kata.length()];
        
        input.close();

        return balik;
    }
    
    public char[] balikKata() {
        kataArray = kata.toCharArray();
        
        for(int i = 0; i < kata.length(); i++) {
            balik[i] = kataArray[kata.length() - (i+1)];
        }

        displayBalik();
        
        return balik;
    }
    
    public void displayBalik() {
        System.out.print("Kata terbalik\t\t: ");
        for(int i = 0; i < kata.length(); i++) {
            System.out.print(balik[i]);
        }
        System.out.println();
    }
}