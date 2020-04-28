package Snake.LeaderBoard;

import java.util.regex.Pattern;

public class Member {
    private int age=0;
    private String first;
    private String last;
    private int score=0;

    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    Member(String first, String last, String age, String score){
        if (isNumeric(age)) this.age = Integer.parseInt(age);
        if (isNumeric(score)) this.score = Integer.parseInt(score);
        this.first = first;
        this.last = last;
    }

    Member(String first, String last, String age, int score){
        if (isNumeric(age)) this.age = Integer.parseInt(age);
        this.score = score;
        this.first = first;
        this.last = last;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    // checks if string follows a numeric patter
    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}
