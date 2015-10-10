/**
 * Created by vlad on 07.10.15.
 */
public class CHXProcessing {

    private double absoluteError;
    private double remTerm;
    private double F_X;
    private int n;


    public void generateValuesFirstTable(double x, double eps){
        double sampleCHX = Math.cosh(x);
        double U;
        double result = 0;
        int k;

        U = 1;
        x *= x;

        for(k = 1; U >= eps; ++k){
            result += U;
            U *= x / (2 * k * (2 * k - 1));
        }

        this.absoluteError = Math.abs(result - sampleCHX);
        this.remTerm = U;
        this.F_X = result;
        this.n = k;
    }

    public void generateValuesSecondTable(double x, int n){
        double U;
        double sampleCHX = Math.cosh(x);
        int k = 1;
        double result = 0;

        if (n > 0){
            U = 1;
            x *= x;
            while(--n > 0){
                result += U;
                U *= x / (2 * k * (2 * k - 1));
                k++;
            }
            this.remTerm = U;
        }

        this.absoluteError =Math.abs(result - sampleCHX);
        this.F_X = result;
        this.n = k;


    }
    public double getAbsoluteError() {
        return absoluteError;
    }

    public double getRemTerm() {
        return remTerm;
    }

    public double getF_X() {
        return F_X;
    }

    public int getN() {
        return n;
    }



}
