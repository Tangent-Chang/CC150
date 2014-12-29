package Java.src.CC150;

/**
 * Created by YHWH on 12/8/14.
 */

public class ArrayAndString {

    public boolean isUniqueChars(String str){
        if (str.length()>256){return false;}

        boolean[] charSet = new boolean[256];
        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i);
            if(charSet[val]){
                return false;
            }
            charSet[val] = true;
        }
        return true;
    }

    public boolean isPermutation (String str1, String str2){
        if (str1.length()!=str2.length()){return false;}
        return sort(str1).equals(sort(str2));
    }
    private String sort (String s){
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    public String replaceSpace(String str, int length){
        char[] chars = str.toCharArray();

        int spaceCount = 0, newLength;
        for(int i=0; i<length; i++){
            if(chars[i]==' '){
                spaceCount++;
            }
        }

        newLength = length + spaceCount*2;
        char[] newChars = new char[newLength];
        //newChars[newLength] = '\0';

        for(int i=length-1; i>=0; i--){
            if(chars[i]==' '){
                newChars[newLength-1] = '0';
                newChars[newLength-2] = '2';
                newChars[newLength-3] = '%';
                newLength = newLength-3;
            }
            else{
                newChars[newLength-1] = chars[i];
                newLength = newLength-1;
            }
        }
        String newStr = new String(newChars);
        return newStr;
    }

    public String stringCompress(String str){
        if(str ==null || str.isEmpty()) return null;
        String result ="";
        char last = str.charAt(0);
        int repeatCount = 0;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==last){
                repeatCount++;
            }
            else{
                result = result+last+repeatCount;
                last = str.charAt(i);
                repeatCount = 1;
            }
        }
        result = result+last+repeatCount;

        return result;
    }
    public int countCompress(String str){
        if(str ==null || str.isEmpty()) return 0;

        char last = str.charAt(0);
        int letterCount = 1, repeatCount = 0;
        String compressLength = "";

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==last){
                repeatCount++;
            }
            else{
                letterCount++;
                compressLength = compressLength+repeatCount;
                repeatCount = 1;
                last=str.charAt(i);
            }
        }
        compressLength = compressLength+repeatCount;
        return compressLength.length()+letterCount;
    }

    public boolean checkIsSubstring(String s1, String s2){
        if(s1.length()==s2.length() && s1.length()>0){
            s1 = s1.toLowerCase();
            s2 = s2.toLowerCase();
            s1 = s1 + s1;
            return isSubstring(s1, s2);
        }
        return false;
    }
    private boolean isSubstring(String s1s1, String s2){
        return s1s1.contains(s2);
    }

    public int[][] setZeroMatrix(int[][] matrix){
        if(matrix.length==0) return null;
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[] mArray = new boolean[m];
        boolean[] nArray = new boolean[n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    mArray[i]=true;
                    nArray[j]=true;
                }
            }
        }

        for(int i=0; i<mArray.length; i++){
            for(int j=0; j<nArray.length; j++){
                if(mArray[i] || nArray[j]) matrix[i][j]=0;
            }
        }

        return matrix;
    }

    public int[][] rotateMatrix(int[][] matrix, int n){
        if(matrix.length==0 || n==0) return null;
        for(int layer=0; layer<n/2; layer++){
            int first = layer;
            int last = n-layer-1;
            for(int i=first; i<last; i++){
                int offset = i-first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
        return matrix;
    }
}
