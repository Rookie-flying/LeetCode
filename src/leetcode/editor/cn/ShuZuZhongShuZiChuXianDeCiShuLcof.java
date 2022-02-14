//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// Related Topics 位运算 数组 👍 492 👎 0


package leetcode.editor.cn;

public class ShuZuZhongShuZiChuXianDeCiShuLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();
        System.out.println(solution.singleNumbers(new int[]{1,2,5,2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] singleNumbers(int[] nums) {

            int[] res = new int[2];
            int index = 0;
            int count = 0;
            for (int item : nums) {
                count = count ^ item;
            }

            //找到count二进制 从右到左为1的位数，说明a 和 b 在该位上不相等
            int flag = count & (-count);

            for (int item : nums) {

                //把该位上为零的分成一堆，为一的分成一堆
                if ((item & flag) == 0) {
                    res[0] = res[0] ^ item;
                } else {
                    res[1] = res[1] ^ item;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}