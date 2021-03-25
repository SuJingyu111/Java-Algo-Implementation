package DataStructures;

enum Color {RED, BLACK};

class RBTNode extends TreeNode{
    protected RBTNode left;
    protected RBTNode right;
    protected RBTNode parent;
    Color color;
    public RBTNode(Integer val, Color color) {
        super(val);
        this.color = color;
    }
}

public class RedBlackTree {
    RBTNode root;

    public RedBlackTree(Integer val) {
        root = new RBTNode(val, Color.BLACK);
    }

    private void leftRotate(RBTNode node) {
        if (node.right == null)
            return;
        RBTNode rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }
        rightChild.parent = node.parent;
        if (rightChild.parent == null) {
            this.root = rightChild;
        }
        else if (node == node.parent.left) {
            node.parent.left = rightChild;
        }
        else
            node.parent.right = rightChild;
        node.parent = rightChild;
        rightChild.left = node;
    }

    private void rightRotate (RBTNode node) {
        if (node.left == null) {
            return;
        }
        RBTNode leftChild = node.left;
        node.left = leftChild.right;
        if (leftChild.right != null) {
            node.left.parent = node;
        }
        leftChild.parent = node.parent;
        if (node.parent == null) {
            this.root = leftChild;
        }
        else if (node.parent.left == node) {
            node.parent.left = leftChild;
        }
        else
            node.parent.right = leftChild;
        node.parent = leftChild;
        leftChild.right = node;
    }
}
