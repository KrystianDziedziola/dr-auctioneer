package edu.uz.dr.auctioneer.model.request;

import org.junit.Test;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

public class AuctionRequestTest {

    @Test
    public void Should_Pass_All_Pojo_Tests() {
        // given
        final Class<?> classUnderTest = AuctionRequest.class;

        // when

        // then
        assertPojoMethodsFor(classUnderTest).testing(Method.CONSTRUCTOR)
                                            .areWellImplemented();
    }

}