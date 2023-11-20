import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liaoyueyue
 * Date: 2023-11-20
 * Time: 23:20
 */
public class YangHuiTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> colList = new ArrayList<>();
        List<Integer> firstRowList = new ArrayList<>();
        firstRowList.add(1);
        colList.add(firstRowList);
        for(int i = 1; i < numRows; i++) {
            List<Integer> rowList = new ArrayList<>();
            rowList.add(1);
            List<Integer> preRowList = colList.get(i - 1);
            for(int j = 1; j < i; j++){
                int num = preRowList.get(j) + preRowList.get(j - 1);
                rowList.add(num);
            }
            rowList.add(1);
            colList.add(rowList);
        }
        return colList;
    }

    public static void main(String[] args) {
        YangHuiTriangle yangHuiTriangle = new YangHuiTriangle();
        System.out.println(yangHuiTriangle.generate(5));
    }
}
