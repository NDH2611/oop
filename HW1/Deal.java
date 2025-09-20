import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Deal {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        String[] power = {"A", "2", "3", "4", "5", "6", "7", "8"
        , "9", "10", "J", "Q", "K"};
        String[] chat = {"ngọc bích", "cá tép", "cá rô", "trái tim"};
        int size = 52;
        if (n * 5 > 52)
        {
            throw new RuntimeException("thiếu bài ròi");
        }
        String[] mix = new String[size];
        for (int i = 0; i < chat.length; i++) {
            for (int j = 0; j < power.length; j++) {
                mix[i * power.length + j] = power[j] + " " + chat[i];
            }
        }

        for (int i = 0; i < size; i++)
        {
            int rand = i + (int) (Math.random() * (size - i));
            String tmp = mix[rand];
            mix[rand] = mix[i];
            mix[i] = tmp;
        }

        for(int i = 0; i < n * 5; i++) {
            System.out.println(mix[i]);
            if(i % 5 == 4)
            {
                System.out.println();
            }

        }
    }
}
