package edu.uz.dr.auctioneer.configuration.properties;

import org.junit.Test;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

public class SpringApplicationPropertiesTest {

    @Test
    public void Should_Pass_All_Pojo_Tests() {
        // given
        final Class<?> classUnderTest = SpringApplicationProperties.class;

        // when

        // then
        assertPojoMethodsFor(classUnderTest).testing(Method.GETTER, Method.SETTER)
                                            .testing(Method.CONSTRUCTOR)
                                            .areWellImplemented();
    }
}