//THIS PROGRAM IS PREPARED BY 23CS069 MEGH PATEL
#include<iostream>
using namespace std;

void Print_array(int arr[],int size)
{
    for(int i=0;i<size;i++)
    {
        cout<<"Element "<<i<<" :"<<arr[i]<<endl;
    }
    return ;
}

int getmax(int arr[],int size)
{
    int max=arr[0];
    for(int i=1;i<size;i++)
    {
        if(max<arr[i])
        {
            max=arr[i];
        }
    }
    return max;
}

void CountSort(int arr[] ,int size ,int exp)
{
    int max_element=getmax(arr,size);

    int count[10]={0};

    for(int i=0;i<size;i++)
    {
        count[ (arr[i]/exp)%10 ]++;
    }

    for(int i=1;i<max_element+1;i++)
    {
        count[i]+=count[i-1];
    }

    int Output_Array[size]={0};

    for(int i=size-1;i>=0;i--)
    {
        Output_Array[ count[ (arr[i]/exp)%10 ]-1 ]= arr[i];
        count[ (arr[i]/exp)%10 ]--;
    }

    for(int i=0;i<size;i++)
    {
        arr[i]=Output_Array[i];
    }

    return ;
}

void Sort(int arr[],int size)
{
    int max_element=getmax(arr,size);

    for(int exp=1;max_element/exp>0;exp*=10)
    {
        CountSort(arr,size,exp);
    }
}

int main()
{
    int n;
    cout<<"Enter the size of the array:";
    cin>>n;

    if(n<1)
    return 0;

    int arr[n];

    cout<<"Enter the array:-"<<endl;
    for(int i=0;i<n;i++)
    {
        cout<<"Enter arr["<<i<<"] :";
        cin>>arr[i];
        if(arr[i]<0)
        {
            cout<<"Please enter positive number";
            return 0;
        }
    }
    Sort(arr,n);
    cout<<endl<<"Sorted array :-"<<endl;
    Print_array(arr,n);
}