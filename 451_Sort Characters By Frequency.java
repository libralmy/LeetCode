/**
* class Freq char, count
* Freq[256] 1 fill up new Freq(), 2 iterate counter, 3 Arrays.sort
* output stringbuilder
*/

public class Solution {
    public class Freq{
        char c;
        int count;
        Freq(){
            this.count = 0;
        }
    }
    
    public String frequencySort(String s) {
        if(s == null || s.length() == 0){ return s;}
        
        Freq[] f = new Freq[256];
        for(int i = 0 ; i < 256; i++){
            f[i] = new Freq();
        }
        
        for(int i = 0; i < s.length(); i++){
            f[s.charAt(i)].c = s.charAt(i);
            f[s.charAt(i)].count++;
            
        }
        
        Arrays.sort(f, new Comparator<Freq>(){
            @Override
            public int compare(Freq f1, Freq f2){
                return f2.count - f1.count;
            }
            
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < f.length; i++){
            if(f[i].count != 0){
                for(int k = f[i].count; k > 0; k--){
                    sb.append(f[i].c);
                }
                
            }
        }
        
        return sb.toString();
    }
}
