
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
 
public class Main {
   
	static tree root=new tree('A',null,null);
   public static void main(String[] args) throws IOException, InterruptedException {
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      for(int i=0;i<n;i++) {
    	  StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	  char node = st.nextToken().charAt(0);
    	  char lnode = st.nextToken().charAt(0);
    	  char rnode = st.nextToken().charAt(0);
    	  
    	  insertNode(root, node, lnode, rnode);	  
      }
      
      preorder(root);
      System.out.println();
      inorder(root);
      System.out.println();
      postorder(root);
   } 
   public static class tree{
	   char node;
	   tree left;
	   tree right;
	   
	tree(char node, tree left, tree right) {
		super();
		this.node = node;
		this.left = left;
		this.right = right;
	}
	   
   }
   public static void insertNode(tree temp,char root,char left,char right) {
	  
	   if(temp.node==root) {
		   
		   temp.left = (left=='.'? null: new tree(left,null,null));
		   temp.right = (right=='.'? null:new tree(right,null,null));
	   }
	   if(temp.left!=null)insertNode(temp.left, root, left, right);
	   if(temp.right!=null)insertNode(temp.right, root, left, right);
   }
   public static void preorder(tree t) {
	   if(t==null)return;
	   System.out.print(t.node);
	   preorder(t.left);
	   preorder(t.right);
   }
   public static void inorder(tree t) {
	   if(t==null)return;
	   inorder(t.left);
	   System.out.print(t.node);
	   inorder(t.right);
   }
   public static void postorder(tree t) {
	   if(t==null)return;
	   postorder(t.left);
	   postorder(t.right);
	   System.out.print(t.node);
   }
}
