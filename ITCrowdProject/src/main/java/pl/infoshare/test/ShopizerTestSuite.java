package pl.infoshare.test;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.infoshare.categories.*;
import pl.infoshare.tests.BillingInformationValidationTest;
import pl.infoshare.tests.FooterTest;
import pl.infoshare.tests.LoginTest;
import pl.infoshare.tests.PurchaseTest;

@RunWith(Categories.class)
@Categories.IncludeCategory({PurchaseTests.class, AddToCartTest.class, AddToCartRandomBagTest.class, AddToCartNextRandomBagTest.class, PurchaseLaptopBagTest.class, HandbagsOnFooter.class, ValidateNameIsRequired.class, ValidateLastnameIsRequired.class, ValidateStreetAddressIsRequired.class, ContactUsOnFooter.class, HomeOnFooter.class, ValidateLoginFieldRequired.class})
@Suite.SuiteClasses({PurchaseTest.class, FooterTest.class, BillingInformationValidationTest.class, LoginTest.class})
public class ShopizerTestSuite {
}
