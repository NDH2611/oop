import java.util.HashSet;
import java.util.Set;

public class StringCode {
    public static String blowup(String str) {
        StringBuilder s = new StringBuilder();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c) && i + 1 < n) {
                char ch = str.charAt(i + 1);
                if (Character.isLetter(ch)) {
                    int count = c - '0';
                    for (int j = 0; j < count; j++) {
                        s.append(ch);
                    }
                }
            }
            if (Character.isLetter(c)) {
                s.append(c);
            }
        }

        return s.toString();
    }

    public static int maxRun(String str) {
        if (str == null || str.isEmpty()) return 0;
        int max = 1;
        int count = 1;
        int n = str.length();
        for (int i = 0; i < n; i++)
        {
            if (i + 1 < n && str.charAt(i) == str.charAt(i+1)) {
                count++;
            }
            else {
                count = 1;
            }
            if (max < count) {
                max = count;
            }
        }
        return max;
    }

    public static boolean stringIntersect(String a, String b, int len) {
        if (len > a.length() || len > b.length()) {
            return false;
        }
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < a.length() - len; i++)
        {
            seen.add(a.substring(i, i + len));
        }
        for (int i = 0; i < b.length() - len; i++)
        {
            String s = b.substring(i, i + len);
            if (seen.contains(s)) {
                return true;
            }
        }
        return false;
    }
}
