package pl.infoshare.dataModels;


import pl.infoshare.generators.BagGenerator;

public class Bag {
    private String category;
    private String collection;
    private String name;
    private Boolean avaliable;
    private Integer price;
    private Integer weight;
    private Integer height;
    private Integer width;
    private Integer lenght;


    public Bag(String category, String  collection, String name,
               Boolean avaliable, Integer price, Integer weight, Integer height, Integer width, Integer lenght) {
        this.category = category;
        this.collection = collection;
        this.name = name;
        this.avaliable = avaliable;
        this.price = price;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.lenght = lenght;
    }

    public Bag() {
        BagGenerator bag = new BagGenerator();
        this.category = bag.generateRandomBag().category;
        this.collection = bag.generateRandomBag().collection;
        this.name = bag.generateRandomBag().name;
        this.avaliable = bag.generateRandomBag().avaliable;
        this.price = bag.generateRandomBag().price;
        this.weight = bag.generateRandomBag().weight;
        this.height = bag.generateRandomBag().height;
        this.width = bag.generateRandomBag().width;
        this.lenght = bag.generateRandomBag().lenght;
    }

    public Bag(String category) {
        BagGenerator bag = new BagGenerator();
        this.category = bag.generateCategoryRandomBag(category).category;
        this.collection = bag.generateCategoryRandomBag(category).collection;
        this.name = bag.generateCategoryRandomBag(category).name;
        this.avaliable = bag.generateCategoryRandomBag(category).avaliable;
        this.price = bag.generateCategoryRandomBag(category).price;
        this.weight = bag.generateCategoryRandomBag(category).weight;
        this.height = bag.generateCategoryRandomBag(category).height;
        this.width = bag.generateCategoryRandomBag(category).width;
        this.lenght = bag.generateCategoryRandomBag(category).lenght;
    }

    public Bag(String category, String collection) {
        BagGenerator bag = new BagGenerator();
        this.category = bag.generateCollectionRandomBag(category, collection).category;
        this.collection = bag.generateCollectionRandomBag(category, collection).collection;
        this.name = bag.generateCollectionRandomBag(category, collection).name;
        this.avaliable = bag.generateCollectionRandomBag(category, collection).avaliable;
        this.price = bag.generateCollectionRandomBag(category, collection).price;
        this.weight = bag.generateCollectionRandomBag(category, collection).weight;
        this.height = bag.generateCollectionRandomBag(category, collection).height;
        this.width = bag.generateCollectionRandomBag(category, collection).width;
        this.lenght = bag.generateCollectionRandomBag(category, collection).lenght;
    }


    @Override
    public String toString() {
        return  "Bag{" +
                "category=" + category+ '\'' +
                ", collection='" + collection + '\'' +
                ", name='" + name + '\'' +
                ", avaliable='" + avaliable + '\'' +
                ", price='" + price + '\'' +
                ", weight='" + price + '\'' +
                ", height='" + price + '\'' +
                ", width='" + width + '\'' +
                ", lenght='" + lenght + '\'' +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public String getCollection() {
        return collection;
    }
}
