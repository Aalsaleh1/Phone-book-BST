/*************Information***************
CLASS: BST.java
CSC212 Data structures - Project phase II
Fall 2023
EDIT DATE:
3-12-2023
TEAM:

AUTHORS:

Abdulaziz Alsaleh 

****************************************/
public class BSTNode {
    public String key;
    public Contact data;
    public BSTNode left,right;


    public BSTNode(String k,Contact val) {
        key=k;
        data=val;
        left=right=null;
    }

    public BSTNode(String k, Contact val, BSTNode l, BSTNode r) {
        key=k;
        data=val;
        left=l;
        right=r;
    }
    
    public Contact getData() {//1 bigO(1)
    	return data;//1
    }
    public void setData(Contact data) {//1   bigO(1)
    	this.data = data;//1
    }
}