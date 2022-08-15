import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10820_김선규 {

	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = "";
		while ((s=br.readLine()) != null) {
			int a = 0, b = 0, c = 0, d = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) >= 97 && s.charAt(i) <= 122)
					a++;
				else if (s.charAt(i) >= 65 && s.charAt(i) <= 90)
					b++;
				else if (s.charAt(i) >= 48 && s.charAt(i) <= 57)
					c++;
				else if (s.charAt(i) == ' ')
					d++;
			}
			sb.append(a + " ").append(b + " ").append(c + " ").append(d);
			System.out.println(sb);
			sb = new StringBuilder();
		}
	}
}