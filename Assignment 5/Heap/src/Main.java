public class Main {
    public static void main(String[] args) throws Exception {
        int[] key = {78, 3, 9, 10, 23, 77, 34, 86, 90, 100, 20, 66, 94, 63, 97};

        Heap heap = new Heap(15);

        for(int i = 0; i < key.length; i++) {
            heap.insert(key[i]);
        }

        heap.heapSort();
    }
}

class Node {
    private int data;

    public Node(int d) {
        this.data = d;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int d) {
        this.data = d;
    }
}

class Heap {
    private Node[] array;
    private int maxSize, currentSize;

    public Heap(int max) {
        maxSize = max;
        currentSize = 0;
        array = new Node[maxSize + 1];
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public boolean hasLeftChild(int i) {
        return 2 * i <= currentSize;
    }

    public boolean hasRightChild(int i) {
        return 2 * i + 1 <= currentSize;
    }

    public boolean insert(int data) {
        if(isFull()) {
            return false;
        }

        array[++currentSize] = new Node(data);
        trickleUp(currentSize);
        
        return true;
    }

    public void trickleUp(int i) {
        int parent = i / 2;
        Node bottom = array[i];

        while(i > 1 && array[parent].getData() < bottom.getData()) {
            array[i] = array[parent];
            i = parent;
            parent = i / 2;
        }

        array[i] = bottom;
    }

    public Node remove() {
        Node root = array[1];
        array[1] = array[currentSize--];
        trickleDown(1);
        
        return root;
    }

    public void trickleDown(int i) {
        Node  top = array[i];
        int largerChild;
    
        while (hasLeftChild(i)) {
            int leftChild = 2 * i;
            int rightChild = leftChild + 1;
    
            if (hasRightChild(i) && array[rightChild].getData() > array[leftChild].getData()) {
                largerChild = rightChild;
            }
            else {
                largerChild = leftChild;
            }
    
            if (top.getData() >= array[largerChild].getData()) {
                break;
            }
    
            array[i] = array[largerChild];
            i = largerChild;
        }
    
        array[i] = top;
    }

    public void heapSort() {
        Node[] sorted = new Node[maxSize + 1];
        for(int i = currentSize; i >= 1; i--) {
            Node max = remove();
            sorted[currentSize + 1] = max;
        }
        
        displayHeap();
    }
    
    public void displayHeap() {
        System.out.println();

        System.out.println("Sorted Heap Tree (Ascending): ");
        for(int i = 1; i <= maxSize; i++) {
            System.out.print(array[i].getData() + " ");
        }    

        System.out.println("\n");
        
        System.out.println("Sorted Heap Tree (Descending): ");
        for(int i = maxSize; i >= 1; i--) {
            System.out.print(array[i].getData() + " ");
        }    

        System.out.println("\n");
    }
}

