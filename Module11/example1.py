## [File: example1.py]
## Concurrency - Example 1
## Python version 3.X

## - Simple threads being created in a loop
## - Each thread sleeps and prints the parameter
## - Cannot determine order!

import time
from threading import Thread

def myfunc(i, param):
    print("sleeping 5 sec from thread %d" % i)
    time.sleep(5)
    print( "finished sleeping from thread %d: %s" % (i, param))

param = "hello"
# Looping 10 times
for i in range(10):
    # Param alternates from "hello" to "goodbye"
    param = "hello" if param == "goodbye" else "goodbye"
    # Thread targets the "myfunc" function:  myfunc(i, param)
    t = Thread(target=myfunc, args=(i,param))
    t.start() # Start Thread t
    
# === Sample output ===============================
# ... sleeping messages ...
# finished sleeping from thread 1: hello
# finished sleeping from thread 2: goodbye
# finished sleeping from thread 0: goodbye
# finished sleeping from thread 3: hello
# finished sleeping from thread 5: hello
# finished sleeping from thread 4: goodbye
# finished sleeping from thread 7: hello
# finished sleeping from thread 6: goodbye
# finished sleeping from thread 8: goodbye
# finished sleeping from thread 9: hello
