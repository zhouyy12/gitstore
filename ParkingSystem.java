import java.util.ArrayList;
import java.util.Scanner;

public class ParkingSystem implements IParking{
    private int big;
    private int medium;
    private int small;
    static ArrayList result = new ArrayList();

    public ParkingSystem(int big, int medium, int small) {
        this.big =  big;
        this.medium = medium;
        this.small = small;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        IParams params = IParking.parse();//ParkingSystem.parse();
        ParkingSystem ps = new ParkingSystem(params.getBig(), params.getMedium(),params.getSmall());
        ArrayList<Integer> plan = params.getPlanParking();
        result.add(null);
        for (int i = 0; i < plan.size(); i++) {
            boolean b = ps.addCar(plan.get(i));
            result.add(b);
        }
        ps.print();
    }

    @Override
    public void print() {
            System.out.println(result);
    }

    @Override
    public boolean addCar(int carType) {
        if(carType==1)
        {
            if(big>0)
            {
                big--;
                return true;
            }
            return false;
        }
        else if(carType==2)
        {
            if(medium>0)
            {
                medium--;
                return true;
            }
            return false;
        }
        else
        {
            if(small>0)
            {
                small--;
                return true;
            }
            return false;
        }
    }
}
