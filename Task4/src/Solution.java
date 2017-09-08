import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/*Создать игру. Игра называется "Города". Компьютер задаёт букву,
вы вводите название города, Если компьютер такого города не знает, то он делает замечание,
что возможно такого города не существует. Если компьютер город знает,
то отвечает названием города на последнюю букву города, который вы назвали до этого
(сандартные правила этой игры).
Примечание: Компьютер может как бесконечно с вами играть так-же можно установить лимит.
Города можно скачать с интернета. Алфавит для игры только Русский или Румынский или Английский.
 */
public class Solution {

    private static List<String> listOfCities;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Starting the game? (y/n)");
        if (sc.nextLine().equals("n"))
            return;
        System.out.println("Enter full path to the file containing city names:");
        if (citiesLoad(sc.nextLine()) == 1) {
            System.out.println("Error loading city names");
            return;
        }
        int count = 0;
        System.out.println("Your turn. Tell the city name:");
        String inpCity = sc.nextLine();
        while (true) {
            count++;
            System.out.println(getCity(inpCity, false));
            String answer = getCity(inpCity, true);
            System.out.println(answer);
            String lastLetter = answer.substring(answer.length() - 1, answer.length());
            System.out.println(String.format("Your turn. Tell the city name starting with %s:", lastLetter));
            inpCity = sc.nextLine();

            if (count % 5 == 0) {
                System.out.println("Continue game? (y/n)");
                if (sc.nextLine().equals("n"))
                    break;
            }
        }
    }

    private static String getCity(String s, boolean islastLetter) {
        String retCity = "No such city or it was used yet!";
        s = s.toLowerCase().trim();
        int i = 0;
        for (String city : listOfCities) {
            if (islastLetter) {
                String lastLetter = s.substring(s.length() - 1, s.length());
                if (city.startsWith(lastLetter.toUpperCase())) {
                    retCity = city;
                    listOfCities.remove(i);
                    break;
                }
            } else if (city.toLowerCase().trim().equals(s)) {
                retCity = "Ok";
                listOfCities.remove(i);
                break;
            }
            i++;
        }
        return retCity;
    }

    private static int citiesLoad(String path) {
        try {
            listOfCities = Files.readAllLines(Paths.get(path), Charset.forName("UTF-8"));
            // my list contains cities and countries, needs to be separated
            for (String currLine : listOfCities) {
                String newLine = currLine.substring(currLine.indexOf(',') + 1, currLine.length());
                listOfCities.set(listOfCities.indexOf(currLine), newLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }


}
