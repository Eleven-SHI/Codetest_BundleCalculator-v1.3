import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Price {
//    public static void price() {
//
//    }

    public static double getPrice(String media, int size) {
        Set<HashMap.Entry<String, ArrayList<Bundle>>> entries = Bundles.bundles().entrySet();
        double price = 0;
        for (Map.Entry<String, ArrayList<Bundle>> stringArrayListEntry : entries) {
            String key = stringArrayListEntry.getKey();

                ArrayList<Bundle> value = stringArrayListEntry.getValue();
                for (Bundle bundle : value) {
                    int sizeKey = bundle.getSize();
                    if (key.equals(media) && sizeKey == size) {
                        price = bundle.getPrice();

                    }
                }

        }
        return price;
    }
}