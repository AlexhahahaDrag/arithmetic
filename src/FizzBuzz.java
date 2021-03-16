import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Write a program that outputs the string representation of numbers from 1 to n.
 *
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 *
 * Example:
 *
 * n = 15,
 *
 * Return:
 * [
 *     "1",
 *     "2",
 *     "Fizz",
 *     "4",
 *     "Buzz",
 *     "Fizz",
 *     "7",
 *     "8",
 *     "Fizz",
 *     "Buzz",
 *     "11",
 *     "Fizz",
 *     "13",
 *     "14",
 *     "FizzBuzz"
 * ]
 * @Author:      alex
 * @CreateDate:  2019/2/26 11:19
 * @param
 * @return
*/
public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }
    public static List<String> fizzBuzz(int n) {
        List<String> l1 = new ArrayList<String>();
        int i3 = 3, i5 = 5;
        for(int i=1; i<=n;i++){
            i3--;
            i5--;
            if(i3 == 0 && i5 == 0){
                i3 = 3;
                i5 = 5;
                l1.add("FizzBuzz");
            }else if(i3 == 0){
                i3 = 3;
                l1.add("Fizz");
            }else if(i5 == 0){
                i5 = 5;
                l1.add("Buzz");
            }else {
                l1.add(Integer.toString(i));
            }
        }
        return l1;
    }
    public static List<String> fizzBuzz1(int n) {
        List list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%3==0) {
                if(i%5==0) {
                    list.add("FizzBuzz");
                } else {
                    list.add("Fizz");
                }
            } else
            if(i%5==0) {
                list.add("Buzz");
            } else {
                list.add(Integer.toString(i));
            }
        }
        return list;
    }
}
