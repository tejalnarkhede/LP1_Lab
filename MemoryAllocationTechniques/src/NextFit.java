import java.util.Arrays;

public class NextFit {
	
	public static void NextFit(int[] processSize, int m, int[] blockSize, int n) {
		// TODO Auto-generated method stub
		int[] allocation=new int[n];
		int j=0;
		Arrays.fill(allocation, -1);
		
		for(int i=0;i<n;i++)
		{
			int count=0;
			while(j<m)
			{
			
				if(blockSize[j]>=processSize[i])
				{
					allocation[i]=j;
					blockSize[j]-=processSize[i];
					break;
				}
				
				j=(j+1)%m; 	
			
			}
			
		}
		 System.out.print("\nProcess No.\tProcess Size\tBlock no.\n");
	        for (int i = 0; i < n; i++) {
	            System.out.print( i + 1 + "\t\t" + processSize[i]
	                    + "\t\t");
	            if (allocation[i] != -1) {
	                System.out.print(allocation[i] + 1);
	            } else {
	                System.out.print("Not Allocated");
	            }
	            System.out.println("");
	        }

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int blockSize[] = {5, 10, 20};
	     int processSize[] = {10, 20, 5};
	     int n = blockSize.length;
	     int m = processSize.length;
	     NextFit(processSize, m, blockSize, n);
		
	}

}
