package pl.infoshare.test;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.infoshare.categories.*;

@RunWith(Categories.class)
@Categories.IncludeCategory({PurchaseTest.class, AddToCartTest.class, AddToCartRandomBagTest.class, AddToCartNextRandomBagTest.class,
        PurchaseLaptopBagTest.class})
@Suite.SuiteClasses(pl.infoshare.tests.PurchaseTest.class)
public class ShopizerTestSuite {
}
