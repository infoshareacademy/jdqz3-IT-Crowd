package pl.infoshare.test;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.infoshare.categories.*;
import pl.infoshare.tests.*;

@RunWith(Categories.class)
@Categories.IncludeCategory({
        PurchaseHandBag.class,
        PurchaseBagsTest.class,
        PurchaseLaptopBagTest.class,
        AddToCartTest.class,
        AddToCartRandomBagTest.class,
        AddToCartNextRandomBagTest.class,
        ValidateNameIsRequired.class,
        ValidateLastnameIsRequired.class,
        ValidateStreetAddressIsRequired.class,
        ValidateStateIsRequired.class,
        ValidatePostalCodeIsRequired.class,
        ValidateEmailAddressIsRequired.class,
        ValidatePhoneNumberIsRequired.class,
        ValidateLoginFieldRequired.class,
        ValidateLoginPasswordFieldRequired.class,
        RegisterUnderMyAccount.class,
        SignInUnderMyAccount.class,
        BeachBagsOnFooter.class,
        HandbagsOnFooter.class,
        ContactUsOnFooter.class,
        HomeOnFooter.class,
        SignInOnFooter.class,
})
@Suite.SuiteClasses({
        PurchaseTests.class,
        FooterTests.class,
        BillingInformationValidationTests.class,
        LoginTests.class,
        QuantityTests.class,
        MyAccountTests.class
})
public class ShopizerTestSuite {
}
