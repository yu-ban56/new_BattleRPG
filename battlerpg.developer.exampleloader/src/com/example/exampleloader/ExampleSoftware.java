package com.example.exampleloader;

import battlerpg.sdk.Software;

public abstract class ExampleSoftware implements Software {
    public void starting() {}
    public void destroy() {}
    public abstract void init();
}
