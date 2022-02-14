//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 滑动窗口 单调队列 堆（优先队列） 👍 345 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class HuaDongChuangKouDeZuiDaZhiLcof {
    public static void main(String[] args) {
        Solution solution = new HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
        System.out.println(solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {

            int len = nums.length;

            if (len == 0 || k == 0 || len < k) {
                return new int[0];
            }
            //单调队列
            int[] res = new int[len - k + 1];
            int h = 0;

            //双端队列, first最大，last最小
            Deque<Integer> queue = new LinkedList<>();

            // 窗口未形成前
            for (int i = 0; i < k; i++) {

                while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                    queue.removeLast();
                }
                queue.addLast(nums[i]);
            }
            res[0] = queue.peekFirst();
            //窗口形成后
            for (int i = k ; i < len ; i++) {

                //如果First和剔除的窗口值相等，则去除
                if (queue.peekFirst() == nums[i - k]) {
                    queue.removeFirst();
                }

                while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                    queue.removeLast();
                }
                queue.addLast(nums[i]);
                res[i - k + 1] = queue.peekFirst();
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}