
public class BestFit {

	public static void firstFit(int processes[],int m,int blocks[],int n)
	{
	
		int[] allocation=new int[n];
		for(int i=0;i<n;i++)
			allocation[i]=-1;
		for(int i=0;i<processes.length;i++)
		{
			int bestIdx=-1;
			for(int j=0;j<blocks.length;j++)
			{
				if(blocks[j]>=processes[i])
				{
					if(bestIdx==-1)
						bestIdx=j;
					else if(blocks[bestIdx]>blocks[j])
						bestIdx=j;
						
				}
				
			}
			if(bestIdx!=-1)
			{	
				allocation[i]=bestIdx;
				blocks[bestIdx]-=processes[i];
			}
		}
		
		System.out.print("\nProcess no \tProcess Size \tBlock No");
		for(int i=0;i<n;i++)
		{
			System.out.println();
			System.out.print((i+1)+"\t\t"+processes[i]+"\t\t");
			if(allocation[i]!=-1)
				System.out.print(allocation[i]+1);
			else
				System.out.print("Not Allocated");
			System.out.println("");
		}
		
	}
	
	public static void main(String[] args)
	{
		int blocks[]= {100,500,200,300,600};
		int processes[]= {212,417,112,426};
		int m=processes.length;
		int n=blocks.length;
		firstFit(processes,m,blocks,n);
			
	}
}
