//给你一个二叉树的根节点 root ， 检查它是否轴对称。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1727 👎 0


package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.*;

public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
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
        public boolean isSymmetric(TreeNode root) {

//            return isSymmetricRecurrence(root.left, root.right);
//            return isSymmetricDeque(root);
            return isSymmetricQueue(root);
        }

        /**
         * 递归
         * @param node1
         * @param node2
         * @return
         */
        public boolean isSymmetricRecurrence(TreeNode node1, TreeNode node2) {

            //排除为空情况
            if (node1 == null && node2 != null) {
                return false;
            } else if (node1 != null && node2 == null) {
                return false;
            } else if (node1 == null && node2 == null) {
                return true;
            } else if (node1.val != node2.val) {
                return false;
            }

            //只有两个相等情况
            //比较两个子树的外侧
            boolean a = isSymmetricRecurrence(node1.left, node2.right);
            //比较两个子树的内测
            boolean b = isSymmetricRecurrence(node1.right, node2.left);

            return a && b;
        }

        /**
         * 普通队列
         * @param root
         * @return
         */
        public boolean isSymmetricQueue(TreeNode root) {

            if (root == null) {
                return true;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            //每次保存两个节点
            queue.offer(root.left);
            queue.offer(root.right);

            while (!queue.isEmpty()) {

                TreeNode node1 = queue.poll();
                TreeNode node2 = queue.poll();

                if (node1 == null && node2 == null) {
                    continue;
                }
                if (node1 == null && node2 != null || node1 != null && node2 == null || node1.val != node2.val) {
                    return false;
                }

                queue.offer(node1.left);
                queue.offer(node2.right);
                queue.offer(node1.right);
                queue.offer(node2.left);
            }

            return true;
        }

        /**
         * 双端队列
         * @param root
         * @return
         */
        public boolean isSymmetricDeque(TreeNode root) {

            if (root == null) {
                return true;
            }

            //双端队列
            Deque<TreeNode> deque = new LinkedList<>();
            deque.offerFirst(root.left);
            deque.offerLast(root.right);

            while (!deque.isEmpty()) {

                TreeNode node1 = deque.pollFirst();
                TreeNode node2 = deque.pollLast();

                if (node1 == null && node2 == null) {
                    continue;
                }
                if (node1 == null && node2 != null || node1 != null && node2 == null || node1.val != node2.val) {
                    return false;
                }

                deque.offerFirst(node1.left);
                deque.offerFirst(node1.right);
                deque.offerLast(node2.right);
                deque.offerLast(node2.left);
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}