import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_21919_김선규 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int max = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		// input end
		
		boolean[] check = new boolean[max+1];  // 배열의 최댓값만큼 boolean 배열 선언. 아리스토체네스의 체로 소수인지 판별하기 위함
		check[0] = check[1] = true;
		
		for(int i=2; i*i<=max; i++) {
			for(int j=i*i; j<=max; j+=i) {
				check[j] = true; // 소수가 아니면 true/ 소수면 false
			}
		}
		
		int cnt=0;
		ArrayList<Integer> primeList = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			if(!check[arr[i]]) {// i가 소수면 리스트에 집어넣음
				primeList.add(arr[i]);
				cnt++;
			}
		}
		long[] prime = new long[cnt];
		for(int i=0; i<prime.length; i++) // 리스트를 매개변수로 넘길수 있을까? 고민하다 안되는 거 같아서 새로운 배열을 만들어서 배열을 매개변수로 넘겼다.
			prime[i] = primeList.get(i);
		
		if(primeList.size()==0) // 소수가 존재하지 않는다면 -1 출력
			System.out.println(-1);
		else { // 소수가 존재한다면 최소공배수 구하기
			System.out.println(lcm(prime));
		}
	}
	
	public static long gcd(long a, long b) { // 최대공약수 구하기 : 유클리드 호제법
		
		if(b==0)
			return a;
		
		return gcd(b, a % b);
	}
	
	public static long lcm(long[] prime) { // 최소공배수 구하기 : 유클리드 호제법
		long gcd = gcd(prime[0], prime[1]);
		long lcm = (prime[0] * prime[1]) / gcd;
		
		for(int i=2; i<prime.length; i++) {
			gcd = gcd(gcd, prime[i]);
			lcm = (lcm * prime[i]) / gcd;
		}
		
		return lcm;
	}

}
