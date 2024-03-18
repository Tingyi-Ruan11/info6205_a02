public class Assignment02 {
// Problem One
// Given a sorted array containing duplicates, count the number of occurrences of a given element. 
// For this assignment, we will use a list of integers. Please see the example below

// [2, 2, 3, 3, 4, 4, 4, 8, 8, 8, 8, 8, 9, 9, 10, 12, 15]

// The parameters given to the method will be an array and then the target integer being counted

// Example output using the above example is as follows:

// Target 4 = 3 Occurrences (Parameter array, 4)

// Target 2 = 2 Occurrences (Parameter array, 2)

// Target 5 = 0 Occurrences (Parameter array, 5)

    // find the left boundary
    public static int searchingLeftBoundary(int[] nums,int target){
        int n = nums.length;
        // initilize two pointers, left at start index and right at the end index
        int left = 0;
        int right = n-1;

        while (left<=right){
            // divide the whole nums into two parts
            int mid = left+(right-left)/2;
            // if value of one index equals to target and the element on the left does not, then it is the left boundary
            if(nums[mid]== target && (mid==0 || nums[mid-1]!= target)){
                return mid;
            }
            // if the value of mid is less than target, then go to the right part
            if(nums[mid]< target){
                left = mid+1;
            }
            // if the value of mid is greater than target, then go to the left part
            // or if the value of mid equals to target, but also equal to the element on the left, we also go to left part
            // so here we can just use else condition
            else {
                right = mid-1;
            }
        }
        // if can not find target,return -1
        return -1;
    }

    // find the right boundary
    public static int searchingRightBoundary(int[] nums,int target){
        int n = nums.length;
        // initilize two pointers, left at start index and right at the end index
        int left = 0;
        int right = n-1;

        while (left<=right){
            // divide the whole nums into two parts
            int mid = left+(right-left)/2;
            // if value of one index equals to target and the element on the right does not, then it is the right boundary
            if(nums[mid]== target && (mid==n-1 || nums[mid+1]!= target)){
                return mid;
            }
            // if the value of mid is greater than target, then go to the left part
            if(nums[mid]> target){
                right = mid-1;
            }
            // if the value of mid is less than target, then go to the right part
            // or if the value of mid equals to target, but also equal to the element on the right, we also go to right part
            // so here we can just use else condition
            else {
                left = mid+1;
            }
        }
        // if can not find target,return -1
        return -1;
    }
    


    public static int problemOneSolution(int[] nums,int target){
        // we can use binary search method to solve this problem, since the input array is sorted;
        // in detail, we use two binary search, one for searching right boundary, another fot left boundary
        // the time complexity would be O(log n), and space complexity would be O(1).

        // find left boundary
        int leftBoundary = searchingLeftBoundary(nums, target);
        int rightBoundary = searchingRightBoundary(nums,target);
        // check if target exist in input array
        if(leftBoundary==-1){
            return 0;
        }
        // calculate occurrences
        int occurrences = rightBoundary-leftBoundary+1;

        return occurrences;
    }


// Assume a “Rotated Sorted Array”. Please see an example below. 
// Return the index of the integer when it is found or -1 if it does not exist.
// This list will NOT have duplicates. 
// A rotated sorted array is an array that has a sorted list at first then it breaks and has another sorted list. 
// See example below:

// [6, 7, 8, 2, 3, 4, 5]

// This method will take two parameters. The first is the array and the second is the target being searched

// If we use the above array as an example, output would be as follows:

// Target 8 = 2 (2 is the index of 8)

// Target 9 = -1 (6 does not exist)

    public static int problemTwoSolution(int[] nums,int target){
        // we can also use a modifed binary search method to slove this problem
        // in detail, the input array is orginally sorted but be rotated by unknown steps
        // but we can noticed that, there must be at least half of the input array is sorted
        // so that is the point we can take advantage of;
        // the time complexity would be O(log n), and space complexity is O(1);

        int n = nums.length;
        // initilize two pointers, left at start index and right at the end index
        int left = 0;
        int right = n-1;

        while (left<=right){
            // divide the whole nums into two parts
            int mid = left+(right-left)/2;

            // if value of one index equals to target, we found it
            if(nums[mid]== target){
                return mid;
            }

            // check which part of the array is sorted
            // if right part is sorted
            if (nums[mid]<nums[right]){
                // check if target falls in the right part
                if(target>nums[mid] && target<=nums[right]){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
            //if left part is sorted
            else{
                // check if target falls in the left part
                if (nums[left]<=target && target<nums[mid]){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
        }
        // if we can not find target, return -1
        return -1;
    }

    public static void main(String[] args){
        // check for problem one solution
        int[] nums1 = {2, 2, 3, 3, 4, 4, 4, 8, 8, 8, 8, 8, 9, 9, 10, 12, 15};
        System.out.println(problemOneSolution(nums1,4));
        System.out.println(problemOneSolution(nums1,2));
        System.out.println(problemOneSolution(nums1,5));
        //check for problem two solution
        int[] nums2 = {6,7,8,2,3,4,5};
        System.out.println(problemTwoSolution(nums2,8));
        System.out.println(problemTwoSolution(nums2,9));
        System.out.println(problemTwoSolution(nums2,3));
    }
}

