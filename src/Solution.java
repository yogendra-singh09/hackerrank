import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	int T;
	int N;
	long M;
	Scanner sc;

	Solution(){
		sc = new Scanner(System.in);
		//System.out.println(sc.nextLine());
	}


	int graph[][];
	void readInput(){
		T=Integer.parseInt(sc.nextLine());
		String[] temp;
		while(T-->0){
			temp= sc.nextLine().trim().split(" ");
			N= Integer.parseInt(temp[0].trim());
			M= Long.parseLong(temp[1].trim());

			buildGraph();
			dfs();
		}

	}


	private void buildGraph() {
		// TODO Auto-generated method stub
		graph  = new int[N+1][N+1];
		String[]temp;
		int i,j;
		while(M-->0){
			temp=sc.nextLine().trim().split(" ");
			i= Integer.parseInt(temp[0].trim());
			j= Integer.parseInt(temp[1].trim());
			graph[i][j]=6;
			graph[j][i]=6;
		}


	}

	boolean visited[];
	int queue[];
	int distance[];
	void dfs(){
		visited= new boolean [N+1];
		queue= new int[10000];
		distance =  new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		int s= Integer.parseInt(sc.nextLine().trim());
		int s1=s;
		int r,f;
		r=f=-1;
		queue[++r]=s;
		distance[s]=0;
		int min=Integer.MAX_VALUE;
		while(r!=f)
		{
			f++;
			//s=queue[++f];
			visited[s]=true;
			for(int i=0;i<N+1;i++){
				//System.out.println(graph[s][i]+" "+visited[i]+"i"+i);
				if(graph[s][i]>0 && !visited[i]){
					queue[++r]=i;
					int d = distance[s]+graph[s][i];
					if(d<distance[i])
						distance[i]=d;
				}

			}
			for(int x=1;x<N+1;x++){
				if(!visited[x] && min>distance[x]){
					min=Math.min(min,distance[x]);
					s=x;
				}
			}


		}



		for(int i=1;i<N+1;i++)
		{
			if(i!=s1){
				if(distance[i]!=Integer.MAX_VALUE)
					System.out.print(distance[i]);
				else
					System.out.print(-1);
				if(i!=N)
					System.out.print(" ");
			}

		}

	}


	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Solution s = new Solution();
		s.readInput();

	}
}