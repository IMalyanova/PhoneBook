import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String,String> phoneName = new TreeMap<>();

        for (; ; ) {

            System.out.println("Введите номер телефона, имя или команду: ");
            String command = reader.readLine().trim();
            String name;

            if(command.equals("exit")) {
                System.out.println("До новых встреч!");
                break;
            }else if (command.equals("LIST")) {
                for (String element: phoneName.keySet()){
                    System.out.println(element + " " + phoneName.get(element));
                }
            }else if ((phoneName.get(command)) == (null)){
                boolean nameIsCommand = false;
                for (String element: phoneName.keySet()){
                    if(phoneName.get(element).equals(command)){
                        System.out.println(element + " " + command);
                        nameIsCommand = true;
                    }
                }
                if (!nameIsCommand){

                    System.out.println("Таких данных нет. Для сохранения новых данных" +
                            " введите сначала номер телефона и нажмите enter: ");
                    String phone = reader.readLine().trim();
                    if (phone.equals("")) {
                        phone = command;
                    }

                    System.out.println("Теперь введите имя: ");
                    name = reader.readLine().trim();

                    phoneName.put(phone, name);
                }
             }else {
                System.out.println(command + " " + phoneName.get(command));
            }
        }

    }
}
