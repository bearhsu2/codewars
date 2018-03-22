package idv.kuma._7kyu.find_the_stray_number;

class Solution {
    static int stray(int[] numbers) {

        if (numbers[0] != numbers[1] && numbers[0] != numbers[2]) {
            return numbers[0];
        }

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != numbers[0]){
                return numbers[i];
            }
        }

        return 0;
    }
}