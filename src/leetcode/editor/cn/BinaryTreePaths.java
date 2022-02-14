//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
//
// 叶子节点 是指没有子节点的节点。 
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 642 👎 0


package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();
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
        public List<String> binaryTreePaths(TreeNode root) {


            List<String> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            String s = "";
//            printTreePaths(root, list, s);
//            List<Integer> nodes = new ArrayList<>();
//            printTreePaths(root, list, nodes);
            printTreePaths(root, list);
            return list;
        }

        public void printTreePaths(TreeNode node, List<String> list, String s) {

            s += node.val;

            if (node.left == null && node.right == null) {
                list.add(s);
            }

            if (node.left != null) {
                printTreePaths(node.left, list, s + "->");
            }

            if (node.right != null) {
                printTreePaths(node.right, list, s + "->");
            }
        }

        public void printTreePaths(TreeNode node, List<String> list, List<Integer> nodes) {

            nodes.add(node.val);
            if (node.left == null && node.right == null) {

                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < nodes.size() - 1 ; i++) {

                    stringBuilder.append(nodes.get(i));
                    stringBuilder.append("->");
                }

                stringBuilder.append(nodes.get(nodes.size() - 1));
                list.add(stringBuilder.toString());
                return;
            }


            if (node.left != null) {

                printTreePaths(node.left, list, nodes);
                nodes.remove(nodes.size() - 1); //回溯
            }

            if (node.right != null) {

                printTreePaths(node.right, list, nodes);
                nodes.remove(nodes.size() - 1);//回溯
            }
        }

        public void printTreePaths(TreeNode root, List<String> list) {

            Deque<Object> stack = new LinkedList<>();

            stack.push(root);
            stack.push(root.val + "");

            while (!stack.isEmpty()) {

                String path = String.valueOf(stack.pop());
                TreeNode node = (TreeNode) stack.pop();

                if (node.left == null && node.right == null) {

                    list.add(path);
                }

                if (node.left != null) {

                    stack.push(node.left);
                    stack.push(path + "->" + node.left.val);
                }

                if (node.right != null) {
                    stack.push(node.right);
                    stack.push(path + "->" + node.right.val);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}