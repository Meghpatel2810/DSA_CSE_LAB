#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int size;
    cin>>size;

    if(size<1 || size>20)
    return 0;

    int arr[size];

    for(int i=0;i<size;i++)
    {
        cin>>arr[i];
    }
    
    int temp1=0,temp2=0;
    for(int i=0;i<size-1;i++)
    {
        if(arr[i]>arr[i+1])
        {
            if(temp1==0)
            temp1=i;
            else
            temp2=i+1; 
        }
        if(temp2==0)
        temp2=3;
    }
    int swap=arr[temp1];
    arr[temp1]=arr[temp2];
    arr[temp2]=swap;
    
    for(int i=0;i<size;i++)
    {
        cout<<arr[i]<<" ";
    }
    return 0;
}