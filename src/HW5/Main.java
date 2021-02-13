package HW5;

public class Main {
    static final int size = 1000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        float[] arr = new float[size];
        long test1 = test1(arr);
        long test2 = test2(arr);
        System.out.printf("В 1 поток %s, в 2 потока %s, в два потока быстрее в %s раза.",
                test1, test2, ((float)test1/test2));

    }
    static long test1 (float[] arr){
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i / 5)
                    * Math.cos(0.4f + i / 2));
        }
        return (System.currentTimeMillis() - a);
    }
    static long test2 (float[] arr){
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        Thread t1 = new Thread(()->{
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5)
                        * Math.cos(0.2f + i / 5)
                        * Math.cos(0.4f + i / 2));
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = (float)(arr2[i] * Math.sin(0.2f + i / 5)
                        * Math.cos(0.2f + i / 5)
                        * Math.cos(0.4f + i / 2));
            }
        });
        long a = System.currentTimeMillis();
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        return (System.currentTimeMillis() - a);
    }
}

