//输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
//
// 
//
// 示例 1: 
//
// 给定二叉树 [3,9,20,null,null,15,7] 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回 true 。 
// 
//示例 2: 
//
// 给定二叉树 [1,2,2,3,3,null,null,4,4] 
//
// 
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// 返回 false 。 
//
// 
//
// 限制： 
//
// 
// 0 <= 树的结点个数 <= 10000 
// 
//
// 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/ 
//
// 
// Related Topics 树 深度优先搜索 二叉树 👍 204 👎 0


package leetcode.editor.cn;

public class PingHengErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new PingHengErChaShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        public boolean isBalanced(TreeNode root) {

            return deepth(root) == -1 ? false : true;
        }


        public int deepth(TreeNode root) {

            if (root == null) {
                return 0;
            }

            int leftDeep = deepth(root.left);
            int rightDeep = deepth(root.right);

            if (leftDeep == -1 || rightDeep == -1 || Math.abs(leftDeep - rightDeep) > 1) {
                return -1;
            } else {
                return Math.max(leftDeep, rightDeep) + 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}