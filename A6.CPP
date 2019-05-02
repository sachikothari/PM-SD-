#include<iostream>
using namespace std;
class heap
{	
public:
void printarray(int a[], int n);
void heapsort(int a[], int n);
void minimum(int a[],int n);
void maximum(int a[],int n);
};
void heapify(int a[],int n,int i);
void heap:: heapsort(int a[], int n)
  {
   for(int i=(n/2)-1; i>=0;i--)
   {
    heapify(a,n,i);
   }
   for(int i=(n-1);i>=0;i--)
   {
     int temp= a[0];
     a[0]= a[i];
     a[i]= temp;
    heapify (a,i,0);
    }
   }
void heapify(int a[],int n, int i)
{
     int largest=i;
     int l= (2*i)+1;
     int r=(2*i)+2;
     if(l<n && a[l]>a[largest])
     largest=l;
     if(r<n && a[r]>a[largest])
     largest=r;

     if(largest!=i)
     {
     int t= a[i];
     a[i]=a[largest];
     a[largest]=t;
     heapify(a,n,largest);
     }
}
void heap:: printarray(int a[],int n)
{
    for(int i=0;i<n;i++)
       {
        cout<<a[i]<<"";
        cout<<"\n";
        }
        }
        void heap::maximum(int a[],int n)
        {
            cout<<"MAXIMUM MARKS:"<<a[n-1]<<endl;
        }
        void heap::minimum(int a[],int n)
        {
            cout<<"MINIMUM MARKS:"<<a[0]<<endl;
        }
int main()
{
  heap h;
  int a[100],n;
  cout<<"Enter number of students"<<endl;
  cin>>n;
  cout<<"enter the marks"<<endl;
  for(int i=0;i<n;i++)
    {
    cin>>a[i];
    }
    cout<<"HEAP SORT"<<endl;
    h.heapsort(a,n);
    cout<<"DISPLAY THE HEAP"<<endl;
    h.printarray(a,n);
    char ch;
    int choice;
    cout<<"DO YOU WANT TO SEE MAXIMUM OR MINIMUM MARKS(y/n)"<<endl;
    cin>>ch;
    while(ch=='y')
    {
    cout<<"MENU"<<endl;
    cout<<"1.MAXIMUM MARKS"<<endl;
    cout<<"2.MINIMUM MARKS"<<endl;
    cout<<"ENTER YOUR CHOICE"<<endl;
    cin>>choice;
    switch(choice)
        {
        case 1:
            h.maximum(a,n);
            break;
        case 2:
            h.minimum(a,n);
            break;
        default:
            cout<<"SORRY!WRONG CHOICE"<<endl;
            break;
        }
        cout<<"DO YOU WANT TO CONTINUE"<<endl;
        cin>>ch;
    }
return 0;
  }
