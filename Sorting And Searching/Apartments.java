// Cses
// Apartments

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

public class Apartments {
    private static FastScanner fs = new FastScanner();
    private static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {
        int n =fs.nextInt(); // applicant
        int m = fs.nextInt(); // apartments
        int k = fs.nextInt();  // max Difference

        int arr[] = fs.readArray(n);
        int apartment[] = fs.readArray(m);
        ruffleSort(arr);
        ruffleSort(apartment);
        int l =0;
        int r =0;
        int ans =0;
        while(r<m && l<n)
        {
            if(arr[l]-k<= apartment[r] && arr[l]+k>= apartment[r])
            {
                ans++;
                l++;
                r++;
            }
            else if(arr[l]-k> apartment[r])
            {
                r++;
            }
            else if(apartment[r]>arr[l]+k)
            {
                l++;
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
