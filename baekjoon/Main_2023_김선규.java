import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2023_김선규 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> s = new Stack<>();
		Stack<Integer> tmp = new Stack<>();
		int[] ans = new int[N];
		int max = 0;
		int befo = 0;
		for(int i =0; i<N; i++) {
			int n = Integer.parseInt(st.nextToken()); //i=2, n=5
			
			
			if(s.isEmpty()) {
				ans[i] = 0;
				befo = ans[i];
				max = n;
			}
				
			if(!s.isEmpty() && s.peek() >= n) { //peek = 9 , n = 5
				ans[i] = s.size();
				max = (max > n) ? max : n;  
			}
			else if(!s.isEmpty() && s.peek() < n) {
				ans[i] = befo;
			}
			
			s.add(n);
			
			System.out.print(i+" "+n+" "+max+" "+ans[i]+" "+s);
			System.out.println();
		}
		
//		
//		System.out.println();
//		for(int i : ans)
//			System.out.println(i);
		// 초기화
//		
//		
//		int n = 0;
//		int high = 0;
//		
//		for(int i=N-1; i>=0; i--) {
//			max = (max > tap[i]) ? max : tap[i];  
//			
//			if(tap[i] > max) {
//				
//			}
//			
//			
//			
//			if(i==0) {
//				ans[i] = 0;
//				max = n;
//			}
//			if(max < n) { //i=2
//				max = n; //9
//				high = i+1; //1
//				ans[i] = 0;
//			}
//			if(max >= n){ //i=2
//				ans[i] = high;
//			}
//			
//			
//		}
//		
//		for(int i : ans)
//			System.out.println(i);
		
	}

}
