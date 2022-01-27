/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.pojo;

/**
 *
 * @author pc
 */
public class Exam {

   
    private String ExamId;
    private String language;
    private int totalQuestions; 
    private int time;

  

    @Override
    public String toString() {
        return "Exam{" + "ExamId=" + ExamId + ", language=" + language + ", totalQuestions=" + totalQuestions + ", time=" + time + '}';
    }
    
    public Exam(String ExamId, String language, int totalQuestions ,int time) {
        this.ExamId = ExamId;
        this.language = language;
        this.totalQuestions = totalQuestions;
        this.time = time;
    }

    public String getExamId() {
        return ExamId;
    }

    public void setExamId(String ExamId) {
        this.ExamId = ExamId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }
    
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
}
