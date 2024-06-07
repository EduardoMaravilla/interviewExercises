package org.eduardomaravill.fizzbuzz;

public class FizzBuzz {

    public String convert(int num){
        if (num % 3 == 0 && num % 5 == 0){
            return "FizzBuzz";
        }else if (num % 5 == 0){
            return "Buzz";
        }else if (num % 3 == 0){
            return "Fizz";
        }else {
            return String.valueOf(num);
        }
    }

    public String convertAll(int num){
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= num; i++){
            result.append(convert(i)).append("\n");
        }
        return result.toString().trim();
    }
}
