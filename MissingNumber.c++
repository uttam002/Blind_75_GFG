// User function template for C++

class Solution{
  public:
    int MissingNumber(vector<int>& array, int n) {
        // Your code goes here
        return ((n*(n+1))/2) - accumulate(array.begin(),array.end(),0); 
    }
};
