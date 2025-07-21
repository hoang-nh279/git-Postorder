public class BinarySearchTree {
    Node root; // Nút gốc của cây

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // Phương thức thêm một giá trị vào BST (giữ nguyên)
    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    // =========================================================
    // PHƯƠNG THỨC DUYỆT PRE-ORDER
    // =========================================================

    // Phương thức duyệt Pre-order công khai
    void preorder() {
        System.out.print("Duyệt Pre-order: ");
        preorderRec(root);
        System.out.println();
    }

    // Phương thức đệ quy để duyệt Pre-order
    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " "); // 1. Thăm nút gốc
            preorderRec(root.left);           // 2. Duyệt cây con trái
            preorderRec(root.right);          // 3. Duyệt cây con phải
        }
    }

    // (Các phương thức khác như inorder, postorder, delete có thể được giữ lại nếu cần)

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /*
              27
             /  \
            14  35
           / \  / \
          10 19 31 42
        */

        // Thêm các phần tử theo thứ tự để xây dựng cây như hình minh họa
        tree.insert(27);
        tree.insert(14);
        tree.insert(35);
        tree.insert(10);
        tree.insert(19);
        tree.insert(31);
        tree.insert(42);

        // Thực hiện duyệt Pre-order
        tree.preorder(); // Expected Output: 27 14 10 19 35 31 42
    }
}