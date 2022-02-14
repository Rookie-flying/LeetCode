//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 贪心 字符串 排序 👍 320 👎 0


package leetcode.editor.cn;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import java.util.Random;

public class BaShuZuPaiChengZuiXiaoDeShuLcof {
    public static void main(String[] args) {
        Solution solution = new BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
        System.out.println(solution.minNumber(new int[]{3,30,34,5,9}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Random random = new Random();
        public String minNumber(int[] nums) {

            //定义排序规则
            // 3 和 30
            // 330(3+30) > 303(30+3) 说明 3 > 30 则需要把3往后移，由大到小排序

            int len = nums.length;
            StringBuilder res = new StringBuilder();
            String[] strings = new String[len];

            for (int i = 0 ; i < len ; i++) {
                strings[i] = String.valueOf(nums[i]);
            }

            quickSort(strings, 0, len - 1);

            for (String item : strings) {
                res.append(item);
            }
            //冒泡排序
/*            for (int i = 0 ; i < len ; ++i) {

                for (int j = len - 1 ; j > i ; --j) {

                    String x = nums[j] + "" + nums[j-1];
                    String y = nums[j-1] + "" + nums[j];
                    if (Long.parseLong(x) < Long.parseLong(y)) {
                        swap(nums, j, j-1);
                    }
                }

                res.append(nums[i]);
            }*/
            return res.toString();
        }

        public void quickSort(String[] strings, int left, int right) {

            if (left >= right)
                return;

            int start = random.nextInt(right - left) + left;
            String startStr = strings[start];
            swap(strings, left, start);
            int l = left;
            int r = right;
            while (l < r) {

                while (l < r && (strings[r] + startStr).compareTo(startStr + strings[r]) >= 0)
                    r--;
                strings[l] = strings[r];
                while (l < r && (strings[l] + startStr).compareTo(startStr + strings[l]) <= 0)
                    l++;
                strings[r] = strings[l];
            }
            strings[r] = startStr;

            quickSort(strings, left, r - 1);
            quickSort(strings, r + 1, right);

        }
        public void swap(String[] nums, int i, int j) {

            String temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}