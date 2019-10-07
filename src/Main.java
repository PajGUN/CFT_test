import java.io.*;

public class Main {
    public static void main(String[] args) {
        double square = 0;
        Triangle biggest = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] xy = line.split(" ");
                    if (xy.length == 6) {
                        try {
                            Triangle triangle = new Triangle(Long.valueOf(xy[0]), Long.valueOf(xy[1]), Long.valueOf(xy[2])
                                    , Long.valueOf(xy[3]), Long.valueOf(xy[4]), Long.valueOf(xy[5]));
                            if (triangle.isIsosceles() && triangle.getSquare() > square) {
                                biggest = triangle;
                                square = triangle.getSquare();
                            }
                        } catch (RuntimeException ignored) {}
                    }
                }

                if (biggest != null) {
                    writer.write(biggest.toString());
                } else writer.write("");

            } catch (ArrayIndexOutOfBoundsException  e) {
                System.out.println("Не указан путь для файла с результатом");
            } catch (IOException e){
                System.out.println("Ошибка записи в файл!");
            }
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Не указан путь входного файла с координатами");
        } catch (FileNotFoundException e){
            System.out.println("Входноый файл не найден, проверьте путь");
        } catch (IOException e) {
            System.out.println("Ошибка чтения из файла!");
        }
    }
}
