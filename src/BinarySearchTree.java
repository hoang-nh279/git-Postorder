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
    // PHƯƠNG THỨC TÌM KIẾM (SEARCH)
    // =========================================================

    /**
     * Phương thức công khai để tìm kiếm một khóa trong BST.
     * @param key Khóa cần tìm.
     * @return true nếu tìm thấy khóa, false nếu ngược lại.
     */
    public boolean search(int key) {
        Node resultNode = searchRec(root, key);
        if (resultNode != null) {
            System.out.println("Tìm thấy " + key + " trong cây.");
            return true;
        } else {
            System.out.println("Không tìm thấy " + key + " trong cây.");
            return false;
        }
    }

    /**
     * Phương thức đệ quy để tìm kiếm một nút chứa khóa.
     * @param root Nút gốc hiện tại của cây con đang được xem xét.
     * @param key Khóa cần tìm.
     * @return Nút chứa khóa nếu tìm thấy, ngược lại trả về null.
     */
    private Node searchRec(Node root, int key) {
        // Trường hợp cơ bản 1: Cây rỗng hoặc đã đến cuối nhánh mà không tìm thấy
        if (root == null) {
            return null;
        }

        // Trường hợp cơ bản 2: Đã tìm thấy khóa
        if (root.key == key) {
            return root;
        }

        // Nếu khóa nhỏ hơn giá trị của nút hiện tại, tìm kiếm bên trái
        if (key < root.key) {
            System.out.println("  So sánh " + key + " với " + root.key + ". Đi sang trái.");
            return searchRec(root.left, key);
        }
        // Nếu khóa lớn hơn giá trị của nút hiện tại, tìm kiếm bên phải
        else {
            System.out.println("  So sánh " + key + " với " + root.key + ". Đi sang phải.");
            return searchRec(root.right, key);
        }
    }

    // Phương thức duyệt In-order để kiểm tra (tùy chọn)
    void inorder() {
        System.out.print("Duyệt In-order: ");
        inorderRec(root);
        System.out.println();
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Xây dựng cây như hình minh họa:
              27
             /  \
            14  35
           / \  / \
          10 19 31 42
        */
        System.out.println("--- Xây dựng cây ban đầu ---");
        tree.insert(27);
        tree.insert(14);
        tree.insert(35);
        tree.insert(10);
        tree.insert(19);
        tree.insert(31);
        tree.insert(42);

        tree.inorder(); // Duyệt In-order để kiểm tra cây ban đầu

        System.out.println("\n--- Tìm kiếm giá trị có trong cây (19) ---");
        tree.search(19);

        System.out.println("\n--- Tìm kiếm giá trị gốc (27) ---");
        tree.search(27);

        System.out.println("\n--- Tìm kiếm giá trị không có trong cây (50) ---");
        tree.search(50);

        System.out.println("\n--- Tìm kiếm giá trị không có trong cây (1) ---");
        tree.search(1);
    }
}