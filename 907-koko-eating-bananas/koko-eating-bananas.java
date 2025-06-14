class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int kMin = 1;
        int kMax = piles[0];
        int kRes = -1;

        for (int i = 1; i < piles.length; i++) {
            int pile = piles[i];
            if (pile > kMax) {
                kMax = pile;
            }
        }

        while (kMin <= kMax) {
            int mid = (kMin + kMax) / 2;

            if (isfeasibleEatSpeed(piles, h, mid)) {
                kRes = mid;
                kMax = mid - 1;
            } else {
                kMin = mid + 1;
            }
        }

        return kRes;        
    }

    private boolean isfeasibleEatSpeed(int[] piles, int h, int mid) {
        int actualHourCount = 0;
        for (int pile: piles) {
            actualHourCount += (pile % mid == 0 ? pile/mid : pile/mid + 1);
            if (actualHourCount > h)
                return false;
        }
        return true;
    }
}