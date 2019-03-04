package pl.infoshare.generators;

import pl.infoshare.dataModels.Bag;

import java.util.ArrayList;


public class BagGenerator extends RandomGenerator {

    public static Bag vintageExotikCarryBag = new Bag("Handbag", "Vintage", "Vintage Exotik Carry Bag", true, 62, 1, 17, 28, 4);
    public static Bag chicVintageDeVille = new Bag("Handbag", "Chic", "Chic vintage DeVille", true, 78, 1, 17, 28, 4);
    public static Bag vintageCourierBag = new Bag("HandBag", "Courier", "Vintage courier bag", true, 60, 2, 18, 22, 10);
    public static Bag retroStyleBag = new Bag("Beachbag", "Retro", "Retro style bag", true, 48, 1, 20, 30, 4);
    public static Bag vintageBeachBag = new Bag("Beachbag", "Beach", "Vintage beach bag", true, 60, 1, 20, 30, 8);
    public static Bag VintageLaptopBag = new Bag("Laptopbag", "Vintage", "Vintage laptop bag", true, 78, 2, 18, 20, 4);
    public static Bag vintageBagWithLeatherBands = new Bag("Bags", "Vintage", "Vintage bag with leather bands", true, 68, 1, 19, 27, 4);

    public static Bag generateRandomBag() {

        List<Bag> bagList = new ArrayList<>();
        bagList.add(vintageExotikCarryBag);
        bagList.add(chicVintageDeVille);
        bagList.add(vintageCourierBag);
        bagList.add(retroStyleBag);
        bagList.add(vintageBeachBag);
        bagList.add(VintageLaptopBag);
        bagList.add(vintageBagWithLeatherBands);

        Bag randomBag = bagList.get(generateRandomNumber(0, (bagList.size()-1)));

        return randomBag;
    }
}
