package battlerpg.api.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriterOutputStream extends FilterOutputStream {
    String encoding;
    /**
     * Creates an output stream filter built on top of the specified
     * underlying output stream.
     *
     * @param out the underlying output stream to be assigned to
     *            the field {@code this.out} for later use, or
     *            {@code null} if this instance is to be
     *            created without an underlying stream.
     */
    public WriterOutputStream(OutputStream out) {
        super(out);
    }

    public void write(String str) throws IOException {
        super.write(str.getBytes());
    }
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
}
