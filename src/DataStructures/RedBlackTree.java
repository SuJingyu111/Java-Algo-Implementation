package DataStructures;

enum Color {RED, BLACK};

class RBTNode extends TreeNode{
    protected RBTNode left;
    protected RBTNode right;
    protected RBTNode parent;
    Color color;

    public RBTNode(Integer val, Color color, RBTNode nil) {
        super(val);
        this.color = color;
        left = nil;
        right = nil;
        parent = nil;
    }
}

public class RedBlackTree {
    RBTNode root;
    RBTNode nil = new RBTNode(0, Color.BLACK, null);

    public RedBlackTree(Integer val) {
        root = new RBTNode(val, Color.BLACK, nil);
    }

    public void insert(Integer val) {
        RBTNode newNode = new RBTNode(val, Color.RED, nil);
        RBTNode trace = nil;
        RBTNode currentNode = root;
        while (currentNode != nil) {
            trace = currentNode;
            if (newNode.val > currentNode.val) {
                currentNode = currentNode.right;
            }
            else {
                currentNode = currentNode.left;
            }
        }
        newNode.parent = trace;
        if (trace == nil) {
            root = newNode;
        }
        else if (newNode.val < trace.val) {
            trace.left = newNode;
        }
        else {
            trace.right = newNode;
        }
        insertFixUp(newNode);
    }

    private void insertFixUp(RBTNode newNode) {
        while (newNode.parent.color == Color.RED) {
            if (newNode.parent == newNode.parent.parent.left) {
                RBTNode uncle = newNode.parent.parent.right;
                if (newNode.color == Color.RED) {
                    newNode.parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    newNode.parent.parent.color = Color.RED;
                    newNode = newNode.parent.parent;
                }
                else if (newNode == newNode.parent.right) {
                    newNode = newNode.parent;
                    leftRotate(newNode);
                }
                newNode.parent.color = Color.BLACK;
                newNode.parent.parent.color = Color.RED;
                rightRotate(newNode.parent.parent);
            }
            else {
                RBTNode uncle = newNode.parent.parent.left;
                if (newNode.color == Color.RED) {
                    newNode.parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    newNode.parent.parent.color = Color.RED;
                    newNode = newNode.parent.parent;
                }
                else if (newNode == newNode.parent.left) {
                    newNode = newNode.parent;
                    rightRotate(newNode);
                }
                newNode.parent.color = Color.BLACK;
                newNode.parent.parent.color = Color.RED;
                leftRotate(newNode.parent.parent);
            }
        }
        root.color = Color.BLACK;
    }

    public void delete(RBTNode z) {
        RBTNode y = z;
        RBTNode x;
        Color yOriginalColor = y.color;
        if (z.left == nil) {
            x = z. right;
            transplant(z, x);
        }
        else if (z.right == nil) {
            x = z.left;
            transplant(z, x);
        }
        else {
            y = minimum(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            }
            else
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        if (yOriginalColor == Color.BLACK) {
            deleteFixUp(x);
        }
    }

    private RBTNode minimum(RBTNode root){
        RBTNode cursor = root;
        while (cursor.left != nil) {
            cursor = cursor.left;
        }
        return cursor;
    }

    private void deleteFixUp(RBTNode x) {
        while (x != this.root && x.color == Color.BLACK) {
            RBTNode w;
            if (x == x.parent.left) {
                w = x.parent.right;
                if (w.color == Color.RED) {
                    w.color = Color.BLACK;
                    x.parent.color = Color.RED;
                    leftRotate(x.parent);
                    w = x.parent.right;
                }
                if (w.left.color == Color.BLACK && w.right.color == Color.BLACK) {
                    w.color = Color.RED;
                    x = x.parent;
                }
                else if (w.right.color == Color.BLACK) {
                    w.left.color = Color.BLACK;
                    w.color = Color.RED;
                    rightRotate(w);
                    w = x.parent.right;
                    w.color = x.parent.color;
                    x.parent.color = Color.BLACK;
                    w.right.color = Color.BLACK;
                    leftRotate(x.parent);
                    x = this.root;
                }
            }
            else {
                w = x.parent.left;
                if (w.color == Color.RED) {
                    w.color = Color.BLACK;
                    x.parent.color = Color.RED;
                    rightRotate(x.parent);
                    w = x.parent.left;
                }
                if (w.right.color == Color.BLACK && w.left.color == Color.BLACK) {
                    w.color = Color.RED;
                    x = x.parent;
                }
                else if (w.left.color == Color.BLACK) {
                    w.right.color = Color.BLACK;
                    w.color = Color.RED;
                    leftRotate(w);
                    w = x.parent.left;
                    w.color = x.parent.color;
                    x.parent.color = Color.BLACK;
                    w.left.color = Color.BLACK;
                    rightRotate(x.parent);
                    x = this.root;
                }
            }
        }
        x.color = Color.BLACK;
    }

    private void transplant(RBTNode u, RBTNode v) {
        if (u.parent == nil) {
            root = v;
        }
        else if (u == u.parent.left) {
            u.parent.left = v;
        }
        else
            u.parent.right = v;
        v.parent = u.parent;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.root == nil) {
            sb.append(" nil ");
            return sb.toString();
        }
        else {
            String s = " (" + Integer.toString(root.val) + " " + root.color + ") ";
            sb.append(s);
            sb.append(recurse(root.left));
            sb.append(recurse(root.right));
        }
        return sb.toString();
    }

    private StringBuilder recurse(RBTNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == nil) {
            sb.append(" nil ");
            return sb;
        }
        else {
            String s = " (" + Integer.toString(root.val) + " " + root.color + ") ";
            sb.append(s);
            sb.append(recurse(root.left));
            sb.append(recurse(root.right));
        }
        return sb;
    }

    private void leftRotate(RBTNode node) {
        if (node.right == nil)
            return;
        RBTNode rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != nil) {
            rightChild.left.parent = node;
        }
        rightChild.parent = node.parent;
        if (rightChild.parent == nil) {
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
        if (node.left == nil) {
            return;
        }
        RBTNode leftChild = node.left;
        node.left = leftChild.right;
        if (leftChild.right != nil) {
            node.left.parent = node;
        }
        leftChild.parent = node.parent;
        if (node.parent == nil) {
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
