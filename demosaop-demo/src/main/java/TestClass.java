public class TestClass {

    public TestClass() {
        System.out.println("TestClass Constructor");
    }

    //This is a join point
    public void testJoinPoint() {
        System.out.println("testJoinPoint()");
    }
}
