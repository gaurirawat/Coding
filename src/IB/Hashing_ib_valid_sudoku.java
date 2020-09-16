package IB;

import java.util.List;

//https://www.interviewbit.com/problems/valid-sudoku/
public class Hashing_ib_valid_sudoku {
    public int isValidSudoku(final List<String> a) {
        for(int i=0;i<9;++i){
            boolean numr[]=new boolean[9];
            boolean numc[]=new boolean[9];
            for(int j=0;j<9;++j){
                if(Character.isDigit(a.get(i).charAt(j))){
                    int x=Integer.parseInt(a.get(i).charAt(j)+"")-1;
                    if(numr[x]) return 0;
                    numr[x]=true;
                }
                if(Character.isDigit(a.get(j).charAt(i))){
                    int x=Integer.parseInt(a.get(j).charAt(i)+"")-1;
                    if(numc[x]) return 0;
                    numc[x]=true;
                }
            }
        }
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                boolean num[]=new boolean[9];
                for(int k=i;k<i+3;++k){
                    for(int l=j;l<j+3;++l){
                        if(Character.isDigit(a.get(k).charAt(l))){
                            int x=Integer.parseInt(a.get(k).charAt(l)+"")-1;
                            if(num[x]) return 0;
                            num[x]=true;
                        }
                    }
                }
            }
        }
        return 1;
    }
}