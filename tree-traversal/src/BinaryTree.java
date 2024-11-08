import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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
public class BinaryTree {
    private Node root;
    private final Scanner sc;

    public BinaryTree() {
        this.root = null;
        this.sc = new Scanner(System.in);
    }
    public Node buildTree() {
        Queue<Node> nodeQueue = new LinkedList<>();
        System.out.println("Enter the value of the root node:");
        int rootValue = sc.nextInt();
        if (rootValue != -1)
        {
            root = new Node(rootValue);
            nodeQueue.add(root);

            buildTreeRecursive(nodeQueue);
            return root;
        }
        else {
            System.out.println("No Tree");
            return null;
        }

    }

    private void buildTreeRecursive(Queue<Node> nodeQueue) {
        while (!nodeQueue.isEmpty()) {
            Node currentNode = nodeQueue.poll();

            System.out.println("Enter left child value of " + currentNode.data + " (or -1 to skip):");
            int leftValue = sc.nextInt();
            if (leftValue != -1) {
                currentNode.left = new Node(leftValue);
                nodeQueue.add(currentNode.left);
            }

            System.out.println("Enter right child value of " + currentNode.data + " (or -1 to skip):");
            int rightValue = sc.nextInt();
            if (rightValue != -1) {
                currentNode.right = new Node(rightValue);
                nodeQueue.add(currentNode.right);
            }
        }
    }
    public void preOrderTraversal() {
        preorder(root);
    }
    private void preorder(Node root){
        if (root != null)
        {
            System.out.print(" " + root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }
    public void inOrderTraversal() {
        inorder(root);
    }
    private void inorder(Node root){
        if (root != null)
        {
            inorder(root.left);
            System.out.print(" " + root.data);
            inorder(root.right);
        }
    }
    public void postOrderTraversal() {
        postorder(root);
    }
    private void postorder(Node root){
        if (root != null)
        {
            postorder(root.left);
            postorder(root.right);
            System.out.print(" " + root.data);
        }
    }

}