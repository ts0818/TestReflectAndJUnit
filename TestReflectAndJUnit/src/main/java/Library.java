import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import dto.Jyugemu;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class Library {
  public boolean someLibraryMethod() {
    
    boolean isNoMistake = false; // TRUE:エラー無し、FALSE:エラー有り
    Jyugemu jyugemu = new Jyugemu();
    // setter でセットしたい値
    List<String> list = new ArrayList<>(
        Arrays.asList("寿限無", "寿限無", "五劫ごこうの擦すり切きれ", "海砂利かいじゃり水魚すいぎょの", "水行末すいぎょうまつ・雲来末うんらいまつ・風来末ふうらいまつ", "喰う寝る処ところに住む処",
            "藪やぶら柑子こうじの藪柑子", "パイポ・パイポ・パイポのシューリンガン", "シューリンガンのグーリンダイ", "グーリンダイのポンポコピーのポンポコナーの", "長久命ちょうきゅうめいの長助"));

    Map<String, String> resultMap = new LinkedHashMap<>(); // setter で、どんな値を設定したかを保持する用
    
    try {
      Class<?> clazz = jyugemu.getClass();
      Method[] methods = clazz.getDeclaredMethods(); // クラスのメソッド
      Field[] fields = clazz.getDeclaredFields(); // クラスのフィールド
      int fieldCount = fields.length; // クラスのフィールド数
      String[] fieldNames = new String[fieldCount]; // クラスのフィールド名を保持用
      // クラスのフィールド名を格納
      for (int i = 0; i < fieldNames.length; i++) {
          if (Objects.nonNull(fields[i]) && Objects.nonNull(fields[i].getName())) {
            fieldNames[i] = fields[i].getName();
          }          
      }
     
      String methodName = "";
      // メソッドの分だけ繰り返し
      for (Method method: methods) {
        methodName = method.getName(); // メソッド名を取得
        // setter だけに絞る
        if (Objects.nonNull(method) && (methodName).startsWith("set")) {
          // フィールド名の数だけ繰り返し
          for (int index = 0; index < fieldNames.length; index++) {
            // フィールド名と、メソッド名（"set"部分を除く）が一致していれば、
            if (methodName.substring(3, methodName.length()).toLowerCase().contains((fieldNames[index]).toLowerCase())) {
              method.invoke(jyugemu, list.get(index)); // setter を実行
              resultMap.put(method.getName(), list.get(index)); // setter にどの値をセットしたかを保持
            }
          }          
        }
        System.out.println(method); // すべてのメソッドを出力
      }
      isNoMistake = true; // エラーが無く、処理が完了した場合は、フラグをtrueに
      
    } catch (SecurityException e) {
      // TODO 自動生成された catch ブロック
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      // TODO 自動生成された catch ブロック
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      // TODO 自動生成された catch ブロック
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      // TODO 自動生成された catch ブロック
      e.printStackTrace();
    }
    // 結果
    System.out.println("----- 結果 -----");
    resultMap.entrySet().stream()
    .sorted(Map.Entry.comparingByKey())
    .forEach(entry -> System.out.println(entry));
//    for (Map.Entry<String, String> entry :resultMap.entrySet()) {
//      System.out.println(entry.getKey() + " : " + entry.getValue());
//    }
    
    return isNoMistake;
  }
  

}
