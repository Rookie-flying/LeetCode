//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 1168 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
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


        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {

            //levelOrderRecurrence(root, 0);
            levelOrderQueue(root);
            return result;
        }

        /**
         * 递归
         * @param node
         * @param depth
         */
        public void levelOrderRecurrence(TreeNode node, int depth) {

            if (node == null) {
                return;
            }
            depth++;
            if (result.size() < depth) {
                result.add(new ArrayList<>());
            }

            result.get(depth - 1).add(node.val);
            levelOrderRecurrence(node.left, depth);
            levelOrderRecurrence(node.right, depth);
        }

        /**
         * 队列
         * @param root
         */
        public void levelOrderQueue(TreeNode root) {

            if (root == null) {
                return;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {

                List<Integer> list = new ArrayList<>();
                int size = queue.size();

                for (int i = 0 ; i < size ; i++) {

                    TreeNode node = queue.poll();
                    list.add(node.val);

                    if (node.left != null) {
                        queue.offer(node.left);
                    }

                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }

                result.add(list);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}