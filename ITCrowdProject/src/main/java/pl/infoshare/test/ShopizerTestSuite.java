package pl.infoshare.test;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.infoshare.categories.*;
import pl.infoshare.pages.MainPage;
import pl.infoshare.tests.*;

@RunWith(Categories.class)
@Categories.IncludeCategory({PurchaseTests.class, AddToCartTest.class, AddToCartRandomBagTest.class, AddToCartNextRandomBagTest.class, PurchaseLaptopBagTest.class, HandbagsOnFooter.class, ValidateNameIsRequired.class, ValidateLastnameIsRequired.class, ValidateStreetAddressIsRequired.class, ValidateStateIsRequired.class, ValidatePostalCodeIsRequired.class, ValidateEmailAddressIsRequired.class, ValidateEmailAddressIsRequired.class, ValidatePhoneNumberIsRequired.class, BeachBagsOnFooter.class, RegisterUnderMyAccount.class})
@Suite.SuiteClasses({PurchaseTest.class, FooterTest.class, BillingInformationValidationTest.class, QuantityTest.class, MyAccountTest.class})
public class ShopizerTestSuite {
}
