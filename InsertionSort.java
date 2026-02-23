public class InsertionSort {
    public static void insertionSort(int[] arr){
        int n = arr.length;
        for(int i =0;i< n;i++){
            //i=0
            int key = arr[i];//1
            int j = i-1;//-1
            //move elements of array {0,1,2,4,...}that are greater than key
            //to the position ahea of their urrent position
            //j=2
            while(j >= 0 && arr[j]>key){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1]=key;
            //-1+1=0=1
        }
    }
    public static void main(String[] args) {
        int  arr[] = {1,5,7,3,2,4};
        System.out.print("Array before insertion sort:");
        for(int i: arr){
            System.out.print(i + " ");

        }
        System.out.println();
        insertionSort(arr);
        System.out.print("Array after insertion Sort: ");
        for(int i: arr){
            System.out.print(i+" ");

        }
    }
}
