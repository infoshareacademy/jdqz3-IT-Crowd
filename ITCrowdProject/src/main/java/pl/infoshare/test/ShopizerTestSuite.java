package pl.infoshare.test;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.infoshare.categories.*;
import pl.infoshare.tests.FooterTest;
import pl.infoshare.categories.*;
import pl.infoshare.tests.PurchaseTest;
import pl.infoshare.tests.FooterTest;

@RunWith(Categories.class)
@Categories.IncludeCategory({PurchaseTests.class, AddToCartTests.class, AddToCartRandomBagTest.class, AddToCartNextRandomBagTest.class, PurchaseLaptopBagTest.class, LaptopBagsOnFooter.class, HandbagsOnFooter.class})
@Suite.SuiteClasses({PurchaseTest.class, FooterTest.class})
public class ShopizerTestSuite {
}
