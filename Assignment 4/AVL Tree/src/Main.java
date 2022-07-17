public class Main {
    public static void main(String[] args) {
        AVL tree = new AVL();

        tree.setRoot(tree.insert(tree.getRoot(), 9));
        tree.setRoot(tree.insert(tree.getRoot(), 5));
        tree.setRoot(tree.insert(tree.getRoot(), 10));
        tree.setRoot(tree.insert(tree.getRoot(), 0));
        tree.setRoot(tree.insert(tree.getRoot(), 6));
        tree.setRoot(tree.insert(tree.getRoot(), 11));
        tree.setRoot(tree.insert(tree.getRoot(), -1));
        tree.setRoot(tree.insert(tree.getRoot(), 1));
        tree.setRoot(tree.insert(tree.getRoot(), 2));

        System.out.println("Preorder transversal of constructed tree: ");

        tree.preOrder(tree.getRoot());

        tree.setRoot(tree.deleteNode(tree.getRoot(), 10));

        System.out.println("Preorder transversal after deletion of 10: ");

        tree.preOrder(tree.getRoot());
    }
}

class Node {
    private int data, height;
    private Node left, right;

    public Node(int data) {
        this.data = data;
        height = 1;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

    public int getData() {
        return this.data;
    }

    public int getHeight() {
        return this.height;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(Node node) {
        this.left = node;
    }

    public void setRight(Node node) {
        this.right = node;
    }

    public void setHeight(int n) {
        this.height = n;
    }
} 

class AVL {
    private Node root;

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node node) {
        this.root = node;
    }
    
    public int getHeight(Node node) {
        if(node == null) {
            return 0;
        }

        return node.getHeight();
    }
    
    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public Node rightRotate(Node y) {
        Node x = y.getLeft();
        Node T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.setHeight(max(y.getLeft().getHeight(), y.getRight().getHeight()) + 1);
        x.setHeight(max(x.getLeft().getHeight(), x.getRight().getHeight()) + 1);

        return x;
    }

    public Node leftRotate(Node x) {
        Node y = x.getRight();
        Node T2 = y.getLeft();

        y.setRight(x);
        x.setLeft(T2);

        x.setHeight(max(x.getLeft().getHeight(), x.getRight().getHeight()) + 1);
        y.setHeight(max(y.getLeft().getHeight(), y.getRight().getHeight()) + 1);

        return y;
    }

    public int getBalance(Node node) {
        if(node == null) {
            return 0;
        }

        return node.getLeft().getHeight() - node.getRight().getHeight();
    }

    public Node insert(Node node, int data) {
        if(node == null) {
            return(new Node(data));
        }
        if(data < node.getData()) {
            node.setLeft(insert(node.getLeft(), data));
        }
        else if(data > node.getData()) {
            node.setRight(insert(node.getRight(), data));
        }
        else {
            return node;
        }

        node.setHeight(1 + max(node.getLeft().getHeight(), node.getRight().getHeight()));

        int balance = getBalance(node);

        if(balance > 1 && data < node.getRight().getData()) {
            return rightRotate(node);
        }
        if(balance < -1 && data > node.getLeft().getData()) {
            return leftRotate(node);
        }
        if(balance > -1 && data > node.getLeft().getData()) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        return node;
    }

    public Node minValueNode(Node node) {
        Node current = node;

        while(current.getLeft() == null) {
            current = current.getLeft();
        }

        return current;
    }
    public Node deleteNode(Node root, int data) {
        if(root == null) {
            return root;
        }

        if(data < root.getData()) {
            root.setLeft(deleteNode(root.getLeft(), data));
        }
        else if(data > root.getData()) {
            root.setRight(deleteNode(root.getRight(), data));
        }
        else {
            if(root.getLeft() == null || root.getRight() == null) {
                Node temp = null;

                if(temp == root.getLeft()) {
                    temp = root.getRight();
                }
                else {
                    temp = root.getRight();
                }

                if(temp == null) {
                    temp = root;
                    root = null;
                }
                else {
                    root = temp;
                }
            }
            else {
                Node temp = minValueNode(root.getRight());
                root.setData(temp.getData());
                root.setRight(deleteNode(root.getRight(), temp.getData()));
            }
        }
        if(root == null) {
            return root;
        }

        root.setHeight(max(root.getLeft().getHeight(), getHeight(root.getRight()) + 1));

        int balance = getBalance(root);

        if(balance > 1 && getBalance(root.getLeft()) >= 0) {
            return rightRotate(root);
        }
        if(balance > 1 && getBalance(root.getLeft()) < 0) {
            return rightRotate(root);
        }
        if(balance < -1 && getBalance(root.getRight()) <= 0) {
            return leftRotate(root);
        }
        if(balance < -1 && getBalance(root.getRight()) > 0) {
            root.setRight(rightRotate(root.getRight()));
            return leftRotate(root);
        }

        return root;
    }

    public void preOrder(Node node) {
        if(node != null) {
            System.out.println(node.getData() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }
}