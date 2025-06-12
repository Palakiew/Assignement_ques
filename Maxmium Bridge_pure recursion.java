
class Solution {
    public int maximumBridges(int n, int m, int[] a, int[] b) {
   
        return lcs(a,b,n-1,m-1);
    }
    private int lcs(int[]a, int[]b, int i, int j){
            if(i<0 || j<0){
                return 0;
            }
            if(a[i]==b[j]){
             return 1+lcs(a,b,i-1,j-1);
        }
            else{
              return Math.max(lcs(a,b,i-1,j),lcs(a,b,i,j-1));
        } 
    }
}
