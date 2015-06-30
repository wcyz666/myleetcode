public class Solution {
	
	/*
	 * Well, this problem desires for the use of dynamic programming. They key to any DP problem is to come up with the state equation. In this problem, we define the state to be the maximal size of the square that can be achieved at point (i, j), denoted as P[i][j]. Remember that we use size instead of square as the state (square = size^2).

Now let's try to come up with the formula for P[i][j].

First, it is obvious that for the topmost row (i = 0) and the leftmost column (j = 0), P[i][j] = matrix[i][j]. This is easily understood. Let's suppose that the topmost row of matrix is like [1, 0, 0, 1]. Then we can immediately know that the first and last point can be a square of size 1 while the two middle points cannot make any square, giving a size of 0. Thus, P = [1, 0, 0, 1], which is the same as matrix. The case is similar for the leftmost column. Till now, the boundary conditions of this DP problem are solved.

Let's move to the more general case for P[i][j] in which i > 0 and j > 0. First of all, let's see another simple case in which matrix[i][j] = 0. It is obvious that P[i][j] = 0 too. Why? Well, since matrix[i][j] = 0, no square will contain matrix[i][j]. According to our definition of P[i][j], P[i][j] is also 0.

Now we are almost done. The only unsolved case is matrix[i][j] = 1. Let's see an example.

Suppose matrix = [[0, 1], [1, 1]], it is obvious that P[0][0] = 0, P[0][1] = P[1][0] = 1, what about P[1][1]? Well, to give a square of size larger than 1 in P[1][1], all of its three neighbors (left, up, left-up) should be non-zero, right? In this case, the left-up neighbor P[0][0] = 0, so P[1][1] can only be 1, which means that it contains the square of itself.

Now you are near the solution. In fact, P[i][j] = min(P[i - 1][j], P[i][j - 1], P[i - 1][j - 1]) + 1 in this case.

Taking all these together, we have the following state equations.

P[0][j] = matrix[0][j] (topmost row);
P[i][0] = matrix[i][0] (leftmost column);
For i > 0 and j > 0: if matrix[i][j] = 0, P[i][j] = 0; if matrix[i][j] = 1, P[i][j] = min(P[i - 1][j], P[i][j - 1], P[i - 1][j - 1]) + 1.
Putting them into codes, and maintain a variable maxsize to record the maximum size of the square we have seen, we have the following (unoptimized) solution.

int maximalSquare(vector<vector<char>>& matrix) {
    int m = matrix.size();
    if (!m) return 0;
    int n = matrix[0].size();
    vector<vector<int> > size(m, vector<int>(n, 0));
    int maxsize = 0;
    for (int j = 0; j < n; j++) {
        size[0][j] = matrix[0][j] - '0';
        maxsize = max(maxsize, size[0][j]);
    }
    for (int i = 1; i < m; i++) {
        size[i][0] = matrix[i][0] - '0';
        maxsize = max(maxsize, size[i][0]);
    }
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            if (matrix[i][j] == '1') {
                size[i][j] = min(size[i - 1][j - 1], min(size[i - 1][j], size[i][j - 1])) + 1;
                maxsize = max(maxsize, size[i][j]);
            }
        }
    }
    return maxsize * maxsize;
}
	 */
	
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] maxRow = new int[m][n];
        int[][] maxCol = new int[m][n];
        int length = 0;
        for (int i = 0; i < m; i++) {
            maxRow[i][0] = matrix[i][0] - '0';
            for (int j = 1; j < n; j++)
                if (matrix[i][j] == '1')
                    maxRow[i][j] = maxRow[i][j - 1] + 1;
        }
        
        for (int i = 0; i < n; i++) {
            maxCol[0][i] = matrix[0][i] - '0';
            for (int j = 1; j < m; j++)
                if (matrix[j][i] == '1')
                    maxCol[j][i] = maxCol[j - 1][i] + 1;
        }
        
        
        for (int i = 0; i < m - length ; i++) {
            for (int j = 0; j < n - length; j++) {
                if (matrix[i][j] == '1') {
                	int tmp = 1;
                	int i1 = i + 1;
                	int j1 = j + 1;
                	while (i1 < m && j1 < n && maxCol[i1][j1] > tmp && maxRow[i1][j1] > tmp) {
                		++i1;
                		++j1;
                		++tmp;
                	}
                	if (tmp > length)
                		length = tmp;
                }
            }
        }
        return length;
    }
    public static void main(String[] args) {
		new Solution().maximalSquare(new char[][]{
			{'0', '1', '1', '1'},
			{'0', '1', '1', '1'},
			{'0', '1', '1', '1'},
			{'0', '1', '0', '0'}
		});
	}
}