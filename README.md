# java_file_processor
This problem statement given by One of the Reputed companies (Greater Bank Australia)

Below is the Problem Statement:

Coding Challenge
Processing Customer Transactions
Your team has been asked by the Finance department to create a program that can process customer transactions. Customer transactions
are are received by file and need to be processed and applied to customer loan accounts.
During an analysis meeting with stakeholders from the Finance department the following information is made available
Customer transactions are received as a File daily
once at 06:00 hours
once at 21:00 hours
File is received in csv format, example format
"Customer Account#", "Transaction Amount"
123456789, 100.00
987654321, -50.00
Each line in the file represents a customer transaction
Negative transaction amounts represent a debit against a customer account, and the customers account balance is increased
Positive transaction amounts represent a credit against a customer account, and the customers account balance is decreased.
Customer accounts numbers contain numerical characters only, however
some lines are encountered where the account number contains non numerical characters - these lines are considered
corrupt
corrupt lines should not be processed but skipped
Files are received in a directory located at $TRANSACTION_PROCESSING/pending, where
$TRANSACTION_PROCESSING is an environment variable referencing a arbitrary directory on each machine the program
will execute
the format of the file finance_customer_transactions-${datetime}.csv, where ${datetime} represents the time the file was
written to the filesystem
When a file is received, processing of the File should commence within 5minutes
Each file can contain up to 500K customer payments
Files must only be processed once
Processed files should be placed in $TRANSACTION_PROCESSING/processed
The same customer account number can appear multiple times in a customer payment file
Initially the Finance stakeholders would like to see the program process each file and produce a text report detailing
name of the file processed
the number of accounts processed
total credit amount 
total debit amount
number of skipped lines
An example report was provided
File Processed: finance_customer_transactions-20171201060101.csv
Total Accounts: 203,102
Total Credits : $856,480.70
Total Debits : $100,132.50
Skipped Transactions: 103
The report should be written to the directory $TRANSACTION_PROCESSING/reports
report file name should be of the form finance_customer_transactions_report-${datetime}.txt


![alt text](https://github.com/DhanaTontanahal/java_file_processor/blob/master/2.PNG)




![alt text](https://github.com/DhanaTontanahal/java_file_processor/blob/master/2.PNG)




