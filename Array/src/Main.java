public class Main {
    // java 的数组 有局限性:
    // array 是固定size的(静态), 如何添加/删除
    // 索引index可以有语义(比如学号)也可以没有语义, 并非所有有语义的索引都适用于数组
    // -> 封装动态数组 -> 增删改查
    public static void main(String[] args) {
        int[] arr = new int[10];
        for(int i = 0; i< arr.length; i++)
            arr[i] = i;

        int[] scores = new int[]{100,99,60};
        for(int i = 0; i < scores.length; i++)
            System.out.println(scores[i]);
        for(int score : scores) //for each
            System.out.println(score);

        scores[0] = 98;
        for(int score : scores) //for each
            System.out.println(score);
    }
}
