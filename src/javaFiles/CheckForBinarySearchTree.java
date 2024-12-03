package src.javaFiles;
/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
*/
public class CheckForBinarySearchTree {
    private class BinaryNode {
        int data;
        BinaryNode left;
        BinaryNode right;
    }
    private boolean checkBST(BinaryNode root) {
        return root.left.data < root.data && root.data < root.right.data;
    }
}