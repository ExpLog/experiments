import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Refresher {
    public static void main(String[] args) throws IOException {
        readFile();
        lists();
        sets();
        maps();
    }

    public static void readFile() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("test.txt"));
        System.out.println(in.readLine());
        in.close();

        Scanner scanner = new Scanner(new File("test.txt"), StandardCharsets.UTF_8.name());
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
        scanner.close();

        try (Scanner scanner2 = new Scanner(new File("test.txt"));) {
            // auto close
            while (scanner2.hasNext()) {
                System.out.println(scanner2.next());
            }
        }

        List<String> lines = Files.readAllLines(Paths.get("test.txt"), StandardCharsets.UTF_8);
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static void lists() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.sort(Comparator.reverseOrder());
        for (Integer it : list) {
            System.out.println(it);
        }

        Collections.sort(list, Comparator.comparing(Integer::intValue));
        list.stream().forEach(System.out::println);

        while (!list.isEmpty()) {
            int i = list.remove(list.size() - 1);
            System.out.println(i);
            System.out.println(list.size());
        }

        list.add(1);
        list.set(0, 2);
        System.out.println(list.get(0));
        list.remove(0);
        System.out.println(list);

        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        String result = list.stream()
                .map(it -> it * 2)
                .filter(it -> it % 4 == 0)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(result);
    }

    public static void sets() {
        Set<Integer> set = Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).collect(Collectors.toSet());
        for (int i = 0; i < 20; i++) {
            set.add(i);
        }

        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            if (iter.next() % 2 == 0) {
                iter.remove();
            }
        }
        System.out.println(set);

        set.removeIf(it -> it % 3 == 0);
        System.out.println(set);
    }

    public static void maps() {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            map.put(i, String.valueOf(i));
        }
        System.out.println(map);

        for (int i = 0; i < 10; i++) {
            map.merge(i, String.valueOf(i), String::concat);
        }
        System.out.println(map);

        System.out.println(map.get(0) + map.get(19) + map.getOrDefault(20, "default!"));

        map.computeIfPresent(0, (k, v) -> "0 is present!");
        System.out.println(map.get(0));

        map.computeIfAbsent(100, k -> k + " was not present!");
        System.out.println(map.get(100));

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
