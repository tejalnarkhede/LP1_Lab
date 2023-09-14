import java.util.Scanner;

public class FCFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i=0,no_p=0;
		float avg_WT=0,avg_TT=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter Number of Processes:");
		no_p=sc.nextInt();
		int[] WT=new int[no_p];
	    WT[0]=0;
		int[] TT=new int[no_p];
		System.out.println("\nEnter the Burst time for processes: ");
		int[] burst_time=new int[no_p];
		for(i=0;i<no_p;i++)
		{
			System.out.println("P"+(i+1));
			burst_time[i]=sc.nextInt();
		}
		
		for(i=1;i<=no_p-1;i++)
		{
//			if(i==4)
//				break;
			WT[i]=WT[i-1]+burst_time[i-1];
			avg_WT += WT[i];
		}
		avg_WT/=no_p;
		
		for(i=0;i<no_p;i++)
		{
			TT[i]=WT[i]+burst_time[i];
			avg_TT += TT[i]; 
		}
		avg_TT/=no_p;
		
		System.out.println("********************************************************");
		System.out.println("Processes");
		System.out.println("********************************************************");
		System.out.println("Process\tBurst Time\tWaiting Time\tTurnaround Time");
		for(i=0;i<no_p;i++)
		{
		System.out.println("P"+(i+1)+"\t\t"+burst_time[i]+"\t\t"+WT[i]+"\t\t"+TT[i]);
		}
		System.out.println("\n------------------------------------------------------");
		System.out.println("Average Waiting Time:"+avg_WT);
		System.out.println("Average Turnaround Time:"+avg_TT);
		
	}

}
