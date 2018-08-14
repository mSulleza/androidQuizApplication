package com.uplb.mark.nasc9;

public class Question {

    private int id;
    private int qType;
    private String question;
    private String answer;
    private int answered;
    private String c1;
    private String c2;
    private String c3;
    private String c4;


    public Question()
    {}

    public Question(int id, int qType, String question, String answer, int answered, String c1, String c2, String c3, String c4)
    {
        this.id = id;
        this.qType = qType;
        this.question = question;
        this.answer = answer;
        this.answered = answered;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.c4 = c4;
    }

    public int getId()
    {
        return id;
    }

    public int getQType()
    {
        return qType;
    }

    public String getQuestion()
    {
        return question;
    }

    public String getAnswer()
    {
        return answer;
    }

    public int getAnswered()
    {
        return answered;
    }

    public String getC1()
    {
        return c1;
    }

    public String getC2()
    {
        return c2;
    }

    public String getC3()
    {
        return c3;
    }

    public String getC4()
    {
        return c4;
    }

    public void setAnswered(int answered)
    {
        this.answered = answered;
    }

}
