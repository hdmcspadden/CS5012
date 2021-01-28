public class ProdCons {

    public static void main( String args[] ) {
	//Buffer buf = new MonitorBuffer();
	Buffer buf = new SyncBuffer();

	Consumer cons = new Consumer( buf );
	cons.start();

	Producer prod = new Producer( buf, 1000 );
	prod.start();
    }
}
