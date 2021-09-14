import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Price {
    public static double price(String mediaType, int Size) {
        double price;
        switch (mediaType) {
            case "IMG":
                price = imgBundlePrice(Size);
                break;
            case "FLAC":
                price = flacBundlePrice(Size);
                break;
            case "VID":
                price = vidBundlePrice(Size);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + mediaType);
        }
        return price;
    }

    public static double imgBundlePrice(int Size) {
        double price;
        HashMap<Integer, Double> imgBundlePrice = new HashMap<>();
        imgBundlePrice.put(5, 450.0);
        imgBundlePrice.put(10, 800.0);
        price = imgBundlePrice.get(Size);
        return price;
    }

    public static double flacBundlePrice(int Size) {
        double price;
        HashMap<Integer, Double> flacBundlePrice = new HashMap<>();
        flacBundlePrice.put(3, 427.50);
        flacBundlePrice.put(6, 810.0);
        flacBundlePrice.put(9, 1147.50);
        price = flacBundlePrice.get(Size);
        return price;
    }

    public static double vidBundlePrice(int Size) {
        double price;
        HashMap<Integer, Double> vidBundlePrice = new HashMap<>();
        vidBundlePrice.put(3, 570.0);
        vidBundlePrice.put(5, 900.0);
        vidBundlePrice.put(9, 1530.0);
        price = vidBundlePrice.get(Size);
        return price;
    }
}


//    public static double getPrice(String media, int size) {
//        Set<HashMap.Entry<String, ArrayList<Bundle>>> entries = Bundles.bundles().entrySet();
//        double price = 0;
//        for (Map.Entry<String, ArrayList<Bundle>> stringArrayListEntry : entries) {
//            String key = stringArrayListEntry.getKey();
//
//                ArrayList<Bundle> value = stringArrayListEntry.getValue();
//                for (Bundle bundle : value) {
//                    int sizeKey = bundle.getSize();
//                    if (key.equals(media) && sizeKey == size) {
//                        price = bundle.getPrice();
//
//                    }
//                }
//
//        }
//        return price;
//    }
//}