package syc.study.javabase.syn;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * java多线程通信范例
 * @author syc
 */
public class ThreadConnection {

    /**
     * 通过管道通信
     */
    public static void main(String[] args) throws IOException {
        // 输入流
        PipedWriter writer = new PipedWriter();
        // 输出流
        PipedReader reader = new PipedReader();
        writer.connect(reader);
        Thread thread = new Thread(new WriteData(reader), "read");
        int receive = 0;
        thread.start();
        while (((receive = System.in.read()) !=-1)){
            writer.write(receive);
        }


    }

    static class WriteData implements Runnable{
        private PipedReader reader;

        public WriteData(PipedReader reader){
            this.reader = reader;
        }
        @Override
        public void run(){
            int recive = 0;
            while (true) {
                try {
                    if (((recive=reader.read()) !=-1)) {
                        System.out.print((char)recive);
                    };
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            }
        }

    }
}
