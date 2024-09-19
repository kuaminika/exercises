package flattenBinaryTreeToLinkedList;

public class TreeNode {
    int val;
    TreeNode left;
   TreeNode right;
    TreeNode(int x) { val = x;    
    }


    public String toString()//inorder --> left root right
    {
        String leftPart = this.left == null? "(N)":this.left.toString();

        String myPart = "-"+this.val+"-";

        String rightPart = this.right == null?"(N)": this.right.toString();

        return leftPart+myPart+rightPart;
    }
}