package kihon.treeNode;

public class DirNodeTester {

	public static void main(String[] args) {
		DirNode root = new DirNode();
		DirNode x = root.mkdir("x");
		x.mkdir("y");
		x.mkdir("z/a");
		System.out.println("--- x.tree()");
		x.tree();
		System.out.println("--- root.tree()");
		root.tree();
		System.out.println("--- x.cd(''z/a'')");
		DirNode a = x.cd("z/a");
		System.out.println(a.pwd());
		System.out.println(x.cd("z/a"));
		System.out.println("---");
		DirNode za = root.mkdir("z/a");
		DirNode bb = za.mkdir("b/b");
		System.out.println(bb.pwd());
	}

}
