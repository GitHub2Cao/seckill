package org.seckill.test.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static java.lang.System.out;

public class TestBTree {
	public static void main(String[] args) {
		TestBTree testBTree = new TestBTree();
		TreeNode root = testBTree.buildTree();
		List<Integer> traversTrace = new ArrayList<>();
//		testBTree.qianGenXuDigui(traversTrace, root);
//		out.println(traversTrace);
//
//		traversTrace.clear();
//		testBTree.zhongGenXuDigui(traversTrace, root);
//		out.println(traversTrace);
//
//		traversTrace.clear();
		testBTree.qianGenXuDigui(traversTrace, root);
		out.println(traversTrace);
		traversTrace.clear();
		testBTree.qianGenXuDiedai(traversTrace, root);
		out.println(traversTrace);
	}

	public void houGenXuDiedai(List<Integer> traversTrace, TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.empty()) {
			while (root != null) {
				stack.push(root.getLeft());
				root = root.getLeft();
			}
			root = stack.pop();
			traversTrace.add(root.getVal());
			root = root.getRight();
		}
	}

	public void houGenXuDigui(List<Integer> traversTrace, TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.getLeft() != null) {
			houGenXuDigui(traversTrace, root.getLeft());
		}
		if (root.getRight() != null) {
			houGenXuDigui(traversTrace, root.getRight());
		}
		traversTrace.add(root.getVal());
	}

	public void zhongGenXuDigui(List<Integer> traversTrace, TreeNode root) {
		if (root == null) {
			return;
		}

		if (root.getLeft() != null) {
			zhongGenXuDigui(traversTrace, root.getLeft());
		}
		traversTrace.add(root.getVal());
		if (root.getRight() != null) {
			zhongGenXuDigui(traversTrace, root.getRight());
		}

	}

	public void qianGenXuDiedai(List<Integer> traversTrace, TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode temp = s.pop();
			traversTrace.add(temp.getVal());
			if (temp.getRight() != null) {
				s.push(temp.getRight());
			}
			if (temp.getLeft() != null) {
				s.push(temp.getLeft());
			}
		}
	}

	public void qianGenXuDigui(List<Integer> traversTrace, TreeNode root) {
		if (root == null) {
			return;
		}

		traversTrace.add(root.getVal());
		if (root.getLeft() != null) {
			qianGenXuDigui(traversTrace, root.getLeft());
		}

		if (root.getRight() != null) {
			qianGenXuDigui(traversTrace, root.getRight());
		}
	}

	public TreeNode buildTree() {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(5);
		TreeNode e = new TreeNode(6);
		TreeNode f = new TreeNode(7);
		TreeNode g = new TreeNode(8);

		root.setLeft(a);
		root.setRight(b);
		a.setLeft(c);
		c.setRight(f);
		b.setLeft(d);
		b.setRight(e);
		e.setLeft(g);

		return root;
	}
}
