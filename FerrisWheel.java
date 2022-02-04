// Ferris Wheel
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.List;
import java.util.Collections;

public class FerrisWheel {
    private static FastScanner fs = new FastScanner();
    private static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {

        int n = fs.nextInt();
        int x = fs.nextInt();
        int arr[] = fs.readArray(n);
        ruffleSort(arr);
        int l =0;
        int r =n-1;
        int ans =0;
        while(l<=r)
        {
            if(arr[r]+arr[l]<=x)
            {
                l++;
                r--;
                ans++;
            }
            else
            {
                ans++;
                r--;
            }
        }
        System.out.println(ans);
    }
    static final Random random=new Random();

    static void ruffleSort(int [] a) {
        int n=a.length;//shuffle, then sort
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n); int temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        Arrays.sort(a);
    }


    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        int [] sort(int [] arr)
        {
            List<Integer> list = new ArrayList<>();
            for(int i : arr) list.add(i);

            Collections.sort(list);
            int res[] = new int[arr.length];
            for(int i=0;i<arr.length;i++) res[i] = list.get(i);


            return res;
        }
        void debug(int a)
        {
            System.out.println("This is var "+a);
        }
    }
}