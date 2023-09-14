import java.util.Scanner;
public class RoundRobin
{
	public static void main(String[] args)
	{
		int wt[],bt[] = null,tat[],rem_bt[],n=0,qt=0,sq=0,temp=0,count=0,i,avg_wt = 0,avg_tat =0;
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter number of Processes:");
		n=sc.nextInt();
		
		 bt=new int[n];
		 wt=new int[n];
		 tat=new int[n];
		 rem_bt=new int[n];
		
		for(i=0;i<n;i++)	
		{
			System.out.println("\nEnter Burst time for Process P"+(i+1)+":");
			bt[i]=sc.nextInt();
			rem_bt[i]=bt[i];
		}
		
		System.out.println("\nEnter Quantum Time:");
		qt=sc.nextInt();
		
		while(true)
		{
			for(i=0,count=0;i<n;i++)
			{
				temp=qt;
				if(rem_bt[i]==0)
				{
					count++;
					continue;
				}
				if(rem_bt[i]>qt)
					rem_bt[i]=rem_bt[i]-qt;
				if(rem_bt[i]>=0)
				{
					temp=rem_bt[i];
					rem_bt[i]=0;
					
				}
				sq=sq+temp;
				tat[i]=sq;
				
			}
			if(n==count)
				break;
		}
		
		for(i=0;i<n;i++)
		{
			wt[i] += tat[i]-bt[i];
			avg_wt += avg_wt+wt[i];
			avg_tat += avg_tat+tat[i];
			
		}
		
		avg_wt=avg_wt/n;
		avg_tat=avg_tat/n;
		
		System.out.println("------------------------------------------------------------------");
		System.out.println("\nProcess \tBurst Time \tTurnaround Time \tWaiting Time");
		System.out.println("------------------------------------------------------------------");
		for(i=0;i<n;i++)
		{
		System.out.println("P"+(i+1)+"\t\t"+bt[i]+"\t\t"+tat[i]+"\t\t"+wt[i]);
		
		}
		System.out.println("\nAverage Waiting time:"+avg_wt);
		System.out.println("\nAverage Turnaround Time:"+avg_tat);
		
	}
}