**NexaVault - Bank Management System**
*NexaVault* is a Bank Management System built in **Java** with **MySQL database integration using JDBC**.
It provides core banking features such as account creation, login authentication, transactions, and account management.

**🚀 Features**
 **Account Signup**
  * New users can create an account.
  * During signup, the system automatically generates a **Card Number** and **PIN**.
  * Initial deposit is required to open an account.
 **Secure Login**
  * Users can log in using their **Card Number** and **PIN**.
  * Login credentials are validated against the database records.
 **Transactions & Services**
  1) **Deposit** – Add money to your account.
  2) **Withdrawal** – Withdraw money from your account.
  3) **Fast Cash** – Quick withdrawal of predefined amounts.
  4) **Balance Enquiry** – Check current account balance.
  5) **Mini Statement** – View recent transactions.
  6) **PIN Change** – Update account PIN securely.
 **Database Integration (MySQL + JDBC)**
  * All account details, transactions, and login records are stored in a **MySQL database**.
  * JDBC is used for database connectivity.

**🛠️ Technologies Used**
1) **Java** (Core + OOP)
2) **Swing/AWT** (for GUI, if implemented)
3) **JDBC** (Java Database Connectivity)
4) **MySQL** (for data storage)
   
**📂 Project Structure**
* `Signup` → Handles new account creation.
* `Login` → Manages user login with card number & PIN verification.
* `Transactions` → Provides transaction services: Deposit, Withdraw, Fast Cash, etc.
* `Database` → MySQL tables store user details, transactions, and authentication data.

**⚙️ How It Work**
1. **Sign Up**
   * Enter personal details and deposit an initial amount.
   * System generates **Card Number** & **PIN** automatically.
2. **Login**
   * Enter **Card Number** and **PIN**.
   * System verifies details with the database.
   * On success → transaction dashboard opens.
3. **Perform Transactions**
   * Choose any banking service (Deposit, Withdraw, Fast Cash, etc.).
   * Transactions are updated in the database.
     
 **📸 Screenshots**


 **Signup Page**
 
<img width="788" height="722" alt="image" src="https://github.com/user-attachments/assets/dbb65b73-2e91-45ad-937f-6da9b8ebce74" />
<img width="785" height="724" alt="image" src="https://github.com/user-attachments/assets/c00635e6-03de-469d-80b5-df0a4b535aea" />
<img width="785" height="721" alt="image" src="https://github.com/user-attachments/assets/3275c843-8550-424c-9657-94ff4982d3d4" />



**Login Page**

<img width="783" height="472" alt="image" src="https://github.com/user-attachments/assets/7126875f-7664-4c5c-8df8-5bace8e15322" />



**Transaction Page**

<img width="784" height="680" alt="image" src="https://github.com/user-attachments/assets/aeb1aec7-cd13-45db-a5ad-0e7e033d74f8" />



**Deposit Balance**

<img width="785" height="680" alt="image" src="https://github.com/user-attachments/assets/d5ab2189-44c4-4b00-bb27-19a7b1e8c5db" />



**Withdraw Balance**

<img width="784" height="651" alt="image" src="https://github.com/user-attachments/assets/cc4cc096-ffe5-4bb0-a7d1-8249d2846e3c" />



**Mini Statement**

<img width="385" height="591" alt="image" src="https://github.com/user-attachments/assets/3997a3a9-c539-4d1d-89c7-f46c10cd85d2" />

**📌 Future Improvements**
* Add **Admin Dashboard** for bank staff.
* Provide **Email/SMS notifications** for transactions.
* Enhance **Security** with encryption for PIN & Card Number.

**🤝 Contributing**
Feel free to fork this project and contribute by submitting pull requests.
