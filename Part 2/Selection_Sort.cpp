#include<iostream>
using namespace std;

void Print_array(int arr[],int size)
{
    for(int i=0;i<size;i++)
    {
        cout<<"Element "<<i<<" :"<<arr[i]<<endl;
    }
}

void Sort(int arr[],int size)
{
    for(int i=0;i<size;i++)
    {
        int min=i;
        for(int j=i+1;j<size;j++)
        {
            if(arr[min]>arr[j])
            {
                min=j;
            }
        }
        
            int temp=arr[i];
            arr[i]=arr[min];
            arr[min]=temp;
        
    }
    cout<<endl<<"Sorted array"<<endl;
    Print_array(arr,size);
}

int main()
{
    int size;
    cout<<"Enter the size of the array :";
    cin>>size;

    if(size<1)
    return 0;

    int arr[size];
    cout<<"Enter the array"<<endl;
    for(int i=0;i<size;i++)
    {
        cout<<"Enter element "<<i<<" :";
        cin>>arr[i];
    }
    Sort(arr,size);
}