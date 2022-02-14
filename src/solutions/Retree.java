package solutions;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
}

public class Retree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0 ; i<inorder.length ; ++i) {

            hashMap.put(inorder[i], i);
        }

        return dfs(preorder, hashMap, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode dfs(int[] preorder, Map<Integer, Integer> hashMap,
                        int preLeft, int preLight, int inLeft, int inRight) {

        if (preLeft > preLight || inLeft > inRight) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preLeft]);
        int mid = hashMap.get(preorder[preLeft]);


        node.left = dfs(preorder, hashMap, preLeft+1, mid-inLeft+preLeft, inLeft, mid - 1);
        node.right = dfs(preorder, hashMap, mid-inLeft+preLeft+1, preLight, mid+1, inRight);

        return node;
    }
}


