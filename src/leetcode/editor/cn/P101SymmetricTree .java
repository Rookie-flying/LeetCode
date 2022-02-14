//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 1534 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：对称二叉树
class P101SymmetricTree{
    public static void main(String[] args) {
        Solution solution = new P101SymmetricTree().new Solution();
        // TO TEST
        
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public boolean isSymmetric(TreeNode root) {
        List left = new ArrayList();
        List right = new ArrayList();
        DFS_left(left, root.left);
        DFS_right(right, root.right);

        if(left.size() != right.size()){
            return false;
        } else {
            for(int i=0 ; i<left.size() ; i++){
                if(left.get(i) != right.get(i))
                    return false;
            }
        }
        return true;
    }

    public void DFS_left(List left, TreeNode leftNode){
        if(leftNode == null){
            left.add("null");
            return;
        }
        DFS_left(left, leftNode.left);
        left.add(leftNode.val);
        DFS_right(left, leftNode.right);
    }

    public void DFS_right(List right, TreeNode rightNode){
        if(rightNode == null){
            right.add("null");
            return;
        }
        DFS_right(right, rightNode.right);
        right.add(rightNode.val);
        DFS_left(right, rightNode.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
