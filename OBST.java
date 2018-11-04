package test;

public class OBST {
	public static void OBST1(double p[],double q[],int n,double e[][],double w[][],double root[][]) {

		for(int i=1;i<n+1;i++) {
			e[i][i-1]=q[i-1];
			w[i][i-1]=q[i-1];
		}
		for(int i=1;i<n+1;i++)
			for(int j=i;j<n;j++) {
				w[i][j]=w[i][j-1]+p[j]+q[j];
			}
		for(int j=1;j<n;j++)
			for(int i=j;i>0;i--) {
				e[i][j]=9999;
				for(int r=i;r<j+1;r++) {
					double t=e[i][r-1]+e[r+1][j]+w[i][j];
					if(t<e[i][j]) {
						e[i][j]=t;
						root[i][j]=r;
					}
				}
			}
	}
	public static void main(String[] args) {
		double p[]= {0,0.04,0.06,0.08,0.02,0.10,0.12,0.14};
		double q[]= {0.06,0.06,0.06,0.06,0.05,0.05,0.05,0.05};
		double e[][]=new double [9][9];
		double w[][]=new double [9][9];
		double root[][]=new double [9][9];
		OBST1(p,q,8,e,w,root);
	}
}
