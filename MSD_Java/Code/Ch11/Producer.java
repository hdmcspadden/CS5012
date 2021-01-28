/**
 * The producer side of the Producer/Consumer problem.
 * This thread generates a stream of integers and feeds
 * them to a consumer through a buffer.
 */

public class Producer extends Thread {

    private Buffer consumer;  // The connection to the consumer
    private int howMany;      // The number of integers to produce

    /**
     * Create a new producer.
     *
     * @param buf the buffer that is connected to the consumer.
     * @param count the number of items to produce.
     */

    public Producer( Buffer buf, int count ) {
	consumer = buf;
	howMany = count;
    }

    /**
     * Generate the integers and feed them to the consumer.
     */

    public void run() {

	// Generate the numbers

	for ( int i = 0; i < howMany; i++ ) {
	    consumer.add( i );
	}

	// A -1 marks the end of the stream

	consumer.add( -1 );
    }

} // Producer

