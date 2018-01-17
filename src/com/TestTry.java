package com;

public class TestTry {
    public static void main(String args[]) {
        System.out.println(testTry());
    }
    private static int testTry() {
        try {
            System.out.println(1/0);
            return 1;
        } catch (Exception e) {
            System.out.println("2");
            return 2;
        } finally {
            System.out.println("3");
            return 3;
        }
    }
}
