package IB;

public class Acolite {
    public static int completeBracelet(int arr[], int n){
        if(n<4) return 0;
        String pattern=""+arr[0];
        String curr="";
        int rep=1;
        boolean isMatch=false;
        for(int i=1;i<n;++i){
            curr+=arr[i];
            isMatch= curr.length() == 0 || ((curr).equals(pattern.substring(0, curr.length())));
            if(curr.length()==pattern.length() && isMatch) {
                if(pattern.equals(curr)){
                    ++rep;
                    curr="";
                }
            }
            if(!isMatch){
                StringBuffer t=new StringBuffer();
                for(int j=0;j<rep;++j)
                    t.append(pattern);
                pattern=t.toString()+curr;
                curr="";
                rep=1;
            }
        }

        if(rep>1 && pattern.length()>=2 && (pattern.length()*rep)==n)
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(completeBracelet(new int[]{1,1,2,1,1,4},6));
        System.out.println(completeBracelet(new int[]{1,2,2,1,2,2},6));
        System.out.println(completeBracelet(new int[]{1,2,2,1,2,2,1,2,4},9));
        System.out.println(completeBracelet(new int[]{1,2,2,1,2,2,1,2,2},9));
        System.out.println(completeBracelet(new int[]{1,2,2,1,2,2},6));
    }
}
