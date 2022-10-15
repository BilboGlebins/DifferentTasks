import java.text.DecimalFormat;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {
    static DecimalFormat decimalFormat = new DecimalFormat( "#.##" );
    static Scanner in = new Scanner(System.in);
    static BaseConverter convert_temp = new BaseConverter();

    public static void main(String[] args) {
        zadanie1();
        System.out.println("\n");
        zadanie2();
        System.out.println("\n");
        zadanie3();
        System.out.println("\n");
        zadanie4();
    }

    public static void zadanie1(){
        System.out.println("Задание 1" + "\n" + "Сформировать и заполнить массив случайным числами и вывести максимальное, минимальное и среднее значение.");
        System.out.print("Введите количество элементов в массиве: ");

        int number_of_elements = in.nextInt();
        double[] array = new double[number_of_elements];
        for (int i=0;i<array.length;i++)
            array[i] = Math.random();
        for (double i: array) {
            System.out.print(decimalFormat.format(i) + " " );
        }
        System.out.print("\n");

        double max_element = array[0];
        double min_element = array[0];
        double avg_element = 0;
        for (double v : array) {
            if (max_element < v)
                max_element = v;
            if (min_element > v)
                min_element = v;
            avg_element += v / array.length;
        }
        System.out.println("Максимальное число: " + decimalFormat.format(max_element));
        System.out.println("Минимальное число: " + decimalFormat.format(min_element));
        System.out.print("Среднее значение: " + decimalFormat.format(avg_element));
    }

    public static void zadanie2() {
        System.out.println("Задание 2" + "\n" + "Написать программу, которая должна найти и вывести повторяющийся символ в слове «Hello».");
        String value = "Hello";
        char[] buff_array = value.toCharArray();
        System.out.print("Повторяющиеся символы:");
        for (int i=0; i< value.length(); i++) {
            for(int j=i+1; j< value.length(); j++) {
                if (buff_array[i] == buff_array[j]) {
                    System.out.print(buff_array[j] + " ");
                    break;
                }
            }
        }
    }

    public static void zadanie3() {
        System.out.println("Задание 3" + "\n" + "Напишите класс BaseConverter для конвертации из градусов по Цельсию в " +
                           "Кельвины, Фаренгейты. У класса должен быть метод convert, который и делает конвертацию. " + "\n" +
                           "При запуске кода должна быть возможность ввести градусы Цельсия и выбора конвертации в Кельвины или Фаренгейты");
        while (true){
            try {
                System.out.print("Введите градусы Цельсия: ");
                double celsius_temp = new Scanner(System.in).nextInt();
                System.out.print("1 - Конвертация из градусы Цельсия в градусы Фаренгейта." + "\n" +
                        "2 - Конвертация из градусы Цельсия в градусы Кельвина." + "\n" +
                        "Выберите вид конвертации: ");
                int choice = new Scanner(System.in).nextInt();
                if (choice >= 3){
                    throw new Exception();
                }
                else{
                    convert_temp.convert(celsius_temp, choice);
                }
                break;
            }
            catch (Exception e){
                System.out.println("Введено неверное значение");
            }
        }
    }

    public static void zadanie4() {
        System.out.println("Задание 4" + "\n" + "Напишите метод, который будет вычислять угол между часовой и минутной " +
                "стрелками часов. На вход функции подаётся время в виде двух переменных: «hours» и «minutes».");

        System.out.print("Введите положение часовой стрелки: ");
        double hours = new Scanner(System.in).nextInt();

        System.out.print("Введите положение минутной стрелки: ");
        double minutes = new Scanner(System.in).nextInt();

        double hour_angle= (hours % 12) * 30 + minutes * 0.5;
        double minute_angle= minutes*6;
        double result_angle = abs(hour_angle - minute_angle) % 360;
        System.out.println("Угол между стрелками равен: " + result_angle);
    }
}

class BaseConverter {
    double result;
    void convert(double buff_temp, int buff_choice){
        switch (buff_choice) {
            case (1):
                result = buff_temp * 1.8 + 32;
                System.out.print("Конвертация в градусы Фаренгейта: " + result);
                break;
            case (2):
                result = buff_temp + 273.15;
                System.out.print("Конвертация в градусы Кельвина: " + result);
                break;
        }
    }
}