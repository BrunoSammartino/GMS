import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class GymManagementSystem {
	private ArrayList<GymMember> members;
    private Scanner scanner;
    private static final String DATA_FILE = "gym_members.dat";

    public GymManagementSystem() {
        members = loadMembersFromFile();
        scanner = new Scanner(System.in);
    }

    public void addMember() {
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter admission date: ");
        String admissionDate = scanner.nextLine();
        System.out.print("Enter contact details: ");
        String contactDetails = scanner.nextLine();

        GymMember member = new GymMember(name, admissionDate, contactDetails);
        members.add(member);
        saveMembersToFile();

        System.out.println("Member added successfully.");
    }

    public void removeMember() {
        System.out.print("Enter member name to remove: ");
        String name = scanner.nextLine();

        GymMember memberToRemove = null;
        for (GymMember member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                memberToRemove = member;
                break;
            }
        }

        if (memberToRemove != null) {
            members.remove(memberToRemove);
            saveMembersToFile();
            System.out.println("Member removed.");
        } else {
            System.out.println("Member not found.");
        }
    }

    public void assignMembership() {
        System.out.print("Enter member name to assign membership: ");
        String name = scanner.nextLine();

        for (GymMember member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                member.setHasMembership(true);
                saveMembersToFile();
                System.out.println("Membership assigned.");
                return;
            }
        }

        System.out.println("Member not found.");
    }
    
    public void revokeMembership() {
        System.out.print("Enter member name to revoke membership: ");
        String name = scanner.nextLine();

        for (GymMember member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                member.setHasMembership(false);
                saveMembersToFile();
                System.out.println("Membership revoked.");
                return;
            }
        }

        System.out.println("Member not found.");
    }

    public void checkMembershipStatus() {
        System.out.print("Enter member name to check membership status: ");
        String name = scanner.nextLine();

        for (GymMember member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                System.out.println("Membership Status: " + (member.hasMembership() ? "Active" : "Inactive"));
                return;
            }
        }

        System.out.println("Member not found.");
    }

    public void makePayment() {
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();

        for (GymMember member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                member.setFeePaid(true);
                saveMembersToFile();
                System.out.println("Payment recorded.");
                return;
            }
        }

        System.out.println("Member not found.");
    }

    public void viewStatus() {
        System.out.println("\nMember\t\tDate\tContact\t\tPayment Status\t\tMembership Status");
        System.out.println("---------------------------------------------------------------------------------");

        for (GymMember member : members) {
            System.out.printf("%s\t\t%s\t%s\t%s\t\t\t%s\n",
                    member.getName(), member.getAdmissionDate(), member.getContactDetails(),
                    member.isFeePaid() ? "Paid" : "Pending", member.hasMembership() ? "Active" : "Inactive");
        }
    }

    public void saveMembersToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            outputStream.writeObject(members);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
	public ArrayList<GymMember> loadMembersFromFile() {
        ArrayList<GymMember> members = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            members = (ArrayList<GymMember>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // File may not exist or could not be read, this is fine for the first run
        }

        return members;
    }

    // User menu for accessing gym accessories
    private void userMenu(GymMember member) {
        while (true) {
            System.out.println("\nUser Menu");
            System.out.println("1. Access Dumbbells");
            System.out.println("2. Access Bench");
            System.out.println("3. Access Treadmill");
            System.out.println("4. Access Cycle");
            System.out.println("5. Access Barbell");
            System.out.println("6. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    accessDumbbells(member);
                    break;
                case 2:
                    accessBench(member);
                    break;
                case 3:
                    accessTreadmill(member);
                    break;
                case 4:
                    accessCycle(member);
                    break;
                case 5:
                    accessBarbell(member);
                    break;
                case 6:
                    System.out.println("Exiting the user menu.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    
    @SuppressWarnings("unused")
	private int readIntFromUser(String prompt) {
        int value = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(prompt);
                value = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Consume the invalid input
            }
        }

        return value;
    }

    // Method for accessing Dumbbells
    private void accessDumbbells(GymMember member) {
        member.setHasAccessDumbbells(true);
        System.out.println("Access to dumbbells granted.");
    }

    // Method for accessing Bench
    private void accessBench(GymMember member) {
        member.setHasAccessBench(true);
        System.out.println("Access to bench granted.");
    }

    // Method for accessing Treadmill
    private void accessTreadmill(GymMember member) {
        member.setHasAccessTreadmill(true);
        System.out.println("Access to treadmill granted.");
    }

    // Method for accessing Cycle
    private void accessCycle(GymMember member) {
        member.setHasAccessCycle(true);
        System.out.println("Access to cycle granted.");
    }

    // Method for accessing Barbell
    private void accessBarbell(GymMember member) {
        member.setHasAccessBarbell(true);
        System.out.println("Access to barbell granted.");
    }

    // Admin menu for various actions
    private void adminMenu() {
        while (true) {
            System.out.println("\n***** Admin Menu *****");
            System.out.println("1. Add Member");
            System.out.println("2. Remove Member");
            System.out.println("3. Assign Membership");
            System.out.println("4. Check Membership Status");
            System.out.println("5. Revoke Membership");
            System.out.println("6. Make Payment");
            System.out.println("7. View Payment and Membership Status");
            System.out.println("8. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    addMember();
                    break;
                case 2:
                    removeMember();
                    break;
                case 3:
                    assignMembership();
                    break;
                case 4:
                    checkMembershipStatus();
                    break;
                case 5:
                    revokeMembership();
                    break;
                case 6:
                    makePayment();
                    break;
                case 7:
                    viewStatus();
                    break;
                case 8:
                    System.out.println("\nExiting the Admin Menu.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Method to run the entire system
    public void run() {
        System.out.println("Welcome to the Gym Management System!");
        System.out.print("\nAre you a User or an Admin? (User/Admin): ");
        String userType = scanner.nextLine();

        if (userType.equalsIgnoreCase("User")) {
            System.out.print("Enter your name: ");
            String userName = scanner.nextLine();
            GymMember userMember = null;

            for (GymMember member : members) {
                if (member.getName().equalsIgnoreCase(userName)) {
                    userMember = member;
                    break;
                }
            }

            if (userMember != null) {
                userMenu(userMember);
            } else {
                System.out.println("User not found.");
            }
        } else if (userType.equalsIgnoreCase("Admin")) {
            adminMenu();
        } else {
            System.out.println("Invalid choice.");
            return;
        }
    }
}