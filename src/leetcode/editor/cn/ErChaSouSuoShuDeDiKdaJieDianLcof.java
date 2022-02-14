//给定一棵二叉搜索树，请找出其中第k大的节点。
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 220 👎 0


package leetcode.editor.cn;

public class ErChaSouSuoShuDeDiKdaJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node3.left = node1;
        node3.right = node4;
        node1.right = node2;

        System.out.println(solution.kthLargest(node3, 1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        int count = 0;
        int res = 0;
        public int kthLargest(TreeNode root, int k) {

            dfs(root, k);
            return res;
        }

        public void dfs(TreeNode root, int k) {

            if (root == null) {
                return;
            }

            dfs(root.right, k);
            ++count;
            if (count == k) {

                res = root.val;
                return;
            }
            dfs(root.left, k);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}