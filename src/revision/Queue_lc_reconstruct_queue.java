package revision;
//https://leetcode.com/problems/queue-reconstruction-by-height/

/* short solution:https://leetcode.com/problems/queue-reconstruction-by-height/discuss/89345/Easy-concept-with-PythonC%2B%2BJava-Solution
  (check comments)
  public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> { 
            return p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]; 
        }); 
        LinkedList<int[]> list = new LinkedList<>(); 
        for (int i = 0; i < people.length; i++)
            list.add(people[i][1], people[i]); 

        return list.toArray(people); 
    }
 */
import java.util.*;

public class Queue_lc_reconstruct_queue {
    public int[][] reconstructQueue(int[][] people) {
    	ArrayList<Obj> l= new ArrayList<Obj>();
    	for(int i=0; i<people.length;++i)
    		l.add(new Obj(people[i][0], people[i][1]));
    	Comparator<Obj> comp= Comparator.comparingInt(Obj::getH).thenComparingInt(Obj::getK);
    	Collections.sort(l, comp);
    	int len= l.size();
    	for(int i=len-2; i>=0;--i) {
    		if(l.get(i).k!=0) {
    			int c=0;
    			for(int j=i-1; j>=0;--j) {
    				if(l.get(j).h==l.get(i).h)
    					++c;
    				else
    					break;
    			}
    			c=l.get(i).k-c;
    			if(c>0) {
    				Obj temp=l.remove(i);
    				l.add(c+i, temp);
    			}
    		}
    	}
    	
    	for(int i=0; i<len;++i) {
    		people[i][0]=l.get(i).h;
    		people[i][1]=l.get(i).k;
    	}
    	return people;
    }
}
class Obj{
	int h;
	int k;
	public Obj(int a, int b) {this.h=a;this.k=b;}
	public int getH() {return h;}
	public void setH(int h) {this.h = h;}
	public int getK() {return k;}
	public void setK(int k) {this.k = k;}
}
