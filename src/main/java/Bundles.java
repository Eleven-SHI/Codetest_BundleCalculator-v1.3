import java.util.*;

public class Bundles {

    TreeMap<Integer, Double> bundleInfo;

    public Bundles() {
        bundleInfo = new TreeMap<Integer, Double>();
    }

    public Bundles(TreeMap<Integer, Double> bundleInfoInput) {
        bundleInfo = bundleInfoInput;
    }

    public TreeMap<Integer, Double> getBundleInfo (){
        return bundleInfo;
    }

    public void setBundleInfo(TreeMap<Integer, Double> bundleInfo) {
        this.bundleInfo = bundleInfo;
    }

    public void add1BundleInfo (int bundleSize, double bundlePrice){
        this.bundleInfo.put(bundleSize,bundlePrice);
    }
    public static HashMap bundles(){
//        TreeMap <String,TreeMap<Integer, Double>> bundles = new TreeMap<String, TreeMap<Integer,Double>>();
//        TreeMap <Integer, Double> imgBundle = new TreeMap<Integer, Double>();
////        TreeMap <Integer, Double> imgBundle = bundles.get("IMG");
//        TreeMap <Integer, Double> flacBundle = new TreeMap<Integer, Double>();
//        TreeMap <Integer, Double> vidBundle = new TreeMap<Integer, Double>();
//        imgBundle.put(5,450.0);
//        imgBundle.put(10,800.0);
//        flacBundle.put(3,427.50);
//        flacBundle.put(6,810.0);
//        flacBundle.put(9,1147.50);
//        vidBundle.put(3,570.0);
//        vidBundle.put(5,900.0);
//        vidBundle.put(9,1530.0);
//        bundles.put("IMG",imgBundle);
//        bundles.put("FLAC",flacBundle);
//        bundles.put("VID",vidBundle);
        //use List
        ArrayList<Bundle> imgBundle = new ArrayList<>();
        imgBundle.add(new Bundle(5,450.0));
        imgBundle.add(new Bundle(10,800.0));
        ArrayList<Bundle> flacBundle = new ArrayList<>();
        flacBundle.add(new Bundle(3,427.50));
        flacBundle.add(new Bundle(6,810.0));
        flacBundle.add(new Bundle(9,1147.50));
        ArrayList<Bundle> vidBundle = new ArrayList<>();
        vidBundle.add(new Bundle(3,570.0));
        vidBundle.add(new Bundle(5,900.0));
        vidBundle.add(new Bundle(9,1530.0));


        HashMap<String,ArrayList<Bundle>> bundleMap = new HashMap<>();
        bundleMap.put("IMG",imgBundle);
        bundleMap.put("FLAC",flacBundle);
        bundleMap.put("VID",vidBundle);



        return bundleMap;
    }
}

class Bundle{
    private int size;
    private double price;

    public Bundle(){
    }

    public Bundle(int size, double price){
        this.size = size;
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
    public int getSize(){ return size; }
}