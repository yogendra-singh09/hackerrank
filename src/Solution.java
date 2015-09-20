import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	static Scanner sc = new Scanner(System.in);
	
    public static void main(String[] args) {
    
    	
    	int tc, len,arr[];
    	tc = Integer.parseInt(sc.nextLine().trim());
    	for(int i=0;i<tc;i++){
    		len = Integer.parseInt(sc.nextLine().trim());
    		System.out.println(getLen(len));
    	}
    	
    	
    	
    }

    static int getLen(int N) {
        int n=0;
    	int d;
        int _n=N;
        while(_n>0){
        	d = _n%10;
        	_n = _n/10;
        	//System.out.println(_n +" "+ d);
        	if(d!=0 && N%d==0){
        		n++;
        	}
        }
        return n;
    }
}