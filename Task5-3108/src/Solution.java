import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*дан текст:
 "Contrary to popular belief, Lorem Ipsum is not simply random text.
 It has roots in a piece of classical Latin literature from %s BC, making it over %d years Old.%s"
Необходимо:
   a) Создать текстовый файл и сохранить там этот текст
   б) Программой считать этот текст и выполнить следующие действия над этим текстом:
      1. Вывести в консоли колличество букв "О" (независимо от регистра)
      2. подставить в строку вместо %s и %d 45 и 2000. Вместо %s вконце предложения,
      подставить текущую дату. Данный пункт задания выполнить только с помощью String.format
	  3. Заменить все заглавные буквы на обычные (на маленькие)
   в) Записать получившийся текст в отдельный файлик (ваша программа должна записывать).
      Название файлика должно быть уникальным и никогда не повторяться.
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        System.out.println("Enter full path for saving file:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String path = br.readLine();

        createFile(path, "Contrary to popular belief, Lorem Ipsum is not simply random text.It has roots in a piece of classical Latin literature from %s BC, making it over %d years Old.%s");

        String str = readFile(path);
        System.out.println(String.format("This text contains %s letters o/O", countLettersO(str)));

        String newStr = String.format(str, 45, 2000, LocalDate.now());
        newStr = newStr.toLowerCase();
        File file = new File(path);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yy_HH_mm_ss");
        String newPath = file.getParent()+"\\text"+ LocalDateTime.now().format(formatter)+".txt";
        createFile(newPath, newStr);
    }

    private static void createFile(String path, String inpStr) throws IOException {
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(inpStr);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String readFile(String path) {
        String outStr;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            outStr = bufferedReader.readLine();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            outStr = "";
        }
        return outStr;
    }

    private static int countLettersO(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'O' || c == 'o')
                count++;
        }
        return count;
    }
}
