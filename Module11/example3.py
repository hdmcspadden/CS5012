## [File: example3.py] 
## Concurrency - Example
## Python version 3.X

## - Simulating a bank account
## - Class BankAccount is created and has a deposit() and withdraw() method
## - Once again cannot determine order! But also threads don't always finish
## - In the middle of depositing the withdraw thread could take over
##   and vice versa --> inconsistent balance, can be highly neg or pos
## - If we have 100 threads to deposit $100 and 100 threads to withdraw $100
##   SHOULD have final balance: $0   (hardly EVER will get this!)

from threading import Thread
import time

class BankAccount:
    def __init__(self):
        self.balance = 0
    
    def deposit(self, amount):
        newBalance = self.balance + amount
        print("Depositing: %d, new balance is %d \n" % (amount, newBalance))
        self.balance = newBalance
    
    def withdraw(self, amount):
        newBalance = self.balance - amount
        print("Withdrawing: %d, new balance is %d \n" % (amount, newBalance))
        self.balance = newBalance
    
    def getBalance(self):
        return self.balance
    
## ---- end of BankAccount Class ----
        
# Deposits $100 in bank account (in 'balance')
def triggerDeposits(bankAccount, amount, count):
    for i in range(count):
        bankAccount.deposit(amount)
        # time.sleep(1)

# Withdraws $100 from bank account (from 'balance') 
def triggerWithdraws(bankAccount, amount, count):
    for i in range(count):
        bankAccount.withdraw(amount)
        # time.sleep(1)


if __name__ == '__main__':
    bAcct = BankAccount()
    amount = 100
    repetitions = 25
    threads = 100

    # Create 100 'deposit' threads and 100 'withdraw' threads
    for i in range(threads):
        t1 = Thread(target=triggerDeposits, args=(bAcct, amount, repetitions))
        t2 = Thread(target=triggerWithdraws, args=(bAcct, amount, repetitions))
        t1.start()
        t2.start()
        
