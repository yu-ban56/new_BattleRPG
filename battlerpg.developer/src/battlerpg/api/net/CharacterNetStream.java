package battlerpg.api.net;

import battlerpg.resources.materials.Characterr;

import java.net.*;
import java.io.*;
import java.util.zip.*;

public class CharacterNetStream {
    private final Socket netConnect;
    private final ObjectOutputStream outputFilters;
    private final ObjectInputStream inputFilters;
    private final OutputStream outputStream;
    private final InputStream inputStream;

    public CharacterNetStream(String accessAddress) throws IOException{
        String ipAddress = accessAddress.split(":")[0];
        int port = Integer.parseInt(accessAddress.split(":")[1]);
        netConnect = new Socket(ipAddress, port);
        inputStream = netConnect.getInputStream();
        outputStream = netConnect.getOutputStream();
        outputFilters = new ObjectOutputStream(new ZipOutputStream(new BufferedOutputStream(outputStream)));
        inputFilters = new ObjectInputStream(new ZipInputStream(new BufferedInputStream(inputStream)));
    }

    public void write(Characterr character)throws IOException {
        outputFilters.writeObject(character);
    }

    public Characterr read() throws IOException, ClassNotFoundException {
        return (Characterr) inputFilters.readObject();
    }

    public void close() throws IOException{
        outputFilters.close();
        inputFilters.close();
        netConnect.close();
    }
}
