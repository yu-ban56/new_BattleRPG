package com.example.exampleloader;

import battlerpg.api.Crash;

public class ExampleSoftwareLoadingCrash extends Crash {
    @Override
    public String getSubMessage() {
        return "examplesoftwareloader";
    }

    public ExampleSoftwareLoadingCrash() {super();}
    public ExampleSoftwareLoadingCrash(String message) {super(message);}
    public ExampleSoftwareLoadingCrash(Throwable throwable) {super(throwable);}
}
