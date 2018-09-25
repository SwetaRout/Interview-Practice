
import java.util.*;
class minStack{
	Stack<Integer> st;
	int minVal;
	public minStack(){
		st = new Stack<>();
		minVal = Integer.MAX_VALUE;
	}
	public void push(int x){
		if(x<minVal){
			st.push(minVal);
			minVal = x;
		}
		st.push(x);
		System.out.println("Pushed "+x+" stack: "+st);
	}
	public void pop(){
		if(st.isEmpty()){
			System.out.println("Stack empty");
			return;
		}
		int poppedNum = st.pop();
		if(poppedNum == minVal){
			minVal = st.pop();
		}
		System.out.println("Popped "+poppedNum+" stack: "+st);
	}
	public void min(){
		System.out.println("MInVal: "+minVal);
	}
}
class SetOfStacks{
	Stack<Stack<Integer>> sos;
	int caps;
	public SetOfStacks(int capacity){
		caps = capacity;
		sos = new Stack<>();
	}
	public void push(int x){
		if(sos.isEmpty() || sos.peek().size()==caps){
			Stack<Integer> st = new Stack<Integer>();
			sos.push(st);
		}
		sos.peek().push(x);
		System.out.println("push "+x+" stack: "+sos);
	}
	public void pop(){
		if(sos.isEmpty()){
			System.out.println("Set of stacks is empty");
			return;
		}
		if(sos.peek().isEmpty()){
			System.out.println(" Remove an inner stack");
			sos.pop();
			if(sos.isEmpty()){
				System.out.println("Set of stacks is empty");
				return;
			}
		}
		int poppedNum = sos.peek().pop();
		System.out.println("poppedNum "+poppedNum+" stack: "+sos);
	}	
	public	void popAt(int index){
		if(index<0 || index>=sos.size() || sos.isEmpty()){
			System.out.println("Index out of bounds or stack is empty");
			return;
		}
		List<Stack<Integer>> li = new ArrayList<>(sos);
		if(li.get(index).isEmpty()){
			System.out.println(index+" stack is empty");
		}
		int poppedNum = li.get(index).pop();
		System.out.println("poppedNum "+poppedNum+" stack: "+sos);
	}
}
class AnimalShelter{
	List<Character> li;
	public AnimalShelter(Character[] ch){
		li = new LinkedList<Character>(Arrays.asList(ch));
		System.out.println(li);
	}
	public void dequeue(){
		char c = li.remove(0);
		System.out.println("Adopt oldest = "+c);
	}
	public void dequeueDog(){
		System.out.println(li);
		for(int i = 0;i<li.size();i++){
			if(li.get(i)=='D'){
				li.remove(i);
				System.out.println("ADOPT DOG : "+i);
				return;
			}
		}
	}
	public void dequeueCat(){
		System.out.println(li);
		for(int i = 0;i<li.size();i++){
			if(li.get(i)=='C'){
				li.remove(i);
				System.out.println("ADOPT CAT : "+i);
				return;
			}
		}
	}
}
public class StacksNQueues{
	public static void sortStack(Stack<Integer> st){
		System.out.println("Input stack = "+st);
		Stack<Integer> res = new Stack<>();
		int st_element = st.pop();
		while(!st.empty()){			
			for(int i = 0;i<st.size();i++){
				int st_next = st.pop();
				if(st_element>st_next){
					res.push(st_element);
					st_element = st_next;
				} else{
					res.push(st_next);
				}
			}
		}
		res.push(st_element);
		System.out.println("Sorted stack = "+res);
	}
	public static void main(String[] args){
		System.out.println("\nstack operatins\n");
		minStack mst = new minStack();
		mst.push(2);
		mst.push(5);
		mst.pop();
		mst.push(5);
		mst.push(3);
		mst.push(1);
		mst.min();
		mst.pop();
		mst.min();
		mst.pop();
		mst.min();
		System.out.println("\n SetOfStacks \n");
		SetOfStacks sos = new SetOfStacks(3);
		sos.push(1);		sos.push(1);		sos.push(1);
		sos.push(2);		sos.push(2);		sos.push(2);
		sos.push(3);		sos.push(3);		sos.push(3);
		sos.push(4);		sos.push(4);		sos.push(4);
		sos.popAt(0);		sos.popAt(1);		sos.popAt(2);		sos.popAt(3);		sos.popAt(4);
		sos.pop();		sos.pop();		sos.pop();
		sos.pop();		sos.pop();		sos.pop();
		sos.pop();		sos.pop();		sos.pop();
		sos.pop();		sos.pop();		sos.pop();
		sos.pop();
		System.out.println("\n sort stack \n");
		Stack<Integer> st = new Stack<>();
		for(int i = 0;i<10;i++){
			st.push(i);
		}
		sortStack(st);
		System.out.println("\n Animal Shelter \n");
		AnimalShelter as = new AnimalShelter(new Character[]{'D','C','D','D','C','C','C','D','D','D','C','D','D'});
		as.dequeue();
		as.dequeueDog();
		as.dequeueCat();
	}
}
