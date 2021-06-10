package genetic;

public class Main {

    public static final int MAX_ITERATIONS = 1;

    public static void main(String[] args) {
        System.out.println("Количество индивидуумов= " + Population.POPULATION_COUNT);
        System.out.println("Количество генов= " + Chromosome.GENES_COUNT);
        Population test = new Population();
        test.createInitialPopulation();
        int iterationsNumber = 0;
        do {
            System.out.println("Итерация №" + iterationsNumber);
            int fillingWithFitnessesResult = test.fillChromosomesWithFitnesses();
            if (fillingWithFitnessesResult != Population.TARGET_NOT_REACHED_FLAG) {
                System.out.println("\nРешение найдено: " + test.getPopulation()[fillingWithFitnessesResult]);
                return;
            }
            Chromosome[][] pairs = test.getPairsForCrossover();
            Chromosome[] nextGeneration = test.getNewPopulation(pairs);
            test.setPopulation(nextGeneration);

        } while (iterationsNumber++ < MAX_ITERATIONS);
        System.out.println("Решение не найдено. Попробуйте еще...");
    }

    public static float getRandomFloat(float min, float max) {
        return (float) (Math.random() * max + min);
    }

}
