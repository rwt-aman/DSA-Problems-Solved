class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] arr = new int[n];
        
        for (int i = 0; i < bookings.length; i++) {
            int[] row = bookings[i];
            for (int j = row[0]; j <= row[1]; j++) {
                arr[j - 1] = arr[j - 1] + row[2];
            }
        }
        return arr;
    }
}