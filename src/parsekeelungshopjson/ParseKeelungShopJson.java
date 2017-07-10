package parsekeelungshopjson;

import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import pojo.shopdata.Principal;
import txttojson.BagOfPrimitives;

public class ParseKeelungShopJson {
//第一次commit測試修改
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        ArrayList<String> list = new ArrayList<>();

        String jsonFilePath = "/Users/xanxus/Downloads/Sublime程式碼備份/基隆到屏東_GoogleMap路線指示資料(非Json)(部分)";
        String content = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
        String[] instructions = content.split("\n");
        BagOfPrimitives[] bop = new BagOfPrimitives[instructions.length];
        for(int i = 0 ; i<instructions.length ; i++){
            bop[i] = new BagOfPrimitives();
            bop[i].setHtmlInstructions(instructions[i]);
//            if(bop[i].getHtmlInstructions().contains("/")&& bop[i].getHtmlInstructions().contains("繼續開在")){
//                list.add(bop[i].getHtmlInstructions());//加進ArrayList中
//            }
            if(bop[i].getHtmlInstructions().contains("/")){
                list.add(bop[i].getHtmlInstructions());//加進ArrayList中
            }
        }
        for(int i = 0 ; i<list.size() ; i++){
            Collections.sort(list);//排序
            System.out.println(rule1(list.get(i)));
//            System.out.println(list.get(i));
        }
        /*轉成Json*/
//        String htmlInstructionsJson = gson.toJson(bop);
//        BagOfPrimitives[] enums = gson.fromJson(htmlInstructionsJson, BagOfPrimitives[].class);
//        for(BagOfPrimitives b : enums){
//            System.out.println(b.getHtmlInstructions());
//        }
//        System.out.println(htmlInstructionsJson);
    }//main結尾
    public static String rule1(String a){
        String tmp = a.substring(0, 1);//取得第一個字
        int count = 0;
        int idxSlashPosition = 0;
        int idxFirstBoundary = 0;
        String sub1 = null;
        String sub2 = null;
        String instruction = null;
        if(a.contains("線") && !a.contains("支線") && !a.contains("玉井線") && !a.contains("繼續開在")){
            idxSlashPosition = a.indexOf("/");//找到斜線
            idxFirstBoundary = a.indexOf("線");//找到邊界關鍵字
            sub1 = a.substring(0, idxSlashPosition);
            sub2 = a.substring(idxFirstBoundary+1, a.length());
            instruction = sub1+sub2+"1";
//            instruction = "1";
        }
        else if(a.contains("玉井線") && !a.contains("繼續開在")){//於東西向快速公路北門玉井線/台84線向左轉
            idxSlashPosition = a.indexOf("/");//找到斜線
            idxFirstBoundary = a.indexOf("玉井線");//找到邊界關鍵字
            sub1 = a.substring(0, idxSlashPosition);
            sub2 = a.substring(idxFirstBoundary+8, a.length());
            instruction = sub1+sub2+"9";
        }
        else if(a.contains("縣道") && !a.contains("繼續開在")){
            idxSlashPosition = a.indexOf("/");//找到斜線
            idxFirstBoundary = a.indexOf("縣道");//找到邊界關鍵字
            sub1 = a.substring(0, idxSlashPosition);
            sub2 = a.substring(idxFirstBoundary+2, a.length());
            instruction = sub1+sub2+"2";
//            instruction = "2";
        }
        else if(a.contains("聯絡道") && !a.contains("繼續開在")){
            idxSlashPosition = a.indexOf("/");//找到斜線
            idxFirstBoundary = a.indexOf("聯絡道");//找到邊界關鍵字
            sub1 = a.substring(0, idxSlashPosition);
            sub2 = a.substring(idxFirstBoundary+3, a.length());
            instruction = sub1+sub2+"3";
        }
        else if(a.contains("鄉道") && !a.contains("繼續開在")){
            idxSlashPosition = a.indexOf("/");//找到斜線
            idxFirstBoundary = a.indexOf("鄉道");//找到邊界關鍵字
            sub1 = a.substring(0, idxSlashPosition);
            sub2 = a.substring(idxFirstBoundary+2, a.length());
            instruction = sub1+sub2+"4";
//            instruction = "3";
        }
        else if(a.contains("繼續開在") && tmp.equals("靠") && (!a.contains("靠右行駛") || !a.contains("靠左行駛") || !a.contains("向左轉") || !a.contains("向右轉"))){//接著走鳳林公路/鳳林四路/台25線繼續開在鳳林公路/台25線上
            idxSlashPosition = a.indexOf("/");//找到斜線
            sub1 = a.substring(0, idxSlashPosition);
            instruction = sub1+"，並繼續前進5";
//            instruction = "4";
        }
        else if(a.contains("繼續開在") && (a.contains("向左轉") || a.contains("向右轉")) && !tmp.equals("靠") && (!a.contains("靠右行駛") || !a.contains("靠左行駛"))){//於園區三路/科環路向左轉繼續開在園區三路上
            idxSlashPosition = a.indexOf("/");//找到斜線
            idxFirstBoundary = a.indexOf("向");//找到邊界關鍵字
            sub1 = a.substring(0, idxSlashPosition);
            sub2 = a.substring(idxFirstBoundary, idxFirstBoundary+3);
            instruction = sub1+sub2+"，並繼續前進11";
//            instruction = "4";
        }
        else if(a.contains("繼續開在") && a.contains("向")){//於花東縱谷公路/賓朗路/台9線向左轉繼續開在花東縱谷公路/台9線上
            idxSlashPosition = a.indexOf("/");//找到斜線
            idxFirstBoundary = a.indexOf("向");//找到邊界關鍵字
            sub1 = a.substring(0, idxSlashPosition);
            sub2 = a.substring(idxFirstBoundary, idxFirstBoundary+3);
            instruction = sub1+sub2+"，並繼續前進6";
        }
        else if(a.contains("繼續開在") && tmp.equals("靠")){//靠左行駛，進入中山路三段/114縣道繼續開在114縣道上
            idxSlashPosition = a.indexOf("/");//找到斜線
            sub1 = a.substring(0, idxSlashPosition);
            instruction = sub1+"，並繼續前進7";
//            instruction = "5";
        }
        else if(a.contains("繼續開在") && !tmp.equals("靠") && a.contains("靠右行駛") || a.contains("靠左行駛")){//於中興路/中豐公路/內山公路/台3線靠右行駛繼續開在中豐公路/內山公路/台3線上
            idxSlashPosition = a.indexOf("/");//找到斜線
            idxFirstBoundary = a.indexOf("靠");
            sub1 = a.substring(0, idxSlashPosition);
            sub2 = a.substring(idxFirstBoundary,idxFirstBoundary+4);
            instruction = sub1+sub2+"，並繼續前進8";
//            instruction = "6";
        }
        else if(a.contains("前進") && !a.contains("繼續開在") && !a.contains("線") && !a.contains("縣道") && !a.contains("鄉道") && !a.contains("聯絡道")){//向右轉，朝板城路/環河西路五段/環河道路前進
            idxSlashPosition = a.indexOf("/");//找到斜線
            idxFirstBoundary = a.indexOf("前進");//找到邊界
            sub1 = a.substring(0, idxSlashPosition);
            sub2 = a.substring(idxFirstBoundary, a.length());
            instruction = sub1+sub2+"10";
        }
        else if((a.contains("左轉") || a.contains("右轉")) && (!a.contains("繼續開在") || !a.contains("線") || !a.contains("縣道") || !a.contains("鄉道") || !a.contains("聯絡道"))){//於板城路/華東街向左轉
            idxSlashPosition = a.indexOf("/");//找到斜線
            idxFirstBoundary = a.indexOf("向");//找到邊界
            sub1 = a.substring(0, idxSlashPosition);
            sub2 = a.substring(idxFirstBoundary, a.length());
            instruction = sub1+sub2+"12";
        }
        else if ((a.contains("靠右行駛") || a.contains("靠左行駛")) && !a.contains("繼續開在") ){//於港埠路一段/西濱公路靠右行駛
            idxSlashPosition = a.indexOf("/");//找到斜線
            idxFirstBoundary = a.indexOf("靠");//找到邊界
            sub1 = a.substring(0, idxSlashPosition);
            sub2 = a.substring(idxFirstBoundary, a.length());
            instruction = sub1+sub2+"13";
        }
        else {//因"路"在其他位置也會有，這裡直接抓"前進"兩字的位置 //向右轉，朝板城路/環河西路五段/環河道路前進
//            char[] newInstructionText = instructionText.toCharArray();
//            for(int i = 0 ; i<newInstructionText.length ; i++){
//                if(newInstructionText[i] == '/' ){
//                    count++;
//                }
//            }
            instruction = "XX"+a;
        }
        return instruction;
    }
}
