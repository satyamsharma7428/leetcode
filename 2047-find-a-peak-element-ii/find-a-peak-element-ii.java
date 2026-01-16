class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int rl= mat.length;
        int cl= mat[0].length;

        int start= 0;
        int end= cl-1;
        while(start<=end){
            int mid= (start+end)/2;

            int maxrow=0;
            for(int i=0; i<rl; i++){
                if(mat[i][mid]> mat[maxrow][mid]){
                    maxrow=i;
                }
            }

            int left= (mid -1>=0)? mat[maxrow][mid-1]: -1;
            int right= (mid +1<cl)? mat[maxrow][mid+1]: -1;

            if(mat[maxrow][mid]> left && mat[maxrow][mid]>right){
                return new int[]{maxrow, mid};
            } else if(left> mat[maxrow][mid]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        
        }
        return new int[]{-1,-1};
        
    }
}