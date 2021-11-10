public class LeetCode495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int time = 0,seq = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if(seq <= timeSeries[i]){
                time += duration;
                seq = timeSeries[i] + duration;
            }else if(seq < timeSeries[i] + duration){
                time += timeSeries[i] + duration -seq;
                seq = timeSeries[i] + duration;
            }
        }
        return time;
    }
}
