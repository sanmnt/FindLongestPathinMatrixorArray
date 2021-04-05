import java.util.*;
public class LongestPath {
    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.print("Rows: ");
            int row = input.nextInt();
            System.out.print("Columns: ");
            int column = input.nextInt();
            Random rand = new Random();
            //make the array
            int[][] arr = new int[row][column];
            //input random numbers into the array
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    arr[i][j] = rand.nextInt();
                }
            }
            //print out board for users to see
            System.out.println("Show Board: ");
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            int n = arr.length;
            int m = arr[0].length;
            //print out answer
            System.out.println("The longest path is:");
            System.out.println(longestWay(arr,n,m));
        }

    static int longestWay(int[][]a,int n, int m){
        int[][]b = new int[n][m];
        //add values of top row because they can only get there from the left
        for(int i=1; i < m; i++ ) {
            a[0][i] = a[0][i-1]+a[0][i];
        }
        //add values of most left column because it can only be reached from top to bottom
        for(int i=1; i < n; i++ ) {
            a[i][0] = a[i-1][0]+a[i][0];
        }
        //compare values for down, right, and diag
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                //compare top
                if(a[i][j] + a[i-1][j]>a[i][j] + a[i][j-1] && a[i][j] + a[i-1][j]>a[i][j] + a[i-1][j-1])
                    a[i][j]=a[i][j] + a[i-1][j];
                //compare fromLeft
                if(a[i][j] + a[i][j-1]>a[i][j] + a[i-1][j] && a[i][j] + a[i-1][j]>a[i][j] + a[i-1][j-1])
                    a[i][j]=a[i][j] + a[i][j-1];
                //compare diag
                if(a[i][j] + a[i-1][j-1]>a[i][j] + a[i][j-1] && a[i][j] + a[i-1][j]>a[i][j] + a[i-1][j])
                    a[i][j]=a[i][j] + a[i-1][j-1];
            }
        }
        //return last value/longest path
        return a[n-1][m-1];
    }
}
