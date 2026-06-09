class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left=0;
        int right=people.length-1;

        int count=0;

        // while (left <= right) {
        //     // System.out.println(left + " " + right);
        //     if (left ==right) {
        //         count++;
        //         left++;
        //         continue;
        //     }
        //     if (people[left] + people[right] <= limit) {
        //         left++;
        //         right--;
        //         count++;
        //     } else if (people[left] >= limit && people[right] >= limit) {
        //         left++;
        //         right--;
        //         count+=2;
        //     } else if (people[left] >= limit) {
        //         left++;
        //         count++;
        //     } else if (people[right] >= limit) {
        //         right--;
        //         count++;
        //     } else if (people[left] + people[right] > limit) {
        //         left++;
        //         right--;
        //         count+=2;
        //     }
        // }

         while (left <= right) {
            // System.out.println(left + " " + right);
            if (left ==right) {
                count++;
                left++;
                continue;
            }
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
                count++;
            } else {
                if (people[left] > limit) {
                    left++;
                    count++;
                } else  {
                    right--;
                    count++;
                } 
            }
         }
               
        return count;
    }
}

/*

[3,3,4,5] limit=5
[5]
[3]
[3]
[4]
l=0, r=4
l=0, r=3

[2,3,4,5] limit=5
[5]
[4]



5,1,4,2

1,2,4,5

1,3,2,3,2

1,2,2,3,3


1,2,2,3

[3]
[1,2]
[2]

1,3,2,3,2

1,2,2,3,3 limit=3

people=[5,1,4,2]

[1,2,4,5] limit=6





*/