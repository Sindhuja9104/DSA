
import java.util.*;

public class BucketSort {

    // Function to sort an array using Bucket Sort
    @SuppressWarnings("unchecked")   // <-- prevents unchecked warning
    public static void bucketSort(float arr[]) {
        int n = arr.length;
        if (n <= 0)
            return;

        // 1. Create empty buckets
        List<Float>[] buckets = (List<Float>[]) new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<Float>();
        }

        // 2. Put array elements into different buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int)(arr[i] * n);  // Correct bucket index
            buckets[bucketIndex].add(arr[i]);
        }

        // 3. Sort each bucket individually
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // 4. Combine all buckets into one array
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (float value : buckets[i]) {
                arr[index++] = value;
            }
        }
    }

    // Print the array
    public static void printArray(float arr[]) {
        for (float num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        float arr[] = {0.42f, 0.32f, 0.23f, 0.52f, 0.25f, 0.47f, 0.51f};

        System.out.println("Original array:");
        printArray(arr);

        bucketSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}