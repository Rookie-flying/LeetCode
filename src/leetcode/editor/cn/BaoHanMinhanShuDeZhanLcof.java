  //定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。 
//
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// 各函数的调用总次数不超过 20000 次 
// 
//
// 
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/ 
// Related Topics 栈 设计 👍 219 👎 0

  
  package leetcode.editor.cn;

  import java.util.ArrayList;
  import java.util.LinkedList;
  import java.util.List;

  public class BaoHanMinhanShuDeZhanLcof{
      public static void main(String[] args) {
           MinStack solution = new BaoHanMinhanShuDeZhanLcof().new MinStack();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    /** initialize your data structure here. */
    private List<Integer> stack;
    private List<Integer> sortList;
    public MinStack() {

        stack = new ArrayList<>();
        sortList = new ArrayList<>();
    }
    
    public void push(int x) {

        stack.add(x);
        if (sortList.size() == 0) {
            sortList.add(x);
        } else if (x <= sortList.get(sortList.size() - 1)) {
            sortList.add(x);
        }
    }
    
    public void pop() {

        if (stack.size() != 0) {
            int temp = stack.remove(stack.size() - 1);
            if (temp == sortList.get(sortList.size() - 1)) {
                sortList.remove(sortList.size() - 1);
            }
        }
    }
    
    public int top() {

        if (stack.size() != 0) {
            return stack.get(stack.size() - 1);
        }
        return -1;
    }
    
    public int min() {

        if (sortList.size() != 0) {
            return sortList.get(sortList.size() - 1);
        }
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)

  }