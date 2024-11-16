import java.util.Scanner;

public class Matrix_Binary_search {
    public static void main(String[] args) 
    {
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter the values of row and column :");
        int row=sc.nextInt();
        int col=sc.nextInt();

        int arr[][]=new int[row][col];
        System.out.println("Enter the matrix in ("+row+"X"+col+") order with index starting at(0,0)");

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }

        System.out.print("Enter the element that you want to find :");
        int key=sc.nextInt();

        Search_2D(arr, row, col, key); //Solution

        System.out.println();
        System.out.println("THIS PROGRAMME IS PREPARED BY 23CS069 MEGH PATEL");

        sc.close();
    }

    public static int Search_1D(int arr[],int size,int key)
    {
        int top=size-1;
        int bottom=0;

        while(top>=bottom)
        {
            int mid=top-(top-bottom)/2;

            if(arr[mid]==key)
            {
                return mid;
            }
            else if(arr[mid]<key)
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

    public static void Search_2D(int arr[][],int row,int col,int key)
    {
        int top=row-1;
        int bottom=0;
        int ans_row,ans_col;

        while(top>=bottom)
        {
            int mid=top-(top-bottom)/2;

            if(arr[mid][0]<=key && arr[mid][col-1]>=key)
            {
                ans_row=mid;
                ans_col=Search_1D(arr[mid],col, key);
                
                System.out.println("The desired element is at ("+ans_row+","+ans_col+")");
                return ;
            }
            else if(arr[mid][0]<key)
            {
                bottom=mid+1;
            }
            else
            {
                top=mid-1;
            }
        }

        System.out.println("The desired element is not found");
        return ;
    }
}


//LEETCODE SOLUTION BEATS 100% RUNTIME

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int bottom=0;
        int top=matrix.length-1;

        while(top>=bottom)
        {
            int mid=top-(top-bottom)/2;

            if(matrix[mid][0]<=target && matrix[mid][matrix[mid].length-1]>=target)
            {
                return searchArray(matrix[mid], target);
            }
            else if(matrix[mid][0]<target)
            {
                bottom=mid+1;
            }
            else
            {
                top=mid-1;
            }
        }
        return false;
    }
    private boolean searchArray(int arr[],int target)
    {
        int bottom=0;
        int top=arr.length-1;

        while(top>=bottom)
        {
            int mid=top-(top-bottom)/2;

            if(arr[mid]==target)
            return true;
            else if(arr[mid]<target)
            bottom=mid+1;
            else
            top=mid-1;
        }
        return false;
    }
}