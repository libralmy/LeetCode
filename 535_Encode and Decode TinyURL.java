/**
* use index in the list to store the short url 
need to check the index is still in bound in the list when decode
**/

public class Codec {

    // Encodes a URL to a shortened URL.http://tinyurl.com/
    
    List<String> urls = new ArrayList<>();
    public String encode(String longUrl) {
        urls.add(longUrl);
        return "http://tinyurl.com/" + (urls.size()-1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = Integer.parseInt(shortUrl.replace("http://tinyurl.com/",""));
        if(index > urls.size()){
            return "";
        }else{
            return urls.get(index);
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
