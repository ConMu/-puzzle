package array;

public class minArray {
    public int minArray(int[] numbers) {
        int num = numbers[0];
        for(int i = 0; i < numbers.length;i ++){
            if(num >= numbers[i]){
                num = numbers[i];
            }
        }
        return num;
    }
}
