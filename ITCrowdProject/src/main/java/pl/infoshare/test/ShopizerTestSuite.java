package pl.infoshare.test;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.infoshare.categories.*;
import pl.infoshare.tests.PurchaseTest;

@RunWith(Categories.class)
@Categories.IncludeCategory({Purchase.class, AddToCartTest.class, AddToCartRandomBagTest.class, AddToCartNextRandomBagTest.class,
        PurchaseLaptopBagTest.class})
@Suite.SuiteClasses(PurchaseTest.class)
public class ShopizerTestSuite {
}
