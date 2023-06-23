package battlerpg.sdk.btcl;

import battlerpg.api.lang.btcl.BTCLSyntaxErrorException;
import battlerpg.api.loader.LoaderRegister;

import java.io.*;

public class Compiler {
    public static void compile(String btclFile) {
        try(BufferedReader in = new BufferedReader(new FileReader(btclFile + ".btcl")); BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(btclFile + ".btb"))) {
            String data;
            int l = 1;
            while((data = in.readLine()) != null) {
                if(data.matches("load .*")) {
                    if(LoaderRegister.getRegister().containsKey(data.substring(5))) {
                        out.write(1);
                        out.write(2);
                        out.write(' ');
                        out.write(("'" + data.split(" ")[1]).getBytes());
                        out.write(data.split(" ")[2].getBytes());
                    } else if(data.split(" ")[1].equals("plugin")) {
                        out.write(1);
                        out.write(1);
                        out.write(' ');
                        out.write(data.split(" ")[2].getBytes());
                    } else throw new BTCLSyntaxErrorException(btclFile + ":" + l + ":そのようなソフトウェアローダはありません。");
                }else throw new BTCLSyntaxErrorException(btclFile + ":" + l + ":そのような構文はありません");
                out.write("\n".getBytes());
                l++;
            }
        }catch(IOException e){e.printStackTrace();}
    }
}
