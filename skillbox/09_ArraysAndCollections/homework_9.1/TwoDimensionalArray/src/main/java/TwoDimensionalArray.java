public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]
        char[][] arraySymbol = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arraySymbol[i][j] = ' ';
            }
            arraySymbol[i][i] = symbol;
            arraySymbol[i][size - i - 1] = symbol;
        }

        return arraySymbol;
    }
}
