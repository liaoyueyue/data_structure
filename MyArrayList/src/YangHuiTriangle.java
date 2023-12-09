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


    /*
    杨辉三角：
    1
    1  1
    1  2  1
    1  3  3  1
    1  4  6  4  1
    ...
    解题思路：
      仔细观察发现杨慧三角类似于一个二维数组，第0列和对角线上的元素全部都是1
      其余位置都是上一行正对元素 与 上一行正对元素的前一个元素之和
    规律摸清楚出之后，按照题意构造即可
 */
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> retList = new ArrayList<>();

        for(int i = 0; i < numRows; ++i){
            // 处理杨辉三角第i行,该行总共有i+1个元素
            List<Integer> rowList = new ArrayList<>(i+1);
            for(int j = 0; j <= i; ++j){
                if(0 == j || j == i){
                    // 第0列和对角线上的元素全部为1
                    rowList.add(1);
                }else{
                    // 其余位置：上行正对元素 + 上行正对元素前一个
                    rowList.add(retList.get(i-1).get(j) + retList.get(i-1).get(j-1));
                }
            }
            retList.add(rowList);
        }
        return retList;
    }

    public static void main(String[] args) {
        YangHuiTriangle yangHuiTriangle = new YangHuiTriangle();
        System.out.println(yangHuiTriangle.generate(5));
    }
}
