package algorithm.array;

public class CanJumpMinCnt {
    public static void main(String[] args) {
        int[] a = {2, 3, 1, 1, 4};
        int r = jump(a);
        System.out.println(r);
    }

    public static int jump(int[] nums) {
        // 当前能跳的最远位置, 即下一跳的位置肯定在 (当前跳, maxPos], 这里是左开右闭
        // 当 i 到达 maxPos(之前已经保存了到 end变量了)时, 说明跳数增加 1
        int maxPos = 0;
        // 上次跳跃可达范围的右边届(即,下次的最右起跳点)
        int end = 0;
        // 跳跃次数
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            // 到达上次跳跃能到达的右边界了, 这个时候也才能确定下一跳的最大跳跃范围,即maxPos
            if (i == end) {
                // 目前能跳到的最远位置变成了下次起跳位置的右边界
                end = maxPos;
                // 进入下一次跳跃
                steps++;
            }
        }
        return steps;
    }
}
