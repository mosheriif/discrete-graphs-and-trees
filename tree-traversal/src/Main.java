public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        if (tree.buildTree() != null){
            System.out.print("Preorder traversal:");
            tree.preOrderTraversal();
            System.out.print("\n");
            System.out.print("Inorder traversal:");
            tree.inOrderTraversal();
            System.out.print("\n");
            System.out.print("Postorder traversal:");
            tree.postOrderTraversal();
            System.out.print("\n");
        }
    }
}