public class BinarySearchTree {
    Node root; // Nút gốc của cây

    // Constructor
    BinarySearchTree() {
        root = null;
    }
    // Phương thức thêm một giá trị vào BST
    void insert(int key) {
        root = insertRec(root, key);
    }

    // Phương thức đệ quy để thêm một nút
    Node insertRec(Node root, int key) {
        // Nếu cây rỗng, tạo nút mới
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Ngược lại, duyệt xuống cây
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        // Trả về con trỏ nút (không đổi)
        return root;
    }

    // Phương thức duyệt Post-order công khai
    void postorder() {
        System.out.print("Duyệt Post-order: ");
        postorderRec(root);
        System.out.println();
    }

    // Phương thức đệ quy để duyệt Post-order
    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);  // 1. Duyệt cây con trái
            postorderRec(root.right); // 2. Duyệt cây con phải
            System.out.print(root.key + " "); // 3. Thăm nút gốc
        }
    }

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

        // Thực hiện duyệt Post-order
        tree.postorder(); // Expected Output: 10 19 14 31 42 35 27
    }
}
