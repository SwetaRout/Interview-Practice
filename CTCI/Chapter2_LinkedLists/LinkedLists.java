import java.util.*;
class intComp implements Comparator<Integer>{
	public int compare(Integer i,Integer j){
		return i.compareTo(j);
	}
}
public class LinkedLists{
	public static void removeDups(List<Integer> li){
		HashSet<Integer> hs = new HashSet<>();
		for(int i = 0;i<li.size();i++){
			hs.add(li.get(i));
		}
		System.out.println("Using Hash Set");
		System.out.println(hs);
		System.out.println("Using Sorting");
		Collections.sort(li, new intComp());
		for(int i = 1; i<li.size();i++){
			if(li.get(i) == li.get(i-1)) {
				li.remove(i-1);
				i--;
			}
		}
		System.out.println(li);
	}
	public static void kthlast(List<Integer> li,int k){
		System.out.println(li+ " \tk = " +k);
		System.out.println("kth last is "+li.get(li.size()-k));
	}
	public static void removeNode(List<Integer> li, int node){
		int l = 0, r = li.size(), mid = (l+r)/2;
		System.out.println(li+"\t node = "+node);
		while(l<r){
			mid = (l+r)/2;
			if(node<li.get(mid)){
				r = mid;
			} else if(node>li.get(mid)){
				l = mid+1;
			} else{
				li.remove(mid);
				System.out.println(li);
				return;
			}
		}
		System.out.println(node+" not present in "+li);
	}
	public static int swap(List<Integer> li, int l,int r, int x){
		for(int i = r;i>l;i--){
			if(li.get(i)<x){
				int tmp = li.get(i);
				li.set(i,li.get(l));
				li.set(l,tmp);
				return i;
			}
		}
		return -1;
	}
				
	public static void partition(List<Integer> li, int x){
		System.out.println(li);
		int curRt = li.size();
		for(int i = 0;i<li.size();i++){
			if(li.get(i)>=x){
				curRt = swap(li,i,curRt-1,x);
				if(curRt == -1){
					break;
				}
			}
		}
		System.out.println(li);
	}
	public static void sumListsReverse(List<Integer> a,List<Integer> b){
		List<Integer> res = new LinkedList<>();
		int carry = 0, sum = 0;
		for(int i = 0,j = 0;i<a.size() || j<b.size();i++,j++){
			sum = (i<a.size()?a.get(i):0)+(j<b.size()?b.get(j):0) + carry;
			res.add(sum%10);
			carry = (int)sum/10;
		}
		if(carry>0){
			res.add(carry);
		}
		System.out.println(res);
	}
	public static void sumListsForward(List<Integer> a,List<Integer> b){
		List<Integer> res = new LinkedList<>();
		int carry = 0, sum = 0;
		for(int i = a.size()-1,j = b.size()-1;i>=0 || j>=0;i--,j--){
			sum = ((i>=0)?a.get(i):0)+(j>=0?b.get(j):0) + carry;
			res.add(sum%10);
			carry = (int)sum/10;
		}
		if(carry>0){
			res.add(carry);
		}
		Collections.reverse(res);
		System.out.println(res);
	}
	public static void checkPalindrome(List<Integer> li){
		int r = li.size()-1;
		for(int i = 0;i<li.size()/2;i++){
			if(li.get(i)!=li.get(r-i)){
				System.out.println(li+" is not a palindrome");
				return;
			}
		}
		System.out.println(li+" is a palindrome!!");
	}
			
	public static void main(String[] args){
		System.out.println("\nRemove Duplicates from an unsorted linkedlist\n");
		removeDups(new LinkedList<>(Arrays.asList(7,7,1,2,2,3,3,3,3,4,5,5)));
		
		System.out.println("\nkth last element\n");
		kthlast(new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,9,0)),3);
		
		System.out.println("\n Remove a specific node\n");
		removeNode(new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,9,0)),2);
		
		System.out.println("\n Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.\n");
		partition(new LinkedList<>(Arrays.asList(3,5,8,5,10,2,1)),5);
		partition(new LinkedList<>(Arrays.asList(10,9,8,7,6,5,4)),10);
		
		System.out.println("\n sum of lists [6,1,9] is 916 and [2,9,5] is 592 and sum is = 1508 [8,0,5,1]\n");
		sumListsReverse(new LinkedList<>(Arrays.asList(6,1,9)),new LinkedList<>(Arrays.asList(2,9,5)));
		
		System.out.println("\n sum of lists [9,1,6] is 916 and [5,9,2] is 592 and sum is = 1508 [1,5,0,8]\n");
		sumListsForward(new LinkedList<>(Arrays.asList(9,1,6)),new LinkedList<>(Arrays.asList(5,9,2)));
		sumListsForward(new LinkedList<>(Arrays.asList(9)),new LinkedList<>(Arrays.asList(1,0)));
		
		System.out.println("\n Check Palindrome \n");
		checkPalindrome(new LinkedList<>(Arrays.asList(1,2,3,4,3,2,1)));
		checkPalindrome(new LinkedList<>(Arrays.asList(1,2,3,3,2,1)));
		checkPalindrome(new LinkedList<>(Arrays.asList(1,2,3,4,5,2,1)));
		checkPalindrome(new LinkedList<>(Arrays.asList(1)));
		checkPalindrome(new LinkedList<>(Arrays.asList(1,2)));
		checkPalindrome(new LinkedList<>(Arrays.asList(1,1)));
		checkPalindrome(new LinkedList<>());
	}
}