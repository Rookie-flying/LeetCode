//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 153 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CongShangDaoXiaDaYinErChaShuIiiLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
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

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {

            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {

                return res;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            int level = 0;
            while (!queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                //使用i=queue.size(),避免queue.size()的实时变动
                for(int i=queue.size() ; i>0 ; i--) {
                    TreeNode item = queue.poll();
                    if (level % 2 != 0) {
                        list.add(0, item.val);
                    } else {
                        list.add(item.val);
                    }
                    if (item.left != null)
                        queue.offer(item.left);
                    if (item.right != null)
                        queue.offer(item.right);
                }
                ++level;
                res.add(list);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}