/**
 * @since beta 1.0
 * @see battlerpg.sdk.plugins.Plugin
 * @see java.util.logging
 * BattleRPG ログ出力ライブラリー
 */
module battlerpg.plugin.logging {
    exports battlerpg.addon.logging;
    requires battlerpg.main;
    requires java.logging;
}
