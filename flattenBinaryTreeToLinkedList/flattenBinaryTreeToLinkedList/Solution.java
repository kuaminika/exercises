 
package flattenBinaryTreeToLinkedList;
public class Solution{
    
    	public TreeNode flatten(TreeNode a) {
			if(a == null ) return a;
 

			TreeNode fRight = flatten(a.right);
			TreeNode fLeft = flatten(a.left);
			if(fLeft == null && fRight == null) return a;

			a.left = null;

			if(fLeft == null)
			{
				a.right = fRight;
				return a;
			}
			TreeNode rmc = fLeft;

			while(rmc.right != null)
			{
				rmc = rmc.right;
			}


			rmc.right = fRight;

			a.right = fLeft;

            return a;
	}
} 


