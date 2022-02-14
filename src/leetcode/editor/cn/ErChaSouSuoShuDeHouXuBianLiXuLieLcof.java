//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 👍 376 👎 0


package leetcode.editor.cn;

import java.util.Stack;

public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPostorder(int[] postorder) {

            //1.递归分治
            //最后一个节点为根节点，从前往后找到第一个大于根节点的数字
            //该节点之前为左子树，该节点及之后为右子树

            //return helper(postorder, 0, postorder.length - 1);

            //2.单调栈
            Stack<Integer> stack = new Stack<>();

            //有后往前遍历，
            //当前节点大于栈顶节点，说明为右子节点，入栈
            //当前节点小于栈顶节点，说明为左子节点，不断出栈，直到找到小于该节点的元素再入栈
            //且栈顶的上一个节点为当前节点父节点parent
            //且后续入栈的节点都为parent的左子节点，应当小于parent

            int parent = Integer.MAX_VALUE;
            for (int i = postorder.length - 1; i >=  0; i--) {

                if (parent < postorder[i]) {
                    return false;
                }


                while (!stack.isEmpty() && stack.peek() > postorder[i]) {

                    parent = stack.pop();
                }
                stack.push(postorder[i]);

            }

            return true;
        }

        public boolean helper(int[] postorder, int left, int right) {

            // = 只有一个数，> 说明为null
            if (left >= right) {
                return true;
            }

            // 寻找分割点，
            int i = left;
            while (postorder[i] < postorder[right]) {
                i++;
            }

            //左子树的值都要小于根节点，右子树的值都要大于根节点
            //我们只需要查看右子树节点是否都大于根节点即可，上面的循环已经验证了左子树
            int j = i;
            while (j < right) {

                if (postorder[j] < postorder[right]) {
                    return false;
                }
                j++;
            }

            return helper(postorder, left, i - 1) && helper(postorder, i, right - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}