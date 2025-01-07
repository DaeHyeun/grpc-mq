package com.example.grpc;

public class Color {
    public static void main(String[] args) {
        // ANSI escape codes for colors
        String red = "\u001B[31m";  // 빨간색
        String green = "\u001B[32m"; // 초록색
        String reset = "\u001B[0m";  // 색상 초기화

        System.out.println("This is a normal text.");
        System.out.println(red + "This text is red!" + reset);
        System.out.println(green + "This text is green!" + reset);
    }
}
