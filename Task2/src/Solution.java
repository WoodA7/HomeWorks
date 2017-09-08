/*Создайте метод, который будет считать сколько денег получает работник в неделю.
Метод должен принимать на входе два аргумента (зарплата в час, кол-во проработанных часов).
Условия:
1) Каждый час после 40 считается за полтора.
2) Работник не может работать больше, чем 60 часов в неделю.
3) Работник не может получать меньше 8 долларов в час.
Результат подсчёта так-же нужно записать в файлик в файловой системе.
*/

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {

        System.out.println("Enter employee name:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Enter hour salary:");
        double hourSal = sc.nextDouble();
        System.out.println("Enter work hours per week:");
        double hours = sc.nextDouble();
        double weekSalary = weekSalary(hourSal, hours);
        String outstr = name + ": week salary = " + weekSalary;
        System.out.println("Enter path for saving file:");
        String path = sc.nextLine();
        try (FileOutputStream fos = new FileOutputStream(String.format("%s%s.txt", path, name))) {
            byte[] b = outstr.getBytes();
            fos.write(b, 0, b.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static double weekSalary(double hourSal, double hours) {
        if (hours > 60) {
            System.out.println("Hours more than 60 !!");
            return 0.0;
        }
        if (hours > 40)
            hours = 40 + (hours - 40) * 1.5;
        hourSal = Math.min(8.0, hourSal);
        return hours * hourSal;
    }
}
