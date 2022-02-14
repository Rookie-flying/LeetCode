//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// Related Topics 位运算 数组 👍 251 👎 0


package leetcode.editor.cn;

public class ShuZuZhongShuZiChuXianDeCiShuIiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {

            //统计该数组中每个元素的二进制每位上之和
            // 3：0 0 1 1
            // 4：0 1 0 0
            // 3：0 0 1 1
            // 3：0 0 1 1
            // c：0 1 3 3
            // 对c结果，每位 % 3
            // r：0 1 0 0  = 4

            int res = 0;

            //int类型总共有32位，统计每位上的总数
            for (int i = 0 ; i < 32 ; i++) {

                int count = 0;
                for (int j = 0 ; j < nums.length ; j++) {

                    //无符号右移
                    count += (nums[j] >>> i)&1;
                }

                if (count % 3 == 1) {

                    res |= (1<<i);
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}