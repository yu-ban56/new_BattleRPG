package battlerpg.sdk.btcl;

import battlerpg.api.lang.btcl.BTCLFormatException;
import battlerpgloader.plugin.PluginLoader;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class BTCLInterpreter {
    public static void run(String btbFile) {
        try(InputStream in = new BufferedInputStream(new FileInputStream(btbFile + ".btb"))) {
            int i;
            while((i = in.read()) != -1) {
                if(i == 1) {
                    if((i = in.read()) == 1) {
                       String strName = new String(in.readNBytes((int) (new File(btbFile).length()))).split(" ")[1];
                       System.out.println(strName);
                       PluginLoader.loadPlugin(strName);
                    }else if(i == 2) {
                        String className = new String(in.readNBytes((int) new File(btbFile).length())).split(" ")[1];
                        String software = new String(in.readNBytes((int) new File(btbFile).length())).split(" ")[2];
                        PluginLoader.loadPlugin(className, software);
                    }
                }else if(i == '\n') {;}else throw new BTCLFormatException("フォーマットが違います。");
            }
        }catch(Exception e){e.printStackTrace();}
    }
}
