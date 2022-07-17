import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        KataPalindrom kata = new KataPalindrom();
        kata.inputPalindrom();
        kata.cekPalindrom();
    }
}

class KataPalindrom {
    private String kata, stringKataAsli, stringKataBalik;
    private boolean isPalindrome = false;
    private char[] kataAsli, kataBalik;

    public String inputPalindrom() {
        Scanner input = new Scanner(System.in);

        System.out.print("Kata yang akan dicek : ");
        kata = input.nextLine();

        input.close();

        return kata;
    }

    public void cekPalindrom() {
        kataAsli = kata.toCharArray();

        kataBalik = new char[kata.length()];

        for(int i = 0; i < kata.length(); i++) {
            kataBalik[i] = kataAsli[kata.length() - (i+1)];
        }
        
        stringKataAsli = new String(kataAsli);
        stringKataBalik = new String(kataBalik);

        if(stringKataAsli.equals(stringKataBalik)) {
            isPalindrome = true;
        }

        if(isPalindrome) {
            System.out.println("Kata \"" + kata + "\" adalah palindrom");
        }
        else {
            System.out.println("Kata \"" + kata + "\" bukan palindrom");
        }
    }
}
