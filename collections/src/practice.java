import java.util.*;
class sortComparator implements Comparator<Map.Entry<List<Integer>,Integer>>{
	public int compare(Map.Entry<List<Integer>,Integer> e1,Map.Entry<List<Integer>,Integer> e2) {
		return e1.getValue().compareTo(e2.getValue());
	}
}
class sort3d implements Comparator<List<List<Integer>>>{
	public int compare(List<List<Integer>> m1, List<List<Integer>> m2) {
		if(m1.size()<m2.size()) {
			return -1;
		}
		else if(m1.size()>m2.size()) {
			return 1;
		}
		return 0;
	}
}
public class practice {
	public static void q1_operations(List<List<Integer>> li) {
		HashMap<List<Integer>,Integer> hm = new HashMap<>();
		//search an element
		for(int i = 0;i<li.size();i++) {
			hm.put(li.get(i), li.get(i).size());
			System.out.println(li.get(i).contains(18));
		}
		System.out.println("Hash map set, each list: length: \n");
		System.out.println(hm);
		ArrayList<Map.Entry<List<Integer>,Integer>> ar = new ArrayList<>(hm.entrySet());
		//sorting hash map
		Collections.sort(ar, new sortComparator());
		System.out.println(ar);
		
	}
	public static void q2_operations(List<List<List<Integer>>> li) {
		HashMap<Integer,Integer> hmcount = new HashMap<>();
		for(int i = 0;i<li.size();i++) {
			for(int j = 0;j<li.get(i).size();j++) {
				for(int k = 0;k<li.get(i).get(j).size();k++)
					if(hmcount.containsKey(li.get(i).get(j).get(k)))
						hmcount.put(li.get(i).get(j).get(k),hmcount.get(li.get(i).get(j).get(k))+1);
					else
						hmcount.put(li.get(i).get(j).get(k),1);
			}
		}
		for(Map.Entry<Integer,Integer> m: hmcount.entrySet()) {
			System.out.println(m.getKey()+"  "+m.getValue()+"\n");
		}
		
		//sorting
		for(int i=0;i<li.size();i++) {
			for(int j = 0;j<li.get(i).size();j++) {
				Collections.sort(li.get(i).get(j));
			}
		}
		Collections.sort(li,new sort3d());
		System.out.println(li);

	}
	static void bfsUtil(List<List<Integer>> li) {
		Queue<List<Integer>> q = new LinkedList<List<Integer>>();
		Set<List<Integer>> visited = new HashSet<>();
		Map<List<Integer>,Integer> dist = new HashMap<>();
		q.add(Arrays.asList(0,0));
		visited.add(Arrays.asList(0,0));
		dist.put(Arrays.asList(0,0), 0);
		int nr = li.size();
		int nc = li.get(0).size();
		while(!q.isEmpty()) {
			List<Integer> adj = q.remove();
			int x = adj.get(0), y = adj.get(1);
			
			if(li.get(x).get(y) == 9) {
				System.out.println("\nshortest distance = "+dist.get(adj)+"\n");
				return;
			}
			if(x>0 && li.get(x-1).get(y)!=0 && !visited.contains(Arrays.asList(x-1,y))) {
				visited.add(Arrays.asList(x-1,y));
				dist.put(Arrays.asList(x-1,y),dist.get(adj)+1);
				q.add(Arrays.asList(x-1,y));
			}
			if(x<nr-1 && li.get(x+1).get(y)!=0 && !visited.contains(Arrays.asList(x+1,y))){
				visited.add(Arrays.asList(x+1,y));
				dist.put(Arrays.asList(x+1,y),dist.get(adj)+1);
				q.add(Arrays.asList(x+1,y));
			}
			if(y>0 && li.get(x).get(y-1)!=0 && !visited.contains(Arrays.asList(x,y-1))) {
				visited.add(Arrays.asList(x,y-1));
				dist.put(Arrays.asList(x,y-1),dist.get(adj)+1);
				q.add(Arrays.asList(x,y-1));
			}
			if(y<nc-1 && li.get(x).get(y+1)!=0 && !visited.contains(Arrays.asList(x,y+1))){
				visited.add(Arrays.asList(x,y+1));
				dist.put(Arrays.asList(x,y+1),dist.get(adj)+1);
				q.add(Arrays.asList(x,y+1));
			}
		}
		System.out.println("shortest path not found\n");
	}
	public static void main(String[] args) {
		System.out.println("\n ****************** \nhello first ques input");
		List<List<Integer>> li = new ArrayList<>();
		li.add(new ArrayList<>(Arrays.asList(4,5,6,7)));
		li.add(new ArrayList<>(Arrays.asList(8,12,14,17,18)));
		li.add(new ArrayList<>(Arrays.asList(5,18,3)));
		System.out.println(li);
		q1_operations(li);
		
		System.out.println("\n ****************** \nhello sec ques input");
		List<List<List<Integer>>> li1 = new ArrayList<>();
		List<List<Integer>> li1_inner = new ArrayList<>();
		li1_inner.add(new ArrayList<>(Arrays.asList(4,5,-1,7)));
		li1_inner.add(new ArrayList<>(Arrays.asList(8,11,9)));
		li1_inner.add(new ArrayList<>(Arrays.asList(12,13,14,15)));
		li1.add(li1_inner);
		List<List<Integer>> li1_inner1 = new ArrayList<>();
		li1_inner1.add(new ArrayList<>(Arrays.asList(4,0,6,7)));
		li1_inner1.add(new ArrayList<>(Arrays.asList(8,9)));
		li1_inner1.add(new ArrayList<>(Arrays.asList(12)));
		li1.add(li1_inner1);
		List<List<Integer>> li1_inner2 = new ArrayList<>();
		li1_inner2.add(new ArrayList<>(Arrays.asList(5,4)));
		li1_inner2.add(new ArrayList<>(Arrays.asList(8,9)));
		li1.add(li1_inner2);
		System.out.println(li1);
		q2_operations(li1);
		
		System.out.println("\n **************\n BFS to find shortest path\n");
		List<List<Integer>> li_bfs = new ArrayList<>();
		li_bfs.add(new ArrayList<>(Arrays.asList(1,1,1,1,0)));
		li_bfs.add(new ArrayList<>(Arrays.asList(0,0,0,1,0)));
		li_bfs.add(new ArrayList<>(Arrays.asList(0,9,1,1,0)));
		li_bfs.add(new ArrayList<>(Arrays.asList(0,0,0,1,0)));
		System.out.println("Start bfs: \n"+li_bfs+"\n");
		bfsUtil(li_bfs);
	}
}