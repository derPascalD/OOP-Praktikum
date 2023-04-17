public class TestKlasse {

    public static void main(String[] args) {

    // Objekt der Klasse RechenQuiz erstellt.
    RechenQuiz quiz = new RechenQuiz();
    quiz.getExercise();
    int result = quiz.getResult();
    System.out.println("Result: " +result);

    }
}
