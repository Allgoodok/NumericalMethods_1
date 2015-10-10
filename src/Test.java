/**
 * Created by vlad on 07.10.15.
 */
public class Test {

    private double a;
    private double b;
    private double x;
    private double h;
    private double eps;
    private CHXProcessing chxProcessing;

    Test(){
        chxProcessing = new CHXProcessing();
        a = -0.8;
        b = 1.9;
        x = a;
        h = (b - a)/10;
    }

    public String[][] dataFirstTable(){

        String[][] data1 = new String[15][4];
        int i = 0;

        for (eps = 1e-2; eps >= 1e-14; eps *= 1e-3) {
                chxProcessing.generateValuesFirstTable(x, eps);
                data1[i][0] = Double.toString(eps);
                data1[i][1] = Integer.toString(chxProcessing.getN());
                data1[i][2] = Double.toString(chxProcessing.getAbsoluteError());
                data1[i][3] = Double.toString(chxProcessing.getRemTerm());
                ++i;
            }
            return data1;
        }

    public String[][] dataSecondTable(){
        chxProcessing.generateValuesFirstTable(x, 1e-8);
        int n = chxProcessing.getN();

        String[][] data2 = new String[15][3];
        int j = 0;
        for (int i = 0; i < 10; ++i) {
            x = a + h * i;
            chxProcessing.generateValuesSecondTable(x, n);
            data2[j][0] = Double.toString(x);
            data2[j][1] = Double.toString(chxProcessing.getAbsoluteError());
            data2[j][2] = Double.toString(chxProcessing.getRemTerm());
            ++j;
        }

        return data2;

    }




}




