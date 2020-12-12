package Mail;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class test1 {
    /**ublic static void main(String args[]) throws Exception {
        String mail = getNewMail();
        if(!mail.equals("-1")) {
            String[] spltMail = mail.split("@");
            String login = spltMail[0];
            String domain = spltMail[1];
            //System.out.println(mail);
        }
        System.out.println(getMailInbox("id2tcxs34d", "wwjmp.com"));
    }*/

    public static String getNewMail() {
        StringBuilder sb = new StringBuilder();
        try{
            URL u = new URL("https://www.1secmail.com/api/v1/?action=genRandomMailbox&count=1");
            HttpURLConnection hr = (HttpURLConnection)u.openConnection();
            //System.out.println(hr.getResponseCode());
            if(hr.getResponseCode()==200) {
                InputStream im = hr.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(im));
                String line = br.readLine();
                while ((line!=null)) {
                    sb.append(line);
                    line=br.readLine();
                }
                //
            }
        }catch (Exception e) {
            System.out.println(e);
            return "-1";
        }
        return sb.toString().split("\"")[1];
    }
    public static String getMailInbox(String login, String domain) {
        StringBuilder s = new StringBuilder();
        try{
            URL u = new URL("https://www.1secmail.com/api/v1/?action=getMessages&login=" + login + "&domain=" + domain);
            HttpURLConnection hr = (HttpURLConnection)u.openConnection();
            if(hr.getResponseCode()==200) {
                InputStream im = hr.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(im));
                String line = br.readLine();
                while ((line!=null)) {
                    s.append(line);
                    line=br.readLine();
                }
            }
        }catch (Exception e) {
            System.out.println(e);
            return "-1";
        }
        if(s.toString().length() > 2){
            String[] split1 = s.toString().split(",");
            String[] split2 = split1[2].split("\\s");
            String[] split3 = split2[0].split("\"");
            return split3[3];
        }
        return "-1";
    }
}
