public class Figure {
    private int x = 4;
    private int y = 4;
    public int cord[][] = new int[x][y];

    /**
     * Отрисовываем ровную фигуру ----
     * @return массив
     */

    public int[][] I(){ // другая поза фигурки
        clearCord();
        cord[0][1] = 1;
        cord[1][1] = 1;
        cord[2][1] = 1;
        cord[3][1] = 1;
        return cord;
    }

    public int[][] I1(){
        clearCord();
        cord[1][0] = 1;
        cord[1][1] = 1;
        cord[1][2] = 1;
        cord[1][3] = 1;
        return cord;
    }

    /**
     * Отрисовываем ботинок
     */
    public int[][] J(){
        clearCord();
        cord[0][0] = 2;
        cord[0][1] = 2;
        cord[1][1] = 2;
        cord[2][1] = 2;
        return cord;
    }
    public int[][] J1(){
        clearCord();
        cord[1][0] = 2;
        cord[0][0] = 2;
        cord[0][1] = 2;
        cord[0][2] = 2;
        return cord;
    }
    public int[][] J2(){
        clearCord();
        cord[0][0] = 2;
        cord[1][0] = 2;
        cord[2][0] = 2;
        cord[2][1] = 2;
        return cord;
    }
    public int[][] J3(){
        clearCord();
        cord[1][0] = 2;
        cord[1][1] = 2;
        cord[1][2] = 2;
        cord[0][2] = 2;
        return cord;
    }

    /**
     * Отрисовываем T
     */
    public int[][] T(){
        clearCord();
        cord[0][1] = 3;
        cord[1][1] = 3;
        cord[2][1] = 3;
        cord[1][0] = 3;
        return cord;
    }
    public int[][] T1(){
        clearCord();
        cord[0][0] = 3;
        cord[0][1] = 3;
        cord[0][2] = 3;
        cord[1][1] = 3;
        return cord;
    }
    public int[][] T2(){
        clearCord();
        cord[0][0] = 3;
        cord[1][0] = 3;
        cord[2][0] = 3;
        cord[1][1] = 3;
        return cord;
    }
    public int[][] T3(){
        clearCord();
        cord[1][0] = 3;
        cord[1][1] = 3;
        cord[1][2] = 3;
        cord[0][1] = 3;
        return cord;
    }

    /**
     *  Отрисовываем квадратик ||
     */
    public int[][] O(){
        clearCord();
        cord[1][0] = 4;
        cord[1][1] = 4;
        cord[2][0] = 4;
        cord[2][1] = 4;
        return cord;
    }

    /**
     * Отрисовываем -_
     */
    public int[][] Z(){
        clearCord();
        cord[0][0] = 5;
        cord[1][0] = 5;
        cord[1][1] = 5;
        cord[2][1] = 5;
        return cord;
    }
    public int[][] Z1(){
        clearCord();
        cord[0][1] = 5;
        cord[0][2] = 5;
        cord[1][0] = 5;
        cord[1][1] = 5;
        return cord;
    }

    /**
     * Фигура _-
     */
    public int[][] S(){
        clearCord();
        cord[0][1] = 6;
        cord[1][1] = 6;
        cord[1][0] = 6;
        cord[2][0] = 6;
        return cord;
    }

    public int[][] S1(){
        clearCord();
        cord[0][0] = 6;
        cord[0][1] = 6;
        cord[1][1] = 6;
        cord[1][2] = 6;
        return cord;
    }

    /**
     * Отрисовываем ботинок в другую сторону
     */
    public int[][] L(){
        clearCord();
        cord[0][1] = 7;
        cord[1][1] = 7;
        cord[2][1] = 7;
        cord[2][0] = 7;
        return cord;
    }

    public int[][] L1(){
        clearCord();
        cord[1][0] = 7;
        cord[1][1] = 7;
        cord[1][2] = 7;
        cord[2][2] = 7;
        return cord;
    }

    public int[][] L2(){
        clearCord();
        cord[0][0] = 7;
        cord[0][1] = 7;
        cord[1][0] = 7;
        cord[2][0] = 7;
        return cord;
    }

    public int[][] L3(){
        clearCord();
        cord[0][0] = 7;
        cord[1][0] = 7;
        cord[1][1] = 7;
        cord[1][2] = 7;
        return cord;
    }

    private void clearCord(){
        cord = new int [x][y];
    }
}
