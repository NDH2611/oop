import java.io.*;

public class Main {
    public static void main(String[] args) {
        /*
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);

        String s;
        try {
            System.out.println("Bấm phím");
            s = in.readLine();
            System.out.println(s);
        }
        catch (IOException e) {
            System.out.println("Chịu");
            e.printStackTrace();
        }
    }


        File file = new File("../../data.out");

        try {
            FileWriter writer = new FileWriter(file);
            PrintWriter out = new PrintWriter(writer);

            String s = "Hello";
            out.println(s);

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

         */

        /*
        try {
            FileInputStream src = new FileInputStream("7 - IOStreams.ppt");
            FileOutputStream des = new FileOutputStream("power.ppt");
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = src.read(buffer)) != -1) {
                des.write(buffer, 0, bytesRead);
            }

            src.close();
            des.close();

            System.out.println("Copy thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }

         */
        int a[] = { 2, 3, 5, 7, 11, 13 };

        try {
            File fout = new File(args[0]);
            RandomAccessFile out;
            out = new RandomAccessFile(fout, "rw");

            for (int i=0; i<a.length; i++)
                out.writeInt(a[i]);
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
