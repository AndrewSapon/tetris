
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 ���� �����������, � ����������� ������� ����� �� Fx=)
 */

public class TetrisGame extends JPanel implements ActionListener{
    static JFrame frame;
    private int SPEED = 3;
    private final static int SCALE = 30; // �������
    private final static int WIDTH = 10; // ������
    private final static int HEIGHT = 20; // ������
    private Random rand = new Random(); // ��� ���������� ��������� �������
    private Timer t = new javax.swing.Timer(1000/SPEED, this);
    private int[][] cord = new int[4][4]; // ������ ����� ������
    private int[][] field = new int[WIDTH][HEIGHT]; // ������� ������� �� ��� ������� �����
    private int check; // �������� �� �����	���������� ���� ������������
    private Color color;
    private int esc; // ������ ������������� ��� ���������� ���� ��� ������� esc
    /**
     * ������� ����� ���������� ������� cord �� ����
     */
    private int locationX = SCALE*3;
    private int locationY = -30;
    private Figure f = new Figure();
    private int figure;
    private int[][] field1;
    private int posture; // ������� ���� �������

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(WIDTH*SCALE+6, HEIGHT*SCALE+28);
                frame.add(new TetrisGame());
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    /**
     * ����������� ������������ ������
     */
    public TetrisGame() {
        setSize(frame.getWidth(), frame.getHeight());
        setFocusable(true);
        addKeyListener(new KeyBoard());
        t.start();
    }

    /**
     * ��� ������� �������
     */
    private int[][] move(int[][] cord, int posture, boolean isLocation){
        if(figure==1){ // ������������ ������ ������ ----
            if(posture == 0){
                cord = f.I();
                check = 525;
            }
            else if(posture == 1){
                cord = f.I1();
                check = 465;
            }
            repaint();
        }

        else if(figure==2){ // ������������ ������� |_
            if(posture == 0){
                cord = f.J();
                check = 525;
            }else if(posture == 1){
                cord = f.J1();
                check = 495;
            }else if(posture == 2){
                cord = f.J2();
                check = 525;
            }else if(posture == 3){
                cord = f.J3();
                check = 495;
            }
            repaint();
        }

        else if(figure==3){ // ������������ T
            if(posture == 0){
                cord = f.T();
                check = 525;
            }else if(posture == 1){
                cord = f.T1();
                check = 495;
            }else if(posture == 2){
                cord = f.T2();
                check = 525;
            }else if(posture == 3){
                cord = f.T3();
                check = 495;
            }
            repaint();

        }

        else if(figure==4){ // ������������ ��������� ||
            cord = f.O();
            check = 525;
            repaint();
        }

        else if(figure==5){ // ������������ -_
            if(posture == 0){
                cord = f.Z();
                check = 525;
            }else if(posture == 1){
                cord = f.Z1();
                check = 495;
            }
            repaint();
        }

        else if(figure == 6){
            if(posture == 0){
                cord = f.S();
                check = 525;
            }else if(posture == 1){
                cord = f.S1();
                check = 495;
            }
            repaint();
        }

        else if(figure == 7){
            if(posture == 0){
                cord = f.L();
                check = 525;
            }else if(posture == 1){
                cord = f.L1();
                check = 495;
            }else if(posture == 2){
                cord = f.L2();
                check = 525;
            }else if(posture == 3){
                cord = f.L3();
                check = 495;
            }
            repaint();
        }
        if(isLocation) locationY += SCALE;
        return cord;
    }

    /**
     * ��������� �������
     */
    @Override
    public void actionPerformed(ActionEvent e){
        checkStop();
        if(checkGameOver()) t.stop();
        /**
         * ���� ������� ������ �������� ��� ���� ��������
         */
        if(locationY == -30){
            figure = generateFigure();
            locationY = -30;
            locationX = SCALE*3;
        }
        /**
         * ���� ���������� ��� ������� � �� ������ ���� ��� ����� �������
         */
        if(locationY >=check){
            clearCord();
            figure = generateFigure();
            locationY = -30;
            locationX = SCALE*3;
        }
        checkClears();
        cord = move(cord, posture, true);
    }

    private boolean checkGameOver(){
        for(int i=0;i<2;i++){
            for(int j=0;j<field.length;j++){
                if(field[j][i]>0) return true;
            }
        }
        return false;
    }

    /**
     * ������ ���� ��������
     */
    private Color figureColor(){
        switch(figure){
            case 1:
                color = Color.CYAN;
                break;
            case 2:
                color = new Color(0x226CFF);
                break;
            case 3:
                color = new Color(0x9000D7);
                break;
            case 4:
                color = Color.YELLOW;
                break;
            case 5:
                color = Color.RED;
                break;
            case 6:
                color = Color.GREEN;
                break;
            case 7:
                color = Color.ORANGE;
                break;
        }
        return color;
    }

    /**
     * ������ ���� ������� ��������� �� ����
     */
    private Color fieldColor(int i, int j){
        switch(field[i][j]){
            case 1:
                color = Color.CYAN;
                break;
            case 2:
                color = new Color(0x226CFF);
                break;
            case 3:
                color = new Color(0x9000D7);
                break;
            case 4:
                color = Color.YELLOW;
                break;
            case 5:
                color = Color.RED;
                break;
            case 6:
                color = Color.GREEN;
                break;
            case 7:
                color = Color.ORANGE;
                break;
        }
        return color;
    }

    /**
     * �������� ��������� ������, ���� ��� ��� ������ �� ���������������
     */
    private void checkStop(){
        int x;
        int y;
        stop: for(int i = 3; i >= 0; i--){ // ��������������
            for(int j = 3; j>=0; j--){
                if(cord[i][j]>0){ // ���� cord[i][j] �� ������ ������(������ 0)
                    x = locationX/SCALE+i;
                    y = locationY/SCALE+j+1; // �� ������ ��������� ������
                    if(y-1<19){ // ���� ������� ������� �� ��������� ���������
                        if(field[x][y]>0){ // ���� ��� �� ������
                            check = locationY; // �� check ����� ��������� �������� ��������������
                            addField();
                            break stop;
                        }
                    }
                }
            }
        }
    }

    /**
     * ��������� �� ���� ������� �������
     */
    private void addField(){
        for(int i = 0;i<cord.length;i++){
            for(int j = 0;j<cord[i].length;j++){
                if(cord[i][j]>0 ){
                    int x = locationX/SCALE+i; // ������ ������ �� ���� ��������� �������
                    int y = locationY/SCALE+j;
                    field[x][y] = figure; // � ��������� � ������� 10x15
                }
            }
        }
    }

    /**
     * ��������� ���� ��� �� ��������, ���� ��� �������� �� 0 �� 10
     * �� ���� ��� ��������� � ������� ������� ���� ���������� ����
     */
    private void checkClears(){
        int check = 0; // �������� �� ���������� ����� ���� ���������
        int c = 0; //
        field1 = new int[WIDTH][HEIGHT];
        for(int j=0;j<HEIGHT;j++,check=0){ // ����������� � ������ ����������� �������� ����
            for(int i=0;i<WIDTH;i++){
                if(field[i][j]>0) check++;
                if(check == 10){ // ���� ���� ��� �������� ���������
                    int row = 0;
                    for(int t=0;t<10;t++){
                        field[t][j] = 0; // �������� ���
                        row = j;
                    }

                    for(int d = HEIGHT-1;d>row;d--){ // ��� ���� ������� ���� ���������� ���� ��������� � ������
                        for(int s = 0;s<WIDTH;s++){
                            field1[s][d] = field[s][d];
                            field[s][d] = 0;
                        }
                    }

                    for(int d = 0;d<row;d++){
                        for(int s = 0;s<WIDTH;s++){
                            if(field[s][d]>0){
                                if(d == 19) return;
                                field1[s][d+1] = field[s][d]; // ����������� ���� �������� ����
                                field[s][d] = 0;
                                c++;
                            }
                        }
                    }
                }
            }
        }
        if(c>0) field = field1;
    }

    /**
     * �������� ������
     */
    private void clearCord(){
        cord = new int [4][4];
    }

    /**
     * ��������� ������������� ������ �� ������
     * 1 - ������ ������ ----
     * 2 - |_
     * 3 - -|-
     * 4 - ||
     * 5 - -_
     * @return ����� �������
     */
    private int generateFigure(){
        int figure;
        posture = 0;
        do{
            figure = rand.nextInt(8);
        }while(figure == 0);
        return figure;
    }

    /**
     * ��������� ����� �� ������
     */
    @Override
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE); // ������� ����

        // ������������ ��� �������� ������� ������ 1
        for(int i=0;i<cord.length;i++){ // x
            for(int j=0;j<cord[i].length;j++){ // y
                if(cord[i][j]>0 ){
                    /**
                     * ���� ������� �� ��� �������
                     */
                    if(locationY >= check){
                        int x = locationX/SCALE+i; // ������ ������ ��������� �������
                        int y = locationY/SCALE+j;
                        field[x][y] = figure; // � ��������� � ������� 10x15
                    }

                    g2.setColor(figureColor());
                    g2.fill3DRect(SCALE*i+locationX+1,SCALE*j+locationY+1, SCALE, SCALE, true); // ������ ������� ������� ������������ ������� location
                }
            }
        }

        // ������������ ������� �� ����� �������
        for(int i=0;i<field.length;i++){ // x
            for(int j=0;j<field[i].length;j++){ // y
                if(field[i][j]>0 ){
                    g2.setColor(fieldColor(i,j));
                    g2.fill3DRect(i*SCALE+1,j*SCALE+1, SCALE, SCALE, true); // SCALE = 30
                }
            }
        }
    }

    /**
     * ��������� ���� ������ �� ����������,
     * ���� posture ������������� �� ���� ������ ��������
     */
    private int setPosture(int posture){
        if(figure == 1){
            if(posture == 1) posture = -1;
            posture++;
        }

        else if(figure == 2){
            if(posture == 3) posture = -1;
            posture++;
        }

        else if(figure == 3){
            if(posture == 3) posture = -1;
            posture++;
        }

        else if(figure == 5){
            if(posture == 1) posture = -1;
            posture++;
        }

        else if(figure == 6){
            if(posture == 1) posture = -1;
            posture++;
        }

        else if(figure == 7){
            if(posture == 3) posture = -1;
            posture++;
        }
        return posture;
    }

    /**
     * �������� �� �� ���� ������� ������� ����
     * �� ������ �� ��� � ����� ��� ������ �������
     * @return true ���� �� ������ � ����� �������� ����, false ���� ������
     */
    private boolean checkPosture(){
        int posture1 = setPosture(posture);
        int[][] cord1 = move(cord, posture1, false); // ��� ������������ ��������� ���� ������
        int x;
        int y;
        for(int i=0;i<cord1.length;i++){
            for(int j=0;j<cord1[i].length;j++){
                if(cord1[i][j]>0){
                    x = locationX/SCALE+i;
                    y = locationY/SCALE+j;
                    if(x<0 | y<0) return false;
                    if(x>=WIDTH | y>=HEIGHT) return false;
                    if(field[x][y]>0) return false;
                }
            }
        }
        return true;
    }

    /**
     * ����� ���������� ����� �� ��������� ������
     * @return ���� ������ ���� ������� ��� ������ �� ���������� false ����� true
     */
    private boolean checkRight(){
        for(int i=0;i<cord.length;i++){
            for(int j=0;j<cord[i].length;j++){
                if(cord[i][j]>0){
                    int x = locationX/SCALE+i; // ������ ������� ���������� �� x
                    int y = locationY/SCALE+j;
                    if(x==9){
                        return false;
                    }
                    if(field[x+1][y]>0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * ����� ���������� ����� �� ��������� �����
     * @return ���� ����� ���� ������� ��� ������ �� ���������� false ����� true
     */
    private boolean checkLeft(){
        for(int i=0;i<cord.length;i++){
            for(int j=0;j<cord[i].length;j++){
                if(cord[i][j]>0){
                    int x = locationX/SCALE+i; // ������ ������� ���������� �� x
                    int y = locationY/SCALE+j;
                    if(x==0){ // ������ ������
                        return false;
                    }
                    if(field[x-1][y]>0){ // ����� ��������� ������� ����� ���� �� �� ��� ����� - ���������� false
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * ����� ��������� ����������
     */
    class KeyBoard extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_LEFT){
                if(checkLeft()){
                    locationX -=SCALE;
                    repaint();
                }
            }
            if(key == KeyEvent.VK_RIGHT){
                if(checkRight()){
                    locationX +=SCALE;
                    repaint();
                }
            }
            if(key == KeyEvent.VK_DOWN){
                SPEED = 13;
                t.setDelay(1000/SPEED);
            }
            if(key == KeyEvent.VK_UP){ // ��������� ���� ������
                if(checkPosture()) posture = setPosture(posture);
            }
            if(key == KeyEvent.VK_ESCAPE){ // ���� ����
                ++esc;
                if(esc%2==1) t.stop();
                if(esc%2==0) t.restart();
            }
        }

        @Override
        public void keyReleased(KeyEvent e){ // ���������
            SPEED = 3;
            t.setDelay(1000/SPEED);
        }
    }
}
