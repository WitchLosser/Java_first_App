package org.example;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) { int num1 = getInt();
        int num2 = getInt();
        char operation = getOperation();
        int result = calc(num1,num2,operation);
        System.out.println("Результат операції: "+result);
    }

    public static int getInt(){
        System.out.println("Ведіть число:");
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("Ви допустили помилку при вводі числа. Спробуйте ще раз.");
            scanner.next();
            num = getInt();
        }
        return num;
    }

    public static char getOperation(){
        System.out.println("Ведіть операцію (+,-,*,/)");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Ви допустили помилку при вводі числа. Спробуйте ще раз.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public static int calc(int num1, int num2, char operation){
        int result;
        switch (operation){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                if (num1 == 0 || num2 == 0)
                {
                    System.out.println("Не можна ділити на 0! Виберіть іншу операцію.");
                    result = calc(num1, num2, getOperation());
                }
                else {
                    result = num1/num2;
                }
                break;
            default:
                System.out.println("Операція не розпізнана. Повторіть дані.");
                result = calc(num1, num2, getOperation());
        }
        return result;
    }
}