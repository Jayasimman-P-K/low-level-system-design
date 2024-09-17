# Banking application

### Requirements:

##### 1. Account Management:

- _Create Account_: Users should be able to create new bank accounts.
- _Close Account:_ Users should be able to close existing bank accounts.
- _Get Account Details:_ Retrieve details of a specific account.

##### 2. User Management

- _Create User:_ The system should allow the addition of new users.
- _Authenticate User:_ Users should be able to log in with their credentials.
- _Get User Details:_ Retrieve user information.

##### 3. Transaction Management

- _Deposit Money:_ Users should be able to deposit money into their accounts.
- _Withdraw Money:_ Users should be able to withdraw money from their accounts.
- _Transfer Money:_ Users should be able to transfer money between accounts.
- _Get Transaction History:_ Users should be able to view their transaction history.

##### 4. Balance Management

- _Check Balance:_ Users should be able to check the balance of their accounts.

### Project Structure

```css

src
├── Banking
│   ├── Models
│   │   ├── Account.java
│   │   ├── User.java
│   │   └── Transaction.java
│   ├── Enums
│   │   ├── TransactionType.java
│   │   └── AccounType.java
│   ├── Services
│   │   ├── AccountService.java
│   │   ├── TransactionService.java
│   │   └── UserService.java
│   └── Driver.java

```
