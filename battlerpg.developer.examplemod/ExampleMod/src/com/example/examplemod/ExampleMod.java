package com.example.examplemod;


import battlerpg.sdk.mods.Mod;

/**
 * Example Mod
 */
public class ExampleMod extends Mod {

    @Override
    public void init() {
        System.out.println("Hello Modding World!");
    }

    @Override
    public String getModId() {
        return "examplemod";
    }

    @Override
    public String getModName() {
        return "ExampleMod";
    }

    @Override
    public String toString() {
        return getModName();
    }

    @Override
    public String getDesc() {
        return "Test And <b>Example</b> Mods.";
    }

    @Override
    public void destroy() {
        System.out.println("Shutdown ExampleMod.");
    }
}
