public class Tiga {
    public static void main(String[] args) {
        ArrayLipat3 array = new ArrayLipat3();
        array.inputArray();
        array.displayLipat();
        array.multiplyArray();
        array.displayLipat();
    }
}

class ArrayLipat3 {
    int[] arr = new int[10];
    
    public int[] inputArray() {
        for(int i = 0; i < 10; i++) {
            arr[i] = i;
        }
        return arr;
    }
    
    public int[] multiplyArray() {
        for(int i = 0; i < 10; i++) {
            arr[i] = arr[i] * arr[i] * arr[i];
        }
        return arr;
    }
    
    public void displayLipat() {
        System.out.print("Data : ");
        for(int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}