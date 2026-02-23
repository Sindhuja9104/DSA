public class JumpSearch {
    public static int jumpSearch(int[] arr,int target ){
        int n = arr.length;
        int blockSize = (int)Math.sqrt(n);
        int startIndex = 0;
        int endIndex = blockSize;
        while(endIndex < n && arr[endIndex] <= target){
            startIndex = endIndex;
            endIndex += blockSize;
            if(endIndex > n){
                endIndex = n;
            }

        }
        int result = -1;
        for(int i = startIndex;i<endIndex;i++){
            if(arr[i]==target)return i;
        }
        return result;
    }
public static void main(String[] args) {
        int arr[] = {2,5,8,11,15,21,35,48,88};
        int target = 21;
        int result = jumpSearch(arr, target);
        System.out.println(result);
    
    }
}