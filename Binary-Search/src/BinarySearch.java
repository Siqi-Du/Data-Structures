public class BinarySearch {

    private BinarySearch(){}

    //二分查找原数组有序
    public static int BinarySearch(Comparable[] arr, int n, Comparable target){

        //在[l...r]中查找target
        int l = 0;
        int r = n -1 ;

        while(l <= r){
            int mid = (l+r)/2;
            if(arr[mid].compareTo(target) == 0)
                return mid;
            if(arr[mid].compareTo(target) < 0)
                l = mid + 1;
            else
                r = mid -1 ;
        }

        return -1;
    }

    public static void main(String[] args){
        int n = 1000000;
        Integer[] data = Util.generateOrderedArray(n);

        long startTime = System.currentTimeMillis();
        for(int i = 0 ; i < n ; i ++)
            if(i != BinarySearch(data, n, i))
                throw new IllegalStateException("find i failed!");
        long endTime = System.currentTimeMillis();

        System.out.println("Binary Search test complete.");
        System.out.println("Time cost: " + (endTime - startTime) + " ms");
    }
}
