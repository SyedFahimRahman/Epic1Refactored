import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EpicRefactored {

    public static void main(String[] args) {
        questionsAnswers();
    }
    // Entry point for the quiz application
    public static void questionsAnswers() {
        // Read quiz data for different difficulty levels
        QuizData easyData = readQuizData("easy");
        QuizData mediumData = readQuizData("medium");
        QuizData hardData = readQuizData("hard");

        Scanner scanner = new Scanner(System.in);
        // Display menu for quiz options
        System.out.println("Which type of quiz would you like to play?");
        System.out.println("1. Random");
        System.out.println("2. Easy to Hard");
        System.out.println("3. Speedrun");
        System.out.println("Enter your choice (1/2/3): ");

        int option = scanner.nextInt();
        // Perform actions based on user's choice
        switch (option) {
            case 1:
                randomQuiz(easyData.questions, easyData.answerChoices, easyData.correctAnswers);
                break;
            case 2:
                difficultyLevel(easyData, mediumData, hardData);
                break;
            case 3:
                speedrunQuiz(easyData.questions, easyData.answerChoices, easyData.correctAnswers);
                break;
            default:
                System.out.println("Invalid choice.");
        }
        scanner.close();
    }
    // Read quiz data from files for a given difficulty level
    public static QuizData readQuizData(String difficulty) {
        String[] questions = readQuestionsFromFile("C://Users//23376066//Desktop//Questions for epic 1/" + difficulty + "Questions.txt");
        String[][] answerChoices = readAnswerChoicesFromFile("C://Users//23376066//Desktop//Questions for epic 1/" + difficulty + "AnswerChoices.txt");
        char[] correctAnswers = readCorrectAnswersFromFile("C://Users//23376066//Desktop//Questions for epic 1/" + difficulty + "CorrectAnswers.txt");

        return new QuizData(questions, answerChoices, correctAnswers);
    }
    // Read questions from a file
    public static String[] readQuestionsFromFile(String filename) {
        return readFileLines(filename);
    }
    // Read questions from a file
    public static String[][] readAnswerChoicesFromFile(String filename) {
        return readAnswerChoices(filename);
    }
    // Read questions from a file
    public static char[] readCorrectAnswersFromFile(String filename) {
        return readCorrectAnswers(filename);
    }
    // Perform the quiz for different difficulty levels
    public static void difficultyLevel(QuizData easyData, QuizData mediumData, QuizData hardData) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        // Display and process easy questions
        System.out.println("EASY QUESTIONS:");
        score += askQuestions(easyData);

        // Display and process medium questions
        System.out.println("\nMEDIUM QUESTIONS:");
        score += askQuestions(mediumData);

        // Display and process difficult questions
        System.out.println("\nDIFFICULT QUESTIONS:");
        score += askQuestions(hardData);

        // Display final score
        System.out.println("Quiz completed! Your final score: " + score);

        scanner.close();
    }

    // Conduct a random quiz
    public static void randomQuiz(String[] questions, String[][] answerChoices, char[] correctAnswers) {
        int score = 0;
        int[] questionOrder = generateRandomOrder(questions.length);

        Scanner scanner = new Scanner(System.in);

        // Iterate through questions in random order
        for (int i = 0; i < questions.length; i++) {
            int questionIndex = questionOrder[i];
            System.out.println(questions[questionIndex]);

            // Shuffle answer choices
            String[] shuffledChoices = shuffleArray(answerChoices[questionIndex]);
            char correctAnswer = correctAnswers[questionIndex];

            // Display shuffled answer choices
            for (int j = 0; j < shuffledChoices.length; j++) {
                System.out.println((char) ('A' + j) + ": " + shuffledChoices[j]);
            }

            // Prompt user for answer
            System.out.print("Enter your answer (A, B, C, or D): ");
            char userAnswer = scanner.next().toUpperCase().charAt(0);

            // Check if the answer is correct
            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + correctAnswer);
            }

            System.out.println("Your current score: " + score);
        }
        // Display final score
        System.out.println("Quiz completed! Your final score: " + score);
    }


    // Conduct a speedrun quiz
    public static void speedrunQuiz(String[] questions, String[][] answerChoices, char[] correctAnswers) {
        int score = 0;
        int[] questionOrder = generateRandomOrder(questions.length);

        // Iterate through questions in speedrun mode
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);

            String[] choices = answerChoices[i];
            char choiceLetter = 'A';

            // Display answer choices
            for (String choice : choices) {
                System.out.println(choiceLetter + ": " + choice);
                choiceLetter++;
            }

            // Prompt user for answer with a timer
            System.out.print("Enter your answer (A, B, C, or D): ");
            char userAnswer = ' ';
            ScheduledExecutorService timerService = Executors.newSingleThreadScheduledExecutor();
            final boolean[] answered = {false};

            // Set a timer for 20 seconds
            timerService.schedule(() -> {
                if (!answered[0]) {
                    System.out.println("Sorry, too slow!");
                }
                timerService.shutdownNow();
            }, 20, TimeUnit.SECONDS);

            Scanner scanner = new Scanner(System.in);
            userAnswer = scanner.next().toUpperCase().charAt(0);
            timerService.shutdownNow();
            answered[0] = true;

            // Check if the answer is correct
            if (userAnswer == correctAnswers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + correctAnswers[i]);
            }

            System.out.println("Your current score: " + score);
        }
    }

    // Process and score a set of questions
    public static int askQuestions(QuizData quizData) {
        int score = 0;
        for (int i = 0; i < quizData.questions.length; i++) {
            System.out.println(quizData.questions[i]);

            // Display answer choices
            for (String choice : quizData.answerChoices[i]) {
                System.out.println(choice);
            }

            // Prompt user for answer
            System.out.print("Enter your answer (A, B, C or D): ");
            char userAnswer = ' ';
            Scanner scanner = new Scanner(System.in);
            userAnswer = scanner.next().toUpperCase().charAt(0);

            // Check if the answer is correct
            if (userAnswer == quizData.correctAnswers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + quizData.correctAnswers[i]);
            }

            System.out.println("Your current score: " + score);
        }
        return score;
    }
    // Generate a random order of indices
    static int[] generateRandomOrder(int length) {
        int[] order = new int[length];
        for (int i = 0; i < length; i++) {
            order[i] = i;
        }
        Random random = new Random();
        for (int i = length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = order[i];
            order[i] = order[j];
            order[j] = temp;
        }

        return order;
    }

    // Shuffle the elements of an array
    private static String[] shuffleArray(String[] array) {
        String[] shuffledArray = Arrays.copyOf(array, array.length);
        Random random = new Random();

        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            String temp = shuffledArray[i];
            shuffledArray[i] = shuffledArray[j];
            shuffledArray[j] = temp;
        }

        return shuffledArray;
    }

    // Read lines from a file
    private static String[] readFileLines(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.lines().toArray(String[]::new);
        } catch (IOException e) {
            handleFileReadError(filename, e);
            return new String[]{"Default Question 1", "Default Question 2", "Default Question 3"};
        }
    }

    // Read answer choices from a file
    private static String[][] readAnswerChoices(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            ArrayList<String[]> answerChoicesList = new ArrayList<>();
            String line;
            String currentQuestion = null;
            ArrayList<String> currentAnswerChoices = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                if (line.trim().matches("[A-D]\\)\\s.*")) {
                    currentAnswerChoices.add(line.trim().substring(3));
                } else {
                    if (currentQuestion != null) {
                        answerChoicesList.add(currentAnswerChoices.toArray(new String[0]));
                    }
                    currentQuestion = line.trim();
                    currentAnswerChoices = new ArrayList<>();
                }
            }

            if (currentQuestion != null) {
                answerChoicesList.add(currentAnswerChoices.toArray(new String[0]));
            }

            return answerChoicesList.toArray(new String[0][]);
        } catch (IOException e) {
            handleFileReadError(filename, e);
            return new String[][]{{"Default Choice 1", "Default Choice 2", "Default Choice 3", "Default Choice 4"}};
        }
    }

    // Read correct answers from a file
    private static char[] readCorrectAnswers(String filename) {
        try (Scanner scanner = new Scanner(new FileReader(filename))) {
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNext()) {
                sb.append(scanner.nextLine().trim());
            }
            return sb.toString().toCharArray();
        } catch (IOException e) {
            handleFileReadError(filename, e);
            return new char[]{'A', 'B', 'C', 'D'};
        }
    }

    // Handle errors that occur during file reading
    private static void handleFileReadError(String filename, IOException e) {
        System.err.println("Error reading file " + filename + ": " + e.getMessage());
    }

    // Data structure to hold quiz information
    static class QuizData {
        String[] questions;
        String[][] answerChoices;
        char[] correctAnswers;

        QuizData(String[] questions, String[][] answerChoices, char[] correctAnswers) {
            this.questions = questions;
            this.answerChoices = answerChoices;
            this.correctAnswers = correctAnswers;
        }
    }
}