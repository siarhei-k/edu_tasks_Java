public class matrix {

    public static void main(String[] args) {

        // hardcoded matrix
        int [] [] matrix = {
                {10, 12, 11},
                {9, 8, 31},
                {2, 16, 24}
        };

        int numberOfRows = matrix.length;
        int numberOfColumns = matrix[0].length;
        int secondaryDiagonal = 0;
        int matrixSize = matrix.length -1;

        if (numberOfRows != numberOfColumns) { // checking for square matrix
            System.out.println("This is not a square matrix");
        } else { // if matrix is square
            for (int i = 0; i < matrix.length; i++) { // calculating the second diagonal
                secondaryDiagonal += matrix[i][matrixSize - i];
            }
            System.out.println("Secondary diagonal is " + secondaryDiagonal);
        }


    }
}