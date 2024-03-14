class Solution{

    // Function to find the trapped water between the blocks.
    public:
    long long trappingWater(int arr[], int n){
        long left=0,right=n-1;
        long maxleft=0,maxright=0;
        long res=0;
        while(left<=right){
            if(arr[left]<=arr[right]){
                if(arr[left]>=maxleft)maxleft=arr[left];
                else res += maxleft-arr[left];
                left++;
            }else{
                 if(arr[right]>=maxright)maxright=arr[right];
                else res += maxright-arr[right];
                right--;
            }
        }
        return res;
    }
};
