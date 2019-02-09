package kihon.treeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author USER
 *
 */

public class DirNode {
	private String dirname = "";
	private DirNode parent = null;
	private DirNode rootdir;
	private List<DirNode> subdirList = new ArrayList<DirNode>();

	public DirNode() {
		rootdir = this;
	}

	private DirNode(String name) {
		dirname = name;
	}

	public DirNode mkdir(String path) {
		String[] ps = path.split("/+");
		List<String>pl = new ArrayList<String>(Arrays.asList(ps));
		if(pl.get(0).equals("")) //　代替　path.startsWith("/")
			throw new IllegalArgumentException();
		return add(pl);
	}

	private DirNode add(List<String>pathList) {
		if(pathList.isEmpty())return this;
		String name = pathList.get(0);
		DirNode subdir = find(name);
		if(subdir == null) {
			subdir = new DirNode(name);
			subdirList.add(subdir);
			subdir.parent = this;
			subdir.rootdir = rootdir;
		}
		pathList.remove(name) ;
		return subdir.add(pathList);
	}

	private DirNode find(String name) {
		for(DirNode node : subdirList)
			if(node.dirname.equals(name))
				return node;
		return null;
	}

	public void tree() {
		tree("");
	}
	private void tree(String path) {
		if(subdirList.isEmpty()) {
			if(!"".equals(dirname))
				System.out.println(path + dirname);
			else
				System.out.println("/");
			return;
		}
		for(DirNode node : subdirList)
			node.tree();
	}

	public String pwd() {
		if(parent == null)
			return "";
		return parent.pwd() + "/" + dirname;
	}

	public DirNode cd (String path) {
		String[] ps = path.split("/+");
		DirNode node = this;
		int i = 0;
		if(path.startsWith("/")) {
			node = rootdir;
			i++;
		}
		while(i < ps.length) {
			node = node.find(ps[i++]);
			if(node == null)
				return null;
		}
		return node;
	}

}
