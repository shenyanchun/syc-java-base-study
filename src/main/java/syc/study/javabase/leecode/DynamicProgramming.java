package syc.study.javabase.leecode;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author syc
 */
public class DynamicProgramming {
    public static int climbStairs(int n) {
       int q = 0,p = 0,r = 1;
        for (int i=1;i<=n;i++) {
            q = p;
            p = r;
            r = q+p;
        }

        return r;
    }


    public static void main(String[] args) throws IOException {
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();
        writer.connect(reader);
        Thread thread = new Thread(new print(reader), "print");
        thread.start();
        int receive = 0;
        while((receive=System.in.read())!=-1){
            writer.write(receive);
        }
    }


    static class print implements Runnable{
        private PipedReader reader;
        public print(PipedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            int receive = 0;
            while (true){
                try {
                    if ((receive = reader.read()) != -1) {
                        System.out.print(Thread.currentThread().getName()+"-"+(char) receive);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
