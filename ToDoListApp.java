import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
  public static void main(String[] args) {
    // ArrayList<参照型名> 変数名 = new ArrayList<参照型名>(); https://qiita.com/ryome/items/cc01a7b6914e5b8b1579
    ArrayList<String> tasks = new ArrayList<>();

    // Javaでコンソールからのユーザー入力を受け取る場合やファイルからの入力を扱う場合 https://qiita.com/EasyCoder/items/f8b1a62a9298231efd21
    Scanner scanner = new Scanner(System.in, "UTF-8");

    while (true) {
      System.out.println("1.タスク追加 2.タスク表示 3.タスク削除 4.終了");
      System.out.print("選択してください");

      // ユーザーが入力した文字を整数に変換 https://miki-prosho.com/?p=1154
      int choice = scanner.nextInt();
        scanner.nextLine(); // 入力ストリームから改行文字（\nや\r\n）までの1行分すべて（改行自体は除く）を文字列として読み込む機能

        switch (choice) {
          case 1:
            System.out.print("追加するタスクを入力してください");

            String task = scanner.nextLine();

            // リストに値を追加
            tasks.add(task);
            break;
          case 2:
            System.out.print("現在のタスク一覧:");
            for (int i = 0; i < tasks.size(); i++) { // 一つ以上なので繰り返し処理

              // 	リストの値を取得し出力
              System.out.println((i + 1)+ "." + tasks.get(i));
            }
            break;
          case 3:
            System.out.print("削除するタスクの番号を入力してください:");

            int index = scanner.nextInt() - 1; //引く理由は「ユーザー向けの番号（1始まり）」と「ArrayListのインデックス（0始まり）」のズレがあるため

            if (index >= 0 && index < tasks.size()) { //サイズはリストの要素数取得
              tasks.remove(index);
              System.out.println("タスクを削除しました");
            } else {
              System.out.println("無効な番号です");
            }
            break;
          case 4:
            System.out.println("終了します");
            scanner.close();
            return;
            
          default:
            System.out.println("無効な選択です");
        }
        System.out.println();
    }
  }
}