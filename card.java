import java.util.Scanner;

public class card {
    public static boolean isValidLuhn(String number) {
        int checksum = Character.getNumericValue(number.charAt(number.length() - 1));
        int total = 0;

        for (int i = number.length() - 1 ; i >= 0 ; i--) {
            int sum = 0; 
            int digit = Character.getNumericValue(number.charAt(i));
            
            if(i % 2 == 0 ){
                digit *= 2;
            }

            sum = digit / 10 + digit % 10;
            total += sum;
        }

        return 10 - total % 10 == checksum;
    }
    public static void main(String[] args) {

        Scanner cardInput = new Scanner(System.in);
        System.out.println("enter card number:\t");

        long cardNumber = cardInput.nextLong();
        System.out.println("card number: " + cardNumber);


        // long cardNumber = 4987050015193976L;

        
        boolean success = isValidLuhn(Long.toString(cardNumber));
        // System.out.println(success);

        if ( success == true) {
            System.out.println("the card failed the luhn test meaning invalid card");
        } else {
            System.out.println("the card passed the luhn test meaning you can card with it");
        }
    }
}
