//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// Related Topics 数组 前缀和 👍 168 👎 0


package leetcode.editor.cn;

public class GouJianChengJiShuZuLcof {
    public static void main(String[] args) {
        Solution solution = new GouJianChengJiShuZuLcof().new Solution();
        solution.constructArr(new int[]{1,2,3,4,5});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructArr(int[] a) {

            int len = a.length;
            if (len == 0) {

                return new int[0];
            }

            int[] res = new int[len];

            //下三角
            //实际上就是计算每个值左半边的区间乘积
            res[0] = 1;

            for (int i = 1 ; i < len ; i++) {
                res[i] = res[i - 1] * a[i - 1];
            }

            //上三角
            //实际上就是计算每个值右半边的区间乘积
            int temp = 1;
            for (int i = len - 2 ; i >= 0 ; i--) {

                temp = temp*a[i+1];
                res[i] = res[i]*temp;
            }

            return res;

/*            int len = a.length;
            if (len == 0) {
                return new int[0];
            }

            int[] res = new int[len];
            int sum = a[0];
            int count = 0;
            int index = 0;
            for (int i = 1; i < len; i++) {

                if (a[i] == 0) {
                    count++;
                    index = i;
                } else {
                    sum = sum * a[i];
                }
            }

            if (count == 0) {
                for (int i = 0; i < len; i++) {
                    res[i] = sum / a[i];
                }
            } else if (count == 1) {

                res[index] = sum;
            }
            return res;*/
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}