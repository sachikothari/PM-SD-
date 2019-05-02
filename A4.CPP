#include<iostream>
using namespace std;
class prim
{
int ve,e;
int w[100][100];
int v[100];
int p[100];
int d[100];
public:
void create()
{
cout<<"\n Enter the number of vertices";
cin>>ve;
cout<<"\n Enter the number of edges";
cin>>e;
for(int i=1;i<=ve;i++)
        for(int j=1;j<=ve;j++)
                w[i][j]=0;
//v[ve]={0};

for(int i=1;i<=ve;i++)
{    v[i]=0;
        p[i]=0;

}
for(int i=1;i<=ve;i++)
{
    d[i]=32767;
}
for(int i=1;i<=e;i++)
{
int a,b,weight;
cout<<"\n ENter vertex no. a and b and weight";
cin>>a>>b>>weight;
w[a][b]=w[b][a]=weight;
}

}
void prims()
{
int current=1;
d[current]=0;
v[current]=1;
p[current]=0;
int tot=0;
while(tot<ve-1)

{

for(int i=1;i<=ve;i++)
{
if(w[current][i]!=0  && v[i]==0)
{
if(w[current][i]<d[i])
{
d[i]=w[current][i];
p[i]=current;

}


}


}
int mini=32767;
for(int k=1;k<=ve;k++)
{
if((d[k]<mini) && (v[k]==0))
{

mini=d[k];
current=k;

}


}

v[current]=1;
tot++;



}

int minw=0;
for(int i=1;i<=ve;i++)
{
minw=minw+d[i];

}
cout<<"\n Minimum Weight is "<<minw;
cout<<"\n Edges are: "<<endl;
for(int i=1;i<=ve;i++)
{
cout<<i<<"-"<<p[i]<<"   ";

}

}

};
int main()
{
prim s;
s.create();
s.prims();
}