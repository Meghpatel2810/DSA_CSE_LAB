#include<iostream>
using namespace std;

void Print_array(int arr[],int size)
{
    for(int i=0;i<size;i++)
    {
        cout<<"Element "<<i<<" :"<<arr[i]<<endl;
    }
}

void bubble_sort(int arr[],int size)
{
    for(int i=0;i<size;i++)
    {
        bool flag=false;

        for(int j=0;j<size-i;j++)
        {
            if(arr[j]>arr[j+1])
            {
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;

                flag=true;
            }
        }
        
        if(flag==false)
        break;
    }
    cout<<"Sorted array"<<endl<<endl;
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
    cout<<"Enter the array :"<<endl;
    for(int i=0;i<size;i++)
    {
        cout<<"Enter element "<<i<<" :";
        cin>>arr[i];
    }
    bubble_sort(arr,size);
}