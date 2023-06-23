/**
 *BattleRPGのコア部分が入っています。
*/
module battlerpg.main {
    exports battlerpg.resources;
    exports battlerpg.resources.characters;
    exports battlerpg.resources.materials;
    exports battlerpg.resources.Field;
    exports battlerpg.resources.weapons.knife;
    exports battlerpg.resources.monsters;
    exports battlerpg.main;
    exports battlerpg.save.read;
    exports battlerpg.save.write;
    exports battlerpg.builders;
    exports battlerpg.resources.effect;
    exports battlerpg.sdk;
    exports battlerpg.sdk.mods;
    exports battlerpg.sdk.plugins;
    exports battlerpg.sdk.annotations;
    exports battlerpg.api.net;
    exports battlerpg.api.util.language;
    exports battlerpg.api.plugin;
    exports battlerpg.api.io;
    exports battlerpg.api.util.logging;
    exports battlerpgloader;
    exports battlerpgloader.plugin;
    exports battlerpgloader.mod;
    exports battlerpg.api.loader;
    exports battlerpg.api;
    exports battlerpg.sdk.btcl;
    exports battlerpg.api.lang;
    exports battlerpg.api.lang.btcl;
    requires java.desktop;
    requires java.xml;
    requires java.logging;
}
