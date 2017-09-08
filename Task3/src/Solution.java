/*Придумайте и реализуйте способ превращения числа в массив из его разрядов.
Пример: 562 -> [5,6,2] и вывести на экран.
 */
public class Solution {
    public static void main(String[] args) {
        Integer x = 34134115;
        String s = x.toString();
        char[] arr = s.toCharArray();
        for (char anArr : arr) {
            System.out.println(anArr);

        }
    }
}
