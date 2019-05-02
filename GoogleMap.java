/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlemap;

// **** MINI PROJECT SEM2 *****
//package ProjectSem2;
import java.util.*;
class node{
	int d;
	String city;
	node next;
	node(int d,String city)
	{
		this.d=d;
		this.city=city;
		next=null;
	}
}
 class Graph {
 
 Scanner s=new Scanner(System.in);
 
 int adj_m[][]=new int[20][20];
	int []visited;
	int num_v;
	node temp,ptr,head;
	Graph()
	{
		head=null;
		temp=null;
		ptr=null;
	}
	Scanner sc=new Scanner(System.in);
	void accept()
	{
		int u=0,v=0,e,i=0;
		String d1,scr,dest;
		int dist;
		System.out.println("Enter the number of cities");
		num_v=sc.nextInt();
		visited=new int[num_v];
		System.out.println("Enter the number of rail routes");
		e=sc.nextInt();
	
		System.out.println("Enter the name of the cities in Maharashtra.");
		for(i=0;i<num_v;i++)
		  {
		   System.out.print("City "+(i)+ " name: ");
		   d1=s.next();
		   temp=new node(i,d1);
		   if(head==null)
		   {
			   head=temp;
		   }
		   else
		   {
			   ptr=head;
			   while(ptr.next!=null)
			   {
				   ptr=ptr.next;
			   }
			   ptr.next=temp;
		   }
		  }
		for(int j=0;j<e;j++)
		{
			
			System.out.println("Enter the starting station between which rail route exists");
			scr=sc.next();
			while(search1(scr)==-1)
			{
				System.out.println("This city is not a junction.\nEnter valid city.");
				System.out.println("Enter the starting station between which rail route exists");
				scr=sc.next();
			}
			System.out.println("Enter the destination station between which rail route exists");
			dest=sc.next();
			while(search1(dest)==-1)
			{
				System.out.println("This city is not a junction.\nEnter valid city.");
				System.out.println("Enter the destination station between which rail route exists");
				dest=sc.next();
			}
			 System.out.println("Distance between "+scr+" and "+dest+" :");
	         dist=sc.nextInt();
			u=search1(scr);
			v=search1(dest);
			adj_m[u][v]=adj_m[v][u]=dist;
		
		}
		
	}
	void display()
	{
		ptr=head;
		 while(ptr!=null)
		  {
		   System.out.print("\t"+ptr.city);
		   ptr=ptr.next;
		  }
		 System.out.println();
		 ptr=head;
		for(int i=0;i<num_v&&ptr!=null;i++)
		{
			System.out.print(ptr.city+"\t");
			ptr=ptr.next;
			for(int j=0;j<num_v;j++)
			{
				System.out.print(adj_m[i][j]+"\t\t");
			}
			System.out.println();
		}
	}
	int search1(String b)
	{
		int v=-1;
		ptr=head;
		
	   while(ptr!=null)
		{
			if(ptr.city.compareToIgnoreCase(b)==0)
			{
				v=ptr.d;
				break;
			}
			ptr=ptr.next;
		}
	   return v;
	}
	String search2(int b)
	{
		String t=null;
		ptr=head;
		   while(ptr!=null)
			{
				if(ptr.d==b)
				{
					t=ptr.city;
					break;
				}
				ptr=ptr.next;
			}
			return t;
	}
	void BFS()
	{
		int i=0,v=0,k;
		for(i=0;i<num_v;i++)
		  {
		   visited[i]=0;
		   for(int j=0;j<num_v;j++)
		   {
			   if(adj_m[i][j]==999)
				   adj_m[i][j]=0;
		   }
		  }
		String scr,t;
		Queue<Integer> q=new LinkedList<Integer>();
		System.out.println("\n\nEnter your city");
		scr=sc.next();
		while(search1(scr)==-1)
		{
			System.out.println("This city is not a junction.\nEnter valid city.");
			System.out.println("\n\nEnter your city");
			scr=sc.next();
		}
		ptr=head;
		t=null;
	   v=search1(scr);
		q.add(v);
		visited[v]=1;
		System.out.println("=== Neighbouring cities connected to "+scr+" by rail are ===\n");
		while(q.isEmpty()==false)
		{
			k=q.remove();
		  t=search2(k);
			
			for(i=0;i<num_v;i++)
			{
				if((adj_m[v][i]!=0)&&(visited[i]==0))
				{
					q.add(i);
					visited[i]=1;
				}
			}
			if(k!=v)
			{
				System.out.print("\n"+scr+" - "+t);
			}
			
		}
	}

	void DFS()
	{	Stack<Integer> st=new Stack<Integer>();
		int k, i,v=0;
		int flag;
		String scr,t;
		System.out.println("\n\nEnter the starting city");
		scr=sc.next();
		while(search1(scr)==-1)
		{
			System.out.println("This city is not a junction.\nEnter valid city.");
			System.out.println("\n\nEnter your city");
			scr=sc.next();
		}
		v=search1(scr);
		for( i=0;i<num_v;i++)
		  {
		   visited[i]=0;
		   for(int j=0;j<num_v;j++)
		   {
			   if(adj_m[i][j]==0)
				   adj_m[i][j]=999;
		   }
		  }		st.push(v);
		visited[v]=1;
		System.out.println("=== The Depth-First Search ===\n");
		System.out.print(scr);
		while(st.isEmpty()==false)
		{	
			flag=0;
			k=st.peek();
			for(i=0;i<num_v;i++)
			{
				if((adj_m[k][i]!=0)&&(visited[i]==0))
				{
					flag=1;
					st.push(i);
					t=search2(i);
						
					System.out.print("\t"+t);
					visited[i]=1;
					break;
				}
			}
			if(flag==0)
			{
				st.pop();
			}
		}
	}
	void prim()
	{
		String scr;
		 for(int i=0;i<num_v;i++)
		  {
		   visited[i]=0;
		   for(int j=0;j<num_v;j++)
		   {
			   if(adj_m[i][j]==0)
				   adj_m[i][j]=999;
		   }
		  }
		int s=0,min,v=0,u=0,totalcost=0,flag;
		String t,m;
		t=null;
		m=null;
		System.out.println("\nEnter the your city");
		scr=sc.next();
		while(search1(scr)==-1)
		{
			System.out.println("This city is not a junction.\nEnter valid city.");
			System.out.println("\n\nEnter your city");
			scr=sc.next();
		}
		s=search1(scr);
		visited[s]=1;
		for(int k=0;k<num_v;k++)
		{
			min=999;flag=0;
			for(int i=0;i<num_v;i++)
			{
				if(visited[i]==1)
				{
					for(int j=0;j<num_v;j++)
					{
						if(visited[j]==0)
						{
							if(min>adj_m[i][j])
							{
								min=adj_m[i][j];
								flag=1;
								u=i;
								v=j;
							}
						}
					}
				}
			}
			if(flag==1)
			{	visited[v]=1;
				totalcost+=adj_m[u][v];
				   t=search2(u);
				   m=search2(v);
				System.out.println("route selected :"+t+"-"+m);
			}
		}
		System.out.println("total distance travelled :"+totalcost);
	}
 void dijikstra()
 {
	 int k=0,i,min,next=0;
	 String scr,dest;
	 int s,t;
	 int []dist=new int[num_v];
	 int []prev_vertex=new int[num_v];
	 for(i=0;i<num_v;i++)
		{
			for(int j=0;j<num_v;j++)
			{
				if(adj_m[i][j]==0)
				{
					adj_m[i][j]=999;
				}
				
	
			}
		}
	 for(i=0;i<num_v;i++)
	   {
		   visited[i]=0;
	   }
		System.out.println("\nenter your city:");
	    scr=sc.next();
		while(search1(scr)==-1)
		{
			System.out.println("This city is not a junction.\nEnter valid city.");
			System.out.println("\n\nEnter your city");
			scr=sc.next();
		}
	    s=search1(scr);
	    System.out.println("enter the destination:");
	    dest=sc.next();
		while(search1(dest)==-1)
		{
			System.out.println("This city is not a junction.\nEnter valid city.");
			System.out.println("\n\nEnter your city");
			dest=sc.next();
		}
	    t=search1(dest);
	    for( i=0;i<num_v;i++)
	    {
	    	
	    		dist[k]=adj_m[s][i];     
	    		k++;    
	   
	    }
	    System.out.println();
	    visited[s]=1;
	    dist[s]=0;
	    for( i=0;i<num_v;i++)
	    {
	    	prev_vertex[i]=s;
	    }
	    
	    
	    for(i=0;i<num_v;i++)
	    {
	    	min=999;
	    	for(int j=0;j<num_v;j++)
	    	{
	    		if(visited[j]==0&&dist[j]<min)
	    		{
	    			min=dist[j];
	    			next=j;
	    		}
	    	}
	    	visited[next]=1;
	    	
	    	for(int j=0;j<num_v;j++)
	    	{
	    		if(visited[j]!=1)
	    		{
	    			int d=min+adj_m[next][j];
	    			if(dist[j]>d)
	    			{
	    				dist[j]=d;
	    				prev_vertex[j]=next;
	    			}
	    		}
	    	} 	
	    }
	    System.out.println("distance is");
	    for( i=0;i<num_v;i++)
	    {
	    	System.out.print(dist[i]+"\t");
	    	
	    }
	    System.out.println();
	    System.out.println("the min distance from "+scr+" to "+dest+" is "+dist[t]);
	    
//================================================TO PRINT THE PATH =========================================================
	    System.out.println("\nThe path taken is :-");
	    int []path=new int[num_v];
	    i=t;
	    k=0;
	    while(i!=s)
	    {
	    	path[k]=prev_vertex[i];
	    	k++;
	    	i=prev_vertex[i];
	    }
	   String m;
	   for(i=k-1;i>=0;i--)
	   {
		   m=search2(path[i]);
		   System.out.print(m+"-->");
	   }
	   System.out.print(dest);
 }
	
 }

public class GoogleMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph g=new Graph();
		Scanner o=new Scanner(System.in);
		String ans,ans1;
		int opt1,opt2,opt3,p=0;
		String pwd1="admin",pwd2="customer";
		do{
			System.out.println("\n*****WELCOME TO MAHARASHTRA RAILWAY TOURISM ****\n\nEnter as\n1]admin login\n2]customer login\n3]exit");    //login option
            opt1=o.nextInt();
            switch(opt1)
            {
            	case 1:
            		System.out.println("Enter password");
            	    String temp_pwd1=o.next();
            	    if(temp_pwd1.equals(pwd1))
            	    {	do{
            			System.out.println("*Enter your choice*\n1.enter data\n2.display ");//admin login options
            			opt3=o.nextInt();
            		switch(opt3)
            		{
            		case 1: p++;
            			g.accept();
            			break;
            		case 2:
            			if(p==0)
            				System.out.println("No data entered");
            			else
            			  g.display();
            			break;
            		}
            		System.out.println("\nContinue ? Y or N");
        		  	ans1=o.next();
        		   }while(ans1.equalsIgnoreCase("Y"));
            	    }
            	    else 
            	    	System.out.println("Wrong password");
            		break;
            	case 2:
            		System.out.println("Enter password");
            	    String temp_pwd2=o.next();
            	    if(temp_pwd2.equals(pwd2))
            	    {	do{
        		  		System.out.println("*Enter your choice*");
            		  	System.out.println("1.Explore the cities that are connected to your city by rail.\n2.Visit all the cities in Maharashtra with minimum distance\n3.Find the shortest rail route between two cities ");  //customer login options
            		  	opt2=o.nextInt();
        		  	switch(opt2)
        		  	{
        		  	case 1:
        			   g.BFS();
        			    break;
        		  	case 2:
        		  		g.prim();
        		  		break;
        		  	case 3:
        		  		g.dijikstra();
        		  		break;
        		  	default:
        		  		System.out.println("Enter valid choice");
        		  	}
        		  	System.out.println("\nContinue ? Y or N");
        		  	ans=o.next();
        		   }while(ans.equalsIgnoreCase("Y"));
            	    }
            	    else
            	    	System.out.println("Wrong password");
        		  	break;
            }
		}while(opt1==1||opt1==2);
          


	}

}