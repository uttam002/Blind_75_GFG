// User function template for C++

class Solution {
  public:
  int binarySearch(int arr[], int l, int r, int x)
{
    if (r >= l) {
        int mid = l + (r - l) / 2;
        if (arr[mid] == x) return mid;
        if (arr[mid] > x) return binarySearch(arr, l, mid - 1, x);
     
     return binarySearch(arr, mid + 1, r, x);
    }
    return -1;
}
    int binarysearch(int arr[], int n, int k) {
        // code here
        binarySearch(arr, 0,n-1,k);
    }
};
