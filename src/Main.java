import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] carrots = {3, 2, 1, 4, 5, 6};     //массив полянок с указанными весами моркови на каждой
        int tonnage = 5;                        //грузоподъёмность нашего Зайца
        int steps = 10;                         //количество ходок в день
        String answerString = "Максимальное возможное количество моркови, которое Заяц может унести с полянок " +
                "за 1 день c %d-ю ходками и имея грузоподъемность %d кг - %d шт, вес каждой = %d кг, общий вес - %d кг.";

        Arrays.sort(carrots); // на тот случай, если веса моркови будут введены не в порядке возрастания.


        // Объявляем массив с результатами, чтобы не вызывать метод два раза
        int[] maxCountCarrotsAndWeight = getMaxCountCarrotsAndWeight(carrots, tonnage, steps);


        int maxCountCarrot = maxCountCarrotsAndWeight[0];   // ответ
        int weightCarrot = maxCountCarrotsAndWeight[1];     // вес используемой моркови

        System.out.format(answerString, steps, tonnage, maxCountCarrot, weightCarrot, weightCarrot * maxCountCarrot);

    }

    /*
     * Метод для получения массива из двух чисел
     * На первой позиции ответ на саму задачу
     * Второй индекс —  вес моркови, которую используем.(С ним метод более громоздкий, но ответ максимально информативный)*/
    private static int[] getMaxCountCarrotsAndWeight(int[] carrots, int tonnage, int steps) {
        int[] maxCountAndWeight = new int[2];
        int maxCountCarrot = 0; // максимальное количество моркови, при её минимальном весе
        int carrotWeight;       // вес используемой моркови
        // Проходим циклом по данному массиву полянок с весами
        for (carrotWeight = 0; carrotWeight < carrots.length; carrotWeight++) {
            // Делим без остатка грузоподъёмность на вес моркови в итерируемом массиве
            if (tonnage / carrots[carrotWeight] > maxCountCarrot) {
                // Присваиваем максимальное количество моркови, которое может унести Заяц за одну ходку.
                maxCountCarrot = tonnage / carrots[carrotWeight];
                // Присваиваем вес моркови, которую используем
                maxCountAndWeight[1] = carrots[carrotWeight];
            }
        }

        // присваиваем максимальное количество моркови, которое может унести Заяц за N ходок.
        maxCountAndWeight[0] = maxCountCarrot * steps;
        return maxCountAndWeight;
    }
}