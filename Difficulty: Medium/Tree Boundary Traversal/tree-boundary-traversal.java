class Solution {

    ArrayList<Integer> boundaryTraversal(Node root) {

        ArrayList<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        ans.add(root.data);

        leftBoundary(root.left, ans);
        leafNodes(root.left, ans);
        leafNodes(root.right, ans);
        rightBoundary(root.right, ans);

        return ans;
    }

    void leftBoundary(Node root, ArrayList<Integer> ans){
        if(root == null || (root.left == null && root.right == null))
            return;

        ans.add(root.data);

        if(root.left != null)
            leftBoundary(root.left, ans);
        else
            leftBoundary(root.right, ans);
    }

    void leafNodes(Node root, ArrayList<Integer> ans){
        if(root == null) return;

        if(root.left == null && root.right == null){
            ans.add(root.data);
            return;
        }

        leafNodes(root.left, ans);
        leafNodes(root.right, ans);
    }

    void rightBoundary(Node root, ArrayList<Integer> ans){
        if(root == null || (root.left == null && root.right == null))
            return;

        if(root.right != null)
            rightBoundary(root.right, ans);
        else
            rightBoundary(root.left, ans);

        ans.add(root.data);
    }
}