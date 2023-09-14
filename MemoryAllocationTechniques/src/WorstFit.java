
public class WorstFit {

	public static void firstFit(int processes[],int m,int blocks[],int n)
	{
	
		int[] allocation=new int[n];
		
		for(int i=0;i<n;i++)
			allocation[i]=-1;
		
		for(int i=0;i<processes.length;i++)
		{
			int wstIdx=-1;
			for(int j=0;j<blocks.length;j++)
			{
				if(blocks[j]>=processes[i])
				{
					if(wstIdx==-1)
						wstIdx=j;
					else if(blocks[wstIdx]<blocks[j])
						wstIdx=j;
						
				}
				
			}
			if(wstIdx!=-1)
			{	
				allocation[i]=wstIdx;
				blocks[wstIdx]-=processes[i];
			}
		}
		
		System.out.print("\nProcess no \tProcess Size \tBlock No");
		for(int i=0;i<n-1;i++)
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
		int processes[]= {112,160,278,300};
		int m=processes.length;
		int n=blocks.length;
		firstFit(processes,m,blocks,n);
			
	}
}
