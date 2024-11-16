//BINARY SEARCH
#include<iostream>
#include<algorithm>
using namespace std;

int Binary_search(int arr[],int size,int key)
{
    int top=size-1;
    int bottom=0;

    while(top>=bottom)
    {
        int mid=(top+bottom) /2;
        if(arr[mid]==key)
        {
            return mid;
        }
        if(arr[mid]<key)
        {
            bottom=mid+1;
        }
        else
        {
            top=mid-1;
        }
    }
    return -1;
}

int main()
{
    int size;
    cin>>size;

    if(size<1 || size>40)
    return 0;
    

    int arr[size];

    for(int i=0;i<size;i++)
    {
        cin>>arr[i];
    }
    // sort(arr,arr+size);
    
    int key;
    cin>>key;

    cout<<Binary_search(arr,size,key);
}