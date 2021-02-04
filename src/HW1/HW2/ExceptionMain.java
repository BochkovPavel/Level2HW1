package HW1.HW2;

public class ExceptionMain {
    public static void main(String[] args) {
        String[][] strArr = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
        };
        System.out.println("Test 1 :" + sumArray(strArr));
        String[][] strArr1 = {
                {"1", "2", "3", "4"},
                {"1", "2", "3"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
        };
        System.out.println("Test 2 :" + sumArray(strArr1));
        String[][] strArr2 = {
                {"1", "2", "3", "Хаха"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
        };
        System.out.println("Test 3 :" + sumArray(strArr2));
    }
    /**
     * Метод проверяет размерность массива. Массив должен быть 4*4. И вызисляет сумму значений массива.
     * @param strArray - массив строк
     */
    public static int sumArray (String[][] strArray){
       int result = 0;
        try {
           if (strArray.length ==4){
               for (int i = 0; i < strArray.length; i++) {
                   if (strArray[i].length == 4) {
                       for (int j = 0; j < strArray[i].length; j++) {
                           try {
                               result += Integer.parseInt(strArray[i][j]);
                           }catch (Exception e){
                               result =0;
                               throw new MyArrayDataException("Преобразовать к числу невозможно");
                           }
                       }
                   }else {
                       result =0;
                       throw new MySizeArrayException("Передан массив неправильной размерности");
                   }
               }
           }else  throw new MySizeArrayException("Передан массив неправильной размерности");
       }catch (MySizeArrayException | MyArrayDataException  e ){
            e.printStackTrace();
       }finally {
            return result;
        }
    }
}

