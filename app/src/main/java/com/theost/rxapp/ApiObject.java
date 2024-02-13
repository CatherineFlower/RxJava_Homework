package com.theost.rxapp;

import java.util.Random;

public class ApiObject {

    private final int id;
    private final String value;

    // stupid code
    private final String randomField1;
    private final String randomField2;
    private final String randomField3;
    private final String randomField4;
    private final String randomField5;
    private final String randomField6;
    private final String randomField7;
    private final String randomField8;
    private final String randomField9;

    public ApiObject(int id) {
        Random random = new Random();
        this.id = id;
        this.value = String.valueOf(random.nextInt(1000000000));

        // stupid code
        randomField1 = String.valueOf(random.nextInt());
        randomField2 = String.valueOf(random.nextInt());
        randomField3 = String.valueOf(random.nextInt());
        randomField4 = String.valueOf(random.nextInt());
        randomField5 = String.valueOf(random.nextInt());
        randomField6 = String.valueOf(random.nextInt());
        randomField7 = String.valueOf(random.nextInt());
        randomField8 = String.valueOf(random.nextInt());
        randomField9 = String.valueOf(random.nextInt());
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public String getRandomField1() {
        return randomField1;
    }

    public String getRandomField2() {
        return randomField2;
    }

    public String getRandomField3() {
        return randomField3;
    }

    public String getRandomField4() {
        return randomField4;
    }

    public String getRandomField5() {
        return randomField5;
    }

    public String getRandomField6() {
        return randomField6;
    }

    public String getRandomField7() {
        return randomField7;
    }

    public String getRandomField8() {
        return randomField8;
    }

    public String getRandomField9() {
        return randomField9;
    }

}
