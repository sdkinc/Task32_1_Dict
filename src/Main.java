import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    private static final String SEP = ": ";
    private static final String IN_FILENAME = "res/dict.txt";

    public static void main(String[] args) throws IOException {
        /*
        Задача 1
        Программисты, как вы уже знаете, постоянно учатся, а в общении между собой используют весьма специфический язык.
        Чтобы систематизировать ваш пополняющийся профессиональный лексикон, мы придумали эту задачу.
        Напишите программу создания небольшого словаря сленговых программерских выражений, чтобы она потом
        по запросу возвращала значения из этого словаря.
        Формат входных данных
        Файл dict.txt
        В первой строке задано одно целое число n — количество слов в словаре.
        В следующих n строках записаны слова и их определения, разделенные двоеточием и символом пробела.
        Ввод с клавиатуры
        В первой строке записано целое число m — количество поисковых слов, чье определение нужно вывести.
        В следующих m строках записаны сами слова, по одному на строке.
        Формат выходных данных
        Для каждого слова, независимо от регистра символов, если оно присутствует в словаре, необходимо вывести
        на экран его определение.
        Если слова в словаре нет, программа должна вывести "Не найдено", без кавычек.
         */

        //create and fill HashMap
        HashMap<String, String> dict = readFromFile();
        //dev output hashMap
        for (String key: dict.keySet()
        ) {
            System.out.println(key+":"+dict.get(key));
        }
        //search and print result
        searchAndPrint(dict);
    }

    private static void searchAndPrint(HashMap<String, String> dict) throws IOException {
        BufferedReader brKeyboard = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input search word:");
        String search = brKeyboard.readLine();
        String searchAsKey = search.toLowerCase();
        System.out.println(dict.getOrDefault(searchAsKey, "Не найдено\n"));
    }
    private static HashMap<String,String>  readFromFile() throws IOException {
        HashMap<String, String> dict = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(new File(IN_FILENAME)));
        //System.out.print("Pls input count of record:");
        int m = Integer.parseInt(br.readLine());

        String[] lineArray;
        for (int i = 0; i < m; i++) {
            //System.out.print("Pls input one record with separator as '" + SEP + "':");
            String line = br.readLine();
            lineArray = line.split(SEP);
            dict.put(lineArray[0].toLowerCase(), lineArray[1]);
        }
        br.close();
        return dict;
    }
}
