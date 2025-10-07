package DesignPatterns.SOLID.SingleResponsibiltyPrinciple.RealExample;

class UserServiceUglyCode {
    public void registerUser(String userName, String password){
        //Validation of user credentials
        if(userName.isEmpty() || password.isEmpty()){
            System.out.println("Invalid credentials");
            return;
        }
        //Storing user in database (simulated)
        System.out.println("User " + userName + " registered successfully.");
        //Sending welcome email (simulated)
        System.out.println("Welcome email sent to " + userName);
        //Logging registration activity (simulated)
        System.out.println("User " + userName + " registration logged.");
    }
    public static void main(String[] args) {
        UserServiceUglyCode userService = new UserServiceUglyCode();
        userService.registerUser("john_doe", "password123");
    }
}

//SRP Compliant Code
class UserValidator {
    public boolean validate(String userName, String password){
        return !(userName.isEmpty() || password.isEmpty());
    }
}
class UserRepository {
    public void saveUser(String userName, String password){
        //Simulate saving user to database
        System.out.println("User " + userName + " registered successfully.");
    }
}
class EmailService {
    public void sendWelcomeEmail(String userName){
        //Simulate sending email
        System.out.println("Welcome email sent to " + userName);
    }
}
class Logger {
    public void logRegistration(String userName){
        //Simulate logging
        System.out.println("User " + userName + " registration logged.");
    }
}
class UserServiceCleanCode{
    public static void main(String[] args) {
        String userName = "john_doe";
        String password = "password123";

        UserValidator validator = new UserValidator();
        UserRepository repository = new UserRepository();
        EmailService emailService = new EmailService();
        Logger logger = new Logger();

        if(!validator.validate(userName, password)){
            System.out.println("Invalid credentials");
            return;
        }
        repository.saveUser(userName, password);
        emailService.sendWelcomeEmail(userName);
        logger.logRegistration(userName);
    }
}
