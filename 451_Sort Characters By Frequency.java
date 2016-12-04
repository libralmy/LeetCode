public class Solution {
    class Entry{
        char c;
        int count; 
        Entry(){
            this.count = 0;
        }
    }
    
    
    public String frequencySort(String s) {
        if(s == null){return s;}
        
        Entry[] elem = new Entry[256];
        
        for(int i = 0; i < 256; i++){
            elem[i] = new Entry();
        }
        
        for(int i = 0; i < s.length(); i++){
            elem[s.charAt(i)].c = s.charAt(i);
            elem[s.charAt(i)].count++;
        }
        
        Arrays.sort(elem, new Comparator<Entry>(){
            @Override
            public int compare(Entry e1, Entry e2){
                return e2.count - e1.count;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Entry e: elem){
            while(e.count > 0){
                sb.append(e.c);
                e.count--;
            }
        }
        
        return sb.toString();

    }
}
