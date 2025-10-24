package Java.Easy;

public class _344_ReverseString {
    public static void main(String[] args) {
        System.out.println("#344 - Reverse String - Easy");

        char[] input = {'h', 'e', 'l', 'l', 'o'};
        reverseString(input);
        String inputString = new String(input);

        System.out.println("Reversed String: " + inputString);

        alternative(input);
        String altString = new String(input);

        System.out.println("Alternative Method: " + altString);

        return;
    }

    private static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        for (int i = 0; i < s.length / 2; i++) {
            char lpChar = s[left];
            char rpChar = s[right];

            s[left] = rpChar;
            s[right] = lpChar;

            left++;
            right--;
        }
    }

    private static void alternative(char[] s) {
        int lp = 0;
        int rp = s.length - 1;

        while (lp < rp) {
            char temp = s[lp];

            s[lp] = s[rp];
            s[rp] = temp;

            lp++;
            rp--;
        }
    }
}
