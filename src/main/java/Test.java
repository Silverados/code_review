import java.util.ArrayList;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static final String CUSTOM_BLOCK_START2 = "//====================CUSTOM BLOCK 2 START====================";
    public static final String CUSTOM_BLOCK_END2 = "//====================CUSTOM BLOCK 2 END====================";
    public static final Pattern CUSTOM_BLOCK_PATTERN2 = Pattern.compile(CUSTOM_BLOCK_START2 + "([\\S]*)" + CUSTOM_BLOCK_END2, Pattern.UNICODE_CHARACTER_CLASS);

    public static void main(String[] args) {
        test222();
    }

    public static void test222() {
        var source =
                "//====================CUSTOM BLOCK 2 START====================\n" +
                "       private static void preInit(HashMap<${PRIMARY_KEY_TYPE}, Test> data) {\n"+
                        "       dfadfadfafdsa\n"+
                "       }\n" +
                "       private static void postInit() {\n" +
                "       }\n" +
                "       ${CUSTOM_CONTENT_BLOCK2}\n" +
                "//====================CUSTOM BLOCK 2 END====================\n";

        var output =
                "//====================CUSTOM BLOCK 2 START====================\n" +
                        "       private static void preInit(HashMap<${PRIMARY_KEY_TYPE}, Test> data) {\n"+
                        "       }\n" +
                        "       private static void postInit() {\n" +
                        "       }\n" +
                        "       ${CUSTOM_CONTENT_BLOCK2}\n" +
                        "//====================CUSTOM BLOCK 2 END====================\n";

        System.out.println(mergeSource(output, source, new Pattern[]{CUSTOM_BLOCK_PATTERN2}));

    }

    public static String mergeSource(String content, String source, Pattern[] patterns) {
        for (Pattern pattern : patterns) {
            Matcher sourceMatcher = pattern.matcher(source);
            if (sourceMatcher.find()) {
                String str = sourceMatcher.group(0);
                Matcher contentMatcher = pattern.matcher(content);

                if (contentMatcher.find()) {
                    String beReplaceStr = contentMatcher.group(0);
                    content = content.replace(beReplaceStr, str);
                }
            }

        }

        return content;
    }

    public static void test111() {
        String patten = "mongodb://(.*):(.*)@(.*):(.*)/(.*)";
        String str = "mongodb://q2write:FtrRMU0lCmv3tOTl@172.16.0.81:27200/a5_game_lsf0351_internal_linux";
        Pattern pattern = Pattern.compile(patten);
        Matcher m = pattern.matcher(str);
        System.out.println(m.groupCount());
        while (m.find()) {
            for (int i = 0; i <= m.groupCount(); i++) {
                System.out.println(i + ":" + m.group(i));
            }
        }
    }

    public static void test(Function<String, String> function, String arg) {
        System.out.println(function.apply(arg));
    }

    public static void print() {
        for (int i = 100; i <= 121; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("hero_" + i + "_" + (j + 1));
            }
        }
    }

    public static void print2() {
        for (int i = 1; i <= 20; i++) {
            System.out.print(i + ":" + (500 + i * 50) + ",");
        }
    }

    private static void Sort(int[] hitPosArray) {
        var len = hitPosArray.length;
        var order = new ArrayList<Integer>();
        if (len % 2 == 0) {
            var first = len / 2 - 1;
            var second = first + 1;
            for (var i = 0; i <= first; i++) {
                order.add(first - i);
                order.add(second + i);
            }
        } else {
            var first = len / 2;
            order.add(first);
            for (var i = 1; i <= first; i++) {
                order.add(first - i);
                order.add(first + i);
            }
        }

        var temp = new int[len];
        System.arraycopy(hitPosArray, 0, temp, 0, len);

        var j = 0;
        for (Integer index : order) {
            hitPosArray[index] = temp[j++];
        }
    }
}
