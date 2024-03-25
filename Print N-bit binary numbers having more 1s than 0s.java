
class Solution {
    public ArrayList<String> NBitBinary(int N) {
        ArrayList<String> result = new ArrayList<>();
        generateValidBinaryNumbers("", N, 0, 0, result);
        return result;
    }
    
    private void generateValidBinaryNumbers(String current, int N, int ones, int zeros, ArrayList<String> result) {
        if (current.length() == N) {
            result.add(current);
            return;
        }
        
        if (ones == zeros) {
            generateValidBinaryNumbers(current + "1", N, ones + 1, zeros, result);
        } else {
            generateValidBinaryNumbers(current + "1", N, ones + 1, zeros, result);
            generateValidBinaryNumbers(current + "0", N, ones, zeros + 1, result);
        }
    }
}
