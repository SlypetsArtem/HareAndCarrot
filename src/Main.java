import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] carrots = {3, 2, 1, 4, 5, 6};     //массив полянок с указанными весами моркови на каждой
        int tonnage = 5;                        //грузоподъёмность нашего Зайца
        int steps = 10;                         //количество ходок в день

        printAnswer(carrots, tonnage, steps);
    }

    /*
     * Метод для получения массива из двух чисел
     * На первой позиции ответ на саму задачу
     * Второй индекс —  вес моркови, которую используем.(С ним метод более громоздкий, но ответ максимально информативный)*/
    private static int[] getMaxCountCarrotsAndWeight(int[] carrots, int tonnage, int steps) {
        int[] maxCountAndWeight = new int[2];
        Arrays.sort(carrots); // сортируем полученный массив.
        // Присваиваем максимальное количество моркови, которое может унести Заяц за N ходок.
        maxCountAndWeight[0] = tonnage / carrots[0] * steps;
        // Присваиваем вес моркови, которую используем
        maxCountAndWeight[1] = carrots[0];

        return maxCountAndWeight;
    }

    private static void printAnswer(int[] carrots, int steps, int tonnage) {

        String answerString = "Максимальное возможное количество моркови, которое Заяц может унести с полянок " +
                "за 1 день c %d-ю ходками и имея грузоподъемность %d кг - %d шт, вес каждой = %d кг, общий вес - %d кг.";

        // Объявляем массив с результатами, чтобы не вызывать метод два раза
        int[] maxCountCarrotsAndWeight = getMaxCountCarrotsAndWeight(carrots, tonnage, steps);


        int maxCountCarrot = maxCountCarrotsAndWeight[0];   // ответ
        int weightCarrot = maxCountCarrotsAndWeight[1];     // вес используемой моркови

        System.out.format(answerString, steps, tonnage, maxCountCarrot, weightCarrot, weightCarrot * maxCountCarrot);
    }
}