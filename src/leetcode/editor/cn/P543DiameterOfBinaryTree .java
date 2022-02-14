//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 802 👎 0

package leetcode.editor.cn;
//Java：二叉树的直径
class P543DiameterOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new P543DiameterOfBinaryTree().new Solution();
        // TO TEST
        TreeNode node_1 = new TreeNode(1);
        TreeNode node_2 = new TreeNode(2);
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_5 = new TreeNode(5);

        node_1.left = node_2;
        node_1.right = node_3;
        node_2.left = node_4;
        node_2.right = node_5;
        System.out.println(solution.diameterOfBinaryTree(node_1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class TreeNode {
        int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
    public int path = 0;
    public int deep = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        DFS_1(root);
        return path;
    }

    public void DFS_1(TreeNode root) {

        if (root == null) {
            return;
        }
        deep = 0;
        int left_path = DFS_2(root.left, 0, 0);
        deep = 0;
        int right_paht = DFS_2(root.right, 0, 0);
        path = Math.max(left_path+right_paht, path);
        DFS_1(root.left);
        DFS_1(root.right);
    }

    public int DFS_2(TreeNode root, int flag, int count) {
        if (root == null) {
            deep = Math.max(flag, deep);
            return count;
        }

        DFS_2(root.left, flag+1, count);
        DFS_2(root.right, flag+1, count);
        return deep;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
