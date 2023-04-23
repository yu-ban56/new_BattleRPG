package battlerpg.resources.Field;

public class grasspane implements Field{
    int[][] Dimention = new int[4][4];
    public grasspane() {
        Dimention[0][0] = 12005;
        Dimention[0][1] = 12032;
        Dimention[0][3] = 12045;
        Dimention[2][0] = 12032;
        Dimention[1][0] = 14305;
        Dimention[3][0] = 12395;
        Dimention[1][1] = 12032;
        Dimention[3][0] = 26903;
    }
    public int[][] getdimention() {
        return Dimention;
    }
}
