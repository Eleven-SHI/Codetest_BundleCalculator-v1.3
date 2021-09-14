import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputFilter {
//    public static Pair<String, Integer> filter(String input)
    public void filter(String input){
//        final String code;
//        final int amount;
        boolean status = Bundles.bundles().containsKey(input.trim().split(" ")[1]);
        if(status) {
            Calculator cal = new Calculator();
            cal.calculate(input.trim().split(" ")[1],Integer.parseInt(input.trim().split(" ")[0]));
//            code = input.trim().split(" ")[1];
//            amount = Integer.parseInt(input.trim().split(" ")[0]);
//            return new Pair<>(code,amount);
        }
        else {
            System.out.println("----This line: '" + input + "' has no match---- ");
        }
    }

}
