package test.plugin;

import battlerpg.sdk.*;
import battlerpg.sdk.plugins.*;
import battlerpgloader.*;

public class PluginMain extends Plugin{
	public void starting() {
		System.out.println("Starting PluginMain");
	}
	public void init() {
		System.out.println("Loaded Test Plugin");
		this.starting();
	}
}
