/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractiles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author hungn_000
 */
public class ArtworkGenerator {
    public HashMap<String,String> artworks;
    public int K,C;
    public ArtworkGenerator(int K, int C){
        this.K=K;
        this.C=C;
        artworks = new HashMap<>();
        ArrayList<String> originalSequenceS= new ArrayList<>();
        ArrayList<String> binaryStringS= generateBinaryString(K);
        for (String binaryString : binaryStringS) {
            String originalSequence = convertBinaryStringtoLinearTiles(binaryString);
            originalSequenceS.add(originalSequence);
        }
        for (String originalSequence : originalSequenceS) {
            String artwork = recursive(originalSequence,originalSequence, 1);
            artworks.put(originalSequence, artwork);
        }
 
    }
    public String convertBinaryStringtoLinearTiles(String binaryString){
                    char[] charArray = binaryString.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char c : charArray) {
                if(c=='1'){
                    sb.append('L');
                }
                if(c=='0'){
                    sb.append('G');
                }
            }
            return sb.toString();
    }
public  ArrayList<String> generateBinaryString(int N){
        ArrayList<String> returnList = new ArrayList<>();
        long upper_bound = (long)Math.pow(2, N)-1;
        long lower_bound = 0;
        long X;
        Stack<Long> s;
        StringBuffer str;
        for(long i=lower_bound;i<=upper_bound;i++){
            s = new Stack<>();
            str = new StringBuffer();
            X=i;
            for(int j=0;j<N;j++){
                s.push(X%2);
                X=X/2;
            }
            while(true){
                str.append(String.valueOf(s.pop()));
                if(s.isEmpty()) break;
            }
            System.out.println(str.toString());
            returnList.add(str.toString());
        }
        return returnList;
}
    public String recursive(String originalSequence,String sequence, int C){
        StringBuilder sb = new StringBuilder();
        char[] charArray = sequence.toCharArray();
        for (char c : charArray) {
                if(c=='L'){
                    sb.append(originalSequence);
                }
                if(c=='G'){
                    for(int i=1;i<=originalSequence.length();i++){
                        sb.append('G');
                    }
                }
            }
        String nextSequence = sb.toString();
        C=C+1;
        if(C<this.C){
            nextSequence=recursive(originalSequence,nextSequence,C); 
        }
        return nextSequence;
    }
}
