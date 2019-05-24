package pl.infoshare.test;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pl.infoshare.categories.*;
import pl.infoshare.tests.*;

@RunWith(Categories.class)
@Categories.IncludeCategory({
        PurchaseHandBag.class,
        AddToCartTest.class,
        AddToCartRandomBagTest.class,
        AddToCartNextRandomBagTest.class,
        PurchaseLaptopBagTest.class,
        ValidateNameIsRequired.class,
        ValidateLastnameIsRequired.class,
        ValidateStreetAddressIsRequired.class,
        ValidateStateIsRequired.class,
        ValidatePostalCodeIsRequired.class,
        ValidateEmailAddressIsRequired.class,
        ValidatePhoneNumberIsRequired.class,
        ValidateLoginFieldRequired.class,
        ValidateLoginPasswordFieldRequired.class,
        BeachBagsOnFooter.class,
        RegisterUnderMyAccount.class,
        SignInUnderMyAccount.class,
        HandbagsOnFooter.class,
        ContactUsOnFooter.class,
        HomeOnFooter.class,
        SignInOnFooter.class,
})
@Suite.SuiteClasses({
        PurchaseTest.class,
        FooterTest.class,
        BillingInformationValidationTest.class,
        LoginTest.class,
        QuantityTest.class,
        MyAccountTest.class
})
public class ShopizerTestSuite {
}
