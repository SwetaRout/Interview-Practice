import java.util.*;
class videoComparator implements Comparator<Map.Entry<String,Integer>>{
	public int compare(Map.Entry<String,Integer> i1, Map.Entry<String,Integer> i2){
		return (i2.getValue()).compareTo(i1.getValue());
	}
}

public class ArraysNStrings{
	public static void checkUnique(String str){
		// extra data structure
		str = str.toUpperCase();
		HashMap<Character,Integer> hm = new HashMap<>();
		for(int i=0;i<26;i++){
			hm.put((char)(i+65),0);
		}
		for(int i=0;i<str.length();i++){
			hm.put(str.charAt(i),hm.get(str.charAt(i))+1);
			if(hm.get(str.charAt(i))>1){
				System.out.println("Not Unique\n");
				return;
			}
		}
		System.out.println("Unique\n");
	}
	public static void checkUnique1(String str){
		char[] ch = str.toCharArray();
		Arrays.sort(ch);
		for(int i = 0;i<str.length()-1;i++){
			if(ch[i]==ch[i+1]){
				System.out.println("Not Unique\n");
				return;
			}
		}
		System.out.println("Unique\n");
	}
	public static void permute(String s1, List<String> li,int l, int r){
		if(l == r){
			li.add(s1);
		}
		for(int i = l;i<=r;i++){
			s1 = swap(s1,i,l);
			permute(s1,li,l+1,r);
			s1 = swap(s1,i,l);
		}
	}
	public static String swap(String s1,int l,int r){
		char[] ch = s1.toCharArray();
		char tmp = ch[l];
		ch[l] = ch[r];
		ch[r] = tmp;
		return String.valueOf(ch);
	}
	public static void checkPermutation(String s1,String s2){
		if(s1.length() != s2.length()){
			System.out.println("\n"+s2+" is not a permutation of "+s1+" length mismatch\n");
			return;
		}			
		List<String> li = new ArrayList<>();
		permute(s1.toLowerCase(),li,0,s1.length()-1);
		System.out.println(li);
		if(li.contains(s2.toLowerCase())){
			System.out.println("\n"+s2+" is a permutation of "+s1+"\n");
		}else{
			System.out.println("\n"+s2+" is not a permutation of "+s1+"\n");
		}
			
	}
	public static void replaceSpaces(String s1){
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<s1.length();i++){
			if(s1.charAt(i) == ' '){
				sb.append("%20");
			}else{
				sb.append(s1.charAt(i));
			}
		}
		System.out.println("\n old str = "+s1+" New Str = "+sb.toString());
	}
	public static void checkPermutationPalindromes(String str){
		List<String> li = new ArrayList<>();
		permute(str.toLowerCase(),li,0,str.length()-1);
		for(int i = 0;i<li.size();i++){
			StringBuilder sb = new StringBuilder(li.get(i));
			String rev = (sb.reverse().toString()).replaceAll(" ","");
			if((li.get(i).replaceAll(" ","")).equals(rev)){
				System.out.println("\n Permutation Palindrome exists\n");
				return;
			}
		}
		System.out.println("\n Permutation Palindrome does not exist\n");
	}
	public static void checkNumOfEdits(String s1, String s2){
		int l1,l2,ct=0,j = 0;
		if(s1.length()>=s2.length()){
			l1 = s1.length();
			l2 = s2.length();
		} else{
			l1 = s2.length();
			l2 = s1.length();
		}
		if(l1-l2 >1){
			System.out.println("Wrong length\n");
			return;
		}
		for(int i = 0;i<l2 && j<l1;i++,j++){
			if(s1.charAt(j)!=s2.charAt(i)){
				ct++;
			}
			if((j+1)<l1 && s1.charAt(j+1) == s2.charAt(i)){
				j++;
			}
		}
		if(ct>1){
			System.out.println("No, "+ct);
			return;
		}
		System.out.println("Yes, "+ct);
			
	}
	public static void compressString(String str){
		HashMap<Character,Integer> hm = new HashMap<>();
		for(int i =0;i<26;i++){
			hm.put((char)(i+65),0);
			hm.put((char)(i+97),0);
		}
		for(int i = 0;i<str.length();i++){
			hm.put(str.charAt(i),hm.get(str.charAt(i))+1);
		}
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Character,Integer> m:hm.entrySet()){
			if(m.getValue()>0){
				sb.append(m.getKey());
				sb.append(m.getValue());
			}
		}
		System.out.println(sb.toString());
		if(sb.toString().length()>str.length()){
			System.out.println("Not compressed");
			return;
		}
		System.out.println("Compressed");
	}
	public static void zeroMatrix(int[][] arr){
		Set<int[]> hs = new HashSet<>();
		for(int i = 0;i<arr.length;i++){
			for(int j = 0;j<arr[0].length;j++){
				if(arr[i][j]==0){
					hs.add(new int[]{i,j});
				}
			}
		}
		for(int[] xy:hs){
			int x = xy[0],y = xy[1];
			for(int j = 0;j<arr[0].length;j++){
				arr[x][j]=0;
			}
			for(int j = 0;j<arr.length;j++){
				arr[j][y]=0;
			}
		}
		for(int i = 0;i<arr.length;i++){
			for(int j = 0;j<arr[0].length;j++){
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
	public static void rotate90(int[][] arr){
		int n = arr.length;
		for(int i = 0;i<arr.length/2;i++){
			for(int j = i;j<n-1-i;j++){
				int tmp = arr[i][j];
				arr[i][j] = arr[j][n-1-i];
				arr[j][n-1-i] = arr[n-1-i][n-1-j];
				arr[n-1-i][n-1-j] = arr[n-1-j][i];
				arr[n-1-j][i]=tmp;
			}
		}
		for(int i = 0;i<arr.length;i++){
			for(int j = 0;j<arr[0].length;j++){
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
	public static void rotateStr(String str){
		int len = str.length();
		System.out.println("Rotations of string : "+str);
		for(int i = 0;i<len;i++){
			int k = 0;
			StringBuffer sb = new StringBuffer();
			for(int j = i;j<len;j++,k++){
				sb.insert(k,str.charAt(j));
			}
			for(int j = 0;j<i;j++,k++){
				sb.insert(k,str.charAt(j));
			}
			System.out.println(sb);
		}
	}
	public static int LCS(char[] a, char[] b,int l1, int l2){
		if(l1 == 0 || l2 == 0){
			return 0;
		}
		if(a[l1-1]==b[l2-1])
			return 1+LCS(a,b,l1-1,l2-1);
		return max(LCS(a,b,l1-1,l2),LCS(a,b,l1,l2-1));
	}
	public static int max(int x, int y){
		return (x>y)?x:y;
	}
	public static int partitionsum(int arr[]){
		if(arr.length == 0)
			return 0;
		int sum  =0;
		for(int i = 0;i<arr.length;i++){
			sum  = sum+arr[i];
			int subsum = 0;
			for(int j = i+1;j<arr.length;j++){
				subsum = subsum+arr[j];
				if((j+1)%(i+1)==0){
					if(subsum!=sum)
						break;
					if(j == arr.length-1)
						return sum;
					subsum=0;
				}
			}
		}
		return sum;
	}
	public static void kWatchRates(List<String> videos, List<Integer> watch,int k){
		if(videos.size()!=watch.size())
			return;
		if(k>videos.size())
			return;
		HashMap<String,Integer> hm = new HashMap<>();
		for(int i = 0;i<videos.size();i++){
			hm.put(videos.get(i),watch.get(i));
		}
		int ct = 0;
		List<Map.Entry<String,Integer>> li = new ArrayList<>(hm.entrySet());
		Collections.sort(li,new videoComparator ());
		for(Map.Entry<String,Integer> m:li){
		System.out.println(m.getKey());
		ct++;
		if(ct == k)
			break;
		}
	}

	public static void main(String[] args){
		System.out.println("\n\nCheck if a string contins unique chars\n\n");
		System.out.println("\n\nUsing hash map\n\n");
		checkUnique("abcde");
		checkUnique("abcdeee");
		checkUnique("abCcde");
		System.out.println("\n\nUsing sorting\n\n");
		checkUnique1("abcde");
		checkUnique1("abcdeee");
		checkUnique1("abCcde");
		
		System.out.println("\n\n permute a string and check if a string is a permuatation of another string\n\n");
		checkPermutation("abccd","adb");
		checkPermutation("abccd","adccb");
		checkPermutation("aBccd","adccb");
		checkPermutation("abccd","ccccc");
		
		System.out.println("\n\n replace all spaces in the string with %20 \n\n");
		replaceSpaces("sweta loves anup but anup does not love sweta");
		
		System.out.println("\n\n permute a string and check if a string is a permuatation of another string\n\n");
		checkPermutationPalindromes("abccd");
		checkPermutationPalindromes("abccd");
		checkPermutationPalindromes("Tact Coa");
		
		System.out.println("\n\nThere are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.\n\n");
		checkNumOfEdits("pales","pale");
		checkNumOfEdits("pale","ple");
		checkNumOfEdits("pale","bale");
		checkNumOfEdits("pale","bake");
		checkNumOfEdits("palestine","pletnesp");
		
		System.out.println("\n\n String Compression\n\n");
		compressString("aabcccccaaa");
		compressString("abbc");
		compressString("abcdefg");
		
		System.out.println("\n\n Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.\n\n");
		int[][] mat = new int[][]{{1,2,3,4,5},{0,6,7,8,9},{5,6,7,0,8}};
		zeroMatrix(mat);
		
		System.out.println("\n\n Rotate matrix by 90 degrees \n\n");
		int[][] mat1 = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		rotate90(mat1);
		
		System.out.println("\n\n All possible string rotations \n\n");
		rotateStr("abcde");
		
		System.out.println("\n\n Longest common subseuequence \n\n");
		System.out.println("Length of common subsequence is " + LCS("ababcd".toCharArray(),"dbabce".toCharArray(),6,6));
		
		System.out.println("Equal partitions\n");
		System.out.println(partitionsum(new int[]{1,3,2,2,1,3}));
		
		System.out.println("\n top k videos\n");
		kWatchRates(new LinkedList<String>(Arrays.asList("abc","def","pqrs","sr","fgh")),new LinkedList<Integer>(Arrays.asList(5,3,6,8,1)),3);
	}
}