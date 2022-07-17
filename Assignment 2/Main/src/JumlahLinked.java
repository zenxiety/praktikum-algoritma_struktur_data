import java.util.LinkedList;
import java.util.Scanner;

public class JumlahLinked {
    public static void main(String[] args) {
        List list = new List();
        list.inputList();
        list.jumlahLinked();
    }
}

class List {
    private LinkedList<Double> list;
    private int banyakData;
    private double data, jumlah;
    
    public LinkedList<Double> inputList() {
        list = new LinkedList<Double>();
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Banyak data : ");
        banyakData = input.nextInt();

        System.out.println("Linked list dengan " + banyakData + " data");
        
        for(int i = 0; i < banyakData; i++) {
            System.out.print("Data ke-" + i + " : ");
            data = input.nextDouble();
            list.add(data);
        }
        
        input.close();

        return list;
    }
    
    public void jumlahLinked() {
        jumlah = 0;

        for(int i = 0; i < banyakData; i++) {
            jumlah += list.get(i);
        }

        System.out.println("Jumlah : " + jumlah);
    }
}