package A1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
//ULAS CEM ERTEN 2256006 - CNG 462
public class String_tracking {
	static int bfsexpand=0;
	static int ucsexpand=0;
	static ArrayList<Star_hold> Expanded = new ArrayList<Star_hold>();
	static ArrayList<Star_hold> Visited = new ArrayList<Star_hold>();
	static int bfscost=0 ;
	static Scanner s = null;
    static String ing=null;
    static String line=null ;
    static  Star_hold[][] Union=new Star_hold[10][9];
    static 	Star_hold[] Letters= new Star_hold[4];
    static int Graph[][] = new int[4][4];
    static  char[] BfsNodes = new char[5];
    static  Scanner scanner;
	static char cv;
	static int uniformcostsearch(int[][] Graph, boolean[] checkvisited,  int position, int cur,   int lsize, int cost, int ucscost)  
           
            
{ 


 if (lsize == cur && Graph[position][0] > 0)  
 {  
	 ucscost = Math.min(ucscost, cost + Graph[position][0]); 
     return ucscost; 
 } 


 for (int i = 0; i < cur; i++)  
 { 
     if (checkvisited[i] == false && Graph[position][i] > 0)  
     { 

         // Mark as visited 
    	 checkvisited[i] = true; 
    	
    	  
         ucscost = uniformcostsearch(Graph, checkvisited, i, cur, lsize + 1,  cost + Graph[position][i], ucscost); 
         ucsexpand++;  
         
       
         checkvisited[i] = false; 
     } 
   
 } 
 
 return ucscost; 
} 
    public static Star_hold calculatevisit(Star_hold d) { // n is next d is destination
    	int i;
    	
    	int pos=0;
    	float min=(float) Math.sqrt((Expanded.get(0).x-d.x)*(Expanded.get(0).x-d.x)+(Expanded.get(0).y-d.y)*(Expanded.get(0).y-d.y))+Expanded.get(0).mintotalpath;;
    	 
    	Star_hold temp1= new Star_hold();
    	
    	for(i=0;i<Expanded.size();i++) {
    		
    		
    		float b =  (float) Math.sqrt((Expanded.get(i).x-d.x)*(Expanded.get(i).x-d.x)+(Expanded.get(i).y-d.y)*(Expanded.get(i).y-d.y));
    		
    		
    		
    		if(b<min) {
    			min = b;
    			temp1= Union[Expanded.get(i).x][Expanded.get(i).y];
    			pos=i;
    		}
    	}
    	Expanded.remove(pos);
    	return temp1;
    }
    public static int pathcost() {
    	return 1;
    }
   
    
  
    public static int BreadthFirstSearch(Star_hold s,int n) {
    	int i,a,b;
    	Star_hold temp = new Star_hold();
    	bfsexpand++;
    	if(n==3) {
    		
    		System.out.print(Letters[n].ch+"-"+ Letters[0].ch);
    		BfsNodes[n]=Letters[n].ch;
    		BfsNodes[n+1]=Letters[n-n].ch;
    		bfscost=bfscost+Graph[n][n-n];
    		
    		return bfscost;
    	}
    	
    	else {
    		//bfscost=bfscost+shortestpath(Letters[n],Letters[n+1]);
    		
    		int c1=n+1;
    		for(i=0;i<3;i++) {
    			bfsexpand++;
    			if((int)Letters[i].ch>=(int)Letters[i+1].ch) {
    				
    				 c1=i;
    			}
    		}
    		bfsexpand++;
    		bfscost=bfscost+Graph[n][c1];
    		System.out.print(Letters[n].ch + "-");
    		BfsNodes[n]=Letters[n].ch;
    		
    		//
    		
    		
    		return BreadthFirstSearch(Letters[n+1],n+1);
    		
    	}
    	
    	
    	
    	}
    	
    		
    	
    	
    
    public static int shortestpath(Star_hold s,Star_hold d) { // s is source d is destination
    	
    		
    		if(s.ch==d.ch) {
    			 
    			return s.mintotalpath;
    			
    		}
    	   
    		
    		if(Union[(s.x)+1][s.y].ch!='*'&&Union[(s.x)+1][s.y].vis==false) {
    			//System.out.print(Union[(s.x)+1][(s.y)].ch);
    			Expanded.add(Union[(s.x)+1][s.y]);
    			Union[(s.x)+1][s.y].mintotalpath=Union[(s.x)][s.y].mintotalpath + 1;
    			Union[(s.x)+1][s.y].vis=true;
    			
    		}
    		if(Union[(s.x)][(s.y)+1].ch!='*'&&Union[(s.x)][(s.y)+1].vis==false) {
    			//System.out.print(Union[(s.x)][(s.y)+1].ch);
    			Expanded.add(Union[(s.x)][(s.y)+1]);
    			Union[(s.x)][(s.y)+1].mintotalpath=Union[(s.x)][s.y].mintotalpath + 1;
    			Union[(s.x)][(s.y)+1].vis=true;
    		}
    		if(Union[(s.x)][(s.y)-1].ch!='*'&&Union[(s.x)][(s.y)-1].vis==false) {
    			//System.out.print(Union[(s.x)][(s.y)-1].ch);
    			Expanded.add(Union[(s.x)][(s.y)-1]);
    			Union[(s.x)][(s.y)-1].mintotalpath=Union[(s.x)][s.y].mintotalpath + 1;
    			Union[(s.x)][(s.y)-1].vis=true;
    		}
    		if(Union[(s.x)-1][s.y].ch!='*'&&Union[(s.x)-1][s.y].vis==false) {
    			//System.out.print(Union[(s.x)-1][(s.y)].ch);
    			Expanded.add(Union[(s.x)-1][s.y]);
    			Union[(s.x)-1][s.y].mintotalpath=Union[(s.x)][s.y].mintotalpath + 1;
    			Union[(s.x)-1][s.y].vis=true;
    		}
    		s=calculatevisit(d);
    		//shortestpath(s,d);
    		
    		return shortestpath(s,d);
    	
    	
    }
	public static void main(String[] args) throws IOException {
		int i;
		int j;
	scanner = new Scanner(new File("map.txt"));
	while (scanner.hasNextLine()) {
	
   
                              
	for(i=0;i<10;i++) {
		 line = scanner.nextLine();
		 String sd;
		int a=0,b=1;
		for(j=0;j<9;j++) {
			sd=line.substring(a,b);
			cv=sd.charAt(0);
			Union[i][j]=new Star_hold(cv,i,j);
			a++;
			b++;
			//System.out.print(Union[i][j].get_ch());
			}
		}
	}

int k=0;
for(i=0;i<10;i++) {
	
	for(j=0;j<9;j++) {
		if(Union[i][j].get_ch()=='A'||Union[i][j].get_ch()=='B'||Union[i][j].get_ch()=='C'||Union[i][j].get_ch()=='D') {
			Letters[k] = new Star_hold(Union[i][j].get_ch(),i,j);
			k++;
		}
	}
} 
for(i=0;i<10;i++) {
	
	for(j=0;j<9;j++) {
		System.out.print(Union[i][j].get_ch());
		}
	System.out.println("");
	}
Star_hold temp = new Star_hold();
for(j=1; j<4; j++)
{
    for(k=0; k<4-j; k++)
    {
        if((int)Letters[k].ch>=(int)Letters[k+1].ch)
        {
            temp=Letters[k];
            Letters[k]=Letters[k+1];
            Letters[k+1]=temp;
        }
    }
}

int a,b;
for(i=0;i<4;i++) {
	for(j=i+1;j<4;j++) {
		
		System.out.println(Letters[i].get_ch() + ","+ Letters[j].get_ch() + "," + shortestpath(Letters[i],Letters[j]));
		
		for(a=0;a<10;a++) {
			for(b=0;b<9;b++) {
				Union[a][b].vis=false;
				Union[a][b].mintotalpath=0;
				
			}
		}
		Expanded.clear();
	}
	
}
/*for(i=0;i<4;i++) {
	System.out.print(Letters[i].get_ch());
}*/
for(i=0;i<4;i++) {
	for(j=0;j<4;j++) {
		Graph[i][j]=shortestpath(Letters[i],Letters[j]);
		for(a=0;a<10;a++) {
			for(b=0;b<9;b++) {
				Union[a][b].vis=false;
				Union[a][b].mintotalpath=0;
				
			}
		}
		Expanded.clear();
	}
}
/*for(i=0;i<4;i++) {
	for(j=0;j<4;j++) {
		System.out.print(Graph[i][j]);
	}
	System.out.print("\n");
}*/


   

//System.out.print(shortestpath(Letters[4],Letters[0]));

//Breadth first Search
System.out.println("Algorithm Used: BFS");
long startTime = System.nanoTime();
bfsexpand++;
int bfs = BreadthFirstSearch(Letters[0],0);
int bfsexpandf=bfsexpand;
long endTime = System.nanoTime();

long duration = (endTime - startTime);

System.out.println("\tTotal Tour Cost:  "+bfs);

System.out.println("Algorithm Used: UCS");

ucsexpand=0;
bfsexpand=0;
BreadthFirstSearch(Letters[0],0);


boolean[] checkvisited = new boolean[4];
checkvisited[0] = true; 
int ucscost = 10000;
int size=4;


long startTime1 = System.nanoTime();
ucsexpand++;   
ucscost = uniformcostsearch(Graph, checkvisited, 0, size, 1, 0, ucscost); 
System.out.println("\tTotal Tour Cost:   "+ucscost);
long endTime1 = System.nanoTime();
long duration1=endTime1-startTime1;
System.out.println("Statistics:\n\tNodes\t\t time\t\t cost");

System.out.println("BFS\t"+bfsexpandf+"\t\t "+duration/1000+" ms\t\t "+bfs);



System.out.println("UCS\t"+ucsexpand+"\t\t "+duration1/1000+" ms\t\t "+ucscost);








	
	}


}