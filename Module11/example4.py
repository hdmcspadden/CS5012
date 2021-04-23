## [File: example4.py]
## Concurrency - Example
## Python version 3.X

## - Simulating a bank account
## - Class BankAccount with deposit() and withdraw() methods (as before)
## - NEW: Introduce locks!
## - One thread cannot interrupt another thread until all the work is done
## - Introduce a try/finally block
## - No matter what happens the UNLOCK (release() method) will happen! 

# ** Balance still has negatives and positives **
# ** End balance WILL result in zero (0) **


from threading import Thread
import threading
import time

class BankAccount:
    def __init__(self):
        self.lock = threading.Lock()  # create a lock object 
        self.balance = 0
    
    def deposit(self, amount):
        self.lock.acquire()
        try:
            newBalance = self.balance + amount
            self.balance = newBalance
            print("Depositing: %d, new balance is %d \n" % (amount, newBalance))
        finally:
            self.lock.release()  # will always get called
            
    
    def withdraw(self, amount):
        self.lock.acquire()
        try:
            newBalance = self.balance - amount
            self.balance = newBalance
            print("Withdrawing: %d, new balance is %d \n" % (amount, newBalance))
        finally:
            self.lock.release()  # will always get called 
    
    def getBalance(self):
        return self.balance

def triggerDeposits(bankAccount, amount, count):
    for i in range(count):
        bankAccount.deposit(amount)
        # time.sleep(1)

def triggerWithdraws(bankAccount, amount, count):
    for i in range(count):
        bankAccount.withdraw(amount)
        # time.sleep(1)

if __name__ == '__main__':

    bAcct = BankAccount()
    amount = 100
    repetitions = 25
    threads = 100

    for i in range(threads):
        t1 = Thread(target=triggerDeposits, args=(bAcct, amount, repetitions,))
        t2 = Thread(target=triggerWithdraws, args=(bAcct, amount, repetitions,))
        t1.start()
        t2.start()
        
