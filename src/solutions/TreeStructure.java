package solutions;

public class TreeStructure {

    boolean flag = false;
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if (A == null || B == null) {
            return flag;
        }
        dfs(A, B);
        return flag;
    }

    public void dfs(TreeNode p, TreeNode q) {

        if (p == null) {

            return;
        }

        if (p.val == q.val) {

            flag = checkSame(p, q);
            if (flag) {
                return;
            }
        }

        dfs(p.left, q);
        dfs(p.right, q);
    }

    public boolean checkSame(TreeNode p, TreeNode q) {

        if (q == null) {
            return true;
        }

        if (p == null || q.val != p.val) {
            return false;
        }

        return checkSame(p.right, q.right) && checkSame(p.left, q.left);
    }

    public static void main(String[] args) {

        TreeNode A = new TreeNode(3);
        TreeNode B = new TreeNode(4);

        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);

        TreeNode four_1 = new TreeNode(4);
        TreeNode one_1 = new TreeNode(1);

        A.left = four;
        A.right =five;
        four.left = one;
        four.right = two;

        four_1.left = one;

        TreeStructure tree = new TreeStructure();
        System.out.println(tree.isSubStructure(A, B));
    }
}
