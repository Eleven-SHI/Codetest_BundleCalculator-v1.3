import java.util.ArrayList;

import static java.lang.Math.min;

public class Calculator {
    public static double calculate(String mediaType, int amount) {
        System.out.println("read file success");
        System.out.println("mediaType: " + mediaType + " amount: " + amount);
//        ArrayList<Bundle> currentBundle = new ArrayList<>();
//        currentBundle = Bundles.bundles().get(mediaType);
//        ArrayList<Integer> currentBundle = new ArrayList<>();
//        currentBundle = (ArrayList<Integer>) Bundles.bundles().get(mediaType);
        ArrayList<Integer> currentBundle = new ArrayList<>();
        currentBundle = (ArrayList<Integer>) Bundles.bundles().get(mediaType);

        int i, j, sizeLength, num, minBundleNum;
        int[] f;
        double totalPrice;
        double[] price;
        sizeLength = currentBundle.size();
        f = new int[100];
        price = new double[sizeLength];
        f[0] = 0;
        totalPrice = 0;
        //get minBundle num for current totalAmount
        for (i = 1; i <= amount; i++) {
            num = 99999;
            for (j = 0; j < sizeLength; j++) {
                if (i - (currentBundle.get(j)) >= 0) {
                    num = Math.min(num, f[i - (currentBundle.get(j))] + 1);
                }
            }
//                if(minBundleNum == 99999) minBundleNum = f[i]+1;

            f[i] = num;
            System.out.println("f[" + i + "]=" + f[i]);
        }
        //get bundle amount for each bundle
        for (i = 0; i < sizeLength; i++) { //loop depends on bundles
            totalPrice = Double.POSITIVE_INFINITY;
            int testBundleNum = 0;
            int[] bundleNum;
            bundleNum = new int[amount];
            int loopamount = amount;
            for(j = 0; f[loopamount-currentBundle.get(i)] != 1; j++){
//            while(f[loopamount-currentBundle.get(i)] !=1){
                bundleNum[j] = f[loopamount - currentBundle.get(i)];
                testBundleNum = f[loopamount -(currentBundle.get(i))] + testBundleNum;
                price[i] = bundleNum[j] * Price.price(mediaType, currentBundle.get(amount-loopamount)) ;
                loopamount = loopamount - currentBundle.get(i);
            }

//            for(i=f[amount-currentBundle.get(j)*(j+1)]; i>1; i-- ) {
//            }
//                double price1 = bundleNum[0] * Price.price(mediaType, (currentBundle.get(0)));
//            if(bundleNum[j+1] > 0) {
//                totalPrice = bundleNum[j+1] * Price.price(mediaType, amount - (currentBundle.get(j)) * (j + 1)) + price1;
//            }
                System.out.println("TestBundleNum: " + testBundleNum);
                System.out.println("total: " +price[i]);
//                System.out.println("p1: " +bundleNum[j] * Price.price(mediaType, currentBundle.get(j)));
            }

//            while ( testBundleNum == f[amount] ){
//                price[j] = f[amount-currentBundle.get(j)] * Price.price(mediaType,currentBundle.get(j)) + f[amount-(currentBundle.get(j)*2)] * Price.price(mediaType,(amount-currentBundle.get(j)*2));
//                totalPrice = Math.min(totalPrice,price[j]);
//                System.out.println("total price="+totalPrice);
//            }
//            else System.out.println("还没想好");

        System.out.println("minBundleNum=" + f[amount]);


        return totalPrice;
    }
}
