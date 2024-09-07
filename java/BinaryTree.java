import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;
  }
}

public class BinaryTree {
  public static String serialize(TreeNode root) {
    if (root == null) {
      return "null";
    }

    String serializedString = root.val + ",";
    serializedString += serialize(root.left) + ",";
    serializedString += serialize(root.right);

    return serializedString;
  }

  public static TreeNode deserialize(String data) {
    Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
    return deserializeHelper(queue);
  }

  private static TreeNode deserializeHelper(Queue<String> queue) {
    String val = queue.poll();

    if (val.equals("null")) {
      return null;
    }

    TreeNode node = new TreeNode(Integer.parseInt(val));
    node.left = deserializeHelper(queue);
    node.right = deserializeHelper(queue);

    return node;
  }

  public static void main(String[] args) {
    // Use case
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(5);

    String serializedTree = serialize(root);
    System.out.println("Pohon biner yang telah diserialkan: " + serializedTree);

    TreeNode deserializedTree = deserialize(serializedTree);
    System.out.println("Pohon biner yang telah dideserialkan: ");
    printTree(deserializedTree);
  }

  // inorder traversal untuk mencetak pohon biner
  private static void printTree(TreeNode root) {
    if (root == null) {
      return;
    }

    printTree(root.left);
    System.out.print(root.val + " ");
    printTree(root.right);
  }
}