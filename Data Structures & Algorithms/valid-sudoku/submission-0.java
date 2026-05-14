class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board[i])) return false;
            if (!isValidColumn(board, i)) return false;
        }

        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3){
                if (!isValidBox(board, i, j)) return false;
            }
        }
        return true;
    }

    private boolean isValidRow(char[] row) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < 9; i++) {

            if (row[i] == '.') continue;
            
            int number = row[i] - '0';
            count.put(number, count.getOrDefault(number, 0) + 1);

            if (count.get(number) > 1) {
                return false;
            }
            
        }

        return true;
    }

    private boolean isValidColumn(char[][] board, int column) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < 9; j++) {
            if (board[j][column] == '.') continue;

            int number = board[j][column] - '0';
            count.put(number, count.getOrDefault(number, 0) + 1);
            if (count.get(number) > 1) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidBox(char[][] board, int row, int column) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = column; j < column + 3; j++) {
                if (board[i][j] == '.') continue;

                int number = board[i][j] - '0';
                count.put(number, count.getOrDefault(number, 0) + 1);
                if (count.get(number) > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
