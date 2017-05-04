package math;

public class Util {
	private static long m(long x, long mod){
        long res = 1;
        long p = mod - 2;
        while(p>0){
            if((p&1) > 0){
                res = (res*x)%mod;
            }
            x = (x*x)%mod;
            p>>=1;
        }
        return res;       
    }
    /**
    * Calculate large nCk
    */
    public static long bigModular(long n, long k, long mod){
        long nf = 1;
        long kf = 1;
        long nkf = 1;
        for(int i=2;i<=n;i++){
            nf=(nf*i)%mod;
            if(i == k){
                kf = nf;
            }
            if(i == n-k){
                nkf = nf;
            }
        }
        kf = m(kf, mod);
        nkf = m(nkf, mod);
        nf = (nf*kf)%mod;
        nf = (nf*nkf)%mod;
        return nf;
    }
    /**
     * Greatest Common Divisor: 
     * for example, gcd(54, 24) = 6
     * @param n
     * @param m
     * @return
     */
    public static long gcd(long n, long m){return m>0? gcd(m,n%m) : n;}
    
    /**
     * Least Common Multiple
     * for example, lcm(4,6) = 12
     * @param n
     * @param m
     * @return
     */
    public static long lcm(long n, long m){return n / gcd(n,m) * m;}
}
