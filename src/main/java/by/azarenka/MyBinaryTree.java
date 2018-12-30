package by.azarenka;

import java.util.ArrayList;
import java.util.List;

public class MyBinaryTree implements MyTree {

    private Node root;

    public MyBinaryTree() {
    }

    @Override
    public boolean add(Integer element) {
        if (element == null) throw new NullPointerException();
        while (true) {
            root = add(element, root);
            if (root == null) {
                return false;
            }
            break;
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return root != null;
    }

    @Override
    public boolean delete(Integer number) {
        if (root == null) throw new NullPointerException("Tree is empty");
        delete(number, root);
        return true;
    }

    @Override
    public Object[] output() {
        if (root != null) {
            return output(root);
        }
        return new String[]{"Tree is empty"};
    }

    private Object[] output(Node element) {
        List<String> result = new ArrayList<String>();
        if (element.rightChild != null) {
            Object[] temp = output(element.rightChild);
            for (int i = 0; i < temp.length; i++) {
                result.add("    " + temp[i]);
            }
        }
        result.add(element.data.toString());
        if (element.leftChild != null) {
            Object[] temp = output(element.leftChild);
            for (int i = 0; i < temp.length; i++) {
                result.add("    " + temp[i]);
            }
        }
        return result.toArray();
    }

    @Override
    public int minValue() {
        if (root == null) throw new NullPointerException("Tree is empty");
        return minValue(root);
    }

    @Override
    public int maxValue() {
        if (root == null) throw new NullPointerException("Tree is empty");
        return maxValue(root);
    }

    @Override
    public boolean search(int value) {
        if (search(value, root) == null) {
            return false;
        } else {
            return true;
        }
    }

    private Node search(int value, Node node) {
        if (node == null || node.data == value) {
            return node;
        }
        if (value < node.data) {
            return search(value, node.leftChild);
        } else {
            return search(value, node.rightChild);
        }
    }

    private int maxValue(Node node) {
        if (node.rightChild == null) {
            return node.data;
        } else {
            return minValue(node.rightChild);
        }
    }

    private int minValue(Node node) {
        if (node.leftChild == null)
            return node.data;
        else
            return minValue(node.leftChild);
    }

    private Node delete(int number, Node node) {
        if (node == null) {
            return null;
        }
        if (node.data > number) {
            node.leftChild = delete(number, node.leftChild);
        } else if (node.data < number) {
            node.rightChild = delete(number, node.rightChild);
        } else if (node.rightChild != null && node.leftChild != null) {
            node.data = minValue(node);
            node.rightChild = delete(node.data, node.rightChild);
        } else {
            if (node.leftChild != null) {
                node = node.leftChild;
            } else {
                node = node.rightChild;
            }
        }
        return node;
    }

    private Node add(Integer element, Node node) {
        if (node == null) {
            node = new Node();
            node.data = element;
            return node;
        }
        if (element == (node.data)) {
            return null;

        } else {
            if (element > node.data) {
                node.rightChild = add(element, node.rightChild);
                return node;
            } else {
                node.leftChild = add(element, node.leftChild);
                return node;
            }
        }
    }

    public static class Node {
        private Integer data;
        private Node leftChild;
        private Node rightChild;

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MyBinaryTree{" +
                "root=" + root +
                '}';
    }
}
