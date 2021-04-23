## [File: example5.py] 
## Concurrency - Example
## Python version 3.X

## - Simulating a bank account
## - Class BankAccount with deposit() and withdraw() methods (as before)
## - FROM BEFORE: Locks!
## - One thread cannot interrupt another thread until all the work is done
## - Introduce a try/finally block
## - No matter what happens the UNLOCK (release() method) will happen! 
## - NEW: Introduce Conditions
## - This will prevent the withdraw() method to withdraw money if there are no funds!
## - Condition objects can signal when funds are added, and will wait on insufficient
##   funds

# ** Balance will NEVER have negative values **
# ** End balance WILL result in zero **

from threading import Thread
import threading
import time

class BankAccount:
    def __init__(self):
        self.lock = threading.Lock()
        self.sufficientBalanceCondition = threading.Condition(self.lock)
        self.balance = 0
    
    def deposit(self, amount):
        self.lock.acquire()
        try:
            newBalance = self.balance + amount
            self.balance = newBalance
            print("Depositing: %d, new balance is %d \n" % (amount, newBalance))
            # each deposit notifies the other threads to check the condition becasue it has changed
            self.sufficientBalanceCondition.notifyAll()
        finally:
            self.lock.release()
            
    
    def withdraw(self, amount):
        self.lock.acquire()
        try:
            while(self.balance < amount):
                self.sufficientBalanceCondition.wait()
            newBalance = self.balance - amount
            self.balance = newBalance
            print("Withdrawing: %d, new balance is %d \n" % (amount, newBalance))
        finally:
            self.lock.release()
    
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
        
