package com.example.calc;

import java.util.ArrayList;
import java.util.Scanner;

public class CodeChef {
    static byte T;
    static byte C;
    static byte X;
    static byte Y;
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        T = sc.nextByte();
        ArrayList<String> input = new ArrayList<>();
        for (int i = 1; i <= T ; i++){
          input.add(sc.nextLine()) ;
        }
    }
}
