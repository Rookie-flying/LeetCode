//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1421 👎 0


package leetcode.editor.cn;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {

            return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        }

        public TreeNode buildTree(int[] preorder, int[] inorder,
                                  int preLeft, int preRight,
                                  int inLeft, int inRight) {

            if (inLeft > inRight) {
                return null;
            }

            if (inLeft == inRight) {
                return new TreeNode(inorder[inLeft]);
            }

            int nodeValue = preorder[preLeft];
            int nodeIndex = 0;

            for (int i = 0; i < inorder.length; i++) {

                if (nodeValue == inorder[i]) {
                    nodeIndex = i;
                }
            }

            TreeNode node = new TreeNode(nodeValue);
            node.left = buildTree(preorder, inorder, preLeft + 1, preLeft + (nodeIndex - inLeft), inLeft, nodeIndex - 1);
            node.right = buildTree(preorder, inorder, preLeft + (nodeIndex - inLeft) + 1, preRight, nodeIndex + 1, inRight);

            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}