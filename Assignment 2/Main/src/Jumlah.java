import java.util.Scanner;

public class Jumlah {
    public static void main(String[] args) {
        ArrayJumlah array = new ArrayJumlah();
        array.inputArray();
        array.jumlahArray();
    }
}

class ArrayJumlah {
    private double[] arr;
    private double jumlah;
    private int banyakData;

    public double[] inputArray() {
        Scanner input = new Scanner(System.in);

        System.out.print("Banyak data : ");
        banyakData = input.nextInt();
        
        arr = new double[banyakData];

        System.out.println("Array dengan " + banyakData + " data");
        
        for(int i = 0; i < banyakData; i++) {
            System.out.print("Data ke-" + i + " : ");
            arr[i] = input.nextDouble();
        }
        
        input.close();

        return arr;
    }

    public void jumlahArray() {
        jumlah = 0;
    
        for(int i = 0; i < arr.length; i++) {
            jumlah += arr[i];
        }
        
        System.out.println("Jumlah : " + jumlah);
    }
}
