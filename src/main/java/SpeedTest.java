import java.util.*;
import java.util.stream.Collectors;

public class SpeedTest {

    public static void main(String[] args) {

        List<String> listNames = new LinkedList<>();
        listNames.add("Pjoter");
        listNames.add("Bartosz");
        listNames.add("Roman");
        listNames.add("Robert");
        listNames.add("Grzesiek");
        listNames.add("Artur");
        listNames.add("Adam");
        listNames.add("Janusz");
        listNames.add("Tony");
        listNames.add("Stefan");

        List<String> names = new ArrayList<>();

        Random rand = new Random();
        for (int i = 0; i <= 100_000_000; i++) {
            names.add(listNames.get(rand.nextInt(listNames.size())));
        }

        long start1 = System.currentTimeMillis();
        Set<String> sortedByCollection = new HashSet<>(names);
        long end1 = System.currentTimeMillis() - start1;

        System.out.println("SET: " + end1);

        long start2 = System.currentTimeMillis();
        names.stream()
                .collect(Collectors.toCollection(HashSet::new));
        long end2 = System.currentTimeMillis() - start2;

        System.out.println("STREAM: " + end2);

    }
}