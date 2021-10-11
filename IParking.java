import java.util.ArrayList;
import java.util.Scanner;

public interface IParking {
    // 打印输出结果
    public void print();
    // 检查是否有 carType 对应的停车位
    // 如果没有空车位，请返回 false ，否则将该车停入车位并返回 true
    public boolean addCar(int carType);
    // 解析命令行输入的参数（格式），如文档描述
    public static IParams parse() throws Exception{
        IParams iParams = new IParams() {
            @Override
            public int getBig() {
                return 1;
            }

            @Override
            public int getMedium() {
                return 1;
            }

            @Override
            public int getSmall() {
                return 0;
            }

            @Override
            public ArrayList<Integer> getPlanParking() {
                Scanner in = new Scanner(System.in);
                String input = in.nextLine();
                String[] tokens = input.split("[^0-9]");
                ArrayList<Integer> arrayList = new ArrayList<>();
                int count = 0;

                for (int i=0;i<tokens.length;i++) {
                    if (!tokens[i].equals("")) {
                        count++;
                        if (count>3) {
                            arrayList.add(Integer.parseInt(tokens[i]));
                        }
                        if (count==8)
                            break;
                    }
                }

                return arrayList;
            }
        };
        return iParams;
    };
}
