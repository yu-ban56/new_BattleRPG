/**
 *BattleRPG�̃R�A�����������Ă��܂��B
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
    requires java.desktop;
}
