import java.util.*;
class Node{
	int data;
	Node left,right;
	Node(int x){
		data = x;
		left=null;
		right=null;
	}
}
public class TreesNGraphs{
	public static Node binaryTreeFromArray(int[] arr, int start, int end){
		if(start>end){
			return null;
		}
		int mid = (start+end)/2;
		Node root = new Node(arr[mid]);
		root.left = binaryTreeFromArray(arr,start,mid-1);
		root.right = binaryTreeFromArray(arr,mid+1,end);
		return root;
	}
	public static void inorder(Node root){
		if(root == null){
			return;
		}
		
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}
	public static void bfs(List<List<Integer>> li, List<Integer> start, List<Integer> end){
		for(int i = 0;i<li.size();i++){
			System.out.println(li.get(i));
		}
		Queue<List<Integer>> Q = new LinkedList<>();
		Q.add(start);
		Set<List<Integer>> visited = new HashSet<>();
		visited.add(start);
		while(!Q.isEmpty()){
			List<Integer> ord = Q.remove();
			int x = ord.get(0),y = ord.get(1);
			if(ord.get(0) == end.get(0) && ord.get(1) == end.get(1)){
				System.out.println("Yayyyyyy! Path exists");
				return;
			}
			if((x-1)>=0 && li.get(x-1).get(y) == 1 && !visited.contains(Arrays.asList(x-1,y))){
				Q.add(Arrays.asList(x-1,y));
				visited.add(Arrays.asList(x-1,y));
			}
			if((y-1)>=0 && li.get(x).get(y-1) == 1 && !visited.contains(Arrays.asList(x,y-1))){
				Q.add(Arrays.asList(x,y-1));
				visited.add(Arrays.asList(x,y-1));
			}
			if((x+1)<li.size() && li.get(x+1).get(y) == 1 && !visited.contains(Arrays.asList(x+1,y))){
				Q.add(Arrays.asList(x+1,y));
				visited.add(Arrays.asList(x+1,y));
			}
			if((y+1)<li.get(0).size() && li.get(x).get(y+1) == 1 && !visited.contains(Arrays.asList(x,y+1))){
				Q.add(Arrays.asList(x,y+1));
				visited.add(Arrays.asList(x,y+1));
			}
		}
		System.out.println("Sorry!!!!!! Path does not exist");
		
	}
	public static void levelOrder(Node root){
		if(root == null){
			return;
		}
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		List<List<Integer>> list = new LinkedList<>();
		while(!q.isEmpty()){
			int nodeCount = q.size();
			List<Integer> li = new LinkedList<>();
			while(nodeCount>0){
				Node node = q.peek();
				System.out.print(node.data+" ");
				li.add(node.data);
				q.remove();
				if(node.left!=null)
					q.add(node.left);
				if(node.right!=null)
					q.add(node.right);
				nodeCount--;
			}
			list.add(li);
			System.out.println();
		}
		System.out.println("List wise traversal of each depth : \n"+list);
	}
	public static boolean checkBST(Node root, int min, int max){
		if(root == null){
			return true;
		}
		if(root.data<min || root.data>max){
			return false;
		}
		return (checkBST(root.left,min,root.data-1)&&checkBST(root.right,root.data+1,max));
	}

	public static void main(String[] argv){
		System.out.println("\n Find if path exists between two nodes \n");
		List<List<Integer>> li = new LinkedList<>();
		li.add(Arrays.asList(0,1,1,0,0));
		li.add(Arrays.asList(1,0,1,1,0));
		li.add(Arrays.asList(0,1,1,0,0));
		li.add(Arrays.asList(0,0,0,1,0));
		bfs(li,Arrays.asList(0,1),Arrays.asList(3,3));
		bfs(li,Arrays.asList(1,0),Arrays.asList(1,2));
		bfs(li,Arrays.asList(0,1),Arrays.asList(2,1));
		bfs(li,Arrays.asList(2,1),Arrays.asList(1,3));
		System.out.println("\n Create binary tree from array \n");
		int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		Node node = binaryTreeFromArray(arr,0,arr.length-1);
		inorder(node);
		System.out.println("\n Level order line by line \n");
		levelOrder(node);
		System.out.println("\n Check if a binary tree is a binary search tree \n");
		System.out.println(checkBST(node,Integer.MIN_VALUE,Integer.MAX_VALUE)?"Yes a BST":"Not a BST");
		int[] arr1 = new int[]{1,2,3,4,55,26,7,87,9,100};
		Node node1 = binaryTreeFromArray(arr1,0,arr1.length-1);
		System.out.println(checkBST(node1,Integer.MIN_VALUE,Integer.MAX_VALUE)?"Yes BST":"Not a BST");
	}
}