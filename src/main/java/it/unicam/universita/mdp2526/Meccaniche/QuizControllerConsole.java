package it.unicam.universita.mdp2526.Meccaniche;

import it.unicam.universita.mdp2526.StudioEesami.Quiz;

public class QuizControllerConsole  implements QuizController{
    private Quiz quiz;
   public QuizControllerConsole(Quiz quiz){
       if(quiz==null) throw new IllegalArgumentException("quiz p nullo");
       this.quiz=quiz;
   }
    public void quizStart(){

    }
}
