package syc.study.javabase.ExceptionS;

public class TestException{

    /**
     * 1.try-catch捕获到异常
     */

    public void throwExceptionMethod(){
        try {
            throw new IllegalArgumentException("IllegalArgumentException异常");
        }catch (RuntimeException e){

        }finally {

        }
    }
}
