//给定一个二叉树的根节点 root ，返回它的 中序 遍历。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
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
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1253 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
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
        public List<Integer> inorderTraversal(TreeNode root) {

            List<Integer> list = new ArrayList<>();
            inOrder(root, list);
            return list;
        }

        /**
         * 递归中序遍历
         * @param node
         * @param list
         */
        public void inOrder(TreeNode node, List<Integer> list) {

            if (node == null) {
                return;
            }

            inOrder(node.left, list);
            list.add(node.val);
            inOrder(node.right, list);
        }

        /**
         * 栈中序遍历
         * @param root
         * @param list
         */
        public void inOrderStack(TreeNode root, List<Integer> list) {

            if (root == null) {
                return;
            }

            TreeNode cur = root;
            Deque<TreeNode> stack = new ArrayDeque<>();

            stack.push(root);
            cur = root;

            while (!stack.isEmpty()) {

                if (cur.left != null) {

                    cur = cur.left;
                    stack.push(cur);
                } else {

                    TreeNode node = stack.pop();
                    list.add(node.val);
                    if (node.right != null) {

                        stack.push(node.right);
                        cur = node.right;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}