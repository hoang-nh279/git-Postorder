public class Node {
    int key; // Giá trị của nút
    Node left, right; // Con trỏ tới nút con trái và phải

    public Node(int item) {
        key = item;
        left = right = null;
    }
}
