public class MergeSort{
    static  void printArray(int[] arr){
        for(int i: arr){
            System.out.print(i + " ");
        }
    }
    static void merge(int[] arr, int l, int mid, int r){
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        int i,j,k;
        for( i = 0;i < n1;i++){
            left[i] = arr[l+i];
        }
        for( j = 0;j < n2; j++){
            right[j] = arr[mid+1+j];


        }
        i = 0;
        j = 0;
        k = l;
        //comparing the value of left array with right and vice verse
        //then if got a value which is  less the other value we will keep it at kth position
        while(i < n1 && j < n2){
            if(left[i] < right[j]){
                arr[k] = left[i];
                k++; 
                i++;

            }else{
                arr[k] = right[j];
                k++;
                j++;

            }
        }
        while(i<n1){
            arr[k++]=left[i++];

        }
        while(j<n2){
            arr[k++]=right[j++];
        }

    }
    static void mergeSort(int[] arr, int l, int r){
        if(l>= r)return;
        int mid = (l + r) /2;
        mergeSort(arr, l,mid);
        mergeSort(arr,mid + 1,r);
        merge(arr,l,mid,r);
    }
    public static void main(String[] args){
        int[] arr = {4,5,7,3,1,2};
        int n = arr.length;
        System.out.print("Array before  merge sort:");
        printArray(arr);
        System.out.println();
        mergeSort(arr,0, n-1);
        System.out.print("Array after  merge sort:");
        printArray(arr);



    }
}   