package pl.infoshare.test;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.infoshare.categories.*;
import pl.infoshare.pages.MainPage;
import pl.infoshare.tests.BillingInformationValidationTest;
import pl.infoshare.tests.FooterTest;
import pl.infoshare.tests.PurchaseTest;
import pl.infoshare.tests.QuantityTest;

@RunWith(Categories.class)
@Categories.IncludeCategory({PurchaseTests.class, AddToCartTest.class, AddToCartRandomBagTest.class, AddToCartNextRandomBagTest.class, PurchaseLaptopBagTest.class, HandbagsOnFooter.class, ValidateNameIsRequired.class, ValidateLastnameIsRequired.class, ValidateStreetAddressIsRequired.class, ValidateStateIsRequired.class, ValidatePostalCodeIsRequired.class, ValidateEmailAddressIsRequired.class, ValidateEmailAddressIsRequired.class, ValidatePhoneNumberIsRequired.class})
@Suite.SuiteClasses({PurchaseTest.class, FooterTest.class, BillingInformationValidationTest.class, QuantityTest.class})
public class ShopizerTestSuite {
}
