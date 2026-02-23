public class InsertionSortProblem {
    public static void insertionSort(int[] arr){
        int n = arr.length;
        for(int i=1;i < n;i++){
            int j = 1;
            while(j > 0 && arr[j] < arr[j-1]){
                //swap
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }
    public static void printArray(int[] arr){
        for(int i: arr){
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,3,5,1,3,6};
        System.out.print("Array before insertion sort:");
        System.out.println();//line break
        printArray(arr);
        insertionSort(arr);
        System.out.println("Array after insertion sort:");
        printArray(arr);
        insertionSort(arr);

    }    
}    