import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

/*

1 2 4 3
0 3 4 3
0 6 4 0
0 10 0 0

1 2 4 3
0 2 4 4
0 0 4 6
0 0 0 10

1 2 3 4
1 3 6 10

1 2 3 4

 */

public class AuthorSol {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt();
			int[] a = fs.readArray(n);
			int[] b = a.clone();
			shuffleSort(a);
			int low = -1, high = n - 1;
			while (high - low > 1) {
				int mid = (low + high) / 2;
				if (win(mid, a)) {
					high = mid;
				} else {
					low = mid;
				}
			}
			ArrayList<Integer> winPlayers = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (b[i] >= a[high]) {
					winPlayers.add(i + 1);
				}
			}
			out.println(winPlayers.size());
			for (int x : winPlayers) {
				out.print(x + " ");
			}
			out.println();
		}
		out.close();
	}
	
	static boolean win(int mid, int[] a) {
		long power = a[mid];
		for (int i = 0; i < a.length; i++) {
			if (i == mid) {
				continue;
			}
			if (power < a[i]) {
				return false;
			}
			power += a[i];
		}
		return true;
	}
	
	static final Random rnd = new Random();
	
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
