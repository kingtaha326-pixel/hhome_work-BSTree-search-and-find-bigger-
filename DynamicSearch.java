package bstdemo;

// كلاس العقدة (Node)
class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

// كلاس شجرة البحث الثنائية (BST)
class BST {
    Node root;

    public BST() {
        root = null;
    }

    // دالة الإضافة (Insert)
    void insertNode(int d) {
        root = insertHelper(root, d);
    }

    private Node insertHelper(Node root, int d) {
        if (root == null) return new Node(d);
        if (d < root.data) 
            root.left = insertHelper(root.left, d);
        else if (d > root.data) 
            root.right = insertHelper(root.right, d);
        return root;
    }

    // دالة إيجاد أصغر عنصر (Find Min)
    int findMin(Node root) {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        Node n;
        for (n = root; n.left != null; n = n.left);
        return n.data;
    }

    // 1. دالة البحث عن عنصر (Search)
    public boolean search(int key) {
        return searchHelper(root, key);
    }

    private boolean searchHelper(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (key < root.data) {
            return searchHelper(root.left, key);
        } else {
            return searchHelper(root.right, key);
        }
    }

    // 2. دالة إيجاد أكبر عنصر (Find Max)
    int findMax(Node root) {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        Node n;
        for (n = root; n.right != null; n = n.right);
        return n.data;
    }

    // الطبع بترتيب تصاعدي (In-Order)
    void inOrder() {
        inOrderHelper(root);
    }

    private void inOrderHelper(Node root) {
        if (root == null) return;
        inOrderHelper(root.left);
        System.out.println(root.data);
        inOrderHelper(root.right);
    }
}

// الكلاس الرئيسي لتشغيل البرنامج (Main)
public class BSTdemo {
    public static void main(String[] args) {
        BST bst = new BST();
        
        // إضافة العناصر للشجرة
        bst.insertNode(20);
        bst.insertNode(15);
        bst.insertNode(25);
        bst.insertNode(12);
        bst.insertNode(18);
        bst.insertNode(30);
        
        System.out.println("--- عناصر الشجرة بترتيب In-Order ---");
        bst.inOrder();
        
        // تجربة دالة البحث (Search)
        System.out.println("\nIs 18 in the tree? " + bst.search(18)); // ستطبع true
        System.out.println("Is 99 in the tree? " + bst.search(99)); // ستطبع false
        
        // تجربة دالة أكبر عنصر (Find Max)
        System.out.println("Maximum value: " + bst.findMax(bst.root)); // ستطبع 30
        
        // تجربة دالة أصغر عنصر (Find Min)
        System.out.println("Minimum value: " + bst.findMin(bst.root)); // ستطبع 12
    }
}
