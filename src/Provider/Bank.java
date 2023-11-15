package Provider;

import java.io.*;

public class Bank implements  Provider,BankMarker{

    @Override
    public boolean verify(String phoneNumber) {
        String filePath = "src/Provider/bankDummyDB.txt";


        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String tempPhoneNumber = parts[0].trim();

                    
                    if (tempPhoneNumber.equals(phoneNumber)) {
                        return true; 
                    }
                } else {
                    System.out.println("Invalid line format: " + line);
                    return false;
                }
            }

          
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    

    @Override
    public double getBalance(String phoneNumber) {
        String filePath = "src/Provider/bankDummyDB.txt";


        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String tempPhoneNumber = parts[0].trim();
                    if (tempPhoneNumber.equals(phoneNumber)) {
                        return Double.parseDouble(parts[1].trim()); 
                    }
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Invalid phone number : " + phoneNumber);
        }
        return 0;
    }

    @Override
    public void  setBalance(double balance,String phoneNumber) {
        try {
            File inputFile = new File("src/Provider/bankDummyDB.txt");
            File tempFile = new File("src/Provider/tempbankDummyDB.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String tempphoneNumber = parts[0].trim();
                    double tempbalance = Double.parseDouble(parts[1].trim());

                    if (tempphoneNumber.equals(phoneNumber)) {
                        tempbalance = balance; // Update the balance
                    }

                    // Write the updated line to the temporary file
                    writer.write(tempphoneNumber + " " + tempbalance);
                    writer.newLine();
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }

            writer.close();
            reader.close();

            if (!inputFile.delete()) {
                System.out.println("Error updating balance. Could not delete the original file.");
                return;
            }
            // Rename the temporary file to the original file
            if (!tempFile.renameTo(inputFile)) {
                System.out.println("Error updating balance. Please check file permissions.");
            } else {
                System.out.println("Balance updated successfully.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addBalance(double balance,String phoneNumber) {
        try {
            File inputFile = new File("src/Provider/bankDummyDB.txt");
            File tempFile = new File("src/Provider/tempbankDummyDB.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String tempphoneNumber = parts[0].trim();
                    double tempbalance = Double.parseDouble(parts[1].trim());

                    if (tempphoneNumber.equals(phoneNumber)) {
                        tempbalance =tempbalance+ balance; // Update the balance
                    }

                    // Write the updated line to the temporary file
                    writer.write(tempphoneNumber + " " + tempbalance);
                    writer.newLine();
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }

            writer.close();
            reader.close();

            if (!inputFile.delete()) {
                System.out.println("Error updating balance. Could not delete the original file.");
                return;
            }
            // Rename the temporary file to the original file
            if (!tempFile.renameTo(inputFile)) {
                System.out.println("Error updating balance. Please check file permissions.");
            } else {
                System.out.println("Balance updated successfully.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deduceBalance(double balance,String phoneNumber) {
        try {
            File inputFile = new File("src/Provider/bankDummyDB.txt");
            File tempFile = new File("src/Provider/tempbankDummyDB.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String tempphoneNumber = parts[0].trim();
                    double tempbalance = Double.parseDouble(parts[1].trim());

                    if (tempphoneNumber.equals(phoneNumber)) {
                        tempbalance =tempbalance- balance; // Update the balance
                    }

                    // Write the updated line to the temporary file
                    writer.write(tempphoneNumber + " " + tempbalance);
                    writer.newLine();
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }

            writer.close();
            reader.close();
            if (!inputFile.delete()) {
                System.out.println("Error updating balance. Could not delete the original file.");
                return;
            }
            // Rename the temporary file to the original file
            if (!tempFile.renameTo(inputFile)) {
                System.out.println("Error updating balance. Please check file permissions.");
            } else {
                System.out.println("Balance updated successfully.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
