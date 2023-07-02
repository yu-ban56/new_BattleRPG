package battlerpg.sdk.btcl;

import battlerpg.api.lang.btcl.BTCLSyntaxErrorException;
import battlerpg.api.loader.LoaderRegister;
import battlerpg.sdk.plugins.Plugin;
import battlerpgloader.plugin.PluginLoader;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Interpreter {
    private static final HashMap<String, Plugin> plugins = new HashMap<>();
    public static void compile(String btclFile) {
        try(BufferedReader in = new BufferedReader(new FileReader(btclFile))) {
            String data;
            int l = 1;
            while((data = in.readLine()) != null) {
                if(data.matches("load .*")) {
                    if(LoaderRegister.getRegister().containsKey(data.substring(5))) {
                        PluginLoader.loadPlugin(LoaderRegister.get(data.split(" ")[1]), data.split(" ")[2]);
                    } else if(data.split(" ")[1].equals("plugin")) {
                        if (!plugins.containsKey(data.split(" ")[1])) PluginLoader.loadPlugin(data.split(" ")[2]); else
                            PluginLoader.loadPlugin(plugins.get(data.split(" ")[1]));
                    } else throw new BTCLSyntaxErrorException(btclFile + ":" + l + ":そのようなソフトウェアローダはありません。");
                } else if (data.split(" ")[0].equals("plugin")) {
                    String finalData = data;
                    Plugin plugin = new Plugin() {
                        @Override
                        public void init(String... args) {
                            if (finalData.split(" ")[2].equals("init:")) {
                                try {
                                    Method init = ClassLoader.getSystemClassLoader().loadClass(finalData.split(" ")[2].split("::")[0]).getMethod(finalData.split(" ")[2].split("::")[1]);
                                    init.invoke(this, (Object[]) args);
                                } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                                         InvocationTargetException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                        @Override
                        public void destroy() {
                            if (finalData.split(" ")[3].equals("destroy:")) {
                                try {
                                    Method init = ClassLoader.getSystemClassLoader().loadClass(finalData.split(" ")[2].split("::")[0]).getMethod(finalData.split(" ")[3].split("::")[2]);
                                    init.invoke(this);
                                } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException |
                                         InvocationTargetException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    };
                    plugins.put(data.split(" ")[1], plugin);
                }
                l++;
            }
        }catch(IOException e){e.printStackTrace();}catch (ArrayIndexOutOfBoundsException e) {
            throw new BTCLSyntaxErrorException(e);
        }
    }

    public static void runningStatement(String data) {
        if(data.matches("load .*")) {
            if(LoaderRegister.getRegister().containsKey(data.substring(5))) {
                PluginLoader.loadPlugin(LoaderRegister.get(data.split(" ")[1]), data.split(" ")[2]);
            } else if(data.split(" ")[1].equals("plugin")) {
                PluginLoader.loadPlugin(data.split(" ")[2]);
            } else throw new BTCLSyntaxErrorException("そのようなソフトウェアローダはありません。");
        }else throw new BTCLSyntaxErrorException("そのような構文はありません");
    }
}
