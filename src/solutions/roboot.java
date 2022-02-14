package solutions;

public class roboot {
    int count = 0;
    public int movingCount(int m, int n, int k) {

        int[][] arr = new int[m][n];

        dfs (arr, 0, 0, k);
        System.out.println(count);
        return count;
    }

    public void dfs(int[][] arr, int i, int j, int k) {

        int c = position(i) + position(j);
        if (i<0 || j<0 || i>=arr.length || j>=arr[0].length || c>k || arr[i][j] == 1) {
            return;
        }



        if (c > k) {
            return;
        }

        count++;
        arr[i][j] = 1;
        dfs(arr, i+1, j, k);
        dfs(arr, i-1, j, k);
        dfs(arr, i, j+1, k);
        dfs(arr, i, j-1, k);
    }

    public int position(int num) {

        int result = 0;

        while (num != 0) {

            result += num % 10;
            num = num / 10;
        }

        return result;
    }

    public static void main(String[] args) {
        roboot test = new roboot();
        test.movingCount(2, 3, 1);
    }
}
