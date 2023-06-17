package com.example.examplemod;

import battlerpg.sdk.mods.Mod;

public class ExampleModSub extends Mod {
    @Override
    public void init() {
        System.out.println("Starting ExampleModSub");
    }

    @Override
    public String getModId() {
        return "examplemod_sub";
    }

    @Override
    public String getModName() {
        return "ExampleMod Sub";
    }

    @Override
    public String getDesc() {
        return "Test Multi Mods.";
    }
}
