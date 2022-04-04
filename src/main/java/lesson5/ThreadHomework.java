package lesson5;

import java.util.Arrays;

public class ThreadHomework {

    static final int SIZE = 10_000_000;

    public static void main(String[] args) {
        firstMethod(SIZE);
        secondMethod(SIZE);
    }
    public static void firstMethod(int size) {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() -
                startTime) + " ms.");
    }


    public static void secondMethod(int size) {
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();

        // Создаем два массива для левой и правой части исходного
        float[] leftHalf = new float[size/2];
        float[] rightHalf = new float[size/2];
        // Копируем в них значения из большого массива
        System.arraycopy(arr, 0, leftHalf, 0, size/2);
        System.arraycopy(arr, size/2, rightHalf, 0, size/2);

        final Thread thread1 = new Thread(() -> {
            for (int i = 0; i < leftHalf.length; i++) {
                leftHalf[i] = (float) (leftHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });



        final Thread thread2 = new Thread(() -> {
            for (int i = 0;i < rightHalf.length; i++) {
                rightHalf[i] = (float) (rightHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(leftHalf, 0, arr, 0, size/2);
        System.arraycopy(rightHalf, 0, arr, size/2, size/2);




// Запускает два потока и параллельно просчитываем каждый малый массив
// ...
// Склеиваем малые массивы обратно в один большой
// ...
        System.out.println("Two thread time: " + (System.currentTimeMillis() -
                startTime) + " ms.");
    }

}
