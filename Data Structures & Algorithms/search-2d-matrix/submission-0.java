class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for (int i=0; i< matrix.length;i++) {
            int[] row = matrix[i];

            if (row[0] <= target && row[row.length-1] >= target) {
                return binarySearch(row, target);
            }
        }

        return false;
    }

    public boolean binarySearch(int[] arr, int target) {

        int s=0, e=arr.length-1;


        while (s<=e) {
            int mid = s + (e-s)/2;
            if (arr[mid] == target) return true;

            if (arr[mid] < target) {
                s = mid+1;
            } else {
                e=mid-1;
            }
        }

        return false;
    }
}
