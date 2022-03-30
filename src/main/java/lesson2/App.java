package lesson2;

public class App {

    private static final int TABLE_SIZE = 4;

    private static final String[][] table = {
            {"1", "1", "1", "1"},
            {"2", "2", "2", "2"},
            {"3", "3", "3", "3"},
            {"4", "b", "4", "4"},
            //{}
    };


    public static void main(String[] args) {
        try {
            System.out.println(parsAndSum(table));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static Integer parsAndSum(String[][] strings) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (strings.length != TABLE_SIZE){
            throw new MyArraySizeException("размер массива не равен " + TABLE_SIZE);
        }
        for (String[] string : strings) {
            for (String s : string) {
                try {
                    sum += Integer.parseInt(s);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException("не удалось распарсить массив");
                }
            }
        }
        return sum;
    }

}
