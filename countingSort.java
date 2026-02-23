public class countingSort
{
    static void printArray(int[] arr){
        for(int i:arr){
            System.out.println(i+" ");
        }

    }
    static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length;i++){
           if(arr[i] > max){
             max = arr[i];
            
           }
        }
        return max;
    }
    static void countSort(int[] arr){
        int max= findMax(arr);
        int[] count = new int[max+1];
        for(int i = 0; i<arr.length;i++){
            count[arr[i]]++;
        }
        int k=0;
        for(int i =0; i<count.length;i++){
            for(int j =0; j<count[i];j++){
                arr[k++]=i;
            }
        }

    }
    public static void main(String[] args) {
        int[] arr = {5,3,4,5,1,0,9,7};
        int n = arr.length;

        System.out.println("Array before quicksort:");
        printArray(arr);
        System.out.println();
        countSort(arr);
        System.out.println("Array after quicksort:");
        printArray(arr);

    }

    
}