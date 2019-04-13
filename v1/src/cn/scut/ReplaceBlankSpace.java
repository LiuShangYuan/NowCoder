package cn.scut;

public class ReplaceBlankSpace {

    public String replaceSpace(StringBuffer str) {

        for(int i=0; i<str.length();i++){
            if(' ' == str.charAt(i)){
                str.replace(i, i+1, "%20");
            }
        }

        return str.toString();
    }



    public static void main(String[] args) {
        String result = new ReplaceBlankSpace().replaceSpace(new StringBuffer().append("We are Happy!"));


        System.out.println(result);
    }
}
