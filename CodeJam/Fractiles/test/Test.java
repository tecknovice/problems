/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import fractiles.*;
import java.util.Map;
/**
 *
 * @author hungn_000
 */
public class Test {
    public static void main(String[] args) {
        ArtworkGenerator ag = new ArtworkGenerator(2, 1);
        for (Map.Entry<String, String> en : ag.artworks.entrySet()) {
            String key = en.getKey();
            String value = en.getValue();
            System.out.println(key+" >>> "+value);
        }
    }
}
