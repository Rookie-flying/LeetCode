//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
//
// 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层
//为第 h 层，则该层包含 1~ 2ʰ 个节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,4,5,6]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是[0, 5  10⁴] 
// 0 <= Node.val <= 5  10⁴ 
// 题目数据保证输入的树是 完全二叉树 
// 
//
// 
//
// 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？ 
// Related Topics 树 深度优先搜索 二分查找 二叉树 👍 611 👎 0


package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new CountCompleteTreeNodes().new Solution();
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
        public int countNodes(TreeNode root) {

//            return generalCountNodeRecurrence(root);
//            return generalCountNodeQueue(root);
            return completeTreeCountNode(root);
        }


        /**
         * 通用记录节点个数，递归
         * @param node
         * @return
         */
        public int generalCountNodeRecurrence(TreeNode node) {

            if (node == null) {
                return 0;
            }

            return 1 + generalCountNodeRecurrence(node.left) + generalCountNodeRecurrence(node.right);
        }

        /**
         * 通用记录树的节点个数，队列
         * @param root
         * @return
         */
        public int generalCountNodeQueue(TreeNode root) {

            if (root == null) {
                return 0;
            }

            int result = 0;
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);

            while (!queue.isEmpty()) {

                int size = queue.size();

                for (int i = 0 ; i < size ; i++) {

                    result++;
                    TreeNode node = queue.poll();

                    if (node.left != null) {
                        queue.offer(node.left);
                    }

                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }

            return result;
        }

        /**
         * 完全二叉树记录节点个数
         * @param node
         * @return
         */
        public int completeTreeCountNode(TreeNode node) {

            if (node == null) {
                return 0;
            }

            TreeNode leftNode = node.left;
            TreeNode rightNode = node.right;

            int leftHeight = 0;
            int rightHeight = 0;

            //记录左子树节点高度
            while (leftNode != null) {

                leftHeight++;
                leftNode = leftNode.left;
            }

            //记录右子树节点高度
            while (rightNode != null) {

                rightHeight++;
                rightNode = rightNode.right;
            }

            //如果高度相等，则为完全二叉树
            if (leftHeight == rightHeight) {

                return (2<<leftHeight) - 1;
            }

            return 1 + completeTreeCountNode(node.left) + completeTreeCountNode(node.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}