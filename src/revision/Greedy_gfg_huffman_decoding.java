package revision;
//https://practice.geeksforgeeks.org/problems/huffman-decoding-1/1
public class Greedy_gfg_huffman_decoding {
    String decodeString(minHeapNode root, String encodedStr){
        minHeapNode head=root;
        String decodedStr="";
        int i=0;
        while(i!=encodedStr.length()){
            if(encodedStr.charAt(i)=='0')
                root=root.left;
            else
                root=root.right;
            i++;
            if(root.left==null && root.right==null){
                decodedStr+=root.data;
                root=head;
            }
        }
        return decodedStr;
    }
}
class minHeapNode{
    minHeapNode left, right;
    int freq;
    char data;

    public minHeapNode(int freq, char data) {
        left=right=null;
        this.freq = freq;
        this.data = data;
    }
}