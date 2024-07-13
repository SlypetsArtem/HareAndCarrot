import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] carrots = {3, 2, 1, 4, 5, 6};
        int tonnage = 5;
        int steps = 10;
        String answerString = "Максимальное возможное количество моркови, которое Заяц может унести с полянок " +
                "за 1 день c %d-ю ходками и имея грузоподъемность %d кг - %d шт, вес каждой = %d кг, общий вес - %d кг.";

        Arrays.sort(carrots); // на тот случай, если веса моркови будут введены не в порядке возрастания.


        int[] maxCountCarrotsAndWeight = getMaxCountCarrotsAndWeight(carrots, tonnage, steps);


        int maxCountCarrot = maxCountCarrotsAndWeight[0];
        int weightCarrot = maxCountCarrotsAndWeight[1];

        System.out.format(answerString, steps, tonnage, maxCountCarrot, weightCarrot, weightCarrot * maxCountCarrot);

    }

    private static int[] getMaxCountCarrotsAndWeight(int[] carrots, int tonnage, int steps) {
        int[] maxCountAndWeight = new int[2];
        int maxCountCarrot = 0;
        int carrotWeight;
        for (carrotWeight = 0; carrotWeight < carrots.length; carrotWeight++) {
            if (tonnage / carrots[carrotWeight] > maxCountCarrot) {
                maxCountCarrot = tonnage / carrots[carrotWeight];
                maxCountAndWeight[1] = carrots[carrotWeight];
            }
        }

        maxCountAndWeight[0] = maxCountCarrot * steps;
        return maxCountAndWeight;
    }


}