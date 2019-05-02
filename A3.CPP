#include<iostream>
using namespace std;

int main()
{
	int a,b,i,j,v,w;
	char ans;
	cout<<"Enter the number of airports"<<endl;
	cin>>v;
	int flight[v+1][v+1];
	for(i=0;i<v;i++)
	{
	  for(j=0;j<v;j++)
	  {
	    flight[i][j]=0;
	  }
	}
	
	do
	{
	    cout<<"Enter the flight details in the format (a-b-time)"<<endl;
	  cin>>a>>b>>w;
	  flight[a][b]=w;
	  cout<<"Any more flights? (Y/N)"<<endl;
	  cin>>ans;
	}
	while(ans=='y');
	
	cout<<"The flight details are as follows"<<endl;
	for(i=1;i<=v;i++)
	{
	  for(j=0;j<=v;j++)
	  {
	    if(flight[i][j]!=0)
	    cout<<"Flight from "<<i<<" to "<<j<<" takes "<<flight[i][j]<<" minutes"<<endl;
	  }
	}
	return 0;
}
