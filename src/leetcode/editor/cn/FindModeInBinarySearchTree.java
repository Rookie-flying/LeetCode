//给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
//
// 如果树中有不止一个众数，可以按 任意顺序 返回。 
//
// 假定 BST 满足如下定义： 
//
// 
// 结点左子树中所含节点的值 小于等于 当前节点的值 
// 结点右子树中所含节点的值 大于等于 当前节点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 412 👎 0


package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new FindModeInBinarySearchTree().new Solution();
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

        int count = 0;
        TreeNode pre;
        int max = 0;

        public int[] findMode(TreeNode root) {

/*            Map<Integer, Integer> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return new int[0];
            }

            findMode(root, map);

            List<Map.Entry<Integer, Integer>> entryList = map.entrySet().stream().sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue())).collect(Collectors.toList());
            list.add(entryList.get(0).getKey());

            for (int i = 1; i < entryList.size(); i++) {

                if (entryList.get(i).getValue() == entryList.get(i - 1).getValue()) {
                    list.add(entryList.get(i).getKey());
                } else {

                    break;
                }
            }

            return list.stream().mapToInt(Integer::intValue).toArray();*/

            List<Integer> list = new ArrayList<>();
            findMode(root, list);

            return list.stream().mapToInt(Integer::intValue).toArray();
        }

        public void findMode(TreeNode node, Map<Integer, Integer> map) {

            if (node == null) {
                return;
            }

            findMode(node.left, map);

            map.put(node.val, map.getOrDefault(node.val, 0) + 1);

            findMode(node.right, map);
        }

        public void findMode(TreeNode node, List<Integer> list) {

            if (node == null) {
                return;
            }

            findMode(node.left, list);

            if (pre == null || pre.val != node.val) {
                count = 1;
            } else if (pre.val == node.val) {
                count++;
            }

            pre = node;

            if (count > max) {
                list.clear();
                list.add(node.val);
                max = count;
            } else if (count == max) {
                list.add(node.val);
            }

            findMode(node.right, list);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}