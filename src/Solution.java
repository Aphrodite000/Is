public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class isBal {
        //  1.递归终止条件
        //  2.返回值类型是啥，每一次递归需要返回啥
        //  3.只用写一次递归，只想写单步
        class ReturnNode{
            int depth;
            boolean isB;
            public ReturnNode(int depth,boolean isB){
                this.depth=depth;
                this.isB=isB;
            }
        }
        //平衡树的条件是 它的左子树和右子树都是平衡树且他们的高度差小于等于1，
        //需要两个返回值，所以要写类包装
        public boolean isBalanced(TreeNode root) {
            return isB(root).isB;
        }
        //判断是否为平衡二叉树，因为返回值要是ReturnNode类型，
        //题目给的是boolean类型，所以要重新写一个方法
        public ReturnNode isB(TreeNode root){
            if(root==null){
                //root为空，是平衡二叉树，返回true
                return new ReturnNode(0,true);
            }
            ReturnNode left=isB(root.left);
            ReturnNode right=isB(root.right);
            //左子树或右子树任意一个不是平衡树,则返回false；
            if(left.isB==false||right.isB==false){
                return new ReturnNode(Math.max(left.depth,right.depth)+1,false);
            }

            if(Math.abs(left.depth-right.depth)>1){
                return new ReturnNode(Math.max(left.depth,right.depth)+1,false);
            }
            //走到这一步说明是平衡二叉树
            return new ReturnNode(Math.max(left.depth,right.depth)+1,true);
        }
    }
}
