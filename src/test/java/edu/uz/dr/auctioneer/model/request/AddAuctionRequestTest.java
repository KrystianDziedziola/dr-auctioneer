package edu.uz.dr.auctioneer.model.request;

import org.junit.Test;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.FieldPredicate.exclude;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

public class AddAuctionRequestTest {

    @Test
    public void Should_Pass_All_Pojo_Tests() {
        // given
        final Class<?> classUnderTest = AddAuctionRequest.class;

        // when

        // then
        assertPojoMethodsFor(classUnderTest, exclude("DATE_FORMAT")).testing(Method.CONSTRUCTOR)
                                            .testing(Method.GETTER,Method.SETTER)
                                            .areWellImplemented();
    }

}