package testData;

import Model.GameData.*;

public class testBag {
    public static void main(String[] args) {
        testBag t = new testBag();
        t.testBag();
        System.out.println("testsBag-done");
    }

    public void testBag() {
        Tile.Bag b = Tile.Bag.getBag();
        Tile.Bag b1 = Tile.Bag.getBag();
        if (b1 != b) System.out.println("your Bag in not a Singleton");

        int[] q0 = b.getQuantities();
        q0[0] += 1;
        int[] q1 = b.getQuantities();
        if (q0[0] != q1[0] + 1) System.out.println("getQuantities did not return a clone");

        for (int k = 0; k < 9; k++) {
            int[] qs = b.getQuantities();
            Tile t = b.getRand();
            int i = t.letter - 'A';
            int[] qs1 = b.getQuantities();
            if (qs1[i] != qs[i] - 1) System.out.println("problem with getRand");

            b.put(t);
            b.put(t);
            b.put(t);

            if (b.getQuantities()[i] != qs[i]) System.out.println("problem with put");
        }

        if (b.getTile('a') != null || b.getTile('$') != null || b.getTile('A') == null)
            System.out.println("your getTile is wrong (-2)");

        int size=0;
        for (int i = 0; i < 100; i++) {
            b.getRand();
            size=b.size();
        }
        if(size!=0)
            System.out.println("size is not 0 after we empty the bag");
        if (b.getRand() != null)
            System.out.println("getRand did not return null when the bag was empty");
    }

}
