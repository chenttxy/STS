package com.sts.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import net.sf.json.JSONObject;

public class GetMessage {
	
    private static final String ACCOUNT_SID = "499c69ad69584cabb84797bd647c0d7d";
    private static final String AUTH_TOKEN = "729a2907465e4f37b36508f14df931f6";
    private static final String BASE_URL = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
    /**
     * @Title: getCode 
     * @Description: TODO( 发送验证码 ) 
     * @param @param phone
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    public static String getCode(String phone){
        String ran = smsCode();
        String timestamp = getStamp();
        String sig  = getMD5(ACCOUNT_SID, AUTH_TOKEN, timestamp); 
        String tamp = "【EGoBuy商城】您的验证码为"+ran+"，请于{2}分钟内正确输入，如非本人操作，请忽略此短信。";  
        OutputStreamWriter out = null;
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(BASE_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(10000);
            connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            String args = getArgs(ACCOUNT_SID, tamp, phone, timestamp, sig, "JSON");
            out.write(args);
            out.flush();

            br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String temp="";
            while ((temp=br.readLine())!=null) {
                sb.append(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONObject json = JSONObject.fromObject(sb.toString());
        /*System.out.println(json);*/
        String code = json.getString("respCode");
        String defaultrespcode = "00000"; 
        if(defaultrespcode.equals(code)){
            return ran;
        }else{
            return code;
        }

    }
    /**
     * @Title: getArgs 
     * @Description: TODO( 参数拼接 ) 
     * @param @param accountSid
     * @param @param smsContent
     * @param @param to
     * @param @param timestamp
     * @param @param sig
     * @param @param respDataType
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    public static String getArgs(String accountSid,String smsContent,String to,String timestamp,String sig,String respDataType){
        return "accountSid="+accountSid+"&smsContent="+smsContent+"&to="+to+"&timestamp="+timestamp+"&sig="+sig+"&respDataType="+respDataType;  
    }

    /**
     * @Title: getStamp 
     * @Description: TODO( 获取时间戳 ) 
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    public static String getStamp(){
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }
    /**
     * @Title: getMD5 
     * @Description: TODO(sig签名 ) 
     * @param @param sid
     * @param @param token
     * @param @param timestamp
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    public static String getMD5(String sid,String token,String timestamp){
        StringBuilder sBuilder = new StringBuilder();
        String source = sid + token + timestamp; 
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] digest = instance.digest(source.getBytes());
            for (byte b : digest) {
                String hexString = Integer.toHexString(b&0xff);
                if(hexString.length()==1){
                    sBuilder.append("0"+hexString);
                }else{
                    sBuilder.append(hexString);
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sBuilder.toString();
    }
    /**
     * @Title: smsCode 
     * @Description: TODO( 产生验证码) 
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    public static String smsCode(){
        String random = new Random().nextInt(1000000)+"";
        if(random.length()!=6){
            return smsCode();
        }else{
            return random;
        }
    }
}
