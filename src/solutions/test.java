package solutions;

import java.util.ArrayList;
import java.util.List;

public class test {
    List<Integer> stack = new ArrayList<>();
    List<Integer> minList = new ArrayList<>();
    int cur_min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public test() {

    }

    public void push(int val) {

        if(val <= cur_min){
            cur_min = val;
            minList.add(val);
        }
        stack.add(val);
    }

    public void pop() {
        if(stack.size() > 0) {
            if(stack.get(stack.size()-1).equals(minList.get(minList.size()-1)))
                minList.remove(minList.size()-1);
            stack.remove(stack.size()-1);
            if(minList.size() <= 0) {
                cur_min = Integer.MAX_VALUE;
            }
        }
    }

    public int top() {
        if(stack.size() > 0)
            return stack.get(stack.size()-1);
        else
            return 0;
    }

    public int getMin() {
        if(minList.size() > 0) {
            return minList.get(minList.size()-1);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        test test = new test();
        System.out.println(test.getMin());
        test.push(-1024);
        test.push(-1024);
        test.push(-1024);
        test.pop();
        test.pop();
        test.pop();
        test.push(-1024);
        System.out.println(test.getMin());
    }
}
