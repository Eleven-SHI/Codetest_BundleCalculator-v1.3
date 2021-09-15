import java.util.ArrayList;

import static java.lang.Math.min;

public class Calculator {
    public double calculate(String mediaType, int amount) {
        System.out.println("read file success");
        System.out.println("mediaType: " + mediaType + " amount: " + amount);
//        ArrayList<Bundle> currentBundle = new ArrayList<>();
//        currentBundle = Bundles.bundles().get(mediaType);
//        ArrayList<Integer> currentBundle = new ArrayList<>();
//        currentBundle = (ArrayList<Integer>) Bundles.bundles().get(mediaType);
        ArrayList<Integer> currentBundle = new ArrayList<>();
        currentBundle = (ArrayList<Integer>) Bundles.bundles().get(mediaType);

        int i, j, sizeLength, maxNum, minBundleNum;
        int[] f;
        double totalPrice;
        double[] price;
        sizeLength = currentBundle.size();
        maxNum = 99999;
        f = new int[100];
        price = new double[sizeLength];
        f[0] = 0;
        totalPrice = 0;
        int loopamount;
        int[] bundleNum;
        bundleNum = new int[amount];

        //Determine if there is Integer Combination result and if yes, get minBundle num for current Amount
        for (i = 1; i <= amount; i++) {
            minBundleNum = maxNum;
            for (j = 0; j < sizeLength; j++) {
                if (i - (currentBundle.get(j)) >= 0) {
                    minBundleNum = Math.min(minBundleNum, f[i - (currentBundle.get(j))] + 1);
                }
            }
            f[i] = minBundleNum;
//                if(minBundleNum == 99999) minBundleNum = f[i]+1;
//            System.out.println("f[" + i + "]=" + f[i]);

        }
        if (f[amount] != maxNum)
            System.out.println("Exist Integer Combination Result, min bundle Num: " + f[amount]);

        //get bundle amount for each bundle
        if (f[amount] == 1) {
            totalPrice = Price.price(mediaType, amount);
            System.out.println("total: " + totalPrice);
        } else if (f[amount] != maxNum) { //exist Integer Combination result

            for (i = sizeLength - 1; i >= 0; i--) { //loop depends on bundles
                loopamount = amount;
                while (f[loopamount - currentBundle.get(i)] != maxNum && f[loopamount - currentBundle.get(i)] != 1) {
//                    System.out.println("now is:" + f[loopamount - currentBundle.get(i)]);
                    bundleNum[i]++;
//                    System.out.println("now i is:" + i + " bundleNum : " + bundleNum[i]);
                    loopamount = loopamount - currentBundle.get(i);
                }
                if (f[loopamount - currentBundle.get(i)] == 1) {
//                    System.out.println("now is:" + f[ loopamount - currentBundle.get(i)]);
                    bundleNum[i]++;
//                    System.out.println("now i is:" + i + " bundleNum : " + bundleNum[i]);
                    bundleNum[i - 1]++;
                    i = -1;
                }
            }
            for (j = 0; j < sizeLength; j++) {
                System.out.println("bundleNum: " + bundleNum[j]);

                totalPrice = bundleNum[j] * Price.price(mediaType, currentBundle.get(j)) + totalPrice;
            }
            System.out.println("Total: " + totalPrice);

        } else {
            //no Integer Combination
            System.out.println("no Integer Combination");
        }


//                totalPrice = Double.POSITIVE_INFINITY;
//                int testBundleNum = 0;
//
//
//
//                for (j = 0; f[loopamount - currentBundle.get(i)] != 1; j++) {
////            while(f[loopamount-currentBundle.get(i)] !=1){
//
//                    bundleNum[j] = f[loopamount - currentBundle.get(i)];
//                    testBundleNum = f[loopamount - (currentBundle.get(i))] + testBundleNum;
//                    price[i] = bundleNum[j] * Price.price(mediaType, currentBundle.get(amount - loopamount));
//                    loopamount = loopamount - currentBundle.get(i);
//                }
//
////            for(i=f[amount-currentBundle.get(j)*(j+1)]; i>1; i-- ) {
////            }
////                double price1 = bundleNum[0] * Price.price(mediaType, (currentBundle.get(0)));
////            if(bundleNum[j+1] > 0) {
////                totalPrice = bundleNum[j+1] * Price.price(mediaType, amount - (currentBundle.get(j)) * (j + 1)) + price1;
////            }
//                System.out.println("TestBundleNum: " + testBundleNum);
//                System.out.println("total: " + price[i]);
////                System.out.println("p1: " +bundleNum[j] * Price.price(mediaType, currentBundle.get(j)));
//            }
//
////            while ( testBundleNum == f[amount] ){
////                price[j] = f[amount-currentBundle.get(j)] * Price.price(mediaType,currentBundle.get(j)) + f[amount-(currentBundle.get(j)*2)] * Price.price(mediaType,(amount-currentBundle.get(j)*2));
////                totalPrice = Math.min(totalPrice,price[j]);
////                System.out.println("total price="+totalPrice);
////            }
////            else System.out.println("还没想好");
//
//            System.out.println("minBundleNum=" + f[amount]);
//        }

        return totalPrice;
    }
}
