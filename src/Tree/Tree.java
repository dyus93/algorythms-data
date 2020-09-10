package Tree;

import DataArray.Cat;

public class Tree {
    //node
    //insert
    //find
    //travers
    //delete

    private class TreeNode implements Comparable{
        private Cat c;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(Cat c){
            this.c = c;
        }
        @Override
        public String toString(){
            return "TreeNode{" +
                    "c=" + c.toString() +
                    '}';
        }

        @Override
        public int compareTo(Object o) {
            if (!(o instanceof Cat))
                throw new ClassCastException("Not a cat");
            return c.getAge() - ((Cat) o).getAge();
        }
    }
    TreeNode root;

    public void insert(Cat c){
        TreeNode node = new TreeNode(c);
        if (root == null){
            root = node;
        }else{
            TreeNode current = root;
            TreeNode parent = null;
            while(true){
                parent = current;
                if (c.getAge() < current.c.getAge()){
                    current = current.left;
                    if (current == null){
                        parent .left = node;
                        return;
                    }
                }else if (c.getAge() > current.c.getAge()){
                    current = current.right;
                    if (current == null){
                        parent.right = node;
                        return;
                    }
                }else
                    return;
            }
        }

    }

    public Cat find(int age){
        TreeNode current = root;
        while (current.c.getAge() != age){
            current = (age < current.c.getAge()) ? current.left : current.right;
            if (current == null) return null;
        }
        return current.c;
    }

    private void preOrderTravers(TreeNode current){
        if (current != null){
            System.out.print(current.c.getAge() + " ");
            preOrderTravers(current.left);
            preOrderTravers(current.right);
        }
    }

    public void displayTree(){
        preOrderTravers(root);
    }

    public boolean delete(int age){
        TreeNode current = root;
        TreeNode parent = null;
        boolean isLeftChild = true;

        while (current.c.getAge() != age){
            parent = current;
            if (age < current.c.getAge()){
                current = current.left;
                isLeftChild = true;
            }else{
                current = current.right;
                isLeftChild = false;
            }
            if (current == null)
                return false;
        }
        if (current.left == null && current.right == null){
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.left = null;
            else
                parent.right = null;
        }
        else if (current.right == null){
            if (isLeftChild)
                parent.left = current.left;
            else
                parent.right = current.left;
        }else if (current.left == null){
            if (isLeftChild)
                parent.left = current.right;
            else
                parent.right = current.right;
        }
        else {
            TreeNode successor = getSuccessor(current);
            if (current == root){
                root = successor;
            }else if (isLeftChild){
                parent.left = successor;
            }else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode node){
        TreeNode parent = node;
        TreeNode s = node;
        TreeNode current = node.right;

        while (current != null){
            parent = s;
            s = current;
            current = current.left;
        }

        if (s != node.right){
            parent.left = s.right;
            s.right = node.right;
        }
        return s;
    }
}
