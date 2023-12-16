package algorithm.basic;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int m = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cnt == 0) {
                m = nums[i];
                cnt = 1;

            } else if(m == nums[i]){
                cnt++;
            } else {
                cnt--;
            }
        }
        return m;
    }
}
