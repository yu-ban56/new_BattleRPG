package com.example;


import battlerpg.sdk.plugins.Plugin;

@SuppressWarnings("all")
public class ExamplePlugin extends Plugin {
    static {

    }
    public void init(String... args) {
        System.out.println("Test Plugin Loaded");
    }

    public void destroy() {
        System.out.println("Test Plugin Unloaded");
    }
}
