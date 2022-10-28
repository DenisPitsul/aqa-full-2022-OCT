package org.prog;

import org.junit.jupiter.api.Assertions;

public class JUnitTests {

    //    @Test
    public void myJUnitTest() {
        System.out.println("my first test");
        String a = "a";
        String b = "a";
        Assertions.assertEquals(a, b, "Strings a and b are not the same!");
    }

    //    @Test
    public void myJUnitTest2() {
        String a = null;
        Assertions.assertNotNull(a, "this string is empty!");

        System.out.println("my first test 2");
    }

    //    @Test
    public void myJUnitTest3() {
        String a = null;
        System.out.println(a.length());
    }
}
