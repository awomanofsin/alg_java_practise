import java.util.ArrayList;
import java.util.HashSet;

public class OJ0813_2 {

    public static void main(String[] args) {
        ArrayList<String> tests = new ArrayList<>(); // 传入的路径集合
        tests.add("usr/local");
        tests.add("usr/local/lib64");
        tests.add("GAMES");
        tests.add("usr/DRIVERS");
        tests.add("home");
        tests.add("var/log");
        HashSet<FileTreeNode> dirs = new HashSet<>(); // 已经有的dir
        FileTreeNode root = new FileTreeNode("");
        for (String test : tests) {
            String[] dirStrs = test.split("/");
            FileTreeNode fatherNode = root; // 父目录，是当前操作的目录的上一级目录
            for (String eachDir : dirStrs) {
                FileTreeNode dirNode = new FileTreeNode(eachDir, fatherNode); // 将目录名转为节点
                if (dirs.contains(fatherNode)) {
                    fatherNode.addChild(dirNode); // hashset自动判重
                } else {
                    dirs.add(dirNode);
                    fatherNode.addChild(dirNode);
                }
                fatherNode = dirNode;
            }
        }
        StringBuffer sb = new StringBuffer();
        root.print(sb, root, "");
        System.out.println(sb);
    }

}

// 新建树形目录结构（多叉树）
class FileTreeNode {
    String curName; // 当前目录名
    HashSet<FileTreeNode> children; // 子目录
    FileTreeNode father;    // 父目录

    public FileTreeNode(String curName, FileTreeNode father) {
        this.curName = curName;
        this.children = new HashSet<>();
        this.father = father;
    }

    // 根据目录名，转换成目录结构节点
    public FileTreeNode(String curName) {
        this.curName = curName;
        this.children = new HashSet<>();
    }

    public void setFather(FileTreeNode father) {
        this.father = father;
    }

    // 判断是不是同一个目录，名称相同就是同一个目录
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        FileTreeNode dir = (FileTreeNode) obj;
        if (dir.curName.equals(this.curName)) {
            if (this.father != null && this.father.equals(dir.father)) {
                return true;
            } else if (this.father == null && dir.father == null) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // 新加一个子目录
    public void addChild(String fileName) {
        this.children.add(new FileTreeNode(fileName));
    }

    // 新加一个子目录
    public void addChild(FileTreeNode childDir) {
        this.children.add(childDir);
    }

    public String print(StringBuffer txt, FileTreeNode node, String blank) {

        if (!node.children.isEmpty()) {
            for (FileTreeNode child : node.children) {
                txt.append(blank + node.curName + "\n");
                blank += " ";
                if (child != null) {
                    txt.append(blank + print(txt, child, blank) + "\n");
                }
            }
        } else {
            return node.curName;
        }
        return null;
    }
}
