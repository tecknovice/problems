/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hungn_000
 */
public class GfG
{
   // Merges two subarrays of arr[].  First subarray is arr[l..m]
   // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
         // Your code here
         int[] A = new int[r-l+1];
         int index=-1;//index of A
         int x,y;
         int i=l;//left pointer
         int j=m+1;//right pointer
         do{
            //if left pointer reach the last point, copy right elements to array A
            if(i>m){
                index+=1;
                A[index]=arr[j];
                if(j<=r)j+=1;
                continue;
            }
            //if right pointer reach the last point, copy left elements to array A
            if(j>r){
                index+=1;
                A[index]=arr[i];
                if(i<=m)i+=1;
                continue;
            }
            x=arr[i];
            y=arr[j];
            //if left pointer and right pointer is on the go
            if(x<=y){
                index+=1;
                A[index]=x;
                if(i<=m)i+=1;
            }
            else{
                index+=1;
                A[index]=y;
                if(j<=r)j+=1;
            }
         }while(i<=m||j<=r);
         System.arraycopy(A, 0, arr, l, r-l+1);
    }
}
