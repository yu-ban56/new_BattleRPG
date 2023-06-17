package com.example;


import battlerpg.sdk.plugins.Plugin;

@SuppressWarnings("all")
public class ExamplePlugin extends Plugin {
    public void init() {
        System.out.println("Test Plugin Loaded");

    }

    public void destroy() {
        System.out.println("Test Plugin Unloaded");
    }
}
