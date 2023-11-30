package Epic;

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
public class Epic {
    public static void main(String[] args) {
        questionsAnswers();
    }


    public static void questionsAnswers() {
        String[] easyQuestions = {
                "What is a Hasse diagram?",
                "What does CPU stand for?",
                "What is the Number 1 SuperComputer in the world? ",
                "What does BNF stand for?",
                "What is a roster method?",
                "Determine the missing term in the sequence: 4, 12, __, 108, 324, 972.",
        };

        String[][] easyAnswerChoices = {
                {"A) A Hasse diagram is a type of mathematical diagram used to represent a finite partially ordered set.", "B) A Hasse diagram is a software tool used to create 3D models and animations.", "C) A Hasse diagram is a hypothetical chart used to represent complex problem-solving processes and identify potential sources of inconvenience in a systematic way.", "D) A Hasse diagram is a type of bar chart used to represent data visually."},
                {"A) Computer Programming Unit  ", "B) Central Processing Unit  ", "C) Cooling Power Unit ", "D) Computational Power Unit "},
                {"A) Fujitsu Fugaku ", "B) HPE Cray Lumi ", " C) HPE Cray Frontier  ", " D) HPE Cray Perlmutter  "},
                {"A) Binary Number Format. ", "B) Bartus-Notation Framework  ", "C) Becker-Navigation Framework ", "D) Backus-Naur Form "},
                {"A) Its an organised list of individuals in an organisation. ", " B) It uses predicate logic to represent elements of a set.", "C) Its an unordered collection of distinct objects referred to as elements ", "D) Its a way to show the elements of a set by listing the elements inside of curly brackets. "},
                {"A) 36", "B) 25 ", "C) 92", "D) 24"},
        };

        char[] easyCorrectAnswers = {'A', 'B', 'C', 'D', 'D', 'A'};

        String[] mediumQuestions = {
                "If X and y are the two finite sets, such that n(X U Y) = 36, n(X) = 20, n(Y) = 28, then find n( X ∩ Y).",
                "What is the cardinality of \uD835\uDC34, if A = {\uD835\uDC65∈Z | \uD835\uDC65 < 7 and \uD835\uDC65 is odd }?",
                "What is a semantics?",
                "What is a Lattice?",
                "What is the primary function of the CPU in a computer system?",
                "How many levels are in the Multilevels Machines?",

        };

        String[][] mediumAnswerChoices = {
                {"A) 15 ", " B) 12 ", " C) 8 ", " D) 13 "},
                {"A) 5", " B) 2 ", "C) 4 ", "D) 3 "},
                {"A) Semantics is the study of the meanings of words and phrases in language, but it's primarily concerned with how grammar and punctuation affect meaning.  ", "B) Semantics, in the context of computer science, linguistics, and philosophy, refers to the study of meaning in language and other symbolic systems.", "C) Semantics is the practice of interpreting the emotions and intentions behind a person's words, rather than the literal meaning of what they say. ", "D) Semantics is the field of study that focuses on understanding the meaning of texts, emphasizing the use of tone and context, but not the structure and syntax of language. "},
                {"A) In computer science, this term refers to complex, networked structures used in quantum computing, where information is processed in intricate, interconnected arrangements that mimic natural phenomena. ", "B) A lattice is a partially ordered set in which every two elements have both a greatest lower bound and a least upper bound.", "C) A lattice is a type of geometric shape with seven sides and six corners. ", "D) These are intricate, ornate patterns formed by intertwining threads or ropes, often used in art and architecture, resembling complex geometric designs."},
                {"A) The CPU is considered a master of languages, capable of instant translation of any spoken or written language, aiding global communication. ", "B) The CPU processes human thoughts and decisions, making it the thinking component of the computer. ", " C) In a fictional scenario, the CPU is thought to handle conversations, interpreting and generating human speech. It helps the computer engage in chit-chat with the user.  ", "D) The function of the CPU in a computer system is to execute instructions and perform calculations that are essential for the operation of the computer "},
                {"A) 5 levels ", "B) 6 levels ", "C) 7 levels ", "D) 4 levels "},
        };

        char[] mediumCorrectAnswers = {'B', 'D', 'B', 'B', 'D', 'B',};

        String[] hardQuestions = {
                "What is Homomorphism?",
                "What is a Binary Decision Diagram (BDD)?",
                "What is the function of The von Neumann bottleneck?",
                "What is the role of Cache memory in Comp Org?",
                "Negate ¬∀xP(x)",
                "Is [(A→B)∧A]→B a tautology?"
        };

        String[][] hardAnswerChoices = {
                {"A) A misunderstood term referring to the idea that mathematical objects can somehow grow or evolve into more complex structures.", "B) A concept in computer graphics that refers to transformations applied to images to make them appear consistent and uniform but not related to algebraic structures. ", "C) A homomorphism is a mathematical concept that arises in various branches of mathematics, such as algebra, group theory, and ring theory.", "D) A term used in topology to describe transformations that maintain the shape of objects but are unrelated to algebraic structures."},
                {"A) A BDD is a directed graph where each node represents a variable or a decision point. It's used to represent and analyze Boolean functions. ", "B) A document used by individuals to help decide what to have for breakfast. It contains binary choices like \\\"cereal or pancakes,\\\" \\\"coffee or tea,\\\" and \\\"fruit or no fruit.\\\"  ", "C) A chart for determining whether to take a binary approach to life decisions. It offers options like \\\"Yes\\\" or \\\"No\\\" for life's most critical questions, such as \\\"Should I wear socks today?\\\" ", "D) A tool for helping computers make decisions by flipping a binary coin. It consists of a visual representation of a coin toss, where heads (H) means \\\"yes,\\\" and tails (T) means \\\"no\\\" for computer choices. "},
                {"A) The primary function of the von Neumann bottleneck is to slow down data transfer and limit the overall performance of a computer system.  ", "B) The von Neumann bottleneck is responsible for increasing the computer's energy efficiency by minimizing data transfer speed.  ", "C) It acts as a memory security feature, preventing unauthorized access to the computer's data and instructions.  ", "D) The von Neumann bottleneck is a performance-enhancing feature that speeds up data transfers between the CPU and memory in a computer system. "},
                {"A) Cache memory translates code and data into different programming languages.  ", "B) Cache memory predicts the future, storing data the CPU will need next. ", "C) Cache memory stores accessed data and instructions, reducing the time it takes for the CPU to retrieve information from main memory. ", "D) Cache memory helps keep the CPU cold.  "},
                {"A) ∃x¬P(x) ", "B) ∀xP(x) ", "C) ∃xP(x) ", "D) ¬∀x ¬P(x) "},
                {"A) true", "B) false"},
        };

        char[] hardCorrectAnswers = {'C', 'A', 'A', 'C', 'D', 'A'};

        String[] questions = {
                "What is a Hasse diagram?",
                "What is a Lattice?",
                "What is Homomorphism?",
                "What does BNF stand for?",
                "What is a Binary Decision Diagram (BDD)?",
                "What is a semantics?",
                "What does CPU stand for?",
                "What is the function of The von Neumann bottleneck?",
                "What is the Number 1 SuperComputer in the world?",
                "What is the function of the CPU in a computer system?",
                "How many levels are in the Multilevel Machines? ",
                "What is the role of Cache memory in Comp Org?",
                "Negate ¬∀xP(x)",
                "What is a roster method?",
                "If X and y are the two finite sets, such that n(X U Y) = 36, n(X) = 20, n(Y) = 28, then find n( X ∩ Y).",
                "What is the cardinality of \uD835\uDC34, if A = {\uD835\uDC65∈Z | \uD835\uDC65 < 7 and \uD835\uDC65 is odd }?",
                "Determine the missing term in the sequence: 4, 12, __, 108, 324, 972. (Easy)",
                "Is [(A→B)∧A]→B a tautology?",
        };
        String[][] answerChoices = {
                {"A) A Hasse diagram is a type of mathematical diagram used to represent a finite partially ordered set.", "B) A Hasse diagram is a software tool used to create 3D models and animations.", "C) A Hasse diagram is a hypothetical chart used to represent complex problem-solving processes and identify potential sources of inconvenience in a systematic way.", "D) A Hasse diagram is a type of bar chart used to represent data visually."},
                {"A) In computer science, this term refers to complex, networked structures used in quantum computing, where information is processed in intricate, interconnected arrangements that mimic natural phenomena. ", "B) A lattice is a partially ordered set in which every two elements have both a greatest lower bound and a least upper bound.", "C) A lattice is a type of geometric shape with seven sides and six corners. ", "D) These are intricate, ornate patterns formed by intertwining threads or ropes, often used in art and architecture, resembling complex geometric designs."},
                {"A) A misunderstood term referring to the idea that mathematical objects can somehow grow or evolve into more complex structures.", "B) A concept in computer graphics that refers to transformations applied to images to make them appear consistent and uniform but not related to algebraic structures. ", "C) A homomorphism is a mathematical concept that arises in various branches of mathematics, such as algebra, group theory, and ring theory.", "D) A term used in topology to describe transformations that maintain the shape of objects but are unrelated to algebraic structures."},
                {"A) Binary Number Format. ", "B) Bartus-Notation Framework  ", "C) Becker-Navigation Framework  ", "D) Backus-Naur Form "},
                {"A) A BDD is a directed graph where each node represents a variable or a decision point. It's used to represent and analyze Boolean functions. ", "B) A document used by individuals to help decide what to have for breakfast. It contains binary choices like \"cereal or pancakes,\" \"coffee or tea,\" and \"fruit or no fruit.\"  ", "C) A chart for determining whether to take a binary approach to life decisions. It offers options like \"Yes\" or \"No\" for life's most critical questions, such as \"Should I wear socks today?\" ", "D) A tool for helping computers make decisions by flipping a binary coin. It consists of a visual representation of a coin toss, where heads (H) means \"yes,\" and tails (T) means \"no\" for computer choices. "},
                {"A) Semantics is the study of the meanings of words and phrases in language, but it's primarily concerned with how grammar and punctuation affect meaning.  ", "B) Semantics, in the context of computer science, linguistics, and philosophy, refers to the study of meaning in language and other symbolic systems.  ", "C) Semantics is the practice of interpreting the emotions and intentions behind a person's words, rather than the literal meaning of what they say. ", "D) Semantics is the field of study that focuses on understanding the meaning of texts, emphasizing the use of tone and context, but not the structure and syntax of language. "},
                {"A) Computer Programming Unit  ", "B) Central Processing Unit  ", "C) Cooling Power Unit ", "D) Computational Power Unit "},
                {"A) The primary function of the von Neumann bottleneck is to slow down data transfer and limit the overall performance of a computer system.  ", "B) The von Neumann bottleneck is responsible for increasing the computer's energy efficiency by minimizing data transfer speed.  ", "C) It acts as a memory security feature, preventing unauthorized access to the computer's data and instructions.  ", "D) The von Neumann bottleneck is a performance-enhancing feature that speeds up data transfers between the CPU and memory in a computer system.  "},
                {"A) Fujitsu Fugaku  ", "B) HPE Cray Lumi ", "C) HPE Cray Frontier  ", "D) HPE Cray Perlmutter  "},
                {"A) The CPU is considered a master of languages, capable of instant translation of any spoken or written language, aiding global communication. ", "B) The CPU processes human thoughts and decisions, making it the \"thinking\" component of the computer. ", "C) In a fictional scenario, the CPU is thought to handle conversations, interpreting and generating human speech. It helps the computer engage in chit-chat with the user.  ", "D) The function of the CPU in a computer system is to execute instructions and perform calculations that are essential for the operation of the computer "},
                {"A) 5 levels  ", "B) 6 levels  ", "C) 7 levels  ", "D) 4 levels  "},
                {"A) Cache memory translates code and data into different programming languages.  ", "B) Cache memory predicts the future, storing data the CPU will need next. ", "C) Cache memory stores accessed data and instructions, reducing the time it takes for the CPU to retrieve information from main memory. ", "D) Cache memory helps keep the CPU cold.  "},
                {"A) ∃x¬P(x) ", "B) ∀xP(x) ", "C) ∃xP(x) ", "D) ¬∀x ¬P(x) "},
                {"A) Its an organised list of individuals in an organisation. ", "B) It uses predicate logic to represent elements of a set. ", "C) Its an unordered collection of distinct objects referred to as elements ", "D) Its a way to show the elements of a set by listing the elements inside of curly brackets. "},
                {"A) 15 ", "B) 12 ", "C) 8 ", "D) 13 "},
                {"A) 5 ", "B) 2 ", "C) 4 ", "D) 3 "},
                {"A) 36 ", "B) 25 ", "C) 92 ", "D) 24 "},
                {"A) true", "B) false"},

        };
        char[] correctAnswers = {'A', 'B', 'C', 'D', 'A', 'B', 'B', 'A', 'C', 'D', 'B', 'C', 'A', 'D', 'B', 'D', 'A', 'A'};

        Scanner scanner = new Scanner(System.in);

        System.out.println("Which type of quiz would you like to play?");
        System.out.println("1. Random");
        System.out.println("2. Easy to Hard");
        System.out.println("3. Speedrun");
        System.out.println("Enter your choice (1/2/3): ");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                random(questions, answerChoices, correctAnswers);
                break;
            case 2:
                difficulty_level(easyQuestions, easyAnswerChoices, easyCorrectAnswers, mediumQuestions, mediumAnswerChoices, mediumCorrectAnswers, hardQuestions, hardAnswerChoices, hardCorrectAnswers);
                break;
            case 3:
                Speedrun(questions, answerChoices, correctAnswers);
                break;
            default:
                System.out.println("Invalid choice.");

        }
        scanner.close();
    }


    public static void difficulty_level(String[] easyQuestions, String[][] easyAnswerChoices, char[] easyCorrectAnswers,
                                        String[] mediumQuestions, String[][] mediumAnswerChoices, char[] mediumCorrectAnswers,
                                        String[] hardQuestions, String[][] hardAnswerChoices, char[] hardCorrectAnswers) {
        Scanner scanner = new Scanner(System.in);

        int score = 0;

        System.out.println("Choose a difficulty level:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        int difficultyChoice = scanner.nextInt();

        switch (difficultyChoice) {
            case 1:
                System.out.println("EASY QUESTIONS:");
                score += askQuestions(easyQuestions, easyAnswerChoices, easyCorrectAnswers);
                break;
            case 2:
                System.out.println("MEDIUM QUESTIONS:");
                score += askQuestions(mediumQuestions, mediumAnswerChoices, mediumCorrectAnswers);
                break;
            case 3:
                System.out.println("DIFFICULT QUESTIONS:");
                score += askQuestions(hardQuestions, hardAnswerChoices, hardCorrectAnswers);
                break;
            default:
                System.out.println("Invalid difficulty choice.");
        }

        System.out.println("Quiz completed! Your final score: " + score);

        scanner.close();
    }

    private static void random(String[] questions, String[][] answerChoices, char[] correctAnswers) {
        int score = 0;
        int[] questionOrder = generateRandomOrder(questions.length);

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            int questionIndex = questionOrder[i];
            System.out.println(questions[questionIndex]);

            String[] shuffledChoices = shuffleArray(answerChoices[questionIndex]);

            for (int j = 0; j < shuffledChoices.length; j++) {
                System.out.println((char) ('A' + j) + ": " + shuffledChoices[j]);
            }
            System.out.println("Enter your answer (A, B, C, or D): ");
            char userAnswer = ' ';

            scanner.nextLine();

            if (userAnswer == correctAnswers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + correctAnswers[i]);
            }

            System.out.println("Your current score: " + score);
        }
        System.out.println("Quiz completed! Your final score: " + score);

    }
    private static int[] generateRandomOrder(int length) {
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

    public static void Speedrun(String[] questions, String[][] answerChoices, char[] correctAnswers){
        int score = 0;
        int[] questionOrder = generateRandomOrder(questions.length);

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);

            for (String choice : answerChoices[i]) {
                System.out.println(choice);
            }
            System.out.print("Enter your answer (A, B, C or D): ");

            char userAnswer = ' '; //default value(if they dont answer in time i.e no answer

            //creating the timer here
            ScheduledExecutorService timerService = Executors.newSingleThreadScheduledExecutor(); // creates an instance of scheduled executor. makes a task after a specified delay
            final boolean[] answered = {false}; //an array to track if the user answered the question
            timerService.schedule(() ->{ //scheduling a task to be executed
                if(!answered[0]){ //if not answered ! -> makes true values false
                    System.out.println("Sorry, too slow!");
                }

                timerService.shutdownNow();

            }, 20, TimeUnit.SECONDS);

            //then if they do answer
            Scanner scanner = new Scanner(System.in);
            userAnswer = scanner.next().toUpperCase().charAt(0);
            timerService.shutdownNow();
            answered[0] = true;

            if (userAnswer == correctAnswers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + correctAnswers[i]);
            }

            System.out.println("Your current score: " + score);
        }
        System.out.println("Quiz completed! Your final score: " + score);
    }


    public static int askQuestions(String[] questions, String[][] answerChoices, char[] correctAnswers) {
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);

            for (String choice : answerChoices[i]) {
                System.out.println(choice);
            }

            System.out.print("Enter your answer (A, B, C or D): ");
            char userAnswer = ' ';
            Scanner scanner = new Scanner(System.in);
            userAnswer = scanner.next().toUpperCase().charAt(0);

            if (userAnswer == correctAnswers[i]) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + correctAnswers[i]);
            }

            System.out.println("Your current score: " + score);
        }
        return score;
    }

}