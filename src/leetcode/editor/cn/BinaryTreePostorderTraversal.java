//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 750 👎 0


package leetcode.editor.cn;

import java.util.*;

public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {

            List<Integer> list = new ArrayList<>();
            //postOrderStack(root, list);
            postOrderRecurrence(root, list);
            return list;
        }

        /**
         * 后续遍历递归
         * @param node
         * @param list
         */
        public void postOrderRecurrence(TreeNode node, List<Integer> list) {

            if (node == null) {
                return;
            }

            postOrderRecurrence(node.left, list);
            postOrderRecurrence(node.right, list);
            list.add(node.val);
        }

        /**
         * 后续遍历栈
         * @param root
         * @param list
         */
        public void postOrderStack(TreeNode root, List<Integer> list) {

            if (root == null) {
                return;
            }

            Deque<TreeNode> stack = new ArrayDeque<>();

            stack.push(root);

            while (!stack.isEmpty()) {

                TreeNode node = stack.pop();
                list.add(node.val);

                if (node.left != null) {

                    stack.push(node.left);
                }

                if (node.right != null) {

                    stack.push(node.right);
                }
            }

            Collections.reverse(list);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}