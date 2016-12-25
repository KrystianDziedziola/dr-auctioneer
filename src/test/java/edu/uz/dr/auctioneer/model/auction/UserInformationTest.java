package edu.uz.dr.auctioneer.model.auction;

import org.junit.Test;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

public class UserInformationTest {

    @Test
    public void Should_Pass_All_Pojo_Tests() {
        // given
        final Class<?> classUnderTest = UserInformation.class;

        // when

        // then
        assertPojoMethodsFor(classUnderTest).testing(Method.GETTER)
                                            .testing(Method.CONSTRUCTOR)
                                            .areWellImplemented();
    }
}