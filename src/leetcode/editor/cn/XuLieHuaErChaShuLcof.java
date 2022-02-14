//请实现两个函数，分别用来序列化和反序列化二叉树。
//
// 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字
//符串反序列化为原始的树结构。 
//
// 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方
//法解决这个问题。 
//
// 
//
// 示例： 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 
//
// 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-
//binary-tree/ 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 243 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class XuLieHuaErChaShuLcof {
    public static void main(String[] args) {
        Codec solution = new XuLieHuaErChaShuLcof().new Codec();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;

        System.out.println(solution.deserialize(solution.serialize(node1)));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            //层序遍历
            if (root == null) {
                return "";
            }
            StringBuilder res = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {

                TreeNode node = queue.poll();

                if (node != null) {
                    res.append(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    res.append("null");
                }
                res.append(",");
            }
            res.deleteCharAt(res.length() - 1);
            return res.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

            if (data.length() == 0 || data.charAt(0) == 'n') {
                return null;
            }
            String[] chars = data.split(",");

            TreeNode head = new TreeNode(Integer.parseInt(chars[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(head);

            int i = 1;
            while (!queue.isEmpty()) {

                TreeNode node = queue.poll();

                if (i < chars.length && !chars[i].equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(chars[i]));
                    queue.offer(node.left);
                }
                ++i;
                if (i < chars.length && !chars[i].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(chars[i]));
                    queue.offer(node.right);
                }
                ++i;
            }
            return head;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}