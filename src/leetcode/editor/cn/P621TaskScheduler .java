//给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个
//单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。 
//
// 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。 
//
// 你需要计算完成所有任务所需要的 最短时间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：tasks = ["A","A","A","B","B","B"], n = 2
//输出：8
//解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
//     在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。 
//
// 示例 2： 
//
// 
//输入：tasks = ["A","A","A","B","B","B"], n = 0
//输出：6
//解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
//["A","A","A","B","B","B"]
//["A","B","A","B","A","B"]
//["B","B","B","A","A","A"]
//...
//诸如此类
// 
//
// 示例 3： 
//
// 
//输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
//输出：16
//解释：一种可能的解决方案是：
//     A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待
//命) -> (待命) -> A
// 
//
// 
//
// 提示： 
//
// 
// 1 <= task.length <= 104 
// tasks[i] 是大写英文字母 
// n 的取值范围为 [0, 100] 
// 
// Related Topics 贪心 数组 哈希表 计数 排序 堆（优先队列） 
// 👍 743 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：任务调度器
class P621TaskScheduler{
    public static void main(String[] args) {
        Solution solution = new P621TaskScheduler().new Solution();
        // TO TEST
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 0;
        System.out.println(solution.leastInterval(tasks, n));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] buckets = new int[26];

        // 统计次数
        for (char item : tasks) {
            buckets[item-'A']++;
        }

        // 升序排序
        Arrays.sort(buckets);

        //计算最大的且次数相同的次数
        int maxCount = 1;
        int maxTimes = buckets[25];
        for(int i=25 ; i>=1 ; i--) {
            if (buckets[i] == buckets[i-1]) {
                maxCount++;
            } else {
                break;
            }
        }

        // 不包含n=0的时候
        int res = (maxTimes-1)*(n+1)+maxCount;
        return Math.max(tasks.length, res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
