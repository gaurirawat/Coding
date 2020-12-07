package revision;
//https://leetcode.com/problems/game-of-life/
public class Array_lc_game_of_life {
    public void gameOfLife(int[][] b) {
        for(int i=0;i<b.length; ++i) {
            for(int j=0;j<b[0].length;++j) {
                int[][] dxy= new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
                int alive=0;
                int dead=0;
                for(int k=0;k<8;++k) {
                    int ii=i+dxy[k][0];
                    int jj=j+dxy[k][1];

                    if(ii>=0 && jj>=0 && ii<b.length && jj<b[0].length) {
                        if(b[ii][jj]%10==1) {
                            alive++;
                        } else {
                            dead++;
                        }
                    }
                }
                if(alive== 3) {
                    b[i][j]=10+b[i][j];
                } else if (alive==2) {
                    b[i][j]+=10*b[i][j];
                }
            }
        }
        for(int i=0;i<b.length; ++i) {
            for(int j=0;j<b[0].length;++j) {
                b[i][j]/=10;
            }
        }
    }
}
