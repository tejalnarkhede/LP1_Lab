import java.util.Scanner;

public class SJF {
	public static void main(String[] args)
	{
		int no,pos,total_comp = 0,temp,WT[],TT[],burst_time[],CT[],avg_CT,process[],AT[],total_WT=0,total_TT = 0;
		float avg_WT,avg_TT;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of processes:");
		no=sc.nextInt();
		WT=new int[no];
		CT=new int[no];
		TT=new int[no];
		process=new int[no];
		burst_time=new int[no];
		AT=new int[no];
		
		for(int i=0;i<no;i++)
		{
			System.out.println("Enter burst time for process P"+(i+1)+":");
			burst_time[i]=sc.nextInt();
			System.out.println("Enter arrival time for process P"+(i+1)+":");
			AT[i]=sc.nextInt();
			process[i]=i+1;
		}
		
		//sorting
		for(int i=0;i<no;i++)
		{
			pos=i;
			for(int j=i+1;j<no;j++)
			{
				if(burst_time[pos] > burst_time[j])
				{
					pos=j;
				}
				temp=burst_time[i];
				burst_time[i]=burst_time[pos];
				burst_time[pos]=temp;
				
			}
		}
		
		for(int i=1;i<no;i++)
		{
			CT[i]=0;
			for(int j=0;j<i;j++)
			{
				CT[i] += burst_time[j];
			    total_comp += CT[i];
			}
		}
		
		for(int i=1;i<no;i++)
		{
			WT[i]=0;
			for(int j=0;j<no;j++)
			{
				WT[i] += burst_time[j];
			    total_WT += WT[i];
				
			}
		}
		for(int i=0;i<no;i++)
		{
			TT[i]=burst_time[i]+WT[i];
		 //Calculating Turnaround Time
			 total_TT += TT[i];
		     System.out.println("\n"+process[i]+"\t\t "+burst_time[i]+"\t\t "+CT[i]+"\t\t"+WT[i]+"\t\t "+TT[i]);
		}

		//Calculating Average waiting time
		avg_WT=(float)total_WT/no;
		avg_TT=(float)total_TT/no;
		
		//Calculation of Average Turnaround Time
		System.out.println("\n\nAverage waiting time: "+avg_WT);
		System.out.println("\nAverage Turnaround time: "+avg_TT);

	}
}
