package IB;
//https://www.interviewbit.com/problems/word-search-board/
public class Graph_ib_word_search_board {
    int R, C;
    public int exist(String[] a, String b) {
        char ch[]=b.toCharArray();
        R=a.length;
        C=a[0].length();
        for(int i=0;i<a.length;++i){
            for(int j=0;j<a[0].length();++j){
                if(a[i].charAt(j)==ch[0] && dfs(i,j,1, ch, a))
                    return 1;
            }
        }
        return 0;
    }

    public boolean dfs(int x, int y, int i, char[]ch, String a[]){
        if(i==ch.length)
            return true;
        int DXY[][]={{1,0},{-1,0},{0,1},{0,-1}};
        for(int dxy[]:DXY){
            int tx=x+dxy[0];
            int ty=y+dxy[1];
            if(isValid(tx, ty) && a[tx].charAt(ty)==ch[i] && dfs(tx, ty, i+1, ch, a))
                return true;
        }
        return false;
    }

    public boolean isValid(int x, int y){
        return x>=0 && y>=0 && x<R && y<C;
    }
}
