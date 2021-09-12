import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputFilter {
    public static void filter(String input) {
//        Pattern imagePattern = Pattern.compile("^[0-9]+\\sIMG$", Pattern.CASE_INSENSITIVE);
//        Matcher imageMatcher = imagePattern.matcher(input.trim());//remove the space between the String
//        Pattern audioPattern = Pattern.compile("^[0-9]+\\sFLAC$", Pattern.CASE_INSENSITIVE);
//        Matcher audioMatcher = audioPattern.matcher(input.trim());
//        Pattern videoPattern = Pattern.compile("^[0-9]+\\sVID$", Pattern.CASE_INSENSITIVE);
//        Matcher videoMatcher = videoPattern.matcher(input.trim());
//        if (imageMatcher.find() || audioMatcher.find() || videoMatcher.find()) {
//            Calculator.calculate(imageMatcher, Integer.parseInt(input.trim().split(" ")[0]));
//        }
        boolean status = Bundles.bundles().containsKey(input.trim().split(" ")[1]);
        if(status) {
            Calculator.calculate(input.trim().split(" ")[1],Integer.parseInt(input.trim().split(" ")[0]));
        }
        else {
            System.out.println("----This line has no match---- " + input);
        }
    }
}
