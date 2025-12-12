import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class StatsCalculator {
    public String calculateStats(String input) {
        int[] intNumbers = Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Map<String, Integer> result = new HashMap<>();
        for (int number : intNumbers) {
            if (number > 0) {
                result.put("выше нуля", result.getOrDefault("выше нуля", 0) + 1);
            } else if (number == 0) {
                result.put("равна нулю", result.getOrDefault("равна нулю", 0) + 1);
            } else {
                result.put("ниже нуля", result.getOrDefault("ниже нуля", 0) + 1);
            }
        }

        return String.format(
                "выше нуля: %d, ниже нуля: %d, равна нулю: %d",
                result.getOrDefault("выше нуля", 0),
                result.getOrDefault("ниже нуля", 0),
                result.getOrDefault("равна нулю", 0)
        );
    }
}