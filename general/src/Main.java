public class Main {
    private static long sum(int n){
        long sum = 0;
        for( int i = 0 ; i < n ; i ++ )
            sum += i;
        return sum;
    }
    public static void main(String[] args){
            // 数据规模每次增大j倍进行测试
            // 有兴趣的同学也可以试验一下数据规模每次增大2倍哦:)
            // 复杂度测试： 时间上也是上一次的两倍
            for( int x = 1 ; x <= 100 ; x ++ ){
                int j = 2;
                int n = (int)Math.pow(j, x);

                long startTime = System.currentTimeMillis();
                long sum = sum(n);
                long endTime = System.currentTimeMillis();

                System.out.println("sum = " + sum);
                System.out.println(j+"^" + x + " : " + (endTime - startTime) + " ms");
                System.out.println("");
            }
    }
}

